import java.awt.Canvas;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.util.Random;
import javax.swing.ImageIcon;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import sun.audio.AudioData;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
//import sun.audio.ContinuousAudioDataStream;

public class Game extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int width = 640;
	public static int height = 640;
	public static boolean drawLines = false;
	public static boolean music = false;
	public static boolean testRun = false;
	//Scores scores;
	//DatabaseCon db;
	public static Thread thread;
	Handler handler;
	static STATE state = STATE.menu;
	Image img;
	public static Image pause;
	Player player;
	Pause pauseScreen;
	Random r;
	Start start;
	Help help;
	End end;
	HUD hud;
	JOptionPane pane;
	public boolean running;
	static boolean tempBool;
	int x1 = 0;
	int x2 = 640;
	//OmerSen
	public static void main(String[] args) {

		new Game();
	}

	public Game() { 
		pane = new JOptionPane();
		//db = new DatabaseCon();
		//scores = new Scores(db);
		handler = new Handler();
		start = new Start();
		help = new Help();
		end = new End(); 
		hud = new HUD();
		pauseScreen = new Pause();
		r = new Random();
		player = new Player(100, 300, ID.Player, handler);
		handler.addObject(player);
		addMouseListener(new MouseInput(this, player));
		addKeyListener(new KeyInput(player, this)); 
		img = new ImageIcon("src/background.png").getImage(); 
		init();


		//music();

	}

	public void init() {
		tempBool = drawLines;
		drawLines = false;
		HUD.score = 0;
		HUD.pipeCount = 0;
		for(int i=1100; i<2000; i+=300) {
			int temprand = r.nextInt(200)+100;
			int temp = r.nextInt(5);
			if(temp == 0) {
				handler.addObject(new Pipe(i, 0, ID.Pipe, temprand, true, true));
				handler.addObject(new Pipe(i, 0, ID.Pipe2, height-temprand-Pipe.spaceBetween, false, true));
			}else {
				handler.addObject(new Pipe(i, 0, ID.Pipe, temprand, true, false));
				handler.addObject(new Pipe(i, 0, ID.Pipe2, height-temprand-Pipe.spaceBetween, false, false));
			}
		}

		pause = new ImageIcon("src/pause.png").getImage();
	}
	public void start() {
		thread = new Thread(this); 
		thread.start();
		running = true;
	}

	public void run() {
		this.requestFocus();
		long lastTime =  System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >=1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(frames);
				frames = 0;
			}
		}
	}

	public void tick() {
		if(state == STATE.play) {
			x1 -= 5;
			x2 -= 5;
			if(x1 <= -640)
				x1 = 640;
			if(x2 <= -640)
				x2 = 640;

			handler.tick();
			hud.tick();
		}
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		g.drawImage(img, x1, 0, width, height, this); // Draw an image that you like
		g.drawImage(img, x2, 0, width, height, this);

		GameObject temp = handler.getClosest();
		GameObject temp2 = handler.getClosestDown();


		if(state == STATE.menu) {
			start.render(g);
		}
		if(state == STATE.help) {
			help.render(g);
		}
		if(state == STATE.play || state == STATE.pause) {
			handler.render(g);
			hud.render(g);
		}
		if(drawLines) {
			g.setColor(Color.red);
			g.drawLine(125, player.getY()+25, temp.getX()+25, temp.getY()+temp.getHeight());
			g.drawLine(125, player.getY()+25, temp2.getX()+25, temp2.getY());
		}
		if(state == STATE.stop) {
			handler.render(g);
			end.render(g);
			//scores.render(g);
		}

		if(state == STATE.pause) {
			handler.render(g);
			hud.render(g);
			pauseScreen.render(g);
		}

		if(state != STATE.menu && state != STATE.help) {
			g.drawImage(pause, 570, 50, 50, 50, this);
		}

		g.dispose();
		bs.show();
	}

	public static enum STATE {
		menu,
		help,
		stop,
		pause,
		play();
	}

	public static int clamp(int var, int min, int max) {
		if(var < min)
			return var = min;
		else if(var > max)
			return var = max;
		else
			return var;
	}

	public void removeAll() {
		for(int i=0; i<handler.list.size(); i++) {
			GameObject temp = handler.list.get(i);
			if(temp.getID() != ID.Player) {
				handler.removeObject(temp);
				i--;
			}
		}
	}

	/*public static void music() 
	{       

		AudioPlayer MGP = AudioPlayer.player;
		AudioStream BGM;
		AudioData MD;

		ContinuousAudioDataStream loop = null;

		try
		{
			InputStream test = new FileInputStream("src/music.wav");
			BGM = new AudioStream(test);
			AudioPlayer.player.start(BGM);
			//
			if(!music)
				AudioPlayer.player.stop(BGM);
			//MD = BGM.getData();
			//loop = new ContinuousAudioDataStream(MD);

		}
		catch(FileNotFoundException e){
			System.out.print(e.toString());
		}
		catch(IOException error)
		{
			System.out.print(error.toString());
		}
		MGP.start(loop);
	}*/


}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player extends GameObject{

	public static int x;
	public int y;
	public ID id;
	public int velY;
	public int speed = 5;
	public int width = 50;
	public int height = 50;
	public int grate = 1;
	DatabaseCon db;
	int count = 0;
	Handler handler;
	Image img;
	//ArrayList<Rectangle> collisions = new ArrayList<Rectangle>();

	public Player(int x, int y, ID id, Handler handler, DatabaseCon db) {
		super(x, y, id);
		this.x = x;
		this.y = y;
		this.db = db;
		this.handler = handler;
		this.id = id;
		img = new ImageIcon("src/Bird.png").getImage();
		setupCollisions();

	}

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.x = x;
		this.y = y;
		this.handler = handler;
		this.id = id;
		img = new ImageIcon("src/Bird.png").getImage();
		setupCollisions();

	}

	public void setupCollisions() {

	}
	@Override
	public void tick() {
		y += velY;
		y = Game.clamp(y, 0, 640-height);
		count ++;
		if(count == 4) {
			count = 0;
			velY += grate;
		}
		if(!Game.testRun)
			collision();
	}

	public void drawHitbox(Graphics g) {
		g.setColor(Color.red);
		Rectangle []temp = getHitbox();
		for(int i=0; i<temp.length; i++) {
			g.fillRect(temp[i].x, temp[i].y, temp[i].width, temp[i].height);
		}
	}

	public Rectangle[] getHitbox() {
		Rectangle []temp = new Rectangle[2];

		temp[0] = new Rectangle(x+8, y+5, width-16, height-10);
		temp[1] = new Rectangle(x, y+15, width-40, height-30);
		return temp;

	}

	@Override
	public void render(Graphics g) {
		//drawHitbox(g);
		g.drawImage(img, x, y, width, height, null);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x+2, y+2, width-2, height-1);
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getY() {	
		return y;
	}

	public ID getID() {
		return id;
	}

	public void collision() {
		for(int i=0;i<handler.list.size();i++) {
			GameObject temp = handler.list.get(i);
			if(temp.getID() == ID.Pipe || temp.getID() == ID.Pipe2) {

				Rectangle []collisions = getHitbox();
				for(int x=0; x<collisions.length; x++) {
					if(collisions[x].getBounds().intersects(temp.getBounds())) {

						Game.state = Game.STATE.stop;
							End.score = HUD.score;
							End.pipe = HUD.pipeCount;
							//String name= JOptionPane.showInputDialog(Window.frame,"Your Name"); 
							//HUD.name = name;
							if(HUD.pipeCount > End.highPipe)
								End.highPipe = HUD.pipeCount;
							if(HUD.score > End.high) {
								End.high = HUD.score;
							}

							//db.insertScore(HUD.score, HUD.name, HUD.pipeCount);
							HUD.score = 0;
							HUD.pipeCount = 0;
						 
						//System.out.println("COLLISION");

					}
				}
			}
		}
	}
}



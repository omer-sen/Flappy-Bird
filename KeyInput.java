import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{

	Player player;
	Game game;
	public static int jump = 0;
	public boolean []keyDown = new boolean[4];
	public KeyInput(Player player, Game game) {
		this.player = player;
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if((key == KeyEvent.VK_W || key == KeyEvent.VK_UP)) { 
			jump = player.getY();
			player.setVelY(-5);
			keyDown[0] = true; 
		}
		if(key == KeyEvent.VK_SPACE && Game.state == Game.STATE.stop) {
			game.removeAll();
			game.init();
			Game.state = Game.STATE.play;
		}
		if(key == KeyEvent.VK_P) {
			if(Game.state == Game.STATE.pause) {
				Game.pause = MouseInput.pause;
				Game.state = Game.STATE.play;
			}else if(Game.state == Game.STATE.play) {
				Game.pause = MouseInput.play;
				Game.state = Game.STATE.pause;
			}
		}
		
	}

	public void keyReleased(KeyEvent e) {
		
	}
}

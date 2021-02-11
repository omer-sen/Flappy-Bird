import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;



public class MouseInput implements MouseListener{

	Player player;
	Game game;
	public static Image play;
	public static Image pause;
	public MouseInput(Game game, Player player) {
		this.game = game;
		this.player = player;
		play = new ImageIcon("src/play.png").getImage();
		pause = new ImageIcon("src/pause.png").getImage();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		//g.drawRect(270, 400, 100, 30);
		
		if(Game.state == Game.STATE.help) {
			if(mx >= 270 && mx <= 370) {
				if(my >= 450 && my <=500) {
					Game.state = Game.STATE.menu;
				}
			}
		}
		if(Game.state == Game.STATE.menu) {
			if(mx >= 270 && mx <= 370) {
				if(my >= 150 && my <= 200) {
					Game.state = Game.STATE.play;
				}if(my >= 250 && my <= 300) {
					Game.state = Game.STATE.help;
				}
				if(my >= 350 && my <= 400) {
					System.exit(1);
				}
			}
		}
		if(Game.state == Game.STATE.stop) {
			if(mx >= 270 && mx <= 370) {
				if(my >= 400 && my <= 430) {
					game.removeAll();
					game.init();
					Game.state = Game.STATE.play;
				}
			}
		}
		
		if(Game.state == Game.STATE.pause) {
			if(mx >= 270 && mx <= 370) {
				if(my >= 280 && my <= 310) {
					Game.pause = pause;
					Game.state = Game.STATE.play;
				}
				if(my >= 330 && my <=360) {
					//Game.state = Game.STATE.pause;
					game.removeAll();
					game.init();
					Game.state = Game.STATE.play;
				}
			}
		}
		
		if(Game.state == Game.STATE.play|| Game.state == Game.STATE.pause) {
			if(mx >= 570 && mx <=620) {
				if(my >= 50 && my <= 100) {
					if(Game.state == Game.STATE.pause) {
						Game.pause = pause;
						Game.state = Game.STATE.play;
					}else if(Game.state == Game.STATE.play) {
						Game.pause = play;
						Game.state = Game.STATE.pause;
					}
				}
			}
		}
		if(Game.state == Game.STATE.play && (mx < 570 || mx >620)&& (my <50 || my > 100)) {
			player.setVelY(-5);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

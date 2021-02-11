import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Help {
	public Rectangle returnMenu = new Rectangle(270, 450, 100, 50);
	public void render(Graphics g) {
		Font fnt0 = new Font("arial", Font.BOLD, 20);
		g.setFont(fnt0);
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(returnMenu);
		g.drawString("MENU", 280, 485);
		g.drawString("JUMP: MOUSE KEY ", 230, 150);
		g.drawString("JUMP: W  ", 230, 200);
		g.drawString("JUMP: UP ARROW ", 230, 250);
		g.drawString("PAUSE/CONTINUE: P ", 230, 300);
		g.drawString("RESTART THE GAME: SPACE ", 230, 350);
		
		
	}
}

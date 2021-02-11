import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Start {

	public Rectangle playButton = new Rectangle(320 - 50, 150, 100,50);
	public Rectangle instructions = new Rectangle(320 - 50, 250, 100,50);
	public Rectangle quitButton = new Rectangle(320 - 50, 350, 100,50);

	public void render(Graphics g) {
		Font fnt0 = new Font("arial", Font.BOLD, 45);
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt0);
		g.setColor(Color.WHITE);
		g.drawString("FlappyBird", 200, 100);
		g.setFont(fnt1);
		g.drawString("by Omer Sen",400,130);
		Graphics2D g2d = (Graphics2D) g; 
		g.setFont(fnt1);
		g.setColor(Color.black);
		g2d.draw(playButton);
		g.drawString("Play", 280, 185);
		
		g2d.draw(instructions);
		g.drawString("HELP", 280, 285);
		
		g2d.draw(quitButton);
		g.drawString("QUIT", 280, 385);
	}
}

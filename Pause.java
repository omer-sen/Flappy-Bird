import java.awt.Color;
import java.awt.Graphics;

public class Pause {
	
	
	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(200, 220, 240, 200);
		g.setColor(Color.black);
		
		g.drawRect(270, 280, 100, 30);
		g.drawString("Continue", 285, 300);
		
		g.drawRect(270, 330, 100, 30);
		g.drawString("Restart", 285, 350);
	}
}

import java.awt.Color;
import java.awt.Graphics;

public class End {

	public static int score = 0;
	public static int high = 0;
	public static int pipe = 0;
	public static int highPipe = 0;
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(200, 200, 240, 240);
		g.setColor(Color.black);
		g.drawRect(270, 400, 100, 30);
		g.drawString("Play Again", 285, 420);
		g.drawString("Pipe Score: "+pipe, 220, 230);
		g.drawString("Highest Pipe: "+highPipe, 220, 260);
		g.drawString("Your Score: "+score, 220, 330);
		g.drawString("High Score", 220, 360);
		g.drawString(HUD.name+": "+high, 220, 390);
		
	}
}

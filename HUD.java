import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {

	public static int score = 0;
	public static int pipeCount = 0;
	public static String name = "";
	public void render(Graphics g) {
	
		g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
		g.setColor(Color.white);
		g.drawString("Score: "+score, 50, 70);
		g.drawString("Pipe: "+pipeCount, 50, 100);
	}
	
	public void tick() {
		score++;
	}

}
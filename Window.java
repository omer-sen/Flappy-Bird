import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	public Window(int width, int height, String title, Game game) {
		frame = new JFrame(title);
		frame.setSize(new Dimension(width, height));
		frame.setResizable(false);
		
		frame.add(game);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		game.start();
	}
	
}

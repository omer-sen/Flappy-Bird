


//import the packages for using the classes in them into the program
import javax.swing.*;
import java.awt.*;

public class Splash{
	public static Game game;
	public Splash(Game game) {
		this.game = game;
	}
	public static JProgressBar jb;
	public static JWindow splash;
	// A simple little method to show a title screen in the
	// center of the screen for a given amount of time.
	public void showSplash(int duration) {
		splash = new JWindow();
		JPanel content = (JPanel) splash.getContentPane();
		jb = new JProgressBar(0,100);
		jb.setValue(0);
		jb.setStringPainted(true);
		// set the window's bounds, centering the window
		/*int width = 354;
        int height = 268;*/
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - 500) / 2;
		int y = (screen.height - 500) / 2;
		splash.setBounds(x, y, 500, 500);
		//splash.setBounds(0,0,screen.width,screen.height-30);

		// build the splash screen
		Image img = new ImageIcon("src/background.png").getImage();

		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(img));
		JLabel copyrt = new JLabel("", JLabel.CENTER);
		copyrt.setFont(new Font("Tahoma", Font.BOLD, 10));
		//copyrt.setBorder(BorderFactory.createEtchedBorder());
		content.setBackground(Color.BLACK);
		//content.setBackground(new Color(232, 232, 228));
		content.add(label, BorderLayout.CENTER);
		content.add(jb, BorderLayout.SOUTH);
		content.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		// display it
		splash.setVisible(true);

		// Wait a little while, maybe while loading resources

		/*try {
			for(int i=1; i<=100; i++) {
				jb.setValue(jb.getValue() +1);
				Thread.sleep(duration);
			}
		}

		catch (Exception e) {
		}
		splash.dispose();
		*/


		
	}
	public static void update() {
		jb.setValue(jb.getValue() + 10);
		if(jb.getValue() == 100) {
			splash.dispose();
			new Window(Game.width, Game.height, "FlappyBird", game);
		}
	}


}

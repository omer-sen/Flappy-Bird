import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Pipe extends GameObject{

	public int x;
	public int y;
	public ID id;
	public static int spaceBetween = 150;
	public static int minSize = 120;
	public int velY = 3;
	public int velX = -5;
	public boolean top;
	public int width = 80;
	public int height;
	public boolean moving;
	Image img;
	
	
	public Pipe(int x, int y, ID id, int height, boolean top, boolean moving) {
		super(x, y, id);
		this.x = x;
		this.height = height;
		this.id = id;
		this.top = top;
		this.moving = moving;
		if(top) {
			this.y = y;
			img = new ImageIcon("src/Pipe2.png").getImage();
		}else {
			this.y = Game.height - height;
			img = new ImageIcon("src/Pipe.png").getImage();
		}
	}

	@Override
	public void tick() {
		x += velX;
		if(moving) {
			if(top) {
				height += velY;
				if(height<=minSize || height>= Game.height-minSize-spaceBetween)
					velY = -velY;
			}else if(!top) {
				y += velY;
				height -= velY;
				if(height<=minSize || height>= Game.height-minSize-spaceBetween)
					velY = -velY;			
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	
	public ID getID() {
		return id;
	}
	
	public int getX() {
		return x;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getY() {
		return y;
	}
	
}

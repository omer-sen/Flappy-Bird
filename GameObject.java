import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	public int x;
	public int y;
	public int velX;
	public int velY;
	public int height;
	
	public ID id;
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setVelX(int value) {
		velX = value;
	}
	
	public void setVelY(int value) {
		velY = value;
	}
	
	public ID getID() {
		return id;
	}
	
	public int getHeight() {
		return height;
	}
}

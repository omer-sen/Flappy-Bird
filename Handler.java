import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Handler {
	LinkedList<GameObject> list = new LinkedList<GameObject>();

	Random r;
	int temprand;
	int rand;
	Handler() {
		r = new Random();
	}
	public void render(Graphics g) {
		for(int i = 0; i < list.size(); i++) {
			GameObject temp = list.get(i);
			temp.render(g);
			

			if(temp.getID() == ID.Pipe) {
				if(temp.getX()<=-80) {
					i--;
					temprand = r.nextInt(200)+100;
					removeObject(temp);
					rand = r.nextInt(5);
					if(rand==0) {
						addObject(new Pipe(800,0,ID.Pipe, temprand, true, true));
					}else {
						addObject(new Pipe(800,0,ID.Pipe, temprand, true, false));
					}
					HUD.pipeCount++;
				}
			}
			if(temp.getID() == ID.Pipe2) {
				if(temp.getX()<=-80) {
					i--;
					removeObject(temp);
					if(rand == 0) {
						addObject(new Pipe(800,0,ID.Pipe2, Game.height-temprand-Pipe.spaceBetween, false, true));
					}else {
						addObject(new Pipe(800,0,ID.Pipe2, Game.height-temprand-Pipe.spaceBetween, false, false));
					}
				}
			}
		}
	}

	public void tick() {
		for(int i = 0; i < list.size(); i++) {
			GameObject temp = list.get(i);
			temp.tick();
		}
	}

	public void addObject(GameObject obj) {
		list.add(obj);
	}

	public void removeObject(GameObject obj) {
		list.remove(obj);
	}


	public GameObject getClosest() {
		int distance = 1000;
		GameObject closest = null;
		for(int i=0; i<list.size(); i++) {
			GameObject temp = list.get(i);
			if(temp.getID()==ID.Pipe) {
				if(temp.getX() <= distance&&temp.getX()>Player.x) {
					distance = temp.getX();
					closest = temp;
					Game.drawLines = Game.tempBool;
				}
			}
		}
		return closest;
	}

	public GameObject getClosestDown() {
		int distance = 1000;
		GameObject closest = null;
		for(int i=0; i<list.size(); i++) {
			GameObject temp = list.get(i);
			if(temp.getID()==ID.Pipe2) {
				if(temp.getX() <= distance&&temp.getX()>Player.x) {
					distance = temp.getX();
					closest = temp;
					Game.drawLines = Game.tempBool;
				}
			}
		}
		return closest;
	}
}

import java.awt.Color;
import java.awt.Graphics;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Scores {

	DatabaseCon db;
	public Scores(DatabaseCon db) {
		this.db = db;
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.orange);
		g.fillRect(70, 150, 500, 300);
		g.setColor(Color.white);
		g.drawString("Name\t\t\tPipe\t\t\tScore\t\t\tDate", 100, 180);
		try {
			ResultSet temp = db.getScores();
			for(int i=0;temp.next(); i++) {
				g.drawString(temp.getString("name")+"\t\t\t"+temp.getString("pipe_score")+"\t\t\t"+temp.getString("score")+"\t\t\t"+temp.getString("date"), 100, i*30+210);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.setColor(Color.black);
		g.drawRect(270, 400, 100, 30);
		g.drawString("Play Again", 285, 420);
	}
	
}

 package paint;

import java.awt.Color;
import java.awt.Graphics;
//needs to get a point that stores colors

public class BucketTool implements Tool {

	public void mousePressed(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		Color temp = g.getColor();
		g.setColor(Color.pink);
		g.fillOval(x, y, 1, 1);

		floodFill(g,x,y,temp,Color.pink);
	}

	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
	}

	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}

	public void floodFill(Graphics g, int x,int y, Color target, Color replacement){
		if (target ==replacement){
			return;
		}
		//point needs to store color
		//if(color of node not equal to target color)
		g.fillOval(x, y, 1, 1);
		floodFill(g, x+1, y, target, replacement);
		floodFill(g, x-1, y, target, replacement);
		floodFill(g, x, y+1, target, replacement);
		floodFill(g, x, y-1, target, replacement);
		
	}
}

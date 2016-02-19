package rozenberg.mco364.paint;

import java.awt.Graphics;

public interface Tool {
	//all interface methods are public
	
	//get the point not the event becasue all we care about is the x and y
	void mousePressed(Graphics g, int x,int y);
	void mouseReleased(Graphics g, int x, int y);
	void mouseDragged(Graphics g, int x, int y);
	void drawPreview(Graphics g);
}

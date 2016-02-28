package paint;

import java.awt.Color;
import java.awt.Graphics;

public interface Tool {
	// all interface methods are public

	// get the point not the event becasue all we care about is the x and y
	void mousePressed(Graphics g, int x, int y, Color color);

	void mouseReleased(Graphics g, int x, int y, Color color);

	void mouseDragged(Graphics g, int x, int y, Color color);

	void drawPreview(Graphics g, Color color);
}

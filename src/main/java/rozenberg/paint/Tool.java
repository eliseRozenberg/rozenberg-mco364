package rozenberg.paint;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Tool {
	// all interface methods are public

	protected PaintProperties properties;

	public Tool(PaintProperties properties) {
		this.properties = properties;
	}

	// get the point not the event becasue all we care about is the x and y
	abstract void mousePressed(Graphics g, int x, int y);

	abstract void mouseReleased(Graphics g, int x, int y);

	abstract void mouseDragged(Graphics g, int x, int y);

	abstract void drawPreview(Graphics g);
}

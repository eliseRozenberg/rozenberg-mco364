package paint;

import java.awt.Color;
import java.awt.Graphics;

public class OvalTool extends Tool {
	private int x1, y1, x2, y2, tempX, tempY, width, height;

	public OvalTool(PaintProperties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	public void mousePressed(Graphics g, int x, int y) {
		g.setColor(properties.getColor());
		x1 = x;
		y1 = y;
		x2 = x;
		y2 = y;

	}

	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(properties.getColor());
		x2 = x;
		y2 = y;
		g.drawOval(tempX, tempY, width, height);
	}

	public void mouseDragged(Graphics g, int x, int y) {
		x2 = x;
		y2 = y;
	}

	public void drawPreview(Graphics g) {
		g.setColor(properties.getColor());
		tempX = x1;
		tempY = y1;
		width = x2 - x1;
		height = y2 - y1;

		if (x1 > x2) {
			tempX = x2;
			width = x1 - x2;
		}
		if (y1 > y2) {
			tempY = y2;
			height = y1 - y2;
		}
		g.drawOval(tempX, tempY, width, height);
	}
}

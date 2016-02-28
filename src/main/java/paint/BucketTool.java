package paint;

import java.awt.Color;
import java.awt.Graphics;
//needs to get a point that stores colors
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool implements Tool {
	private BufferedImage image;
	Queue<Point> points;

	public BucketTool(Canvas canvis) {
		image = canvis.getBufferedImage();
		points = new LinkedList<Point>();
	}

	public void mousePressed(Graphics g, int x, int y, Color color) {
	}

	public void mouseReleased(Graphics g, int x, int y, Color newColor) {
		Point point = new Point(x, y);
		int rgb = image.getRGB(x, y);
		points.add(point);
		while (!points.isEmpty()) {
			point = points.remove();
			x = point.getX();
			y = point.getY();
			if (x < image.getWidth() && x >= 0 && y < image.getHeight() && y >= 0)
				if (image.getRGB(x, y) == rgb) {
					image.setRGB(x, y, newColor.getRGB());
					points.add(new Point(x, y + 1));
					points.add(new Point(x, y - 1));
					points.add(new Point(x + 1, y));
					points.add(new Point(x - 1, y));
				}
		}
	}

	public void mouseDragged(Graphics g, int x, int y, Color color) {
		// TODO Auto-generated method stub

	}

	public void drawPreview(Graphics g, Color color) {
		// TODO Auto-generated method stub

	}
}

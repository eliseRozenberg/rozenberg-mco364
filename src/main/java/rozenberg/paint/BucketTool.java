package rozenberg.paint;

import java.awt.Color;
import java.awt.Graphics;
//needs to get a point that stores colors
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool extends Tool {
	private BufferedImage image;
	private Queue<Point> points;
	private Color color;

	public BucketTool(CanvasRepaintManager manager, PaintProperties properties) {
		super(manager, properties);
		image = properties.getImage();
		points = new LinkedList<Point>();
		color = properties.getColor();
	}

	public void mousePressed(Graphics g, int x, int y) {
	}

	public void mouseReleased(Graphics g, int x, int y) {
		color = properties.getColor();
		fill(x, y, color);
	}

	public void mouseDragged(Graphics g, int x, int y) {

	}

	public void drawPreview(Graphics g) {
	}

	public void fill(int x, int y, Color newColor) {
		Point point = new Point(x, y);
		int rgb = image.getRGB(x, y);
		int target = newColor.getRGB();
		if (rgb == target) {
			return;
		}
		points.add(point);
		while (!points.isEmpty()) {
			point = points.remove();
			x = point.getX();
			y = point.getY();
			if (x < image.getWidth() && x >= 0 && y < image.getHeight() && y >= 0)
				if (image.getRGB(x, y) == rgb) {
					image.setRGB(x, y, target);
					points.add(new Point(x, y + 1));
					points.add(new Point(x, y - 1));
					points.add(new Point(x + 1, y));
					points.add(new Point(x - 1, y));
				}
		}
	}

}

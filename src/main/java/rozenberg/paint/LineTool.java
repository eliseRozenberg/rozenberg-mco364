package rozenberg.paint;

import java.awt.Graphics;
import java.util.logging.Logger;

public class LineTool extends Tool {

	// every class gets it's own and unique name
	private static final Logger LOG = Logger.getLogger(LineTool.class.getName());

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public LineTool(PaintProperties properties) {
		super(properties);
	}

	public void mousePressed(Graphics g, int x, int y) {
		g.setColor(properties.getColor());
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(properties.getColor());
		g.drawLine(this.x1, this.y1, x, y);

	}

	public void mouseDragged(Graphics g, int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}

	public void drawPreview(Graphics g) {
		g.setColor(properties.getColor());
		// g.drawLine(this.x1, this.y1, x2, y2);
		g.drawLine(this.x1, this.y1, x2, x2);
		String message = String.format("x1 = %d, y1 = %d, x2 = %d, y2 = %d", x1, y1, x2, y2);
		//messages can get different priorities
		//LOG.info(message);
		LOG.fine(message);
	}

}

package rozenberg.paint;

import java.awt.Graphics;

import com.google.inject.Inject;

public class PencilTool extends Tool {
	private int x;
	private int y;

	@Inject
	public PencilTool(CanvasRepaintManager manager, PaintProperties properties) {
		super(manager, properties);
	}

	public void mousePressed(Graphics g, int x, int y) {
		g.setColor(properties.getColor());
		g.fillOval(x, y, 1, 1);
		this.x = x;
		this.y = y;
		manager.repaint(x, y, x + 1, y + 1);
	}

	public void mouseReleased(Graphics g, int x, int y) {
	}

	public void mouseDragged(Graphics g, int x, int y) {
		g.setColor(properties.getColor());
		g.drawLine(x, y, this.x, this.y);
		this.x = x;
		this.y = y;
	}

	public void drawPreview(Graphics g) {
	}

}

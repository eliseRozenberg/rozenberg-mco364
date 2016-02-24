package rozenberg.mco364.paint;

import java.awt.Graphics;

public class OvalTool implements Tool {
	private int x1, x2, y1, y2;

	public void mousePressed(Graphics g, int x, int y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		g.drawOval(this.x1, this.y1, this.x2, this.y2);
	}

	public void mouseDragged(Graphics g, int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}

	public void drawPreview(Graphics g) {
		g.drawOval(this.x1, this.y1, this.x2, this.y2);
	}

}

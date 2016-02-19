package rozenberg.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class RectangleTool implements Tool {
	private int x;
	private int y;

	public void mousePressed(Graphics g, int x, int y) {
		g.setColor(Color.red);
		this.x = x;
		this.y = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(Color.red);
		//g.drawRect( );
		this.x = x;
		this.y = y;
	}

	public void mouseDragged(Graphics g, int x, int y) {
		
	}

	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}

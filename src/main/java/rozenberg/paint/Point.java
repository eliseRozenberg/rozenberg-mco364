package rozenberg.paint;

import java.awt.Color;

public class Point {
	private int x;
	private int y;
	private Color color;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		color = Color.black;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}

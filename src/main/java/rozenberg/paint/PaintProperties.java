package rozenberg.paint;

import java.awt.Color;
import java.awt.image.BufferedImage;
import com.google.inject.Singleton;

@Singleton
public class PaintProperties {

	private int width;
	private int height;
	private Color color;
	private int weight;
	private BufferedImage image;

	public PaintProperties() {
		width = 900;
		height = 900;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		this.color = Color.BLACK;
		this.weight = 1;
	}

	public PaintProperties(int weight, BufferedImage image) {
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.weight = weight;
		this.color = Color.BLACK;
		this.image = image;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Color getColor() {
		return color;
	}

	public int getWeight() {
		return weight;
	}

	public BufferedImage getImage() {
		return image;
	}

}

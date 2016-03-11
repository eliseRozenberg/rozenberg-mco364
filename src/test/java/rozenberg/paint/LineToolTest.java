package rozenberg.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.junit.Test;
import org.mockito.Mockito;

public class LineToolTest {

	@Test
	public void testMouseReleased() {
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.red);

		LineTool tool = new LineTool(properties);
		Graphics g = Mockito.mock(Graphics.class);

		tool.mousePressed(g, 5, 5);
		tool.mouseReleased(g, 10, 10);

		Mockito.verify(g, Mockito.atLeastOnce()).setColor(Color.red);
		Mockito.verify(g).drawLine(5, 5, 10, 10);

	}

	public void testDrawPreview() {
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.red);

		LineTool tool = new LineTool(properties);
		Graphics g = Mockito.mock(Graphics.class);

		tool.mousePressed(g, 5, 5);
		tool.mouseDragged(g, 7, 7);
		tool.drawPreview(g);
		Mockito.verify(g).drawLine(5, 5, 7, 7);
	}
}

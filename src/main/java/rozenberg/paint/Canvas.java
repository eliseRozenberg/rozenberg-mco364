package rozenberg.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.Stack;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BufferedImage buffer;
	private PaintProperties properties;
	private Stack<Raster> undo;
	private Stack<Raster> redo;
	// private Stack<BufferedImage> undo;
	// private Stack<BufferedImage> redo;
	private Tool tool;

	public Canvas(PaintProperties properties) {
		this.properties = properties;
		tool = new PencilTool(this.properties);
		this.setBackground(Color.white);
		buffer = properties.getImage();
		undo = new Stack<Raster>();
		redo = new Stack<Raster>();
		undo.push(buffer.getData());
		// undo = new Stack<BufferedImage>();
		// redo = new Stack<BufferedImage>();
		addListeners();
	}

	public void addListeners() {
		this.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent event) {
				// undo.push(drawCopy(buffer));
				tool.mouseReleased(buffer.getGraphics(), event.getX(), event.getY());
				repaint();
			}

			public void mousePressed(MouseEvent event) {
				undo.push(buffer.getData());
				tool.mousePressed(buffer.getGraphics(), event.getX(), event.getY());
				repaint();
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}
		});
		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseMoved(MouseEvent e) {
			}

			public void mouseDragged(MouseEvent event) {
				tool.mouseDragged(buffer.getGraphics(), event.getX(), event.getY());
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g);
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	private BufferedImage drawCopy(BufferedImage buffer) {
		BufferedImage newImage = new BufferedImage(buffer.getWidth(), buffer.getHeight(), buffer.getType());
		Graphics2D g2d = newImage.createGraphics();
		g2d.drawImage(buffer, 0, 0, null);
		g2d.dispose();
		return newImage;
	}

	public void undo() {
		if (!undo.isEmpty()) {
			redo.push(buffer.getData());
			// Raster r= undo.pop();
			// redo.push(r);
			// buffer.setData(r);
			buffer.setData(undo.pop());
			// redo.push(drawCopy(buffer));
			// buffer = undo.pop();
			repaint();

		}
	}

	public void redo() {
		if (!redo.isEmpty()) {
			undo.push(buffer.getData());
			buffer.setData(redo.pop());
			// undo.push(drawCopy(buffer));
			// buffer = redo.pop();
			repaint();
		}
	}

	public boolean undoIsEmpty() {
		return undo.isEmpty();
	}

	public boolean redoIsEmpty() {
		return redo.isEmpty();
	}

	public BufferedImage getBufferedImage() {
		return this.buffer;
	}

	public void clear() {
		buffer = new BufferedImage(900, 900, BufferedImage.TYPE_INT_ARGB);
		Graphics g = getGraphics();
		g.drawImage(buffer, 0, 0, null);
		repaint();

	}
}

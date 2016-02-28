package paint;

import java.awt.Color;
import java.awt.Graphics;
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
	private Stack<Raster> undo;
	private Stack<Raster> redo;
	private Color color;
	private Tool tool;

	public Canvas(Color color) {
		tool = new PencilTool();
		this.setBackground(Color.white);
		this.color = color;
		buffer = new BufferedImage(900, 900, BufferedImage.TYPE_INT_ARGB);
		undo = new Stack<Raster>();
		//undo.push(buffer.getData());
		redo = new Stack<Raster>();
		addListeners();
	}

	public void addListeners() {
		this.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent event) {
				tool.mouseReleased(buffer.getGraphics(), event.getX(), event.getY(), color);
				repaint();
				undo.push(buffer.getData());
			}

			public void mousePressed(MouseEvent event) {
				tool.mousePressed(buffer.getGraphics(), event.getX(), event.getY(), color);
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
				tool.mouseDragged(buffer.getGraphics(), event.getX(), event.getY(), color);
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g, this.color);
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void undo() {
		buffer.setData(undo.pop());
		redo.push(buffer.getData());
		repaint();
	}

	public void redo() {
		buffer.setData(redo.pop());
		undo.push(buffer.getData());
		repaint();
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
}

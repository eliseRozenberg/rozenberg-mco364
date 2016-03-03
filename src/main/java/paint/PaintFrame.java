package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PaintFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Canvas canvas;
	private Container container;
	private JPanel toolPanel, drawPanel, fillPanel;
	private JButton lineButton, pencilButton, rectangleButton, ovalButton, rectangleFButton, ovalFButton, bucketButton,
			newButton, colorButton, undoButton, redoButton;

	private Tool lineTool, pencilTool, rectangleTool, rectangleFTool, ovalTool, ovalFTool, bucketTool;
	private Font font;
	private Color color;

	public PaintFrame() {

		setTitle("Paint");
		setSize(900, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		container = getContentPane();

		canvas = new Canvas(Color.black);
		toolPanel = new JPanel();
		drawPanel = new JPanel();
		fillPanel = new JPanel();

		lineButton = new JButton();
		pencilButton = new JButton();
		rectangleButton = new JButton();
		rectangleFButton = new JButton();
		ovalButton = new JButton();
		ovalFButton = new JButton();
		bucketButton = new JButton();
		newButton = new JButton();
		colorButton = new JButton();
		undoButton = new JButton();
		redoButton = new JButton();

		lineTool = new LineTool();
		pencilTool = new PencilTool();
		rectangleTool = new RectangleTool();
		rectangleFTool = new RectangleFillTool();
		ovalTool = new OvalTool();
		ovalFTool = new OvalFillTool();
		bucketTool = new BucketTool(canvas);

		formatComponents();
		addCompnents();
		actionListeners();

	}

	private void actionListeners() {
		lineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(lineTool);
			}
		});
		pencilButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(pencilTool);
			}
		});
		rectangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(rectangleTool);
			}
		});
		rectangleFButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(rectangleFTool);
			}
		});
		ovalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(ovalTool);
			}
		});
		ovalFButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(ovalFTool);
			}
		});
		bucketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(bucketTool);
			}
		});
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// erase canvis

			}
		});
		colorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
				if (color != null) {
					colorButton.setBackground(color);
					canvas.setColor(color);
				}
			}
		});
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.undo();
				// redoButton.setEnabled(true);
				// if (canvas.undoIsEmpty()) {
				// undoButton.setEnabled(false);
				// }
			}
		});
		redoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.redo();
				// undoButton.setEnabled(true);
				// if (canvas.redoIsEmpty()) {
				// redoButton.setEnabled(false);
				// }
			}
		});
	}

	private void addCompnents() {
		container.add(toolPanel, BorderLayout.NORTH);
		container.add(canvas, BorderLayout.CENTER);

		toolPanel.add(pencilButton);
		toolPanel.add(lineButton);
		toolPanel.add(rectangleButton);
		toolPanel.add(ovalButton);
		toolPanel.add(rectangleFButton);
		toolPanel.add(ovalFButton);
		toolPanel.add(bucketButton);
		toolPanel.add(newButton);
		toolPanel.add(colorButton);
		toolPanel.add(undoButton);
		toolPanel.add(redoButton);
	}

	private void formatComponents() {
		container.setLayout(new BorderLayout());
		toolPanel.setLayout(new FlowLayout());

		font = new Font("Calibri", Font.PLAIN, 15);
		pencilButton.setIcon(new ImageIcon(formatIcon(40, 30, "draw.jpg")));
		lineButton.setIcon(new ImageIcon(formatIcon(40, 30, "line.png")));
		rectangleButton.setIcon(new ImageIcon(formatIcon(40, 30, "rectangle.png")));
		rectangleFButton.setIcon(new ImageIcon(formatIcon(40, 30, "fillRectangle.jpg")));
		ovalButton.setIcon(new ImageIcon(formatIcon(40, 30, "circle.png")));
		ovalFButton.setIcon(new ImageIcon(formatIcon(40, 30, "fillCircle.png")));
		bucketButton.setIcon(new ImageIcon(formatIcon(40, 30, "bucket.png")));
		colorButton.setIcon(new ImageIcon(formatIcon(40, 30, "paintBrush.png")));
		colorButton.setBackground(Color.black);
		undoButton.setIcon(new ImageIcon(formatIcon(40, 30, "undo.jpg")));
		redoButton.setIcon(new ImageIcon(formatIcon(40, 30, "redo.jpg")));
		newButton.setText("NEW");
	}

	public Image formatIcon(int width, Integer height, String image) {
		ImageIcon icon = new ImageIcon(image);
		Image img = icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		return img;
	}

	public static void main(String[] args) {
		PaintFrame frame = new PaintFrame();
		frame.setVisible(true);
	}

}
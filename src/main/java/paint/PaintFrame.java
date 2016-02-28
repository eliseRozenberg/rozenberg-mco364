package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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

		lineButton = new JButton("Line");
		pencilButton = new JButton("Pencil");
		rectangleButton = new JButton("Rectangle");
		rectangleFButton = new JButton("Fill Rectangle");
		ovalButton = new JButton("Oval");
		ovalFButton = new JButton("Fill Oval");
		bucketButton = new JButton("Bucket");
		newButton = new JButton("New Page");
		colorButton = new JButton("Color");
		undoButton = new JButton("Undo");
		redoButton = new JButton("Redo");

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
				undoButton.setEnabled(true);
			}
		});
		pencilButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(pencilTool);
				undoButton.setEnabled(true);
			}
		});
		rectangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(rectangleTool);
				undoButton.setEnabled(true);
			}
		});
		rectangleFButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(rectangleFTool);
				undoButton.setEnabled(true);
			}
		});
		ovalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(ovalTool);
				undoButton.setEnabled(true);
			}
		});
		ovalFButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(ovalFTool);
				undoButton.setEnabled(true);
			}
		});
		bucketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setTool(bucketTool);
				undoButton.setEnabled(true);
			}
		});
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// erase canvis

			}
		});
		colorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.undo();
				redoButton.setEnabled(true);
				if (canvas.undoIsEmpty()) {
					undoButton.setEnabled(false);
				}
			}
		});
		redoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.redo();
				undoButton.setEnabled(true);
				if (canvas.redoIsEmpty()) {
					redoButton.setEnabled(false);
				}
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

		pencilButton.setBorder(new LineBorder(Color.red, 5, true));
		lineButton.setBorder(new LineBorder(Color.blue, 5, true));
		rectangleButton.setBorder(new LineBorder(Color.green, 5, true));
		rectangleFButton.setBackground(Color.green);
		ovalButton.setBorder(new LineBorder(Color.orange, 5, true));
		ovalFButton.setBackground(Color.orange);
		bucketButton.setBackground(Color.yellow);
		newButton.setBackground(Color.gray);
		redoButton.setEnabled(false);
		undoButton.setEnabled(false);

		font = new Font("Calibri", Font.PLAIN, 15);
		pencilButton.setFont(font);
		lineButton.setFont(font);
		rectangleButton.setFont(font);
		rectangleFButton.setFont(font);
		ovalButton.setFont(font);
		ovalFButton.setFont(font);
		bucketButton.setFont(font);
		rectangleButton.setFont(font);
		rectangleFButton.setFont(font);
		ovalButton.setFont(font);
		ovalFButton.setFont(font);
		bucketButton.setFont(font);
		newButton.setFont(font);
	}

	public static void main(String[] args) {
		PaintFrame frame = new PaintFrame();
		frame.setVisible(true);
	}
}
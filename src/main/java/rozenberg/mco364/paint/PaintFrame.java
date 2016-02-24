package rozenberg.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Canvis canvis;
	private Container container;
	private JPanel toolPanel;
	private JButton lineButton, pencilButton, rectangleButton, ovalButton, bucketButton;

	Tool lineTool, pencilTool, rectangleTool, ovalTool, bucketTool;

	public PaintFrame() {

		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();

		canvis = new Canvis();
		toolPanel = new JPanel();

		lineButton = new JButton("Line");
		pencilButton = new JButton("Pencil");
		rectangleButton = new JButton("Rectangle");
		ovalButton = new JButton("Oval");
		bucketButton = new JButton("Bucket");

		lineTool = new LineTool();
		pencilTool = new PencilTool();
		rectangleTool = new RectangleTool();
		ovalTool = new OvalTool();
		bucketTool = new BucketTool();

		formatComponents();
		addCompnents();
		actionListeners();

	}

	public void actionListeners() {
		lineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvis.setTool(lineTool);
			}
		});
		pencilButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvis.setTool(pencilTool);
			}
		});
		rectangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvis.setTool(rectangleTool);
			}
		});
		ovalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvis.setTool(ovalTool);
			}
		});
		bucketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvis.setTool(bucketTool);
			}
		});
	}

	public void addCompnents() {
		container.add(toolPanel, BorderLayout.NORTH);
		container.add(canvis, BorderLayout.CENTER);

		toolPanel.add(pencilButton);
		toolPanel.add(lineButton);
		toolPanel.add(rectangleButton);
		toolPanel.add(ovalButton);
		toolPanel.add(bucketButton);
	}

	public void formatComponents() {
		container.setLayout(new BorderLayout());
		toolPanel.setLayout(new FlowLayout());

		pencilButton.setBackground(Color.red);
		lineButton.setBackground(Color.blue);
		rectangleButton.setBackground(Color.green);
		ovalButton.setBackground(Color.orange);
		bucketButton.setBackground(Color.yellow);
	}

	public static void main(String[] args) {
		PaintFrame frame = new PaintFrame();
		frame.setVisible(true);
	}
}
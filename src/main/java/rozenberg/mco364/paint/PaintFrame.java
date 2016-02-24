package rozenberg.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PaintFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Canvis canvis;
	private Container container;
	private JPanel toolPanel,drawPanel,fillPanel;
	private JButton lineButton, pencilButton, rectangleButton, ovalButton, rectangleFButton, ovalFButton, bucketButton;

	private Tool lineTool, pencilTool, rectangleTool, rectangleFTool, ovalTool, ovalFTool, bucketTool;
	private Font font;
	
	public PaintFrame() {

		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();

		canvis = new Canvis();
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

		lineTool = new LineTool();
		pencilTool = new PencilTool();
		rectangleTool = new RectangleTool();
		rectangleFTool = new RectangleFillTool();
		ovalTool = new OvalTool();
		ovalFTool = new OvalFillTool();
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
		rectangleFButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvis.setTool(rectangleFTool);
			}
		});
		ovalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvis.setTool(ovalTool);
			}
		});
		ovalFButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvis.setTool(ovalFTool);
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
		
		toolPanel.add(drawPanel,BorderLayout.WEST);
		toolPanel.add(fillPanel,BorderLayout.EAST);
		
		drawPanel.add(pencilButton);
		drawPanel.add(lineButton);
		drawPanel.add(rectangleButton);
		drawPanel.add(ovalButton);
		
		fillPanel.add(rectangleFButton);
		fillPanel.add(ovalFButton);
		
	}

	public void formatComponents() {
		container.setLayout(new BorderLayout());
		toolPanel.setLayout(new BorderLayout());
		drawPanel.setLayout(new FlowLayout());
		fillPanel.setLayout(new FlowLayout());
		
		pencilButton.setBorder(new LineBorder(Color.red, 5, true));
		lineButton.setBorder(new LineBorder(Color.blue, 5, true));
		rectangleButton.setBorder(new LineBorder(Color.green, 5, true));
		rectangleFButton.setBackground(Color.green);
		ovalButton.setBorder(new LineBorder(Color.orange, 5, true));
		ovalFButton.setBackground(Color.orange);
		bucketButton.setBackground(Color.yellow);
		
		font = new Font("Calibri", Font.PLAIN, 20);
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
	}

	public static void main(String[] args) {
		PaintFrame frame = new PaintFrame();
		frame.setVisible(true);
	}
}
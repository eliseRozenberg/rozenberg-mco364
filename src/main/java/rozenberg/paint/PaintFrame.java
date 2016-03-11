package rozenberg.paint;

//resize outside of program

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class PaintFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Canvas canvas;
	private PaintProperties properties;
	private ToolButton[] toolButtons;
	private Container container;
	private JPanel toolPanel;
	private JButton colorButton, undoButton, redoButton, newButton;
	private Color color;

	@Inject
	public PaintFrame() {
		setTitle("Paint");
		setSize(900, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		container = getContentPane();

		properties = new PaintProperties(1, new BufferedImage(900, 900, BufferedImage.TYPE_INT_ARGB));

		canvas = new Canvas(properties);
		toolPanel = new JPanel();

		newButton = new JButton();
		colorButton = new JButton();
		undoButton = new JButton();
		redoButton = new JButton();

		toolButtons = new ToolButton[] { new ToolButton(new LineTool(properties), "/line.png"),
				new ToolButton(new PencilTool(properties), "/draw.jpg"),
				new ToolButton(new RectangleTool(properties), "/rectangle.png"),
				new ToolButton(new RectangleFillTool(properties), "/fillRectangle.jpg"),
				new ToolButton(new OvalTool(properties), "/circle.png"),
				new ToolButton(new OvalFillTool(properties), "/fillCircle.png"),
				new ToolButton(new BucketTool(properties), "/bucket.png") };

		formatComponents();
		addCompnents();
		actionListeners();

	}

	private void actionListeners() {
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ToolButton button = (ToolButton) event.getSource();
				canvas.setTool(button.getTool());
			}
		};

		for (ToolButton button : toolButtons) {
			toolPanel.add(button);
			button.addActionListener(listener);
		}

		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.clear();
			}
		});
		colorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
				if (color != null) {
					colorButton.setBackground(color);
					properties.setColor(color);
				}
			}
		});
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.undo();
			}
		});
		redoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.redo();
			}
		});
	}

	private void addCompnents() {
		container.add(toolPanel, BorderLayout.NORTH);
		container.add(canvas, BorderLayout.CENTER);

		toolPanel.add(newButton);
		toolPanel.add(undoButton);
		toolPanel.add(redoButton);
		toolPanel.add(colorButton);
	}

	private void formatComponents() {
		container.setLayout(new BorderLayout());
		toolPanel.setLayout(new FlowLayout());
		toolPanel.setBackground(Color.pink);

		colorButton.setIcon(new ImageIcon(formatIcon(40, 30, getClass().getResource("/paintBrush.png"))));
		colorButton.setBackground(Color.black);
		undoButton.setIcon(new ImageIcon(formatIcon(40, 30, getClass().getResource("/undo.jpg"))));
		undoButton.setBackground(Color.white);
		redoButton.setIcon(new ImageIcon(formatIcon(40, 30, getClass().getResource("/redo.jpg"))));
		redoButton.setBackground(Color.white);
		newButton.setText("NEW");
		newButton.setBackground(Color.white);
	}

	public Image formatIcon(int width, Integer height, URL image) {
		ImageIcon icon = new ImageIcon(image);
		Image img = icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		return img;
	}

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame frame = injector.getInstance(PaintFrame.class);
		// PaintFrame frame = new PaintFrame();
		frame.setVisible(true);
	}

}
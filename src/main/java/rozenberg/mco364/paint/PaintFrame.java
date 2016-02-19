package rozenberg.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PaintFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Canvis canvis;
	private Container container;

	public PaintFrame() {

		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();

		canvis = new Canvis();
		
		formatComponents();
		addCompnents();

	}

	public void addCompnents() {
		container.add(canvis, BorderLayout.CENTER);
	}

	public void formatComponents() {
		container.setLayout(new BorderLayout());
	}

	public static void main(String[] args) {
		PaintFrame frame = new PaintFrame();
		frame.setVisible(true);
	}
}
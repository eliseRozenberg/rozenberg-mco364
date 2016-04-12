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
import java.io.IOException;
import java.net.URL;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.common.base.FinalizablePhantomReference;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;


public class PaintFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Container container;

	@Inject
	public PaintFrame(final Canvas canvas, PaintToolbar toolbar) {
		setTitle("Paint");
		setSize(900, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		container = getContentPane();

		container.setLayout(new BorderLayout());
		container.add(canvas, BorderLayout.CENTER);
		container.add(toolbar, BorderLayout.NORTH);
	}

	public static void main(String[] args) throws SecurityException, IOException {
		Logger logger = Logger.getLogger("rozenberg.paint");
		logger.setLevel(Level.FINE);
		//set level of logger
		Handler handler = new ConsoleHandler();
		//Handler handler = new FileHandler("log");
		//handles where the logs get sent to
		handler.setLevel(Level.FINE);
		logger.addHandler(handler);
		Injector injector = Guice.createInjector(new PaintModule());
		injector.getInstance(PaintFrame.class).setVisible(true);
		// PaintFrame frame = new PaintFrame();
		// frame.setVisible(true);
	}

}

package rozenberg.paint;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tool tool;

	public ToolButton(Tool tool, String iconName) {
		this.tool = tool;
		setIcon(new ImageIcon(formatIcon(40, 30, getClass().getResource(iconName))));
		this.setBackground(Color.white);

	}

	public Image formatIcon(int width, Integer height, URL image) {
		ImageIcon icon = new ImageIcon(image);
		Image img = icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		return img;
	}

	public Tool getTool() {
		return tool;
	}
}

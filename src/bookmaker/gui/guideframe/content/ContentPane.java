package bookmaker.gui.guideframe.content;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bookmaker.gui.borders.CyanTitledBorder;

@SuppressWarnings("serial")
public class ContentPane extends JComponent {

	private static final File GUIDE_FILE = new File("res/images/bookmaker_guide.png");
	private static final ImageIcon GUIDE_ICON = new ImageIcon("res/images/open_guide.png");
	
	
	public ContentPane() {
		this.setLayout(new FlowLayout());
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		this.add(centerPanel());
	}
	
	
	private JPanel centerPanel() {
		JLabel label = new JLabel(
				"<html><p style=\"text-align:center\">" +
				"Here is a guide image to help you to understand how this program works.<br>" +
				"Click the button below to open the image<br>" +
				"|<br>" +
				"v<br>" +
				"</p></html>", 
				SwingConstants.CENTER);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton openImageButton = new JButton(GUIDE_ICON);
		openImageButton.setContentAreaFilled(false);
		openImageButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		openImageButton.addActionListener(e -> {
			try {
				Desktop.getDesktop().open(GUIDE_FILE);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createCompoundBorder(new CyanTitledBorder("Guide"), new EmptyBorder(5, 5, 5, 5)));
		
		panel.add(label);
		panel.add(openImageButton);
		
		return panel;
	}
}

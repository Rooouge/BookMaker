package bookmaker.gui.mainframe.content.message;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MessagePanel extends JPanel {
	
	private JLabel textLabel;
	
	
	public MessagePanel() {
		this.setLayout(new BorderLayout(5, 5));
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		textLabel = new JLabel(
				"<html><p style=\"text-align:center\">" +
				"If you need a tutorial about this program or you found a bug and you want to submit it,<br>" +
				"go to the \"Help\" menu and select the corresponding option." + 
				"</p></html>", 
				SwingConstants.CENTER);
		textLabel.setForeground(new Color(128, 128, 128));
		
		this.add(textLabel, BorderLayout.CENTER);
	}
	
	
	public void setMessage(String text) {
		textLabel.setText("<html><p style=\"text-align:center\">" + text + "</p></html>");
	}

}

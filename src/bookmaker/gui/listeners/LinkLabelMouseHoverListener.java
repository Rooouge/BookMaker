package bookmaker.gui.listeners;

import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JLabel;

import bookmaker.gui.Color;
import bookmaker.gui.bugreportframe.content.ContentPane;

public class LinkLabelMouseHoverListener implements MouseListener {

	private JLabel label;
	
	
	public LinkLabelMouseHoverListener(JLabel label) {
		this.label = label;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		try {
			if(label.getText().equals(ContentPane.REDDIT_LINK))
				Desktop.getDesktop().browse(new URI(label.getText()));
			else if(label.getText().equals(ContentPane.GMAIL_LINK))
				Desktop.getDesktop().mail(URI.create("mailto:" + label.getText() + "?subject=BookMaker%20-%20Bug%20report"));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		label.setForeground(Color.BLUE.awt());
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		label.setForeground(Color.BLACK.awt());
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		//Empty
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//Empty
	}

}

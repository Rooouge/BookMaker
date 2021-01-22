package bookmaker.gui.components;

import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EmptyPanel extends JPanel {

	public EmptyPanel() {
		
	}
	
	public EmptyPanel(int width, int height) {
		
		this.setPreferredSize(new Dimension(width, height));
	}
}

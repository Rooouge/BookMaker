package bookmaker.gui.mainframe.content.preview;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import bookmaker.gui.listeners.SwitchPageMouseHoverListener;
import bookmaker.gui.mainframe.content.editor.EditorPanel;

@SuppressWarnings("serial")
public class SwitchPagePanel extends JPanel {

	private static final ImageIcon PREVIOUS_PAGE_BUTTON = new ImageIcon("res/images/previous_page.png");
	private static final ImageIcon NEXT_PAGE_BUTTON = new ImageIcon("res/images/next_page.png");
	
	private EditorPanel editor;
	
	
	public SwitchPagePanel(EditorPanel editor) {
		this.editor = editor;
		this.add(switchPagePanel());
	}
	
	private JPanel switchPagePanel() {
		JButton previousPageButton = new JButton(PREVIOUS_PAGE_BUTTON);
		previousPageButton.setContentAreaFilled(false);
		previousPageButton.setBorder(null);
		previousPageButton.addMouseListener(new SwitchPageMouseHoverListener(previousPageButton, SwitchPageMouseHoverListener.PREVIOUS_BUTTON));
		previousPageButton.addActionListener(e -> editor.changePage(false));
		
		JButton nextPageButton = new JButton(NEXT_PAGE_BUTTON);
		nextPageButton.setContentAreaFilled(false);
		nextPageButton.setBorder(null);
		nextPageButton.addMouseListener(new SwitchPageMouseHoverListener(nextPageButton, SwitchPageMouseHoverListener.NEXT_BUTTON));
		nextPageButton.addActionListener(e -> editor.changePage(true));
		
		JPanel panel = new JPanel(new GridLayout(1, 2, 50, 0));
		panel.setOpaque(false);
		panel.add(previousPageButton);
		panel.add(nextPageButton);
		
		return panel;
	}
}

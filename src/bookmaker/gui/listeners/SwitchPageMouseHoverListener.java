package bookmaker.gui.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SwitchPageMouseHoverListener implements MouseListener {

	public static final String PREVIOUS_BUTTON = "previousButton";
	public static final String NEXT_BUTTON = "nextButton";
	private static final ImageIcon PREVIOUS_PAGE_BUTTON_HOVER = new ImageIcon("res/images/previous_page_hover.png");
	private static final ImageIcon NEXT_PAGE_BUTTON_HOVER = new ImageIcon("res/images/next_page_hover.png");

	private JButton button;
	private Icon onEnterIcon;
	private Icon onExitIcon;
	
	
	public SwitchPageMouseHoverListener(JButton button, String buttonType) {
		this.button = button;
		this.onExitIcon = button.getIcon();
		
		if(buttonType.equals(PREVIOUS_BUTTON))
			this.onEnterIcon = PREVIOUS_PAGE_BUTTON_HOVER;
		else
			this.onEnterIcon = NEXT_PAGE_BUTTON_HOVER;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//Empty
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		button.setIcon(onEnterIcon);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		button.setIcon(onExitIcon);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//Empty
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//Empty
	}
	
	

}

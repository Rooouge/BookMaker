package bookmaker.gui.mainframe.menubar;

import javax.swing.JMenu;

import bookmaker.gui.borders.CyanTitledBorder;

@SuppressWarnings("serial")
public class Menu extends JMenu {

	
	public Menu(String arg0) {
		super(arg0);
		setForeground(CyanTitledBorder.CYAN);
	}
}

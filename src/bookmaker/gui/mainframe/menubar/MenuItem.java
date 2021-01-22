package bookmaker.gui.mainframe.menubar;

import javax.swing.Icon;
import javax.swing.JMenuItem;

import bookmaker.gui.borders.CyanTitledBorder;

@SuppressWarnings("serial")
public class MenuItem extends JMenuItem {

	public MenuItem(String arg0) {
		super(arg0);
		setForeground(CyanTitledBorder.CYAN);
	}
	
	public MenuItem(String arg0, Icon arg1) {
		super(arg0, arg1);
		setForeground(CyanTitledBorder.CYAN);
	}
}

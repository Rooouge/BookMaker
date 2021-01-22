package bookmaker.gui.borders;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class CyanTitledBorder extends TitledBorder {
	
	public static final Color CYAN = new Color(0, 100, 160); 
	
	
	public CyanTitledBorder(String title) {
		super(title);
		setTitleColor(CYAN);
		UIManager.put("TitledBorder.border", new LineBorder(CYAN, 2));
	}

}

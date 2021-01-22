package bookmaker.gui.mainframe.content.editor.rowhandler;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import bookmaker.gui.Color;

public class TextHandlerButtons {

	private static final Border BUTTON_DEFAULT_BORDER = new JButton().getBorder();
	private static final LineBorder BUTTON_GREEN_BORDER = new LineBorder(Color.DARK_GREEN.awt(), 2, true);
	
	private JButton colorButton;
	private JButton boldButton;
	private JButton italicButton;
	private JButton underlinedButton;
	
	
	public TextHandlerButtons(TextRow row) {
		colorButton = new JButton("");
		colorButton.setBackground(Color.BLACK.awt());
		colorButton.setForeground(Color.BLACK.awt());
		colorButton.addActionListener(e -> {
			Color newColor = row.getColor().next();
			java.awt.Color newColorAwt = newColor.awt();
			colorButton.setBackground(newColorAwt);
			colorButton.setForeground(newColorAwt);
			row.setColor(newColor);
		});
		colorButton.addMouseWheelListener(e -> {
			Color newColor;
			
			if(e.getWheelRotation() < 0)
				newColor = row.getColor().next();
			else
				newColor = row.getColor().previous();
				
			java.awt.Color newColorAwt = newColor.awt();
			colorButton.setBackground(newColorAwt);
			colorButton.setForeground(newColorAwt);
			row.setColor(newColor);
				
		});
		
		boldButton = new JButton("B");
		boldButton.setContentAreaFilled(false);
		boldButton.setFont(boldButton.getFont().deriveFont(Font.BOLD));
		boldButton.addActionListener(e -> {
			boolean reverse = !row.isBold();
			boldButton.setBorder(reverse ? BUTTON_GREEN_BORDER : BUTTON_DEFAULT_BORDER);
			row.setBold(reverse);
		});
		
		italicButton = new JButton("I");
		italicButton.setContentAreaFilled(false);
		italicButton.setFont(italicButton.getFont().deriveFont(Font.ITALIC));
		italicButton.addActionListener(e -> {
			boolean reverse = !row.isItalic();
			italicButton.setBorder(reverse ? BUTTON_GREEN_BORDER : BUTTON_DEFAULT_BORDER);
			row.setItalic(reverse);
		});
		
		underlinedButton = new JButton("<html><u>U</u></html>");
		underlinedButton.setContentAreaFilled(false);
		underlinedButton.addActionListener(e -> {
			boolean reverse = !row.isUnderline();
			underlinedButton.setBorder(reverse ? BUTTON_GREEN_BORDER : BUTTON_DEFAULT_BORDER);
			row.setUnderline(reverse);
		});
	}

	/*
	 * Getters & Setters
	 */
	
	public JPanel getButtonsPanel() {
		JPanel panel = new JPanel(new GridLayout(1, 4, 2, 2));
		
		panel.add(colorButton);
		panel.add(boldButton);
		panel.add(italicButton);
		panel.add(underlinedButton);
		
		return panel;
	}
	
}

package bookmaker.gui.mainframe.content.editor.rowhandler;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import bookmaker.format.ASCII;
import bookmaker.gui.mainframe.MainFrameHandler;

@SuppressWarnings("serial")
public class RowHandler extends JPanel implements DocumentListener {

	private MainFrameHandler frame;
	private TextHandlerButtons textHandlerButtons;
	private JTextField textField;
	private JTextPane preview;
	private TextRow row;
	
	
	public RowHandler(MainFrameHandler frame) {
		this.frame = frame;
		this.row = new TextRow(this);
		this.textHandlerButtons = new TextHandlerButtons(row);
		this.textField = new JTextField("", 30);
		this.textField.getDocument().addDocumentListener(this);
		
		this.setLayout(new BorderLayout(10, 10));
		this.add(textHandlerButtons.getButtonsPanel(), BorderLayout.CENTER);
		this.add(textField, BorderLayout.EAST);
	}
	
	/*
	 * Getters & Setters
	 */
	
	public void setPreview(JTextPane previewTextField) {
		this.preview = previewTextField;
		this.preview.setEditable(false);
	}
	
	public void updatePreview() {	
		SimpleAttributeSet set = new SimpleAttributeSet();
		
		StyleConstants.setForeground(set, row.getColor().awt());
		StyleConstants.setBold(set, row.isBold());
		StyleConstants.setItalic(set, row.isItalic());
		StyleConstants.setUnderline(set, row.isUnderline());
		
//		String text = textField.getText();
//		while(ASCII.getWidth(text) > 113) {
//			text = text.substring(0, text.length() - 1);
//		}
//		textField.setText(text);
		
		if(ASCII.isValid(textField.getText()))
			textField.setForeground(Color.black);
		else
			textField.setForeground(Color.red);
		
		preview.setCharacterAttributes(set, true);
		preview.setText(textField.getText());
		
		
		
		frame.update();
	}

	
	@Override
	public void changedUpdate(DocumentEvent e) {
		updateTextRow();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		updateTextRow();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateTextRow();
	}
	
	private void updateTextRow() {
		row.setText(textField.getText());
	}
	
	public TextRow getRow() {
		return row;
	}
}

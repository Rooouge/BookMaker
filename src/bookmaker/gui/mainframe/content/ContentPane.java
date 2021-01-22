package bookmaker.gui.mainframe.content;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import bookmaker.gui.borders.CyanTitledBorder;
import bookmaker.gui.mainframe.MainFrameHandler;
import bookmaker.gui.mainframe.content.editor.EditorPanel;
import bookmaker.gui.mainframe.content.message.MessagePanel;

@SuppressWarnings("serial")
public class ContentPane extends JComponent {
	
	private EditorPanel editorPanel;
	private MessagePanel messagePanel;
	
	
	public ContentPane(MainFrameHandler frame) {
		this.setLayout(new BorderLayout(10, 10));
		
		editorPanel = new EditorPanel(frame);
		this.add(editorPanel, BorderLayout.CENTER);
		this.add(southPanel(), BorderLayout.SOUTH);
	}
	
	
	private JPanel southPanel() {
		JPanel panel = new JPanel(new BorderLayout(10, 10));

		messagePanel = new MessagePanel();
		panel.add(messagePanel, BorderLayout.NORTH);
		panel.add(footer(), BorderLayout.SOUTH);
		
		
		return panel;
	}
	
	private JPanel footer() {
		JLabel label = new JLabel("BookMaker v" + MainFrameHandler.VERSION + " (By u/roooouge)", SwingConstants.CENTER);
		label.setBackground(null);
		label.setForeground(CyanTitledBorder.CYAN);
		label.setFont(label.getFont().deriveFont(10f));
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, CyanTitledBorder.CYAN));
		panel.setBackground(new Color(200, 200, 200));
		panel.add(label);
		
		return panel;
	}
	
	/*
	 * Getters & Setters
	 */
	
	public EditorPanel getEditorPanel() {
		return editorPanel;
	}
	
	public void setMessage(String text) {
		messagePanel.setMessage(text);
	}
	
}

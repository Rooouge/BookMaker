package bookmaker.gui.mainframe.content.preview;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import bookmaker.gui.borders.CyanTitledBorder;
import bookmaker.gui.mainframe.content.editor.EditorPanel;
import bookmaker.gui.mainframe.content.editor.rowhandler.RowHandler;

@SuppressWarnings("serial")
public class PreviewPanel extends JPanel {
	
	
	public PreviewPanel(List<RowHandler> rowHandlers, EditorPanel editor) {this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new CyanTitledBorder("Preview"));
		
		this.add(new PagePanel(editor, rowHandlers));
		this.add(new SwitchPagePanel(editor));
	}
	
	
	/*
	 * Getters & Setters
	 */
}

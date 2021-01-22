package bookmaker.gui.mainframe.content.editor.pagehandler;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bookmaker.gui.borders.CyanTitledBorder;
import bookmaker.gui.mainframe.MainFrameHandler;
import bookmaker.gui.mainframe.content.editor.EditorPanel;
import bookmaker.gui.mainframe.content.editor.rowhandler.RowHandler;
import bookmaker.gui.mainframe.content.editor.rowhandler.TextRow;
import bookmaker.gui.mainframe.content.preview.PreviewPanel;

public class PageHandler {

	public static final int ROWS = 14;
	private static final EmptyBorder PADDING = new EmptyBorder(10,10,10,10);
	
	private List<RowHandler> rowHandlers;
	private EditorPanel editor;
	private int index;
	
	
	public PageHandler(MainFrameHandler frame, EditorPanel editor, int index) {
		this.editor = editor;
		this.index = index;
		
		rowHandlers = new ArrayList<>();
		for(int i = 0; i < ROWS; i++) {
			rowHandlers.add(new RowHandler(frame));
		}
	}
	
	
	public JPanel getRowHandlerPanel() {
		JPanel panel = new JPanel(new GridLayout(ROWS, 1, 10, 10));
		panel.setBorder(BorderFactory.createCompoundBorder(new CyanTitledBorder("Editor"), PADDING));
		
		for(RowHandler rh : rowHandlers) {
			panel.add(rh);
		}
		
		return panel;
	}
	
	public JPanel getPreviewPanel() {
		return new PreviewPanel(rowHandlers, editor);
	}
	
	public boolean isEmpty() {
		for(RowHandler rh : rowHandlers) {
			TextRow row = rh.getRow();
			
			if(row.isEmtpy())
				continue;
			
			return false;
		}
		
		return true;
	}
	
	/*
	 * Getters & Setters
	 */
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public List<RowHandler> getRowHandlers() {
		return rowHandlers;
	}
}

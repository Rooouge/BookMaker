package bookmaker.gui.mainframe.content.editor.rowhandler;

import bookmaker.gui.Color;

public class TextRow {

	private RowHandler handler;
	private String text;
	private Color color;
	private boolean bold;
	private boolean italic;
	private boolean underline;
	
	
	public TextRow(RowHandler handler) {
		this.handler = handler;
		this.text = "";
		this.color = Color.BLACK;
		this.bold = false;
		this.italic = false;
		this.underline = false;
	}
	
	public boolean isEmtpy() {
		return (text == null || text.replace(" ", "").equals(""));
	}
	
	/*
	 * Getters & Setters
	 */

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		handler.updatePreview();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		handler.updatePreview();
	}

	public boolean isBold() {
		return bold;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
		handler.updatePreview();
	}

	public boolean isItalic() {
		return italic;
	}

	public void setItalic(boolean italic) {
		this.italic = italic;
		handler.updatePreview();
	}

	public boolean isUnderline() {
		return underline;
	}

	public void setUnderline(boolean underline) {
		this.underline = underline;
		handler.updatePreview();
	}
	
	
}

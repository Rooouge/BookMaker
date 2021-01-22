package bookmaker.format;

import java.util.List;

import bookmaker.gui.Color;
import bookmaker.gui.mainframe.content.editor.pagehandler.PageHandler;
import bookmaker.gui.mainframe.content.editor.rowhandler.RowHandler;
import bookmaker.gui.mainframe.content.editor.rowhandler.TextRow;

public class BookFormat {

	private String title;
	private String author;
	private String result;
	
	
	public BookFormat(String title, String author, List<PageHandler> handlers) {
		this.title = title;
		this.author = author;
		format(handlers);
	}
	
	private void format(List<PageHandler> handlers) {
		result = "give @p written_book{pages:[";
		
		//Removing Empty pages
		for(int i = handlers.size() - 1; i > 0; i--) {
			PageHandler ph = handlers.get(i);
			
			if(ph == null || ph.isEmpty())
				handlers.remove(i);
			else
				break;
		}
		
		for(int i = 0; i < handlers.size(); i++) {
			result += formatPage(handlers.get(i).getRowHandlers());
			if(i < handlers.size() - 1)
				result += ",";
		}
		
		if(title == null || title.equals(""))
			title = "BookMaker Book";
		if(author == null || author.equals(""))
			author = "BookMaker";
		
		result += "],title:\"" + title + "\",author:" + author + "}";
	}
	
	private String formatPage(List<RowHandler> handlers) {
		result = "'[\"\"";
		
		int lastRow = handlers.size();
		
		//Skipping empty rows but not removing them from handler
		for(int i = handlers.size() - 1; i >= 0; i--) {
			if(handlers.get(i).getRow().isEmtpy())
				lastRow = i;
			else
				break;
		}
		
		for(int i = 0; i < lastRow; i++) {
			TextRow row = handlers.get(i).getRow();
			
			if(row == null)
				continue;
			
			String rowResult = formatRow(row);
			result += "," + rowResult;
		}
		
		result += "]'";
		
		return result;
	}
	
	private String formatRow(TextRow row) {
		String rowResult = "{";
		
		if(row.getText() == null)
			row.setText("");
		rowResult += "\"text\":\"" + Unicode.validate(ASCII.getValid(row.getText())) + "\\\\n\"";
		
		if(row.isBold())
			rowResult += ",\"bold\":true";
		if(row.isItalic())
			rowResult += ",\"italic\":true";
		if(row.isUnderline())
			rowResult += ",\"underlined\":true";
		
		if(!row.getColor().equals(Color.BLACK))
			rowResult += ",\"color\":\"" + row.getColor().name().toLowerCase() + "\"";
		
		rowResult += "}";
		return rowResult;
	}
	
	/*
	 * Getters & Setters
	 */
	
	public String getResult() {
		return result;
	}
}

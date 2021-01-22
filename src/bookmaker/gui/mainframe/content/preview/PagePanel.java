package bookmaker.gui.mainframe.content.preview;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.File;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import bookmaker.gui.Color;
import bookmaker.gui.mainframe.content.editor.EditorPanel;
import bookmaker.gui.mainframe.content.editor.pagehandler.PageHandler;
import bookmaker.gui.mainframe.content.editor.rowhandler.RowHandler;

@SuppressWarnings("serial")
public class PagePanel extends JPanel {

	private static final ImageIcon EMPTY_PAGE = new ImageIcon("res/images/empty_page.png");
	private static final Dimension DIMENSION = new Dimension(EMPTY_PAGE.getIconWidth(), EMPTY_PAGE.getIconHeight());
	
	private Font customFont;
	private EditorPanel editor;
	private List<RowHandler> rowHandlers;
	
	
	public PagePanel(EditorPanel editor, List<RowHandler> rowHandlers) {
		this.editor = editor;
		this.rowHandlers = rowHandlers;
		
		this.setPreferredSize(DIMENSION);
		
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/minecraft (2).ttf")).deriveFont(27f);
			customFont = (customFont == null ? new JTextPane().getFont() : customFont);
		} catch (Exception e) {
			new Exception("Unable to load custom font", e).printStackTrace();
		}
		
		this.add(rowsPanel());
		
		this.addMouseWheelListener(e -> {
			boolean next = e.getWheelRotation() < 0;
			editor.changePage(next);
		});
	}
	
	
	private JPanel rowsPanel() {
		Dimension dimension = new Dimension(DIMENSION.width, DIMENSION.height - 50);
		
		JPanel panel = new JPanel(new GridLayout(PageHandler.ROWS, 1, 0, -12));
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createEmptyBorder(40, 30, 0, 40));
		panel.setPreferredSize(dimension);
		
		for(int i = 0; i < rowHandlers.size(); i++) {		
			JTextPane textPane = new JTextPane();
			textPane.setText(rowHandlers.get(i).getRow().getText());
			textPane.setFont(customFont);
			textPane.setOpaque(false);
			
			panel.add(textPane);
			rowHandlers.get(i).setPreview(textPane);
			rowHandlers.get(i).updatePreview();
		}
		
		return panel;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(EMPTY_PAGE.getImage(), 0, 0, null);

		g.setFont(customFont);
		g.setColor(Color.BLACK.awt());
		
		String currentPage = "Page " + (editor.getActivePage().getIndex() + 1) + " of " + editor.getPageNum();
		int w = g.getFontMetrics().stringWidth(currentPage);
		g.drawString(currentPage, getWidth() - w - 35, 50);
	}
}

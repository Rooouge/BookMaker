package bookmaker.gui.mainframe.content.editor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bookmaker.gui.borders.CyanTitledBorder;
import bookmaker.gui.mainframe.MainFrameHandler;
import bookmaker.gui.mainframe.content.editor.pagehandler.PageHandler;
import bookmaker.sounds.SoundPlayer;

@SuppressWarnings("serial")
public class EditorPanel extends JPanel {

	private static final EmptyBorder PADDING = new EmptyBorder(10,10,10,10);
	
	private MainFrameHandler frame;
	private List<PageHandler> pageHandlers;
	private PageHandler activePage;
	private JTextField titleField;
	private JTextField authorField;
	
	private JPanel westPanel;
	private JPanel eastPanel;
	private String title;
	private String author;
	
	
	public EditorPanel(MainFrameHandler frame) {
		this.frame = frame;
		this.setLayout(new BorderLayout(5, 5));
		this.setBorder(new EmptyBorder(20, 20, 0, 20));
		
		pageHandlers = new ArrayList<>();
		activePage = new PageHandler(frame, this, 0);
		pageHandlers.add(activePage);
		
		westPanel = westPanel();
		eastPanel = eastPanel();
		this.add(westPanel, BorderLayout.WEST);
		this.add(eastPanel, BorderLayout.EAST);
	}
	
	
	private JPanel westPanel() {		
		JPanel panel = new JPanel(new BorderLayout(5, 5));
		
		panel.add(activePage.getRowHandlerPanel(), BorderLayout.CENTER);
		
		return panel;
	}
	
	private JPanel eastPanel() {
		JLabel titleLabel = new JLabel("Title");
		titleField = new JTextField(title, 20);
		JLabel authorLabel = new JLabel("Author");
		authorField = new JTextField(author, 20);
		
		JPanel titleAndAuthorPanel = new JPanel(new GridLayout(4, 1, 5, 5));
		titleAndAuthorPanel.setBorder(BorderFactory.createCompoundBorder(new CyanTitledBorder("Title & Author"), PADDING));
		titleAndAuthorPanel.add(titleLabel);
		titleAndAuthorPanel.add(titleField);
		titleAndAuthorPanel.add(authorLabel);
		titleAndAuthorPanel.add(authorField);
		
		JPanel panel = new JPanel(new BorderLayout(5, 5));
		
		panel.add(activePage.getPreviewPanel(), BorderLayout.CENTER);
		panel.add(titleAndAuthorPanel, BorderLayout.SOUTH);
		
		return panel;
	}
	
	
	public void changePage(boolean next) {		
		if(next) {
			if(activePage.getIndex() == pageHandlers.size() - 1) {
				activePage = new PageHandler(frame, this, pageHandlers.size());
				pageHandlers.add(activePage);
			}
			else
				activePage = pageHandlers.get(activePage.getIndex() + 1);
		}
		else if(activePage.getIndex() > 0) {
			if(activePage.isEmpty() && activePage.getIndex() == pageHandlers.size() - 1) {
				int index = activePage.getIndex();
				
				activePage = pageHandlers.get(index - 1);
				pageHandlers.remove(index);
				
				for(int i = index; i < pageHandlers.size(); i++) {
					pageHandlers.get(i).setIndex(i);
				}
			}
			else
				activePage = pageHandlers.get(activePage.getIndex() - 1);
		}
		else
			return;
		
		//System.out.println("Size Post: " + pageHandlers.size() + "\n\n");
		
		title = titleField.getText();
		author = authorField.getText();
		this.remove(westPanel);
		this.remove(eastPanel);
		westPanel = westPanel();
		eastPanel = eastPanel();
		this.add(westPanel, BorderLayout.WEST);
		this.add(eastPanel, BorderLayout.EAST);
		
		SoundPlayer.getInstance().playRandomPageTurn();
		
		this.revalidate();
		frame.update();
	}
	
	/*
	 * Getters & Setters
	 */
	
	public String getTitle() {
		return titleField.getText();
	}
	
	public String getAuthor() {
		return authorField.getText();
	}
	
	public PageHandler getActivePage() {
		return activePage;
	}
	
	public List<PageHandler> getPageHandlers() {
		return pageHandlers;
	}
	
	public int getPageNum() {
		return pageHandlers.size();
	}
}

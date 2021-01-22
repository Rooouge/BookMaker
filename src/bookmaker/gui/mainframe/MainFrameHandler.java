package bookmaker.gui.mainframe;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import bookmaker.format.BookFormat;
import bookmaker.gui.listeners.ApplicationListener;
import bookmaker.gui.mainframe.content.ContentPane;
import bookmaker.gui.mainframe.content.editor.EditorPanel;
import bookmaker.gui.mainframe.menubar.MenuBar;

@SuppressWarnings("serial")
public class MainFrameHandler extends JFrame {

	public static final String VERSION = "1.0";
	public static final String TITLE = "BookMaker v" + VERSION;
	public static final ImageIcon ICON = new ImageIcon("res/images/icon.png");
	
	private ContentPane contentPane;
	
	
	public MainFrameHandler() {
		super(TITLE);
		
		this.addWindowListener(new ApplicationListener());
		this.setIconImage(ICON.getImage());
		
		this.setJMenuBar(new MenuBar(this));
		contentPane = new ContentPane(this);
		this.setContentPane(contentPane);
		this.pack();

		this.setResizable(false);
		this.setLocationByPlatform(true);
		this.setVisible(true);
	}

	
	public BookFormat getBookFormat() {
		EditorPanel editorPanel = contentPane.getEditorPanel();
		
		return new BookFormat(editorPanel.getTitle(), editorPanel.getAuthor(), editorPanel.getPageHandlers());
	}
	
	public void setMessage(String text) {
		contentPane.setMessage(text);
	}
	
	public void update() {
		new Thread(() -> repaint()).start();
	}
	
}

package bookmaker.gui.bugreportframe;

import javax.swing.JFrame;

import bookmaker.gui.bugreportframe.content.ContentPane;
import bookmaker.gui.mainframe.MainFrameHandler;

@SuppressWarnings("serial")
public class BugReportFrameHandler extends JFrame {

	
	public BugReportFrameHandler() {
		super(MainFrameHandler.TITLE + " - Bug report");
		this.setIconImage(MainFrameHandler.ICON.getImage());
		
		this.setContentPane(new ContentPane());
		this.pack();
		
		this.setResizable(false);
		this.setLocationByPlatform(true);
		this.setVisible(true);
	}
}

package bookmaker.gui.guideframe;

import javax.swing.JFrame;

import bookmaker.gui.guideframe.content.ContentPane;
import bookmaker.gui.mainframe.MainFrameHandler;

@SuppressWarnings("serial")
public class GuideFrameHandler extends JFrame {

	
	public GuideFrameHandler() {
		super(MainFrameHandler.TITLE + " - Tutorial");
		this.setIconImage(MainFrameHandler.ICON.getImage());
		
		this.setContentPane(new ContentPane());
		this.pack();
		
		this.setResizable(false);
		this.setLocationByPlatform(true);
		this.setVisible(true);
	}
}

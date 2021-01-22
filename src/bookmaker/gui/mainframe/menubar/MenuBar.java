package bookmaker.gui.mainframe.menubar;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import bookmaker.format.BookFormat;
import bookmaker.gui.bugreportframe.BugReportFrameHandler;
import bookmaker.gui.guideframe.GuideFrameHandler;
import bookmaker.gui.mainframe.MainFrameHandler;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	public static final ImageIcon SAVE = new ImageIcon("res/images/save.png");
	public static final ImageIcon CLIPBOARD = new ImageIcon("res/images/clipboard.png");
	public static final ImageIcon QUESTION = new ImageIcon("res/images/question.png");
	public static final ImageIcon BUG = new ImageIcon("res/images/bug.png");
	
	
	private MainFrameHandler frame;
	
	
	public MenuBar(MainFrameHandler frame) {
		this.frame = frame;
		
		this.add(fileMenu());
		this.add(helpMenu());
	}
	
	
	private Menu fileMenu() {
		MenuItem saveItem = new MenuItem("Save", SAVE);
		saveItem.addActionListener(e -> {
			BookFormat bookFormat = frame.getBookFormat();
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Choose a file where you want to save the command");
			fileChooser.setSelectedFile(new File("MyBook.txt"));
			
			if(fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				
				if(file.exists()) {
					int result = JOptionPane.showConfirmDialog(frame, "The file \"" + file.getName() +  "\" already exists, overwrite it?");
					
					if(result != JOptionPane.OK_OPTION)
						return;
				}
				
				String msg = null;
				try (
					BufferedWriter bw = new BufferedWriter(new FileWriter(file))
				) {
					bw.write(bookFormat.getResult());
					
					msg = "Command successfully saved to file:<br>" + file.getPath();
				} catch (IOException e1) {
					msg = "Failed to save command to file:<br>" + file.getPath();
				}
				
				JOptionPane.showMessageDialog(frame, msg.replace("<br>", " "));
				frame.setMessage(msg);
			}
			
			frame.update();
		});
		
		MenuItem clipboardItem = new MenuItem("Copy to clipboard", CLIPBOARD);
		clipboardItem.addActionListener(e -> {
			BookFormat bookFormat = frame.getBookFormat();
			
			StringSelection selection = new StringSelection(bookFormat.getResult());
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);
			
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this, "Command copied to clipboard");
		});
		
		
		Menu saveExportItem = new Menu("Save/Export");
		saveExportItem.add(saveItem);
		saveExportItem.add(clipboardItem);
		
		Menu menu = new Menu("File");
		menu.add(saveExportItem);
		
		return menu;
	}
	
	private Menu helpMenu() {
		MenuItem guideItem = new MenuItem("Guide", QUESTION);
		guideItem.addActionListener(e -> new GuideFrameHandler());
		
		MenuItem bugItem = new MenuItem("Submit a bug", BUG);
		bugItem.addActionListener(e -> new BugReportFrameHandler());
		
		Menu menu = new Menu("Help");
		menu.add(guideItem);
		menu.add(bugItem);
		
		return menu;
	}
}

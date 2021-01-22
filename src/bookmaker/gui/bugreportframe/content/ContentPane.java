package bookmaker.gui.bugreportframe.content;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bookmaker.gui.borders.CyanTitledBorder;
import bookmaker.gui.listeners.LinkLabelMouseHoverListener;

@SuppressWarnings("serial")
public class ContentPane extends JComponent {
	
	public static final String REDDIT_LINK = "https://www.reddit.com/user/roooouge";
	public static final String GMAIL_LINK = "andrereds98@gmail.com";
	private static final ImageIcon REDDIT_ICON = new ImageIcon("res/images/reddit.png");
	private static final ImageIcon GMAIL_ICON = new ImageIcon("res/images/gmail.png");
	
	
	public ContentPane() {
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new CyanTitledBorder("Bug report")));
		
		this.add(infoPanel(), BorderLayout.NORTH);
		this.add(linksPanel(), BorderLayout.CENTER);
	}
	
	
	private JPanel infoPanel() {
		JLabel label = new JLabel(
				"<html><p style=\"text-align:center\">" +
				"To submit a bug report click one of the following link,<br>" +
				"then send me a private message or an email.<br>" +
				"</p></html>", 
				SwingConstants.CENTER);
		
		JPanel panel = new JPanel(new FlowLayout());
		
		panel.add(label);
		
		return panel;
	}
	
	private JPanel linksPanel() {
		JLabel redditLabel = new JLabel(REDDIT_ICON);
		JLabel redditLink = new JLabel(REDDIT_LINK);
		redditLink.addMouseListener(new LinkLabelMouseHoverListener(redditLink));
		
		JPanel redditPanel = new JPanel(new BorderLayout(5, 5));
		redditPanel.add(redditLabel, BorderLayout.WEST);
		redditPanel.add(redditLink, BorderLayout.CENTER);
		
		JLabel gmailLabel = new JLabel(GMAIL_ICON);
		JLabel gmailLink = new JLabel(GMAIL_LINK);
		gmailLink.addMouseListener(new LinkLabelMouseHoverListener(gmailLink));
		
		JPanel gmailPanel = new JPanel(new BorderLayout(5, 5));
		gmailPanel.add(gmailLabel, BorderLayout.WEST);
		gmailPanel.add(gmailLink, BorderLayout.CENTER);
		
		JPanel panel = new JPanel(new BorderLayout(5, 5));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		panel.add(redditPanel, BorderLayout.NORTH);
		panel.add(gmailPanel, BorderLayout.SOUTH);
		
		return panel;
	}
}

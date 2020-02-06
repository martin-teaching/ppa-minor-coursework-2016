package assignment14.versions.version9.view.frames;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import assignment14.versions.version9.view.panels.CalendarReminder;

public class View extends JFrame {
	
	private JTabbedPane panes;
	
	public View() {
		
		setLayout(new BorderLayout());
		
		panes = new JTabbedPane();
		
		panes.addTab("Calendar", null, new CalendarReminder(), "Show calendar");
		
		panes.addTab("Reminders", null, new CalendarReminder(), "Show reminders");
		
		add(panes, BorderLayout.CENTER);
		
		setMinimumSize(new Dimension(650, 300));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pack();
		
		setVisible(true);
		
	}

}

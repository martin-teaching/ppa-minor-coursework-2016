package assignment14.view.frames;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import assignment14.controller.CalendarReminderController;
import assignment14.controller.TextFieldController;
import assignment14.model.CalendarReminderListModel;
import assignment14.view.panels.CalendarReminder;

public class View extends JFrame {
	
	private JTabbedPane panes;
	
	public View(CalendarReminderListModel calendarModel, CalendarReminderListModel reminderModel, TextFieldController calendarFieldListener, CalendarReminderController calendarReminderListener) {
		
		setLayout(new BorderLayout());
		
		panes = new JTabbedPane();
		
		panes.addTab("Calendar", null, new CalendarReminder(calendarModel, calendarFieldListener, calendarReminderListener), "Show calendar");
		
		panes.addTab("Reminders", null, new CalendarReminder(reminderModel, calendarFieldListener, calendarReminderListener), "Show reminders");
		
		add(panes, BorderLayout.CENTER);
		
		setMinimumSize(new Dimension(650, 300));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pack();
		
		setVisible(true);
		
	}

}

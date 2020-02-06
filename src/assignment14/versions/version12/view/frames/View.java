package assignment14.versions.version12.view.frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import assignment14.versions.version12.model.CalendarReminderListModel;
import assignment14.versions.version12.view.panels.CalendarReminder;
import assignment14.versions.version12.controller.CalendarReminderController;


public class View extends JFrame {
	
	private JTabbedPane panes;
	
	/**
	 * Passed the two models needed to construct individual panels (objects of the same CalendarReminder class)
	 * with different models.
	 * 
	 * @param calendarModel
	 * @param reminderModel
	 */
	public View(CalendarReminderListModel calendarModel, CalendarReminderListModel reminderModel, ActionListener textFieldListener, CalendarReminderController calendarReminderListener) {
		
		setLayout(new BorderLayout());
		
		panes = new JTabbedPane();
		
		panes.addTab("Calendar", null, new CalendarReminder(calendarModel, textFieldListener, calendarReminderListener), "Show calendar");
		
		panes.addTab("Reminders", null, new CalendarReminder(reminderModel, textFieldListener, calendarReminderListener), "Show reminders");
		
		add(panes, BorderLayout.CENTER);
		
		setMinimumSize(new Dimension(650, 300));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pack();
		
		setVisible(true);
		
	}

}

package assignment14.versions.version12.view.panels;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import assignment14.versions.version12.model.CalendarReminderListModel;
import assignment14.versions.version12.controller.CalendarReminderController;

public class CalendarReminder extends JPanel {

	/**
	 * Only a single model is specified, assuming two objects are made of this class: one for calendar and one for reminder.
	 * 
	 * @param model
	 */
	public CalendarReminder(CalendarReminderListModel model, ActionListener textFieldListener, CalendarReminderController calendarReminderListener) {
		
		setLayout(new BorderLayout());
		
		JList<String> calendarReminder = new JList<String>();
		
		calendarReminder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		/* Don't just want to specify any old list model, want the list model that is being referenced by a listener AND
		 * the model that determines whether this shows calendar or reminder entries.
		 */
		calendarReminder.setModel(model);
		
		calendarReminder.addMouseListener(calendarReminderListener);
		
		centre(calendarReminder);
		
		south(textFieldListener);
		
	}
	
	private void centre(JList<String> calendarReminder) {
		
		add(calendarReminder, BorderLayout.CENTER);
		
	}
	
	private void south(ActionListener textFieldListener) {
		
		JTextField entry = new JTextField();
		
		entry.addActionListener(textFieldListener);
		
		add(entry, BorderLayout.SOUTH);
		
	}
	
}

package assignment14.view.panels;

import java.awt.BorderLayout;

import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import assignment14.controller.CalendarReminderController;
import assignment14.controller.TextFieldController;

public class CalendarReminder extends JPanel {

	public CalendarReminder(AbstractListModel<String> model, TextFieldController calendarReminderFieldListener, CalendarReminderController calendarReminderListener) {
		
		setLayout(new BorderLayout());
		
		JList<String> calendarReminder = new JList<String>();
		
		calendarReminder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		calendarReminder.addMouseListener(calendarReminderListener);
		
		calendarReminder.setModel(model);
		
		centre(calendarReminder);
		
		south(calendarReminderFieldListener);
		
	}
	
	private void centre(JList<String> calendarReminder) {
		
		add(calendarReminder, BorderLayout.CENTER);
		
	}
	
	private void south(TextFieldController calendarReminderFieldListener) {
		
		JTextField entry = new JTextField();
		
		entry.addActionListener(calendarReminderFieldListener);
		
		add(entry, BorderLayout.SOUTH);
		
	}
	
}

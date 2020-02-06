package assignment14.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JTextField;

import assignment14.model.CalendarReminderListModel;

public class TextFieldController implements ActionListener {
	
	private CalendarReminderListModel calendarModel;
	
	private CalendarReminderListModel reminderModel;
	
	public TextFieldController( CalendarReminderListModel calendarModel, CalendarReminderListModel reminderModel ) {
		
		this.calendarModel = calendarModel;
		
		this.reminderModel = reminderModel;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JTextField selected = (JTextField)e.getSource();
		
		if ( selected.getText().contains("Remind me to ") ) {
			
			reminderModel.addEntry(selected.getText());
			
		} else {
			
			calendarModel.addEntry(selected.getText());
			
		}
		
	}

}
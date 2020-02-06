package assignment14.versions.version13.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import assignment14.versions.version13.model.CalendarReminderListModel;

/**
 * @author Martin
 *
 */
public class TextFieldController implements ActionListener {
	
	private CalendarReminderListModel calendarModel;
	
	private CalendarReminderListModel reminderModel;
	
	/**
	 * Now accepts new list type.
	 * 
	 * @param calendarModel
	 * @param reminderModel
	 */
	public TextFieldController( CalendarReminderListModel calendarModel, CalendarReminderListModel reminderModel ) {
		
		this.calendarModel = calendarModel;
		
		this.reminderModel = reminderModel;
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JTextField selected = (JTextField)e.getSource();
		
		if ( selected.getText().contains("Remind me to ") ) {
			
			// Communication between the (custom) model and the view now handled internally by Java.
			reminderModel.formatEntry(selected.getText());
			
		} else {
			
			calendarModel.formatEntry(selected.getText());
			
		}
		
	}

}
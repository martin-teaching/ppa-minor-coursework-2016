package assignment14.versions.version10.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;

import assignment14.model.CalendarReminderListModel;

/**
 * @author Martin
 *
 */
public class TextFieldController implements ActionListener {
	
	private DefaultListModel<String> calendarModel;
	
	private DefaultListModel<String>  reminderModel;
	
	/**
	 * Needs a reference to the list model in the view, so it can add things to it.
	 * 
	 * Could inline the listener, but I'm introducing a wider point here, and separating my classes.
	 * 
	 * Moreover, a need for different models to represent the calendar, and the reminder.
	 * 
	 * @param calendarModel
	 * @param reminderModel
	 */
	public TextFieldController( DefaultListModel<String> calendarModel, DefaultListModel<String>  reminderModel ) {
		
		this.calendarModel = calendarModel;
		
		this.reminderModel = reminderModel;
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JTextField selected = (JTextField)e.getSource();
		
		// This adds to either list model, which may or not be currently shown in the view.
		if ( selected.getText().contains("Remind me to ") ) {
			
			reminderModel.addElement(selected.getText());
			
		} else {
			
			calendarModel.addElement(selected.getText());
			
		}
		
	}

}
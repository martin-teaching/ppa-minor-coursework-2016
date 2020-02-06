package assignment14.versions.version10;

import javax.swing.DefaultListModel;

import assignment14.controller.CalendarReminderController;
import assignment14.versions.version10.controller.TextFieldController;
import assignment14.versions.version10.view.frames.View;

public class Main {
	
	public static void main(String[] args) {
		
		/* So construct separate default models, to later be passed to the 
		 * controller and the view (so the former can manipulate the latter).
		 */
		DefaultListModel<String> calendarModel = new DefaultListModel<String>();
		
		DefaultListModel<String> reminderModel = new DefaultListModel<String>();
		
		TextFieldController textFieldListener = new TextFieldController(calendarModel, reminderModel);
		
		new View(calendarModel, reminderModel, textFieldListener);
		
	}

}

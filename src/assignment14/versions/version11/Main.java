package assignment14.versions.version11;

import assignment14.versions.version11.controller.TextFieldController;
import assignment14.versions.version11.model.CalendarReminderListModel;
import assignment14.versions.version11.view.frames.View;

public class Main {
	
	public static void main(String[] args) {
		
		CalendarReminderListModel calendarModel = new CalendarReminderListModel(true);
		
		CalendarReminderListModel reminderModel = new CalendarReminderListModel(false);
		
		TextFieldController textFieldListener = new TextFieldController(calendarModel, reminderModel);
		
		new View(calendarModel, reminderModel, textFieldListener);
		
	}

}

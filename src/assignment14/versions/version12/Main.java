package assignment14.versions.version12;

import assignment14.versions.version12.controller.CalendarReminderController;
import assignment14.versions.version12.controller.TextFieldController;
import assignment14.versions.version12.model.CalendarReminderListModel;
import assignment14.versions.version12.view.frames.View;

public class Main {
	
	public static void main(String[] args) {
		
		CalendarReminderListModel calendarModel = new CalendarReminderListModel(true);
		
		CalendarReminderListModel reminderModel = new CalendarReminderListModel(false);
		
		TextFieldController textFieldListener = new TextFieldController(calendarModel, reminderModel);
		
		CalendarReminderController calendarReminderListener = new CalendarReminderController();
		
		new View(calendarModel, reminderModel, textFieldListener, calendarReminderListener);
		
	}

}

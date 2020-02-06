package assignment14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import assignment14.controller.CalendarReminderController;
import assignment14.controller.TextFieldController;
import assignment14.model.CalendarReminderListModel;
import assignment14.view.frames.View;

public class Main {
	
	public static void main(String[] args) {
		
		CalendarReminderListModel calendarModel = new CalendarReminderListModel(true);
		
		CalendarReminderListModel reminderModel = new CalendarReminderListModel(false);
		
		TextFieldController textFieldListener = new TextFieldController(calendarModel, reminderModel);
		
		CalendarReminderController calendarReminderListener = new CalendarReminderController();
		
		new View(calendarModel, reminderModel, textFieldListener, calendarReminderListener);
		
	}

}

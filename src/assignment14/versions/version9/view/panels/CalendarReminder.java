package assignment14.versions.version9.view.panels;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class CalendarReminder extends JPanel {

	public CalendarReminder() {
		
		setLayout(new BorderLayout());
		
		JList<String> calendarReminder = new JList<String>();
		
		calendarReminder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		calendarReminder.setModel(new DefaultListModel<String>());
		
		centre(calendarReminder);
		
		south();
		
	}
	
	private void centre(JList<String> calendarReminder) {
		
		add(calendarReminder, BorderLayout.CENTER);
		
	}
	
	private void south() {
		
		JTextField entry = new JTextField();
		
		add(entry, BorderLayout.SOUTH);
		
	}
	
}

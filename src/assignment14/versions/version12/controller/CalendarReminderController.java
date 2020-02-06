package assignment14.versions.version12.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;

import assignment14.versions.version12.model.CalendarReminderListModel;

public class CalendarReminderController implements MouseListener {
	
	public void mouseClicked(MouseEvent e) {
		
		if ( e.getSource() instanceof JList ) {
			
			JList<String> list = (JList<String>)e.getSource();
	    
		    if ( e.getClickCount() == 2 ) {
		
		    	((CalendarReminderListModel)list.getModel()).remove(list.getSelectedIndex());
		    
		    }
	    
		}
	    
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}

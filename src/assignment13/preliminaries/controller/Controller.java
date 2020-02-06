package assignment13.preliminaries.controller;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import assignment13.preliminaries.model.SimulatedAeroplane;
import assignment13.preliminaries.view.Simulator;

/**
 * Make sure you check each student's preliminary tasks, and that they are
 * able to show you the connections between the different parts of their program.
 * 
 * 
 * Controller could also pass a reference to itself to the view without 
 * being a listener, and view's native listeners call controller to call the model.
 * 
 * @author Martin
 *
 */
public class Controller implements ActionListener, ChangeListener {
	
	/**
	 * 
	 */
	private SimulatedAeroplane model_aeroplane;
	
	// private Simulator view;
	
	/**
	 * @throws InterruptedException
	 */
	public Controller(SimulatedAeroplane model_aeroplane) throws InterruptedException {
		
		this.model_aeroplane = model_aeroplane;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// Unlabelled arrow: would facilitate controller manipulating view, but difficult interdependency
		// view.reset();
		
		// 2. Updates model
		model_aeroplane.reset();

	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		
		if ( e.getSource() instanceof JSlider ) {
		
			if ( ((JSlider)e.getSource()).getName().equals("throttle") ) {
				
				// 2. Updates model
				model_aeroplane.setSpeed(((JSlider)e.getSource()).getValue());
				
			} else if ( ((JSlider)e.getSource()).getName().equals("xPosition") ) {
				
				// 2. Updates model
				model_aeroplane.getCoordinates().setX(((JSlider)e.getSource()).getValue());
				
			}
		
		}
		
	}
	
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		
		Rectangle model_runway = new Rectangle(0, 0, 10, 100);
		
		SimulatedAeroplane model_aeroplane = new SimulatedAeroplane(model_runway);
		
		Controller controller = new Controller(model_aeroplane);
		
		// Unlabelled arrow = also addition of controller as listener
		Simulator view = new Simulator(model_aeroplane, controller);
		
		model_aeroplane.addObserver(view);
		
		model_aeroplane.simulateTakeOff();
		
	}
	
}

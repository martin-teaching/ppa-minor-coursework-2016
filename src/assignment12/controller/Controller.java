package assignment12.controller;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import assignment12.model.SimulatedAeroplane;
import assignment12.view.Simulator;

/**
 * Note that students aren't expected to have a complete MVC separation here, as they hadn't
 * covered it at the time of the coursework release, but should consider how to segment their
 * code regardless.
 * 
 * I've gone for my preferred MVC separation, which completely disconnects the
 * model from the view via an explicit intermediate controller.
 * 
 * Moreover, this provides a logical place in which to position the main simulation
 * loop.
 * 
 * This isn't entirely inline with the approach to MVC given in the lectures notes, but 
 * this approach necessitates observer/observable, which the students had not covered at the time 
 * of the assignment release.
 * 
 * Note that for the preliminaries of CW13, I will ask the students to reorganise their
 * solution for CW12 according to the approach to MVC given in the lecture notes, as they will
 * now know about observer/observable.
 * 
 * @author Martin
 *
 */
public class Controller implements ActionListener {
	
	/**
	 * 
	 */
	private SimulatedAeroplane model_aeroplane;
	
	/**
	 * 
	 */
	private Rectangle model_runway;
	
	/**
	 * 
	 */
	private Simulator view;
	
	/**
	 * 
	 */
	private int time;
	
	/**
	 * @throws InterruptedException
	 */
	public Controller() throws InterruptedException {
		
		model_runway = new Rectangle(0, 0, 10, 100);
		
		model_aeroplane = new SimulatedAeroplane(model_runway);
		
		view = new Simulator(this);
		
		simulateTakeOff();
		
	}
	
	/**
	 * @throws InterruptedException
	 */
	private void simulateTakeOff() {
		
		while ( model_aeroplane.isTakingOff() ) {
			
			/* If students emulate an MVC separation, they may not have a controller
			 * query a slider in this way, but instead conceptualise the controller as a listener,
			 * which responds to the movements of the slider and updates the model to reflect
			 * the new speed of the plane.
			 * 
			 * This way works, because we don't necessarily need to respond to changes in the sliders,
			 * but instead query the state of the sliders every second.
			 */
			if ( view.getThrottlePosition() > 0 ) {
				
				model_aeroplane.updatePosition(view.getXPosition(), view.getThrottlePosition());
				
			}
			
			view.addOutputText("Seconds: " + time++);
			
			view.addOutputText("X: " + model_aeroplane.getCoordinates().getX() + " Y: " + model_aeroplane.getCoordinates().getY() + " Speed: " + view.getThrottlePosition() + " Elevation: " + model_aeroplane.getElevation());
			
			if ( model_aeroplane.takeOffFailed() ) {
				
				view.addOutputText("Take off failed.");
				
			}
			
			if ( model_aeroplane.inFlight() ) {
				
				view.addOutputText("Plane in air.");
				
			}
			
			// Given as boilerplate code
			try { 
				
				Thread.sleep(1000);
			
			} catch ( InterruptedException e ) {}
			
		}

	}
	
	/**
	 * 
	 */
	public void reset() {
		
		view.resetOutputText();
		
		model_aeroplane.resetPosition();
		
		time = 0;
			
		if ( !model_aeroplane.isTakingOff() ) {
			
			// Will need to start a new thread if implementing reset button functionality.
			Thread simulateTakeOffContainer = new Thread() {
				
				public void run() {
					
					simulateTakeOff();
				
				}
				
			};
			
			simulateTakeOffContainer.start();
		
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		view.reset();
		reset();
		
	}
	
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		
		new Controller();
		
	}
	
}

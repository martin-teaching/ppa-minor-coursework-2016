package assignment13.preliminaries.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultCaret;

import assignment13.preliminaries.controller.Controller;
import assignment13.preliminaries.model.SimulatedAeroplane;

/**
 * Make sure you check each student's preliminary tasks, and that they are
 * able to show you the connections between the different parts of their program.
 * 
 * @author Martin
 *
 */
public class Simulator implements Observer {
	
	private JFrame frame;
	
	private JTextArea text_outputFrame;
	
	private JScrollPane scroll_outputFrame;
	
	private JPanel controlPanel;
	
	private JSlider slider_xPosition;
	
	private JSlider slider_throttle;
	
	private JButton reset;
	
	private SimulatedAeroplane model_aeroplane;
	
	/**
	 * 
	 */
	public Simulator(SimulatedAeroplane model_aeroplane, Controller controller) {
		
		this.model_aeroplane = model_aeroplane;
		
		frame = new JFrame();
		
		frame.setMinimumSize(new Dimension(500, 600));
		
		frame.setLayout(new GridLayout(2, 1));
		
		setupOutputFrame();
		
		setupControlPanel(controller);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
		
		frame.setVisible(true);
		
	}
	
	/**
	 * 
	 */
	private void setupOutputFrame() {
		
		text_outputFrame = new JTextArea();
		
		text_outputFrame.setEditable(false);
		
		scroll_outputFrame = new JScrollPane(text_outputFrame);
		
		frame.add(scroll_outputFrame);
		
		DefaultCaret caret = (DefaultCaret)text_outputFrame.getCaret();
		
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

	}
	
	/**
	 * @param outputText
	 */
	public void addOutputText(String outputText) {
		
		text_outputFrame.append(outputText + "\n");
		
	}
	
	/**
	 * 
	 */
	public void resetOutputText() {
		
		text_outputFrame.setText("");
		
	}
	
	/**
	 * 
	 */
	private void setupControlPanel(Controller controller) {
		
		controlPanel = new JPanel();
		
		controlPanel.setLayout(new BorderLayout());
		
		setupSlider_xPosition(controller);
		
		setupSlider_throttle(controller);
		
		setupReset(controller);
		
		frame.add(controlPanel);
		
	}
	
	/**
	 * Lots of students will have added ChangeListeners to their x slider, which is fine.
	 */
	private void setupSlider_xPosition(ChangeListener controller) {
		
		slider_xPosition = new JSlider();
		
		slider_xPosition.setMinimum(0);
		
		slider_xPosition.setMaximum(10);
		
		slider_xPosition.setValue(5);
		
		slider_xPosition.setName("xPosition");
		
		slider_xPosition.addChangeListener(controller);
		
		controlPanel.add(slider_xPosition, BorderLayout.NORTH);
		
	}
	
	/**
	 * @return
	 */
	public int getXPosition() {
		
		return slider_xPosition.getValue();
		
	}
	
	
	/**
	 * Lots of students will have add ChangeListeners to their throttle slider, which is fine.
	 */
	private void setupSlider_throttle(ChangeListener controller) {
		
		slider_throttle = new JSlider();
		
		slider_throttle.setMinimum(0);
		
		slider_throttle.setMaximum(10);
		
		slider_throttle.setValue(0);
		
		slider_throttle.setOrientation(SwingConstants.VERTICAL);
		
		slider_throttle.setName("throttle");
		
		slider_throttle.addChangeListener(controller);
		
		controlPanel.add(slider_throttle, BorderLayout.CENTER);
		
	}
	
	/**
	 * @return
	 */
	public int getThrottlePosition() {
		
		return slider_throttle.getValue();
		
	}
	
	/* 
	 * 4. Queries model.
	 * 
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		
		// Resets (replaces direct communication between controller and view)
		if ( model_aeroplane.getTime() == 0 ) {
			
			reset();
			
		} else {
		
			addOutputText("Seconds: " + model_aeroplane.getTime());
			
			addOutputText("X: " + model_aeroplane.getCoordinates().getX() + " Y: " + model_aeroplane.getCoordinates().getY() + " Speed: " + model_aeroplane.getSpeed() + " Elevation: " + model_aeroplane.getElevation());
			
			if ( model_aeroplane.takeOffFailed() ) {
				
				addOutputText("Take off failed.");
				
			}
			
			if ( model_aeroplane.inFlight() ) {
				
				addOutputText("Plane in air.");
				
			}
		
		}
		
	}
	
	/**
	 * 
	 */
	public void reset() {
		
		resetOutputText();
		
		slider_throttle.setValue(0);
		
		slider_xPosition.setValue(5);
		
	}
	
	/**
	 * 
	 */
	private void setupReset(ActionListener resetListener) {
		
		reset = new JButton("Reset");
		
		reset.addActionListener(resetListener);
		
		controlPanel.add(reset, BorderLayout.SOUTH);
		
	}
	
}
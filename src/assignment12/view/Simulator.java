package assignment12.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultCaret;

/**
 * Ideally don't want to see anything but Swing widgets / Listeners referenced here.
 * 
 * @author Martin
 *
 */
public class Simulator {
	
	private JFrame frame;
	
	private JTextArea text_outputFrame;
	
	private JScrollPane scroll_outputFrame;
	
	private JPanel controlPanel;
	
	private JSlider slider_xPosition;
	
	private JSlider slider_throttle;
	
	private JButton reset;

	/**
	 * Conceptualise controller as listener, as well as place in which to
	 * hold main simulation loop.
	 * 
	 * @param controller
	 */
	public Simulator(ActionListener controller) {
		
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
		
		// To make the TextArea always show the most recent content.
		DefaultCaret caret = (DefaultCaret)text_outputFrame.getCaret();
		
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

	}
	
	/**
	 * Frame effectively acts as a space to which to push information.
	 * 
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
	private void setupControlPanel(ActionListener controller) {
		
		controlPanel = new JPanel();
		
		controlPanel.setLayout(new BorderLayout());
		
		setupSlider_xPosition();
		
		setupSlider_throttle();
		
		setupReset(controller);
		
		frame.add(controlPanel);
		
	}
	
	/**
	 * Lots of students will have added a ChangeListener to their x slider, which is fine.
	 * 
	 * Ideally this should update the x position in the model, which is then referenced by
	 * the simulation loop.
	 */
	private void setupSlider_xPosition() {
		
		slider_xPosition = new JSlider();
		
		slider_xPosition.setMinimum(0);
		
		slider_xPosition.setMaximum(10);
		
		slider_xPosition.setValue(5);
		
		controlPanel.add(slider_xPosition, BorderLayout.NORTH);
		
	}
	
	/**
	 * @return
	 */
	public int getXPosition() {
		
		return slider_xPosition.getValue();
		
	}
	
	
	/**
	 * Lots of students will have added a ChangeListener to their throttle slider, which is fine.
	 * 
	 * Ideally this should update the speed in the model, which is then referenced by the simulation loop.
	 */
	private void setupSlider_throttle() {
		
		slider_throttle = new JSlider();
		
		slider_throttle.setMinimum(0);
		
		slider_throttle.setMaximum(10);
		
		slider_throttle.setValue(0);
		
		slider_throttle.setOrientation(SwingConstants.VERTICAL);
		
		controlPanel.add(slider_throttle, BorderLayout.CENTER);
		
	}
	
	/**
	 * @return
	 */
	public int getThrottlePosition() {
		
		return slider_throttle.getValue();
		
	}
	
	public void reset() {

		slider_throttle.setValue(0);
		
		slider_xPosition.setValue(5);
		
	}
	
	/**
	 * 
	 */
	private void setupReset(ActionListener controller) {
		
		reset = new JButton("Reset");
		
		reset.addActionListener(controller);
		
		controlPanel.add(reset, BorderLayout.SOUTH);
		
	}
	
}
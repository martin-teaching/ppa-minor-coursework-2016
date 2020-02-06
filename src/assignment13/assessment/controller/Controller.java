package assignment13.assessment.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import assignment13.assessment.model.Game;

/**
 * This assignment will likely be very tricky to mark.
 * 
 * So, I would advise looking for the following simple things:
 * 
 * 1. That the student can run their code, and show you a simple execution of the game where the game is won, and where the game is lost.
 * 2. That the student adheres to one form of the model view controller paradigm. You'll find different acceptable forms of the diagram here: https://github.kcl.ac.uk/MC/ppa-minor-coursework-ta/tree/ta/briefs/coursework13/e6FdNaws. Students who don't have any form of MVC separation should get at most 2/5.
 * 3. That the student has a reasonable representation in their model, such as not just having a single class called piece, from which everything extends, but appreciating the importance of using interfaces to allow type flexibility.
 *
 * @author Martin
 */
public class Controller implements ActionListener {

	private Game model;
	
	public Controller(Game model) {
		
		this.model = model;
	
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if ( event.getSource() instanceof JButton && !model.gameOver() ) {
			
			JButton button = (JButton)event.getSource();
			String id = button.getName().substring(button.getName().indexOf("-") + 1);
			
			if ( button.getName().contains("left") ) {
				
				if ( button.getName().contains("boat") ) {
					
					model.moveBoatLeft();
						
				} else {
					
					model.movePieceToBoat(model.pieceToPassenger(id));
					model.movePieceToLeftBank(model.pieceToPassenger(id));
					
				}
				
			} else if ( button.getName().contains("right") ) {
				
				if ( button.getName().contains("boat") ) {
					
					model.moveBoatRight();
					
				} else {
					
					model.movePieceToBoat(model.pieceToPassenger(id));
					model.movePieceToRightBank(model.pieceToPassenger(id));
					
				}
				
			}
			
		}
		
	}

}
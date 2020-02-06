package assignment13.assessment;

import assignment13.assessment.controller.Controller;
import assignment13.assessment.model.Game;
import assignment13.assessment.view.River;

public class Main {

	public static void main(String[] args) {
		
		Game model = new Game();
		
		model.start();
		
		Controller controller = new Controller(model);
		
		River view = new River(controller);
		
		model.addObserver(view);
		
	}

}

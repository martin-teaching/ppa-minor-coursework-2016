package assignment9;
import java.util.Collections;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		
		// 2.1
		Board board = new Board();
		
		Scanner in = new Scanner(System.in);
		
		String input;
		
		do {
			
			// 2.2
			// Inheritance allows us to neatly distinguish between ships here.
			// -1 indicates that these ships aren't actually on a row; just created for comparison. Could add second constructor.
			System.out.println("Battleships: " + Collections.frequency(board.getShips(), new Battleship(-1)));
			System.out.println("Cruisers: " + Collections.frequency(board.getShips(), new Cruiser(-1)));
			System.out.println("Frigates: " + Collections.frequency(board.getShips(), new Frigate(-1)));
			System.out.println("Minesweepers: " + Collections.frequency(board.getShips(), new Minesweeper(-1)));
			
			// 2.3
			System.out.println(board);
			
			// 2.4
			input = in.nextLine();
			
			if ( !input.equals("quit") ) {
			
			// 2.5
			if ( board.hit(Integer.parseInt(input.charAt(0) + ""), Integer.parseInt(input.charAt(2) + "")) ) {
				
				System.out.println("Hit!");
				
			} else {
				
				System.out.println("Miss!");
				
			}
			
			}
		
		// 2.6
		} while ( !input.equals("quit"));
		
		in.close();
		
	}
	
}

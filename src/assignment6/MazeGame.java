package assignment6;
import java.util.Scanner;

public class MazeGame {
	
	public static void main(String[] args){
		//status for game end
		boolean finished = false;
		
		
		//Set up the maze - first create the rooms
		// without the links between them
		Room monsterRoom = new Room();
		monsterRoom.setName("Monster Room");
		monsterRoom.setContainsMonster(true);
		
		Room firstRoom = new Room();
		firstRoom.setName("First Room");
		
		Room secondRoom = new Room();
		secondRoom.setName("Second Room");
		
		Room thirdRoom = new Room();
		thirdRoom.setName("Third Room");
		
		Room fourthRoom = new Room();
		fourthRoom.setName("Fourth Room");
		
		Room fifthRoom = new Room();
		fifthRoom.setName("Fifth Room");
		
		Room finalRoom = new Room();
		finalRoom.setName("Final Room");
		finalRoom.setFinalRoom(true);
		
		//Set up the links i.e. correct traversal path
		firstRoom.setBlueDoorRoom(monsterRoom);
		firstRoom.setRedDoorRoom(secondRoom);
		
		secondRoom.setBlueDoorRoom(thirdRoom);
		secondRoom.setRedDoorRoom(monsterRoom);
		
		thirdRoom.setBlueDoorRoom(fourthRoom);
		thirdRoom.setRedDoorRoom(monsterRoom);
		
		fourthRoom.setBlueDoorRoom(monsterRoom);
		fourthRoom.setRedDoorRoom(fifthRoom);
		
		fifthRoom.setBlueDoorRoom(finalRoom);
		fifthRoom.setRedDoorRoom(monsterRoom);
		
		Player player = new Player();
		player.setLivesRemaining(2);
		player.setCurrentRoom(firstRoom);
		Scanner scanner = new Scanner(System.in);
		String input = "";
		System.out.println("Welcome to the two-door game!");
		System.out.println("In this game, rooms are sequentially arranged, and you must traverse to the final room, which is the sixth.");
		System.out.println("Each room has two doors inside it, a blue one and a red one. You may choose to traverse only one of these options");
		System.out.println("Only one of these will lead to the next room. The other will lead to nothing, and will result in the player losing one life.");
		System.out.println("After all the player's lives are lost, the game ends. If the player reaches the final room, they win!");
		
		System.out.println("Hello mysterious stranger, please tell us your name:");
		input = scanner.nextLine();
		player.setName(input);
		System.out.println("Welcome, " + input + ". Let us begin the game...");
		while(finished == false){
			System.out.println("#############################################################################");
			System.out.println("Player: " + player.getName() + ". Lives left: " + player.getLivesRemaining());
			System.out.println("You are currently in Room: " + player.getCurrentRoom().getName());
			System.out.println("#############################################################################");
			System.out.println("Will you choose to take the blue door or the red door? Choose carefully...");
			input = scanner.nextLine();
			if(input.equalsIgnoreCase("red")){
				boolean result = player.move(player.getCurrentRoom().getRedDoorRoom());
				if(result == false){
					System.out.println("INCORRECT! The monster attacks, ROAR! You lost a life...");
					if(player.getLivesRemaining() == 0){
						System.out.println("OUT OF LIVES! Sorry, YOU LOSE!");
						finished = true;
					}
				}
				else{
					System.out.println("CORRECT! Well done, you chose the correct door! Moving to the next room...");
					if(player.getCurrentRoom().getFinalRoom() == true){
						System.out.println("YOU WIN!!!!!!!!!! You have reached the end! THANKS FOR PLAYING!");
						finished = true;
					}
				}
			}
			if(input.equalsIgnoreCase("blue")){
				boolean result = player.move(player.getCurrentRoom().getBlueDoorRoom());
				if(result == false){
					System.out.println("INCORRECT! The monster attacks, ROAR! You lost a life...");
					if(player.getLivesRemaining() == 0){
						System.out.println("OUT OF LIVES! Sorry, YOU LOSE!");
						finished = true;
					}
				}
				else{
					System.out.println("CORRECT! Well done, you chose the correct door! Moving to the next room...");
					if(player.getCurrentRoom().getFinalRoom() == true){
						System.out.println("YOU WIN!!!!!!!!!! You have reached the end! THANKS FOR PLAYING!");
						finished = true;
					}
				}
			}
			
		}
		scanner.close();
		
	}

}

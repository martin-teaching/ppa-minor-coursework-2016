package assignment6;

public class Player {
	private String name;
	private Room currentRoom;
	private int livesRemaining;
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Room getCurrentRoom() {
		return currentRoom;
	}
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	public int getLivesRemaining() {
		return livesRemaining;
	}
	public void setLivesRemaining(int livesRemaining) {
		this.livesRemaining = livesRemaining;
	}
	
	public boolean move(Room room){
		if(room.getContainsMonster() == false){
			this.setCurrentRoom(room);
			return true;
		}
		else{
			--this.livesRemaining;
			return false;
		}
		
		
	}
	
	
}

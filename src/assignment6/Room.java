package assignment6;

public class Room {
	private String name;
	private Room blueDoorRoom;
	private Room redDoorRoom;
	private boolean containsMonster;
	private boolean isFinalRoom;
	
	public boolean getContainsMonster() {
		return containsMonster;
	}
	public void setContainsMonster(boolean containsMonster) {
		this.containsMonster = containsMonster;
	}
	public boolean getFinalRoom() {
		return isFinalRoom;
	}
	public void setFinalRoom(boolean isFinalRoom) {
		this.isFinalRoom = isFinalRoom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Room getBlueDoorRoom() {
		return blueDoorRoom;
	}
	public void setBlueDoorRoom(Room left) {
		this.blueDoorRoom = left;
	}
	public Room getRedDoorRoom() {
		return redDoorRoom;
	}
	public void setRedDoorRoom(Room right) {
		this.redDoorRoom = right;
	}
	
	
	
}
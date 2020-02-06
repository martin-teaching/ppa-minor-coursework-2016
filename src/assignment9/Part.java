package assignment9;
public class Part {
	
	// 1.1.1
	private int row;
	private int column;
	
	// 1.1.2
	private boolean destroyed;
	
	// 1.1.1
	public Part(int row, int column) {
		
		this.row = row;
		this.column = column;
		
	}
	
	// 1.1.2
	public void setDestroyed() {
		
		this.destroyed = true;
		
	}
	
	// 1.1.2
	public boolean isDestroyed() {
		
		return destroyed;
		
	}
	
	// 1.1.3
	public boolean equals(Object position) {
		
		if ( !(position instanceof Part)) return false;
		
		return row == ((Part)position).row && column == ((Part)position).column;
		
	}
	
	// 1.1.4
	public String toString() {
		
		if ( destroyed ) {
			
			return "[X]";
			
		} else {
			
			return "[ ]";
			
		}
		
	}

}

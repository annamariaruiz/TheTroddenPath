package models;

public class Dragon extends BoardChar {

	private int turn;
	
	
	public int getTurn() {
		return turn;
	}

	public void increaseTurn() {
		this.turn += 1;
	}
	
	public void attack() {
		//TODO add body.
	}

	@Override
	public void setOccupiedTile(int occupiedTile) {
		//TODO add logic and restrictions for dragons
		
	}

	@Override
	public void setHealth(int health) {
		//TODO add logic and restrictions for dragons
		
	}

}

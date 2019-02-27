package models;

public abstract class BoardChar {
	protected int occupiedTile;
	protected int health;
	
	
	public int getOccupiedTile() {
		return occupiedTile;
	}
	
	public abstract void setOccupiedTile(int occupiedTile);
	
	public int getHealth() {
		return health;
	}
	
	public abstract void setHealth(int health);
	
	public void changeTile(int advance) {
		setOccupiedTile(getOccupiedTile() + advance);
	}
	
	public void changeHealth(int HPGain) {
		setHealth(getHealth() + HPGain);
	}
}

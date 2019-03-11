package models;

public abstract class BoardChar {
	protected int occupiedTile;
	protected int wellness;
	
	
	public int getOccupiedTile() {
		return occupiedTile;
	}
	
	public abstract void setOccupiedTile(int occupiedTile);
	
	public int getWellness() {
		return wellness;
	}
	
	public abstract void setWellness(int wellness);
	
	public void changeTile(int advance) {
		setOccupiedTile(getOccupiedTile() + advance);
	}
	
	public void changeWellness(int wellnessGain) {
		setWellness(getWellness() + wellnessGain);
	}
}

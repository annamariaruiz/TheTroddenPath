package models;

public class Dragon extends BoardChar {

	private int turn;
	
	public Dragon() {
		setOccupiedTile(49);
	}
	
	public int getTurn() {
		return turn;
	}

	public void increaseTurn() {
		this.turn += 1;
	}
	
	public int[] getDragonTiles() {
		int[] dragonTiles = new int[5];
		for (int i = 0; i < dragonTiles.length; i++) {
			dragonTiles[i] = getOccupiedTile() + i - 2;
		}
		
		return dragonTiles;
	}

	public int[] getDragonTiles() {
		int[] dragonTiles = new int[5];
		for(int i = 0; i < dragonTiles.length; i++) {
			dragonTiles[i] = getOccupiedTile() + i - 2;
		}
		
		return dragonTiles;
	}
	
	@Override
	public void setOccupiedTile(int occupiedTile) {
		if(occupiedTile < 4 || occupiedTile > 94) {
			throw new IllegalArgumentException("Error: The dragon may only occupy a tile at least five spaces away from the start and the end.");
		}
		
		this.occupiedTile = occupiedTile;
	}

	@Override
	public void setWellness(int wellness) {
		if(wellness < 0 || wellness > 500) {
			throw new IllegalArgumentException("Error: A dragon's health ranges from 0 to 500.");
		}
		
		this.wellness = wellness;
	}
}
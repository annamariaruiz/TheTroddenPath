package models;

public class Dragon extends BoardChar {

	private int turn;
	public final int[] ATTACK;
	
	
	public Dragon(int[] attack) {
		if(attack.length != 5) {
			throw new ArrayIndexOutOfBoundsException("Error: A dragon must have attack values for each of the tiles it attacks.");
		}
		this.ATTACK = attack;
	}
	
	public int getTurn() {
		return turn;
	}

	public void increaseTurn() {
		this.turn += 1;
	}

	@Override
	public void setOccupiedTile(int occupiedTile) {
		if(occupiedTile < 4 || occupiedTile > 94) {
			throw new IllegalArgumentException("Error: The dragon may only occupy a tile at least five spaces away from the start and the end.");
		}
	}

	@Override
	public void setWellness(int wellness) {
		if(wellness < 0 || wellness > 500) {
			throw new IllegalArgumentException("Error: A dragon's health ranges from 0 to 500.");
		}
		
		this.wellness = wellness;
	}
}

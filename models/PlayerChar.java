package models;

import java.util.ArrayList;

import models.enums.CharClass;

public class PlayerChar extends BoardChar {
	private ArrayList<Boolean> limbs;
	private CharClass charClass;
	private int shekels;
	private int prestige;
	
	public PlayerChar() {
		//TODO use constructor to initialize variables with setters
	}
	
	
	public ArrayList<Boolean> getLimbs() {
		return limbs;
	}

	public void setLimbs(ArrayList<Boolean> limbs) {
		this.limbs = limbs;
	}

	public CharClass getCharClass() {
		return charClass;
	}

	public void setCharClass(CharClass charClass) {
		this.charClass = charClass;
	}

	public int getShekels() {
		return shekels;
	}

	public void setShekels(int shekels) {
		this.shekels = shekels;
	}

	public int getPrestige() {
		return prestige;
	}

	public void setPrestige(int prestige) {
		this.prestige = prestige;
	}


	@Override
	public void setOccupiedTile(int occupiedTile) {
		//TODO add logic and restrictions for players
		
	}

	@Override
	public void setHealth(int health) {
		//TODO add logic and restrictions for players
		
	}


	@Override
	public String toString() {
		//TODO make decent-looking toString().
		
		StringBuilder builder = new StringBuilder();
		builder.append("PlayerChar [getLimbs()=").append(getLimbs()).append(", getCharClass()=").append(getCharClass())
				.append(", getShekels()=").append(getShekels()).append(", getPrestige()=").append(getPrestige())
				.append(", getOccupiedTile()=").append(getOccupiedTile()).append(", getHealth()=").append(getHealth())
				.append("]");
		return builder.toString();
	}
}

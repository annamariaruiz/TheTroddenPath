package models;

import java.util.ArrayList;

import models.enums.CharClass;

public class PlayerChar extends BoardChar {
	private ArrayList<Boolean> limbs;
	private CharClass charClass;
	private int shekels;
	private int prestige;
	private static int playerNum = 0;
	
	public PlayerChar() {
		this.limbs = new ArrayList<Boolean>();
			limbs.add(true);
			limbs.add(true);
			limbs.add(true);
			limbs.add(true);
		this.charClass = CharClass.CITIZEN;
		this.shekels = 0;
		this.prestige = 0;
		playerNum+=1;
	}
	
	
	public PlayerChar(ArrayList<Boolean> limbs, CharClass charClass, int shekels, int prestige) {
		super();
		this.limbs = limbs;
		this.charClass = charClass;
		this.shekels = shekels;
		this.prestige = prestige;
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
		this.occupiedTile = occupiedTile;
		
	}

	@Override
	public void setHealth(int health) {
		if(health > 100) {
			throw new IllegalArgumentException("A player's health must not exceed 100");
		}
		this.health = health;
		
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


	public static int getPlayerNum() {
		return playerNum;
	}


	public static void setPlayerNum(int playerNum) {
		PlayerChar.playerNum = playerNum;
	}
}


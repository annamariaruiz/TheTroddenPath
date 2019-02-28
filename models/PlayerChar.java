package models;

import java.util.ArrayList;
import java.util.Random;

import models.enums.CharClass;

public class PlayerChar extends BoardChar {
	private ArrayList<Boolean> limbs;
	private CharClass charClass;
	private int shekels;
	private int prestige;
	private static int playerNum = 0;
	public final String CHARNAME;
	private Random rng = new Random();
	private String role = "";
	
	//True = male, false = female
	private final boolean gender;
	
	//Array of names
	private String[] fNames = {
		"Zoe", "Christine", "Henrietta", "Anna", "Josephine", "Crystal", "Gennias", "Candy", "Katherine", "Elizabeth", "Mary", "Laicey", "Brenna", "Heather", "Molly", "Marissa", "Patricia", "Jessica"
	};
	private String[] mNames = {
			"Lucas", "Riley", "Lane", "CJ", "Chris", "Troy", "Eric", "Kyle", "Wesley", "Dakota", "Adam", "Henry", "Joseph", "Harold", "Spencer", "Joshua", "Cameron", "Justin", "Robert"
	};
	
	public PlayerChar() {
		int genderNum = rng.nextInt(2);
		switch(genderNum) {
		case 0:
			gender = false;
			break;
		default:
			gender = true;
			break;
		}
		if(gender) {
			CHARNAME = mNames[rng.nextInt(mNames.length)];
		}
		else {
			CHARNAME = fNames[rng.nextInt(fNames.length)];
		}
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
	
	
	public PlayerChar(String CHARNAME, boolean gender, ArrayList<Boolean> limbs, CharClass charClass, int shekels, int prestige) {
		super();
		this.limbs = limbs;
		this.charClass = charClass;
		this.shekels = shekels;
		this.prestige = prestige;
		this.CHARNAME = CHARNAME;
		this.gender = gender;
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
				StringBuilder builder = new StringBuilder();
		builder.append("Player Character: ")
		.append("\nName: ").append(CHARNAME)
		.append("\nGender: ").append(gender)
		.append("\nShekels: ").append(shekels)
		.append("\nPrestige: ").append(prestige)
		.append("\nPlayer number: ").append(playerNum);
		return builder.toString();
	}


	public static int getPlayerNum() {
		return playerNum;
	}


	public static void setPlayerNum(int playerNum) {
		PlayerChar.playerNum = playerNum;
	}
}


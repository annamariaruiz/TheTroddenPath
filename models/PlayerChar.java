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
		this.role = "player";
		setWellness(100);
	}
	
	public PlayerChar(boolean gender, String role) {
		super();
		this.limbs = new ArrayList<Boolean>();
			limbs.add(true);
			limbs.add(true);
			limbs.add(true);
			limbs.add(true);
		if(gender) {
			CHARNAME = mNames[rng.nextInt(mNames.length)];
		}else {
			CHARNAME = fNames[rng.nextInt(fNames.length)];
		}
		this.charClass = CharClass.CITIZEN;
		this.shekels = 0;
		this.prestige = 0;
		this.gender = gender;
		this.role = role;
		setWellness(100);
	}
	
	public PlayerChar(String CHARNAME, boolean gender, ArrayList<Boolean> limbs, CharClass charClass, int shekels, int prestige) {
		super();
		this.limbs = limbs;
		this.charClass = charClass;
		this.shekels = shekels;
		this.prestige = prestige;
		this.CHARNAME = CHARNAME;
		this.gender = gender;
		setWellness(100);
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
		if(shekels < 0) {
			shekels = 0;
		}
		
		this.shekels = shekels;
	}

	public int getPrestige() {
		return prestige;
	}

	public void setPrestige(int prestige) {
		if(prestige < 0) {
			prestige = 0;
		}
		
		this.prestige = prestige;
	}


	@Override
	public void setOccupiedTile(int occupiedTile) {
		this.occupiedTile = occupiedTile;
		
	}

	@Override
	public void setWellness(int wellness) {
		if(wellness > 100) {
			wellness = 100;
		}
		
		if(wellness < 0) {
			wellness = 0;
		}
		
		this.wellness = wellness;
		
	}

	public static int getPlayerNum() {
		return playerNum;
	}
	
	
	public static void setPlayerNum(int playerNum) {
		PlayerChar.playerNum = playerNum;
	}
		
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
				StringBuilder builder = new StringBuilder();
		builder.append("Player Character: ")
		.append("\nName: ").append(CHARNAME)
		.append("\nRole: ").append(role)
		.append("\nWellness: ").append(wellness)
		.append("\nShekels: ").append(shekels)
		.append("\nPrestige: ").append(prestige)
		.append("\nPlayer number: ").append(playerNum);
		return builder.toString();
	}
}
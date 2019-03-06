package models;

import java.util.ArrayList;
import java.util.Random;

import models.enums.CharClass;
import models.enums.TileColor;

public class ChanceCard {
	public final TileColor TILECOLOR;
	private int effectIndex;
	private String effectString;
	private String[] yValues = {"dysentary.", "measels.", "typhoid fever.", "polio.", "smallpox.", 
			"cholera.", "the Black Death.", "got kicked by a horse.", "got spit on by a peon.", 
			"got a splinter."}; //this holds the collection of the random possible Strings
	private PlayerChar pChar;
	private Player player;
	private ArrayList<PlayerChar> playerChars;
	private boolean repeatTurn, skipTurn;
	private static Random rng = new Random();
	
	private int x = 0; //x refers to the random number generated to represent the amount gained that will be inserted into the effect String.
	private int y = 0; //y refers to the random number generated to represent the string's index that is used in the effect String
	
	//add "repeatTurn" boolean, "skipTurn" boolean
	public ChanceCard(TileColor tileColor, Player player) {
		playerChars = player.getChars();
		pChar = playerChars.get(0);
		this.TILECOLOR = tileColor;
		setPlayerChar(pChar);
		setRepeatTurn(false);
		setSkipTurn(false);
		setPlayer(player);
		
		//from the tile color, determine the effect related to the type of effect (positive, neutral, negative, or random).
		//this logic is to determine the effect based on its index in the overall array.
		
		if(TILECOLOR == TileColor.GREEN) {
			effectIndex = rng.nextInt(8);
		}else if(TILECOLOR == TileColor.RED) {
			effectIndex = rng.nextInt(8) + 8;
		}else if(TILECOLOR == TileColor.BLUE){
			effectIndex = rng.nextInt(4) + 16;
		}else {
			effectIndex = rng.nextInt(20);
		}
		
		//from the determined effect int, find the card the player will draw and return it as a string via...
		findEffect();
	}
	
	//this is the logic to find the specific string for the effect
	public void findEffect() {
		//the logic below is to determine the specific numerical values and random strings
				if((effectIndex >= 0 && effectIndex <= 3) || (effectIndex >= 8 && effectIndex <= 11) || (effectIndex >= 16 && effectIndex <= 19)) {
					x = rng.nextInt(20) + 1;
				}
				
				if(effectIndex == 11) {
					y = rng.nextInt(3) + 7;
				}
				
				if(effectIndex == 12) {
					y = rng.nextInt(7);
				}
		
		String[] effects = {
				"Gain " + (x * 3) + " shekels",
				"Gain " + (x * 3) + " prestige", 
				"You found bandages for your wounds. Gain " + x + " wellness", 
				"Take another turn.",
				"You got treatment for your disease. Gain " + (x * 2) + " wellness.", 
				"You got married.",
				"You had a baby girl.",
				"You have a baby boy.", 
				"You were mugged. Lose " + (x * 3) + " shekels.", 
				"You did something naughty. Lose " + (x * 3) + " prestige.", 
				"You got in a bar fight and lost. Lose " + x + " wellness and " + (x * 2) + " prestige.",
				"You " + yValues[y] + "Lose " + x + " wellness.", 
				"Oops! You have contracted " + yValues[y], 
				"Your spouse is declared a witch and is burned at the stake. Lose your spose.", 
				"You forgot one of your children at the last town. Lose a child.", 
				"Uh oh, you got tarred and feathered. Lose your next turn.",
				"You sell your daugther off for marriage. Lose a daughter, but gain " + (x * 3) + " prestige and shekels.", 
				"You sell your son off for work. Lose a son, but gain " + (x * 3) + " shekels.", 
				"You had too much fun at the local tavern and have ended up with a child. Lose " + (x * 3) + " prestige, but gain a child.", 
				"You got in a bar fight and won! Lose " + x + " wellness, but gain " + (x * 3) + " prestige."};
		
		effectString = effects[effectIndex];
		setEffectString(effectString);
		applyEffect(pChar, effectIndex);
	}
	
	//this is applied when the card is "drawn" / created
	public void applyEffect(PlayerChar pChar, int effectIndex) {
		int shekels, prestige, wellness, familyNum, modifier = 1;
		String role;
		boolean has;
		
		shekels = pChar.getShekels();
		prestige = pChar.getPrestige();
		wellness = pChar.getWellness();
		//this is where the logic that affects the player is entered.
		//effect is based off the card drawn (String effect)
		
		switch(effectIndex) {
		case 0:
			shekels += (x * 3);
			if(pChar.getCharClass() == CharClass.MERCHANT || pChar.getCharClass() == CharClass.DUKE) {
				shekels *= 2;
			}
			pChar.setShekels(shekels);
			break;
		case 1:
			prestige += (x * 3);
			if(pChar.getCharClass() == CharClass.PRIEST || pChar.getCharClass() == CharClass.DUKE) {
				prestige *= 2;
			}
			pChar.setPrestige(prestige);
			break;
		case 2:
			wellness += x;
			if(pChar.getCharClass() == CharClass.PRIEST) {
				wellness *= 2;
			}
			pChar.setWellness(wellness);
			break;
		case 3:
			setRepeatTurn(true);
			break;
		case 4:
			wellness += (x * 2);
			if(pChar.getCharClass() == CharClass.PRIEST) {
				wellness *= 2;
			}
			pChar.setWellness(wellness);
			break;
		case 5:
			has = checkFamily("spouse");
			if(!has && pChar.getCharClass() != CharClass.PRIEST) {
				addFamily("spouse");
			}else {
				setEffectString("Your card had no effect.");
			}
			break;
		case 6:
			if(pChar.getCharClass() != CharClass.PRIEST) {
				addFamily("daughter");				
			}
			break;
		case 7:
			if(pChar.getCharClass() != CharClass.PRIEST) {
				addFamily("son");				
			}
			break;
		case 8:
			if(pChar.getCharClass() == CharClass.MERCHANT) {
				shekels -= x;
			}
			shekels -= ( x * 3);
			pChar.setShekels(shekels);
			break;
		case 9:
			if(pChar.getCharClass() == CharClass.DUKE) {
				prestige -= x;
			}
			prestige -= (x * 3);
			pChar.setPrestige(prestige);
			break;
		case 10:
			if(pChar.getCharClass() == CharClass.KNIGHT) {
				setEffectString("You got in a bar fight, and it was a flawless victory. Gain " + (x * 5) + " prestige.");
				prestige += (x * 5);
			}else {
				wellness -= x;
				prestige -= (x * 2);				
			}
			pChar.setWellness(wellness);
			pChar.setPrestige(prestige);
			break;
		case 11:
			if(pChar.getCharClass() == CharClass.KNIGHT) {
				modifier = 2;
			}
			if(y == 7) {
				wellness -= (15 / modifier); 
			}else if(y == 8) {
				wellness -= (10 / modifier);
			}else {
				wellness -= (5 / modifier);
			}
			pChar.setWellness(wellness);
			break;
		case 12:
			if(pChar.getCharClass() == CharClass.KNIGHT) {
				modifier = 2;
			}
			if(y == 0) {
				wellness -= (5 / modifier);
			}else if(y == 1) {
				wellness -= (10 / modifier);
			}else if(y == 2) {
				wellness -= (15 / modifier);
			}else if(y == 3) {
				wellness -= (20 / modifier);
			}else if(y == 4) {
				wellness -= (30 / modifier);
			}else if(y == 5) {
				wellness -= (40 / modifier);
			}else if(y == 6) {
				wellness -= (50 / modifier);
			}
			pChar.setWellness(wellness);
			break;
		case 13:
			has = checkFamily("spouse");
			if(has) {
				removeFamily("spouse");
			}else {
				setEffectString("Your card had no effect.");
			}
			break;
		case 14:
			has = checkFamily("son");
			if(has) {
				removeFamily("son");
			}else {
				has = checkFamily("daughter");
				if(has) {
					removeFamily("daughter");
				}else {
					setEffectString("Your card had no effect.");
				}
			}
			break;
		case 15:
			setSkipTurn(true);
			break;
		case 16:
			has = checkFamily("daughter");
			if(has) {
				removeFamily("daughter");
				prestige += (x * 3);
				shekels += (x * 3);
				if(pChar.getCharClass() == CharClass.DUKE) {
					prestige *= 2;
					shekels *= 2;
				}else if(pChar.getCharClass() == CharClass.MERCHANT) {
					shekels *= 2;
				}
				pChar.setPrestige(prestige);
				pChar.setShekels(shekels);
			}
			break;
		case 17:
			has = checkFamily("son");
			if(has) {
				removeFamily("son");
				shekels += (x * 3);
				if(pChar.getCharClass() == CharClass.MERCHANT) {
					shekels *= 2;
				}
				pChar.setShekels(shekels);
			}
			break;
		case 18:
			if(pChar.getCharClass() != CharClass.PRIEST) {
				familyNum = rng.nextInt(2);
				if(familyNum == 0) {
					role = "son";
				}else {
					role = "daughter";
				}
				addFamily(role);
				prestige -= (x * 3);
				if(pChar.getCharClass() == CharClass.KNIGHT) {
					prestige *= 2;
				}
				pChar.setPrestige(prestige);				
			}else {
				setEffectString("Your card had no effect.");
			}
			break;
		case 19:
			if(pChar.getCharClass() == CharClass.KNIGHT) {
				setEffectString("You got in a bar fight, and it was a flawless victory. Gain " + (x * 5) + " prestige.");
				prestige += (x * 5);
			}else {
				wellness -= x;
				prestige -= (x * 3);
				pChar.setWellness(wellness);
				pChar.setPrestige(prestige);				
			}
			break;
		}
	}
	
	public void addFamily(String role) {
		boolean gender = false;
		int genderNum;
		
		if(role.equals("son")) {
			gender = true;
		}else if(role.equals("daughter")){
			gender = false;
		}else {
			genderNum = rng.nextInt(2);
			if(genderNum == 0) {
				gender = true;
			}
		}
		PlayerChar newChar = new PlayerChar(gender, role);
		playerChars.add(newChar);
		player.setChars(playerChars);
	}
	
	public void removeFamily(String role) {
		for(int i = 0; i < playerChars.size(); i++) {
			if(playerChars.get(i).getRole().equals(role)) {
				playerChars.remove(i);
				player.setChars(playerChars);
				i = playerChars.size();
			}
		}
	}
	
	public boolean checkFamily(String role) {
		boolean has = false;
		String charRole = null;
		
		for(int i = 0; i < playerChars.size(); i++) {
			charRole = playerChars.get(i).getRole();
			if(charRole.equals(role)) {
				has = true;
				i = playerChars.size();
			}			
		}
		
		return has;
	}
	
	public String getEffectString() {
		return effectString;
	}
	
	public void setEffectString(String effectString) {
		this.effectString = effectString;
	}
	
	public int getEffectNum() {
		return effectIndex;
	}
	
	public void setEffectNum(int effectNum) {
		if(effectNum < 0 || effectNum > 19) {
			throw new IllegalArgumentException("The value of effectNum must be between 0 and 19.");
		}
		this.effectIndex = effectNum;
	}
	
	public PlayerChar getPlayerChar() {
		return pChar;
	}
	
	public void setPlayerChar(PlayerChar pChar) {
		this.pChar = pChar;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public boolean repeatTurn() {
		return repeatTurn;
	}
	
	public void setRepeatTurn(boolean repeatTurn) {
		this.repeatTurn = repeatTurn;
	}
	
	public boolean skipTurn() {
		return skipTurn;
	}
	
	public void setSkipTurn(boolean skipTurn) {
		this.skipTurn = skipTurn;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(player.NAME).append(" draws a card.\n").append(getEffectString());
		return builder.toString();
	}
}

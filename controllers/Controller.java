package controllers;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Random;

import models.*;
import models.enums.*;
import views.PlayerInit;
import views.RankUp;
import views.SellFamily;

public class Controller {
	private static int turn;
	public static Player[] players;
	private static Player currentPlayer;
	private static boolean gameOver;
	private static ArrayList<AbstractMap.SimpleEntry<TileColor, TileDirection>> tiles = new ArrayList<>();
	private static Random rng = new Random();
	private static Dragon drago;
	
	public void initialize() {
		run();
	}
	
	public static void run() {
		initBoard();
//		determineTurnOrder(players);
	}
	
	public static void initPlayers(int playerNum) {
		int numOfPlayers = playerNum;
		
		players = new Player[numOfPlayers];
		for(int p = 0; p < numOfPlayers; p++) {
			PlayerInit.playerName(); // TODO change this such that bot initPlayers() methods have this
			players[p] = new Player();
		}
	}
	
	public static void initPlayers(ArrayList<String> playerNames) {
		int numOfPlayers = playerNames.size();
		players = new Player[numOfPlayers];
		for(int i = 0; i<numOfPlayers; i++) {
			Player player = new Player(playerNames.get(i));
			players[i] = player;
		}
	}
	
	public static void determineTurnOrder(Player[] players) {
		int order, spin = 0, numOfPlayers = players.length;
		Player[] orderedPlayers = new Player[players.length];
		
		do {
			order = Wheel.spinWheel(numOfPlayers) - 1;
			if(order >= 0 && order < numOfPlayers && players[order] != null) {
				orderedPlayers[spin] = players[order];
				players[order] = null;
				numOfPlayers -= 1;
				spin += 1;
			}
		}while(numOfPlayers > 1);
		
		for(Player player : players) {
			if(player != null) {
				orderedPlayers[players.length - 1] = player;
			}
		}
		
		players = orderedPlayers;
		System.out.println("test");
		
		changeTurn();
	}

	//create the board with its tiles. Set dragon's location?, if that is added
	private static void initBoard() {
		turn = 0;
		int nextSpecial = 0;
		// These are the white tiles on the board, including the start and end tiles.
		int[] specials = new int[] {0, 11, 22, 36, 44, 51, 61, 68, 80, 92, 98, 99};
		TileDirection currentDirection = TileDirection.RIGHT;
		TileColor currentColor = null;
		int offset = 0;
		
		for(int t = 0; t < 100; t++) {
			if(t == specials[nextSpecial]) {
				currentColor = TileColor.SPECIAL;
				nextSpecial++;
			} else {
				switch(t % 3) {
					case 1:
						currentColor = TileColor.GREEN;
						break;
					case 2:
						currentColor = TileColor.BLUE;
						break;
					case 0:
						currentColor = TileColor.RED;
						break;
				}
			}
			if(t == 13) {
				currentDirection = TileDirection.UP;
			} else if(t >= 15) {
				if(t == 98) {
					tiles.add(new AbstractMap.SimpleEntry<TileColor, TileDirection>(TileColor.BLUE, TileDirection.UP));
				}
				switch((t - 14 + offset) % 17) {
					case 7:
						currentDirection = TileDirection.LEFT;
						break;
					case 9:
						currentDirection = TileDirection.DOWN;
						break;
					case 15:
						currentDirection = TileDirection.LEFT;
						break;
					case 0:
						currentDirection = TileDirection.UP;
						offset += 1;
						break;
				}
			}
			
			tiles.add(new AbstractMap.SimpleEntry<TileColor, TileDirection>(currentColor, currentDirection));
			
		}
		
		
		for(AbstractMap.SimpleEntry<TileColor, TileDirection> tileEntry : tiles) {
			System.out.println(tileEntry.getKey() + ", " + tileEntry.getValue());
		}
	}
	
//	//logic for what a player would need to do during their turn
//	private static void playGame() {
//		do {
//			changeTurn();
//			// Options - give up / declare self witch/warlock, sell family, spin
//			int menuInput = 0; //TODO return menu input from G.U.I.
//			switch(menuInput) {
//				case 0:
//					// spin wheel
//				case 1:
//					// sell family
//				case
//					// give up
//			}
//		} while(!gameOver);
//	}
	
	private static void sellFamily(int familyMem) {
		boolean isMale = false;
		boolean familyMemTypeExists = false;
		switch(familyMem) {
			case 1:
				isMale = true;
				ArrayList<PlayerChar> sons = new ArrayList<>();
				currentPlayer.getChars().forEach(ch -> { if(ch.getRole().equals("son")) sons.add(ch); });
				familyMemTypeExists = sons.size() > 0;
				if(familyMemTypeExists) {
					currentPlayer.getChars().remove(sons.get(0));					
				}
				break;
			case 2:
				ArrayList<PlayerChar> daughters = new ArrayList<>();
				currentPlayer.getChars().forEach(ch -> { if(ch.getRole().equals("daughter")) daughters.add(ch); });
				familyMemTypeExists = daughters.size() > 0;
				if(familyMemTypeExists) {
					currentPlayer.getChars().remove(daughters.get(0));					
				}
				break;
			case 3:
				ArrayList<PlayerChar> spouses = new ArrayList<>();
				currentPlayer.getChars().forEach(ch -> { if(ch.getRole().equals("spouse")) spouses.add(ch); });
				familyMemTypeExists = spouses.size() > 0;
				if(familyMemTypeExists) {
					currentPlayer.getChars().remove(spouses.get(0));					
				}
				break;
		}
		
		if(familyMemTypeExists) {
			PlayerChar currentChar = currentPlayer.getChars().get(0);
			currentChar.setShekels(currentChar.getShekels() + (isMale ? (rng.nextInt(71) + 20) : (rng.nextInt(66) + 15)));			
		}
	}
	
	public static void checkForFam() {
		if(currentPlayer.getChars().size() > 1) {
			SellFamily.sellFamily();
		} else {
			SellFamily.familyError();
		}
	}
	
	public static void sellSon() {
		sellFamily(1);
	}
	
	public static void sellDaughter() {
		sellFamily(2);
	}
	
	public static void sellSpouse() {
		sellFamily(3);
	}
	
	public static void giveUp() {
		gameOver = true;
	}
	
	public static boolean hasGivenUp() {
		return gameOver;
	}
	
	//to be run when all surviving players reach the end of the board, or only one remains
	//declare the winner
	public static boolean checkForWin() {
		boolean allTurnsAreFin = true;
		
		// If there is one player who is not at the end and is alive, there is one turn that's not finished.
		for(Player p : players) {
			if(p.getChars().get(0).getOccupiedTile() != 99 && p.getChars().get(0).getWellness() > 0) {
				allTurnsAreFin = false;
			}
		}
		
		if(allTurnsAreFin) {
			// Map players to their scores
			ArrayList<AbstractMap.SimpleEntry<Player, Integer>> playersToScores = new ArrayList<>();
//			HashMap<Player, Integer> playersToScores = new HashMap<>();
						
			for(int p = 0; p < players.length; p++) {
				PlayerChar pChar = players[p].getChars().get(0);
				
				// Derive scores from PlayerChar prestige and shekels.
				playersToScores.add(new AbstractMap.SimpleEntry<Player, Integer>(players[p], pChar.getPrestige() + pChar.getShekels()));
			}
			
			// Resolve duplicates and sort the players based on their scores.
			ArrayList<AbstractMap.SimpleEntry<Player, Integer>> sortedPScores = resolveDups(playersToScores);

			//			LinkedHashMap<Player, Integer> sortedPlayers = playersToScores.entrySet().stream().sorted(Entry.comparingByValue()).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
			
			// Update the player array to reflect the sort.
			for(int orderedP = 0; orderedP < sortedPScores.size(); orderedP++) {
				players[orderedP] = sortedPScores.get(orderedP).getKey();
			}
		}
		
		return !allTurnsAreFin;
	}
	
	private static ArrayList<AbstractMap.SimpleEntry<Player, Integer>> resolveDups(ArrayList<AbstractMap.SimpleEntry<Player, Integer>> arrayToDedup) {
		// ArrayList of Integers already found and checked for duplication
		ArrayList<Integer> intsIndexed = new ArrayList<>();
		
		// Temporary value used to swap array elements
		AbstractMap.SimpleEntry<Player, Integer> temp = null;
		
		// Check each value in the array, except the last one, against all following values 
		for(Integer s = 0; s < arrayToDedup.size() - 1; s++) {
			if(!intsIndexed.contains(arrayToDedup.get(s).getValue())) {
				intsIndexed.add(s);
				for(Integer t = s + 1; s < arrayToDedup.size(); t++) {
					
					// If two values are the same, then have the players spin to see who gets to go first
					if(arrayToDedup.get(s).getValue().equals(arrayToDedup.get(t).getValue())) {
						int sSpin = -1;
						int tSpin = -1;
						while(sSpin == tSpin) {
							sSpin = spinWheel();
							tSpin = spinWheel();
						}
						//TODO G.U.I. message about who won spin
						if(sSpin < tSpin) {
							temp = arrayToDedup.get(t);
							arrayToDedup.set(t, arrayToDedup.get(s));
							arrayToDedup.set(s, temp);
						}
					}
				}
			}
		}
		
		return arrayToDedup;
	}
	
	private static boolean checkForLife() {
		boolean allCharsAreDead = false;
		
		// If the current character's wellness is zero, then make his heir the current character, assuming he has one.
		if(currentPlayer.getChars().get(0).getWellness() <= 0) {
			
			// Does the player have more than one character? If not, doesn't have an heir.
			if(currentPlayer.getChars().size() > 1) {
				PlayerChar heir = null;
				int numOfHeirs = 0;
				
				// Make the first spouse or child found the next heir and count the number of heirs so that the current character's money can be divided later.
				for(int pc = 1; pc < currentPlayer.getChars().size() && heir == null; pc++) {
					String role = currentPlayer.getChars().get(pc).getRole();
					if(heir == null && (role.equals("son") || role.equals("daughter") || role.equals("spouse"))) {
						heir = currentPlayer.getChars().get(pc);
					}
					numOfHeirs++;
				}
				
				// If an heir has been found, give him his portion of the inheritance and make him the current character with no family.
				if(heir != null) {
					int shekels = currentPlayer.getChars().get(0).getShekels() / numOfHeirs;
					ArrayList<PlayerChar> resetChars = new ArrayList<>();
					resetChars.add(heir);
					resetChars.get(0).setShekels(shekels);
					currentPlayer.setChars(resetChars);
				} else {
					currentPlayer.getChars().remove(0);
				}
				
				//TODO include G.U.I. message about character being removed and successor's role
				
			} else {
				currentPlayer.getChars().remove(0);
				allCharsAreDead = true;
				//TODO include G.U.I. message about all characters being dead and the player losing
			}
		}
		
		return allCharsAreDead;
	}
	
	//change the turn. If a player is dead or has reached the end of the board, skip them
	private static void changeTurn() {
		turn++;
		int cycle = 0; //cycle increases by 1 for each character-less player. 
							//If it reaches the total count of players, game over.
		currentPlayer = players[(turn - 1) % players.length];
		
		while(currentPlayer.getChars().size() < 1 && cycle < players.length) {
			//(if the current player has no characters, skip their turn && if you haven't cycled through all players yet)
			turn++;
			currentPlayer = players[(turn - 1) % players.length];
			
		
//account for the circumstance in which the first player is dead	
			if(currentPlayer.equals(players[0])) {
				dragonTurn();
			}
		
			
			cycle++;
		}
		
		if(cycle >= players.length) {
			gameOver = true;
			//TODO add G.U.I. message that everyone has died.
		}
		
		checkForLife();
	}
	
	private static void dragonTurn() {
		int movement, direction, currentTile;
		boolean forward = true;
		
		movement = Wheel.spinWheel();
		movement /= 2;
		
		direction = rng.nextInt(2);
		if(direction == 1) {
			forward = false;
			movement *= -1;
		}
		
		currentTile = drago.getOccupiedTile();
		drago.setOccupiedTile(currentTile + movement);
		
		dragonAttack();
	}
	
	private static void dragonAttack() {
		int[] dragonTiles = drago.getDragonTiles();
		PlayerChar pChar;
		
		for(Player player : players) {
			pChar = player.getChars().get(0);
			for(int tile : dragonTiles) {
				if(tile == pChar.getOccupiedTile()) {
					dragonAttackMenu(pChar);					
				}
			}
		}
	}
	
	private static void dragonAttackMenu(PlayerChar pChar){
		int chance;
		boolean runaway = true;
		//if runaway == false, inform the player that they failed to
				//escape and were attacked by the dragon
		//if runaway == true, inform the player that they succeeded
				//in running away
		
		chance = rng.nextInt(2);
		if(chance == 1) {
			runaway = false;
			dragonAttackDamage(pChar);
		}
		
		//if included, give the player the option to choose their
				//class-specific dragon-related action
		//otherwise, it's just a 50- 50 chance to run away
		
	}
	
	private static void dragonAttackDamage(PlayerChar pChar) {
		int count = 0;

		if(drago.getOccupiedTile() == pChar.getOccupiedTile()) {
			do {
				applyDamage(pChar);
			}while(count < 2);
		}else {
			applyDamage(pChar);
		}
	}
	
	private static int availableLimbs(PlayerChar pChar) {
		int limbIndex = 0;
		boolean limb = true;
		ArrayList<Boolean> limbs = pChar.getLimbs();
		
		for(int i = 0; i < limbs.size(); i++) {
			if(limbs.get(i) == true) {
				limbIndex = i;
				limbs.get(i).equals(false);
				i = limbs.size();
			}
		}
		
		return limbIndex;
	}
	
	
	public static int determineDamage(int limbIndex) {
		int limbDamage = 0;
		
		if(limbIndex == 0) {
			limbDamage = 10;
		}else {
			limbDamage = determineDamage(limbIndex - 1) * 2;
		}
		
		return limbDamage;
	}
	
	public static void applyDamage(PlayerChar pChar) {
		int limbIndex, damage, wellness;
		
		limbIndex = availableLimbs(pChar);
		damage = determineDamage(limbIndex);
		wellness = pChar.getWellness();
		pChar.setWellness(wellness - damage);
	}

	//note: changing "PlayerClass" to "CharClass" as there is no "PlayerClass, and 
			//"class" to "charClass" as Java already does its own thing with "class"
	private static void rankUpChar(Player playerToRankUp) {
		PlayerChar pc = playerToRankUp.getChars().get(0);
		CharClass charChoice = pc.getCharClass();
		
		if(pc.getPrestige() >= 500 && pc.getShekels() >= 500) {
			RankUp.rankUpBoth();
			charChoice = null;
		} else if(pc.getPrestige() >= 500) {
			RankUp.rankUpPrestige();
			charChoice = null;
		} else {
			RankUp.rankUpShekels();
			charChoice = null;
		}
		
		switch(charChoice) {
		case DUKE:
			pc.setShekels(pc.getShekels() + 100);
			break;
		case MERCHANT:
			pc.setShekels(pc.getShekels() + 100);
			break;
		case PRIEST:
			pc.setPrestige(pc.getPrestige() + 100);
			if(playerToRankUp.getChars().size() > 1) {
				//TODO G.U.I. message that priest's aren't allowed to have wives and children
				boolean trashFam = true; //TODO prompt for whether to throw away family
				if(trashFam) {
					for(int f = 1; f < playerToRankUp.getChars().size(); f++) {
						playerToRankUp.getChars().remove(f);
					}
					
					//TODO G.U.I. message, "Congratulations, you left your family to perish while you accept a lucrative position as a priest in a town that doesn't know you and can't blame you for past sins."
				}
			}
			break;
		case KNIGHT:
			pc.setPrestige(pc.getPrestige() + 200);
			break;
	}
		
		pc.setCharClass(charChoice);
	}
	
	//draw a chance card after the player makes their movement. Chance card is related to the tile color
			//(enum TileColor)
	private static void drawCard() {
		// Finds currentPlayer's currentChar's occupied tile number then uses that to find the tile color.
		ChanceCard chanceCard = new ChanceCard(tiles.get(currentPlayer.getChars().get(0).getOccupiedTile()).getKey(), currentPlayer);
	}
	
	public static int spinWheel() {
		System.out.println("Wheel spun");
		return Wheel.spinWheel();
	}
}

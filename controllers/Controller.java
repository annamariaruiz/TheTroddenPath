package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;

import models.ChanceCard;
import models.Dragon;
import models.Player;
import models.PlayerChar;
import models.Wheel;
import models.enums.CharClass;
import models.enums.TileColor;
import views.PlayerInit;
import views.RankUp;
import views.SellFamily;

public class Controller {
	private static int turn;
	public static Player[] players;
	private static Player currentPlayer;
	private static boolean gameOver;
	private static TileColor[] tiles;
	private static Random rng = new Random();
	private static Dragon drago;
	
	public static void run() {
		drago = new Dragon(new int[] {1, 1, 2, 1, 1});
		initBoard();
	}
	
	public static void initPlayers(int playerNum) {
		int numOfPlayers = playerNum;
		
		players = new Player[numOfPlayers];
		for(int p = 0; p < numOfPlayers; p++) {
			PlayerInit.playerName();
			String name = PlayerInit.getName();
			
			if(name.trim().isEmpty()) {
				players[p] = new Player();
			} else {
				players[p] = new Player(name);				
			}
		}
	}
	
	public static void determineTurnOrder(Player[] players) {
		int order, spin = 0, numOfPlayers = players.length;
		Player[] orderedPlayers = new Player[players.length];
		
		do {
			order = Wheel.spinWheel(numOfPlayers);
			if(order != 0 && players[order] != null) {
				orderedPlayers[spin] = players[order];
				players[order] = null;
				numOfPlayers -= 1;
				spin += 1;
			}
		}while(numOfPlayers > 1);
		
		for(Player player : players) {
			if(player != null) {
				orderedPlayers[3] = player;
			}
		}
		
		players = orderedPlayers;
	}

		
	//create the board with its tiles. Set dragon's location?, if that is added
	private static void initBoard() {
		turn = 0;
		tiles = new TileColor[100];
		int nextSpecial = 0;
		int[] specials = new int[] {0, 11, 22, 36, 44, 51, 61, 68, 80, 92, 98, 99};
		
		for(int t = 0; t < tiles.length; t++) {
			if(t == specials[nextSpecial]) {
				tiles[t] = TileColor.SPECIAL;
				nextSpecial++;
			} else {
				switch(t % 3) {
					case 1:
						tiles[t] = TileColor.GREEN;
						break;
					case 2:
						tiles[t] = TileColor.BLUE;
						break;
					case 0:
						tiles[t] = TileColor.RED;
				}
			}
			System.out.println(tiles[t]);
		}
	}
	
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
		System.out.println("Fam checked");
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
		System.out.println("Giving up");
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
			HashMap<Player, Integer> playersToScores = new HashMap<>();
						
			for(int p = 0; p < players.length; p++) {
				PlayerChar pChar = players[p].getChars().get(0);
				
				// Derive scores from PlayerChar prestige and shekels.
				playersToScores.put(players[p], pChar.getPrestige() + pChar.getShekels());
			}
			
			// Create an array from the hashmap so that it's orderable.
			Map.Entry<Player, Integer>[] pScoresToSort = (Entry<Player, Integer>[]) playersToScores.entrySet().toArray();
			
			// Resolve duplicates and sort the players based on their scores.
			Map.Entry<Player, Integer>[] sortedPScores = resolveDups(pScoresToSort);

			//			LinkedHashMap<Player, Integer> sortedPlayers = playersToScores.entrySet().stream().sorted(Entry.comparingByValue()).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
			
			// Update the player array to reflect the sort.
			for(int orderedP = 0; orderedP < sortedPScores.length; orderedP++) {
				players[orderedP] = sortedPScores[orderedP].getKey();
			}
		}
		
		return !allTurnsAreFin;
	}

	private static Map.Entry<Player, Integer>[] resolveDups(Map.Entry<Player, Integer>[] arrayToDedup) {
		// ArrayList of Integers already found and checked for duplication
		ArrayList<Integer> intsIndexed = new ArrayList<>();
		
		// Deep copy of array so that the original array is not modified
		Map.Entry<Player, Integer>[] dedupedArray = arrayToDedup.clone();
		
		// Temporary value used to swap array elements
		Map.Entry<Player, Integer> temp = null;
		
		// Check each value in the array, except the last one, against all following values 
		for(Integer s = 0; s < dedupedArray.length - 1; s++) {
			if(!intsIndexed.contains(dedupedArray[s].getValue())) {
				intsIndexed.add(s);
				for(Integer t = s + 1; s < dedupedArray.length; t++) {
					
					// If two values are the same, then have the players spin to see who gets to go first
					if(dedupedArray[s].getValue().equals(dedupedArray[t].getValue())) {
						int sSpin = -1;
						int tSpin = -1;
						while(sSpin == tSpin) {
							sSpin = spinWheel();
							tSpin = spinWheel();
						}
						//TODO G.U.I. message about who won spin
						if(sSpin < tSpin) {
							temp = dedupedArray[t];
							dedupedArray[t] = dedupedArray[s];
							dedupedArray[s] = temp;
						}
					}
				}
			}
		}
		
		return dedupedArray;
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
		int cycle = 0;
		currentPlayer = players[(turn - 1) % players.length];
		
		while(currentPlayer.getChars().size() < 1 && cycle < players.length) {
			turn++;
			currentPlayer = players[(turn - 1) % players.length];
			cycle++;
		}
		
		if(cycle >= players.length) {
			gameOver = true;
			//TODO add G.U.I. message that everyone has died.
		}
		
		checkForLife();
		rankUpChar(currentPlayer);
	}
	
	//note: changing "PlayerClass" to "CharClass" as there is no "PlayerClass, and 
			//"class" to "charClass" as Java already does its own thing with "class"
	private static void rankUpChar(Player playerToRankUp) {
		PlayerChar pc = playerToRankUp.getChars().get(0);
		CharClass charChoice = pc.getCharClass();
		
//		Useless to check because we're only upgrading if they have the right number of shekels or prestige points
//		if(pc.getPrestige() < 500 && pc.getShekels() < 500) {
//			
//		}
		
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
	private static ChanceCard drawCard() {
		// Finds currentPlayer's currentChar's occupied tile number then uses that to find the tile color.
		ChanceCard chanceCard = new ChanceCard(tiles[currentPlayer.getChars().get(0).getOccupiedTile()], currentPlayer);
		return chanceCard;
	}
	
	public static int spinWheel() {
		System.out.println("Wheel spun");
		return Wheel.spinWheel();
	}
}

package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import models.*;
import models.enums.*;
import views.PlayerInit;
import views.RankUp;
import views.SellFamily;

public class Controller {
	private static int turn;
	private static Player[] players;
	private static Player currentPlayer;
	private static boolean gameOver;
	private static TileColor[] tiles;
	private static Random rng = new Random();
	// Add HashMap of lasting effects as stretch-goal. If not implemented, all effects are one-time.
	// private static HashMap<Player, Integer> currentEffects;
	//TODO talk to Mr. Krebs about getting away with no HashMap, or find a different way to incorporate it
	private static HashMap<Player, Integer> currentEffects;
	private static Dragon drago;
	
	public static void run() {
		initCharacters();
		initBoard();
	}
	
	public static void initPlayers(int playerNum) {
		int numOfPlayers = playerNum;
		
		players = new Player[numOfPlayers];
		for(int p = 0; p < numOfPlayers; p++) {
			PlayerInit.playerName("Player", "What is your name?");
			String name = PlayerInit.getName();
			
			if(name.trim().isEmpty()) {
				players[p] = new Player();
			} else {
				players[p] = new Player(name);				
			}
		}
	}
	
	//for every person playing a game, make them a character. Set all their stats to the default
	private static void initCharacters() {
		for(int p = 0; p < players.length; p++) {
			players[p].setChars(new ArrayList<PlayerChar>());
			players[p].getChars().add(new PlayerChar());
		}
		drago = new Dragon(new int[] {1, 1, 2, 1, 1});
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
		return false;
	}
	
	private static boolean checkForLife() {
		boolean allCharsAreDead = false;
		
		if(currentPlayer.getChars().get(0).getWellness() == 0) {
			if(currentPlayer.getChars().size() > 1) {
				currentPlayer.getChars().remove(0);
				//TODO include G.U.I. message about character being removed and successor's role
				
			} else {
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
	}
	
	//note: changing "PlayerClass" to "CharClass" as there is no "PlayerClass, and 
			//"class" to "charClass" as Java already does its own thing with "class"
	private static void rankUpChar(PlayerChar pc) {
		CharClass charChoice;
		
		if(pc.getPrestige() < 500 && pc.getShekels() < 500) {
			throw new IllegalStateException("Error: It should not be possible to rank up a character with less than 500 shekels or prestige.");
		}
		
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
		
		pc.setCharClass(charChoice);
	}
	
	//draw a chance card after the player makes their movement. Chance card is related to the tile color
			//(enum TileColor)
	private static void drawCard() {
		// Finds currentPlayer's currentChar's occupied tile number then uses that to find the tile color.
		ChanceCard chanceCard = new ChanceCard(tiles[currentPlayer.getChars().get(0).getOccupiedTile()], currentPlayer);
	}
	
	public static int spinWheel() {
		System.out.println("Wheel spun");
		return Wheel.spinWheel();
	}
	
	public static int spinWheel(int numOfPlayers) {
		return Wheel.spinWheel(numOfPlayers);
	}
}
package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import enums.CharClass;
import enums.TileColor;
import models.Dragon;
import models.Player;
import models.PlayerChar;

public class Controller {
	private static int turn;
	private static Player[] players;
	private static boolean gameOver;
	private static TileColor[] tiles;
	private static HashMap<Player, Integer> currentEffects;
	//TODO talk to Mr. Krebs about getting away with no HashMap, or find a different way to incorporate it
	private static Dragon drago;
	
	public static void run() {
		
	}
	
	private static void initPlayers() {
		boolean isInvalid = true;
		int numOfPlayers = 0;
		
		while(isInvalid) {
			//TODO prompt for number of players through G.U.I.
			numOfPlayers = 0;
			
			isInvalid = numOfPlayers >= 2 && numOfPlayers <= 4;
		}
		
		players = new Player[numOfPlayers];
		for(int p = 0; p < numOfPlayers; p++) {
			//TODO prompt for player name through G.U.I.
			String name = "";
			
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
//			players[p].setChars(new PlayerChar[] {new PlayerChar()});
			players[p].setChars(new ArrayList<PlayerChar>());
			//TODO I was a little unsure how to change this code to accommodate an arrayList, so I left the old code in comments
					//in case someone else was more confident - Zoe
		}
		drago = new Dragon(new int[] {1, 1, 2, 1, 1});
	}
	
	//create the board with its tiles. Set dragon's location?, if that is added
	private static void initBoard() {
		
	}
	
	//logic for what a player would need to do during their turn
	private static void playGame() {
		
	}
	
	//to be run when all surviving players reach the end of the board, or only one remains
	//declare the winner
	private static boolean checkForWin() {
		return false;
	}
	
	//change the turn. If a player is dead or has reached the end of the board, skip them
	private static void changeTurn() {
		
	}
	
	//note: changing "PlayerClass" to "CharClass" as there is no "PlayerClass, and 
			//"class" to "charClass" as Java already does its own thing with "class"
	private static void rankUpChar(PlayerChar pc) {
		CharClass charChoice;
		
		if(pc.getPrestige() < 500 && pc.getShekels() < 500) {
			throw new IllegalStateException("Error: It should not be possible to rank up a character with less than 500 shekels or prestige.");
		}
		
		if(pc.getPrestige() >= 500 && pc.getShekels() >= 500) {
			//TODO G.U.I. with knight, priest, merchant, and duke choices
			charChoice = null;
		} else if(pc.getPrestige() >= 500) {
			//TODO G.U.I. with knight and priest choices
			charChoice = null;
		} else {
			//TODO G.U.I. with merchant and duke choices
			charChoice = null;
		}
		
		pc.setCharClass(charChoice);
	}
	
	//draw a chance card after the player makes their movement. Chance card is related to the tile color
			//(enum TileColor)
	private static void drawCard() {
		
	}
}

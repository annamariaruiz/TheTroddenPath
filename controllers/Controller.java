package controllers;

import java.util.HashMap;

import models.enums.*;
import models.Player;
import models.Dragon;

public class Controller {
	private static int turn;
	private static Player[] players;
	private static boolean gameOver;
	private static TileColor[] tiles;
	private static HashMap<Player, Integer> currentEffects;
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
	private static void rankUpPlayer(Player player, CharClass charClass) {
		
	}
	
	//draw a chance card after the player makes their movement. Chance card is related to the tile color
			//(enum TileColor)
	private static void drawCard() {
		
	}
}

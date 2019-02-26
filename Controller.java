package controller;

import java.util.HashMap;

import enums.TileColor;
import models.Player;

public class Controller {
	private int turn;
	private Player[] players;
	private boolean gameOver;
	private TileColor[] tiles;
	private HashMap<Player, Integer> currentEffects;
	
	public static void run() {
		
	}
	
	//for every person playing a game, make them a character. Set all their stats to the default
	private static void initCharacters() {
		
	}
	
	//create the board with its tiles. Set dragon's location?, if that is added
	private static void initBoard() {
		
	}
	
	//logic for what a player would need to do during their turn
	private static void playGame() {
		
	}
	
	//to be run when all surviving players reach the end of the board, or only one remains
	//declare the winner
	private static void checkForWin() {
		
	}
	
	//change the turn. If a player is dead or has reached the end of the board, skip them
	private static void changeTurn() {
		
	}
	
	//note: changing "PlayerClass" to "CharClass" as there is no "PlayerClass, and 
			//"class" to "charClass" as Java already does its own thing with "class"
	private static void rankUpPlayer(Player player, charClass charClass) {
		
	}
	
	//draw a chance card after the player makes their movement. Chance card is related to the tile color
			//(enum TileColor)
	private static void drawCard() {
		
	}
}

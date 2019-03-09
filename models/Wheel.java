package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Wheel {

	private static Random rng = new Random();
	
	//Determine who goes first
	public static int spinWheel(int numOfPlayers) {
		//Player 1 turn
			ArrayList<Integer> spins = new ArrayList<Integer>();
			int player1Spin = rng.nextInt(10)+1;
			spins.add(player1Spin);
			int player2Spin = 0;
			int player3Spin = 0;
			int player4Spin = 0;
		if(numOfPlayers > 1) {
		//Player 2 turn
			player2Spin = rng.nextInt(10)+1;
			spins.add(player2Spin);
		if(numOfPlayers > 2) {
		//Player 3 turn
			player3Spin = rng.nextInt(10)+1;
			spins.add(player3Spin);
		}
		if(numOfPlayers > 3) {
		//Player 4 turn
			player4Spin = rng.nextInt(10)+1;
			spins.add(player4Spin);
		}	
		}
		Collections.sort(spins);
		//Who gets to go first
		int winningNum = spins.get(spins.size()-1);
		//Player 1 wins, no tie
		if(winningNum == player1Spin && winningNum != player2Spin && winningNum != player3Spin && winningNum != player4Spin) {
			return 1;
		}
		//Player 2 wins, no tie
		else if(winningNum != player1Spin && winningNum == player2Spin && winningNum != player3Spin && winningNum != player4Spin) {
			return 2;
		}
		//Player 3 wins, no tie
		else if(winningNum != player1Spin && winningNum != player2Spin && winningNum == player3Spin && winningNum != player4Spin) {
			return 3;
		}
		//Player 4 wins, no tie
		else if(winningNum != player1Spin && winningNum != player2Spin && winningNum != player3Spin && winningNum == player4Spin) {
			return 4;
		}
		//Tie, returns 0, should be logic in the controller to repeat this method
		else {
			return 0;
		}		
	}

	//Spin on player's turn
	public static int spinWheel() {
		return rng.nextInt(10)+1;
	}
}

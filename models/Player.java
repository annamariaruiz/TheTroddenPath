package models;

import java.util.ArrayList;

public class Player {
	public final String NAME;
	private ArrayList<PlayerChar> chars;
	//player at index 0 is the current character being played
	private static int playerNum = 0;
	
	
	public Player(String name) {
		playerNum += 1;
		this.NAME = name;
	}
	
	public Player() {
		playerNum += 1;
		this.NAME = "Player " + playerNum;
	}

	public String getNAME() {
		return NAME;
	}

	public ArrayList<PlayerChar> getChars() {
		return chars;
	}

	public void setChars(ArrayList<PlayerChar> chars) {
		this.chars = chars;
	}


	@Override
	public String toString() {
		//TODO make decent-looking toString().
		
		StringBuilder builder = new StringBuilder();
		builder.append("Player Name: ").append(NAME)
		.append("\nAmount of characters: ").append(chars.size());
		return builder.toString();
	}
}

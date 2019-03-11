package models;

import java.util.ArrayList;

public class Player {
	public final String NAME;
	private ArrayList<PlayerChar> chars;
	//player at index 0 is the current character being played
	private static int playerNum = 0;
	private int playerID = 0;
	
	public Player(String name) {
		playerNum += 1;
		setPlayerID(playerNum);
		this.NAME = name;
		chars = new ArrayList<>();
		chars.add(new PlayerChar());
	}
	
	public Player() {
		playerNum += 1;
		this.NAME = "Player " + playerNum;
		chars = new ArrayList<>();
		chars.add(new PlayerChar());
	}


	public ArrayList<PlayerChar> getChars() {
		return chars;
	}

	public void setChars(ArrayList<PlayerChar> chars) {
		this.chars = chars;
	}

	public static int getPlayerNum() {
		return playerNum;
	}

	@Override
	public String toString() {
		//TODO make decent-looking toString().
		
		StringBuilder builder = new StringBuilder();
		builder.append("Player Name: ").append(NAME)
		.append("\nAmount of characters: ").append(getChars().size());
		return builder.toString();
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
}

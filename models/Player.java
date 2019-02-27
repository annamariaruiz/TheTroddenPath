package models;


public class Player {
	final String NAME;
	private PlayerChar[] chars;
	private static int playerNum = 0;
	
	
	public Player(String name) {
		this.NAME = name;
		
	}
	
	public Player() {
		playerNum+=1;
		this.NAME = "Player " + playerNum;
	}


	public PlayerChar[] getChars() {
		return chars;
	}

	public void setChars(PlayerChar[] chars) {
		this.chars = chars;
	}


	@Override
	public String toString() {
		//TODO make decent-looking toString().
		
		StringBuilder builder = new StringBuilder();
		builder.append("Player Name: ").append(NAME)
		.append("\nAmount of characters: ").append(chars.length);
		return builder.toString();
	}
}

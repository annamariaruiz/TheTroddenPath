package models;

import java.util.Arrays;

public class Player {
	final String NAME;
	private PlayerChar[] chars;
	
	
	public Player(String name) {
		this.NAME = name;
		
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
		builder.append("Player [NAME=").append(NAME).append(", getChars()=").append(Arrays.toString(getChars()))
				.append("]");
		return builder.toString();
	}
}

package models;

import models.enums.TileColor;

public class ChanceCard {
	public final TileColor TILECOLOR;
	private int effect;
	
	
	public ChanceCard(TileColor tileColor) {
		this.TILECOLOR = tileColor;
	}
	
	
	public void randomizeEffect() {
		//TODO add body.
	}

	public int getEffect() {
		return effect;
	}

	public void setEffect(int effect) {
		this.effect = effect;
	}
	
	public void applyEffect(PlayerChar pChar) {
		//TODO add body.
	}


	@Override
	public String toString() {
		//TODO make decent-looking toString().
		StringBuilder builder = new StringBuilder();
		builder.append("ChanceCard [TILECOLOR=").append(TILECOLOR).append(", getEffect()=").append(getEffect())
				.append("]");
		return builder.toString();
	}
}

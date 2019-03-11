package views;

import views.enums.NextTileDirection;

public class Tile {

	private static int tileNum = 0;
	private final NextTileDirection ntd;
	
	public Tile(NextTileDirection ntd) {
		tileNum++;
		this.ntd = ntd;
	}

	public int getTileNum() {
		return tileNum;
	}


	public NextTileDirection getNtd() {
		return ntd;
	}
}

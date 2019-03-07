package app;

import java.util.ArrayList;

import models.ChanceCard;
import models.Player;
import models.PlayerChar;
import models.enums.TileColor;

public class Test {

	public static void main(String[] args) {
		Player player = new Player();
		boolean skipTurn = false, repeatTurn = false;
		
		for(int i = 0; i < 25; i++) {
			System.out.println("CARD " + i);
			System.out.println(player);
			System.out.println();
			ArrayList<PlayerChar> family = player.getChars();
			for(PlayerChar fam : family) {
				System.out.println(fam);
				System.out.println();
			}
			System.out.println("Skip Turn: " + skipTurn);
			System.out.println("Repeat Turn: " + repeatTurn);
			System.out.println();
			ChanceCard cc = new ChanceCard(TileColor.SPECIAL, player);
			System.out.println(cc);
			skipTurn = cc.skipTurn();
			repeatTurn = cc.repeatTurn();
			System.out.println();
			System.out.println("Skip Turn: " + skipTurn);
			System.out.println("Repeat Turn: " + repeatTurn);
			System.out.println();
			System.out.println(player);
			System.out.println();
			for(PlayerChar fam : family) {
				System.out.println(fam);
				System.out.println();
			}
			System.out.println();
		}
	}

}

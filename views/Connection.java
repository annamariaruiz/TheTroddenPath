package views;

import controllers.Controller;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import javafx.scene.text.Text;
=======
import javafx.scene.shape.Polygon;
>>>>>>> parent of 66858f4... Fixing stuff ig idc
=======
import javafx.scene.shape.Polygon;
>>>>>>> parent of 6220eb9... Fixing Pt 2, gonna be a lot of commits about nothing
=======
import javafx.scene.shape.Polygon;
>>>>>>> parent of 6220eb9... Fixing Pt 2, gonna be a lot of commits about nothing
import javafx.util.Duration;
import models.Player;
import models.Wheel;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import models.enums.TileDirection;
=======
=======
>>>>>>> parent of 6220eb9... Fixing Pt 2, gonna be a lot of commits about nothing
=======
>>>>>>> parent of 6220eb9... Fixing Pt 2, gonna be a lot of commits about nothing
import views.enums.NextTileDirection;
>>>>>>> parent of 66858f4... Fixing stuff ig idc

public class Connection {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	private int counter = 0;

	@FXML
	private Circle player1;

	@FXML
	private Circle player2;
=======
=======
>>>>>>> parent of 6220eb9... Fixing Pt 2, gonna be a lot of commits about nothing
=======
>>>>>>> parent of 6220eb9... Fixing Pt 2, gonna be a lot of commits about nothing
	    @FXML
	    private Circle player2;

	    @FXML
	    private Circle player3;

	    @FXML
	    private Circle player4;

	    @FXML
	    private Polygon spinner;

	    @FXML
	    private Button spinWheel;

	    @FXML
	    private Label playerName;

	    @FXML
	    private Label shekels;
>>>>>>> parent of 66858f4... Fixing stuff ig idc

	@FXML
	private Circle player3;

	@FXML
	private Circle player4;

	@FXML
	private Pane spinner;

	@FXML
	private Text playerName = new Text();

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	@FXML
	private Text shekels = new Text();

	@FXML
	private Text prestige = new Text();

	@FXML
	private Text wellness = new Text();

	@FXML
	private Text limbsRemaining = new Text();

	@FXML
	private Text family = new Text();

	@FXML
	private Text position = new Text();

	public static void updateView() {
//    	playerName.setText(Controller.currentPlayer.toString());
	}

	public void spinWheel() {

		int spunNumber = Wheel.spinWheel();
		// animation to move that many spaces
		animateWheel(1);
		for (int i = 0; i < spunNumber; i++) {
			animatePiece();
		}
		Controller.drawCard();
	}

	public void animateWheel(int spinAmount) {
		counter++;
		RotateTransition transition = new RotateTransition(Duration.seconds(2.5), spinner);
		transition.setByAngle(44);
		transition.play();
		switch (spinAmount) {
		case 1:
			transition.setByAngle(20);

		}

	}

	private static double player1X = 0;
	private static double player1Y = 0;
	private static double player2X = 0;
	private static double player2Y = 0;
	private static double player3X = 0;
	private static double player3Y = 0;
	private static double player4X = 0;
	private static double player4Y = 0;

	public void animatePiece() {

		Player currentPlayer = Controller.currentPlayer;
		int playerNum = currentPlayer.getPlayerID();
		int occupiedTile = currentPlayer.getChars().get(0).getOccupiedTile();
		TileDirection ntd = Controller.TILES.get(occupiedTile).getValue();
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.millis(1000));
		currentPlayer.getChars().get(0).changeTile(1);

		double currentX;
		double currentY;

		switch (playerNum) {
=======
=======
>>>>>>> parent of 6220eb9... Fixing Pt 2, gonna be a lot of commits about nothing
=======
>>>>>>> parent of 6220eb9... Fixing Pt 2, gonna be a lot of commits about nothing
	    @FXML
	    private Label position;
	
	
	
	public int spinWheel() {
		int spunNumber = Wheel.spinWheel();
		return spunNumber;
		//animation to move that many spaces
		
	}
	
	public void animatePiece1(int currentX, int currentY, Tile currentTile, int playerNum) {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.millis(2000));
		NextTileDirection ntd = currentTile.getNtd();
	
		
		transition.setNode(player1);
		switch(playerNum) {
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 66858f4... Fixing stuff ig idc
=======
>>>>>>> parent of 6220eb9... Fixing Pt 2, gonna be a lot of commits about nothing
=======
>>>>>>> parent of 6220eb9... Fixing Pt 2, gonna be a lot of commits about nothing
		case 2:
			transition.setNode(player2);
			currentX = player2X;
			currentY = player2Y;
			break;
		case 3:
			transition.setNode(player3);
			currentX = player3X;
			currentY = player3Y;
			break;
		case 4:
			transition.setNode(player4);
			currentX = player4X;
			currentY = player4Y;
			break;
		default:
			transition.setNode(player1);
			currentX = player1X;
			currentY = player1Y;
		}

		switch (ntd) {
		case DOWN:
			transition.setToY(currentY + 40);
			currentY += 40;
			break;
		case UP:
			transition.setToY(currentY - 40);
			currentY -= 40;
			break;
		case LEFT:
			transition.setToX(currentX - 40);
			currentX -= 40;
			break;
		case RIGHT:
			transition.setToX(currentX + 40);
			currentX += 40;
			break;
<<<<<<< HEAD
		
=======
>>>>>>> parent of 06fe034... Revert "Merge branch 'master' of https://github.com/lilhappyburrito/TheTroddenPath"
		}
		transition.play();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

		switch (playerNum) {
		case 1:
			player1X = currentX;
			player1Y = currentY;
			break;
		case 2:
			player2X = currentX;
			player2Y = currentY;
			break;
		case 3:
			player3X = currentX;
			player3Y = currentY;
			break;
		case 4:
			player4X = currentX;
			player4Y = currentY;
			break;
		}

		// updating the view because no other choice
		playerName.setText(currentPlayer.NAME);
		// CharName playerName.setText(currentPlayer.getChars().get(0).CHARNAME);
		shekels.setText("Shekels: " + currentPlayer.getChars().get(0).getShekels());
		prestige.setText("Prestige: " + currentPlayer.getChars().get(0).getShekels());
		wellness.setText("Wellness: " + currentPlayer.getChars().get(0).getWellness());
		limbsRemaining.setText("Limbs Remaining: " + currentPlayer.getChars().get(0).getLimbs().size());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < currentPlayer.getChars().size(); i++) {
			sb.append(currentPlayer.getChars().get(i).getRole() + ": " + currentPlayer.getChars().get(i).CHARNAME);
		}
		family.setText(sb.toString());

=======
		
>>>>>>> parent of 66858f4... Fixing stuff ig idc
=======
		
>>>>>>> parent of 6220eb9... Fixing Pt 2, gonna be a lot of commits about nothing
=======
		
>>>>>>> parent of 6220eb9... Fixing Pt 2, gonna be a lot of commits about nothing
	}

	public void sellFamily() {
		controllers.Controller.checkForFam();
	}

	public void giveUp() {
		controllers.Controller.giveUp();
	}
}
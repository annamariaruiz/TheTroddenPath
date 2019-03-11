package views;

import controllers.Controller;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.util.Duration;
import models.Player;
import models.Wheel;
import models.enums.TileDirection;

public class Connection {

	private int counter = 0;
	@FXML
	private Circle player1;

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
	private static Text playerName = new Text();

	@FXML
	private static Text shekels = new Text();

	@FXML
	private static Text prestige = new Text();

	@FXML
	private static Text wellness = new Text();

	@FXML
	private static Text limbsRemaining = new Text();

	@FXML
	private static Text family = new Text();

	@FXML
	private static Text position = new Text();

	public static void updateView() {
		playerName.setText(Controller.currentPlayer.toString());
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

		double currentX = player1X;
		double currentY = player1Y;
		switch (playerNum) {
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
		}

		switch (ntd) {
		case UP:
			transition.setToY(currentY + 40);
			break;
		case DOWN:
			transition.setToY(currentY - 40);
			break;
		case LEFT:
			transition.setToX(currentX - 40);
			break;
		case RIGHT:
			transition.setToX(currentY + 40);
			break;

		}
		transition.play();

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
	}

	public void sellFamily() {
		controllers.Controller.checkForFam();
	}

	public void giveUp() {
		controllers.Controller.giveUp();
	}
}

package views;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import models.Wheel;
import views.enums.NextTileDirection;

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
	private Pane spinner;

	@FXML
	private Button spinWheel;

	@FXML
	private Label playerName;

	@FXML
	private Label shekels;

	@FXML
	private Label prestige;

	@FXML
	private Label wellness;

	@FXML
	private Label limbsRemaining;

	@FXML
	private Label family;

	@FXML
	private Label position;

	public void spinWheel() {
		int spunNumber = Wheel.spinWheel();
		// animation to move that many spaces
		Tile t = new Tile(NextTileDirection.RIGHT);
		animateWheel(1);
		for(int i = 0; i<4; i++) {
			animatePiece(t, 2);
		}

	}

	public void animateWheel(int spinAmount) {
		if(counter < 1) {
			movePivot(spinner, 0, -10);
		}
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
	
	public void animatePiece(Tile currentTile, int playerNum) {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.millis(1000));
		NextTileDirection ntd = currentTile.getNtd();
		
		
		transition.setNode(player1);
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
			currentX += 40;
			break;
		case DOWN:
			transition.setToY(currentY - 40);
			currentX -= 40;
			break;
		case LEFT:
			transition.setToX(currentX - 40);
			currentY -= 40;
			break;
		case RIGHT:
			transition.setToX(currentY + 40);
			currentY += 40;
			break;
		case LAST:
			transition.setToX(currentX + 20);
			transition.setToY(currentY + 20);
			transition.setToX(currentX - 20);
			transition.setToY(currentY - 20);
			transition.setToX(currentX + 10);
			transition.setToY(currentY + 10);
			transition.setToX(currentX - 10);
			transition.setToY(currentY - 10);
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

	private void movePivot(Node node, double x, double y) {
		node.getTransforms().add(new Translate(-x, -y));
		node.setTranslateX(x);
		node.setTranslateY(y);
	}
}

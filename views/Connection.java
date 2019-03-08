package views;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;
import models.Wheel;
import views.enums.NextTileDirection;

public class Connection {
	
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
		case 2:
			transition.setNode(player2);
			break;
		case 3:
			transition.setNode(player3);
			break;
		case 4:
			transition.setNode(player4);
			break;
		}
		
		switch(ntd) {
		case UP:
			transition.setToY(currentY+40);
			break;
		case DOWN:
			transition.setToY(currentY-40);
			break;
		case LEFT:
			transition.setToX(currentX-40);
			break;
		case RIGHT:
			transition.setToX(currentY+40);
			break;
		
		}
		transition.play();
		
	}
	public void sellFamily() {
		controllers.Controller.checkForFam();
	}
	
	public void giveUp() {
		controllers.Controller.giveUp();
	}
}

package views;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
<<<<<<< HEAD
import javafx.scene.shape.Polygon;
=======
>>>>>>> parent of 6c591f7... Updated all labels for the GUI
import javafx.util.Duration;
import models.Wheel;
<<<<<<< HEAD
=======
import models.enums.TileDirection;
>>>>>>> parent of 6c591f7... Updated all labels for the GUI
import views.enums.NextTileDirection;

public class Connection {
	
	 @FXML
	    private Circle player1;

<<<<<<< HEAD
	    @FXML
	    private Circle player2;

	    @FXML
	    private Circle player3;
=======
	private int counter = 0;
	
	@FXML
	private Circle player1;
>>>>>>> parent of 6c591f7... Updated all labels for the GUI

	    @FXML
	    private Circle player4;

	    @FXML
	    private Polygon spinner;

	    @FXML
	    private Button spinWheel;

	    @FXML
	    private Label playerName;

<<<<<<< HEAD
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
=======
    @FXML
    private static Label playerName = new Label();

    @FXML
    private static Label shekels = new Label();

    @FXML
    private static Label prestige = new Label();

    @FXML
    private static Label wellness = new Label();

    @FXML
    private static Label limbsRemaining = new Label();

    @FXML
    private static Label family = new Label();

    @FXML
    private static Label position = new Label();
    
    public static void updateView() {
//    	playerName.setText(Controller.currentPlayer.toString());
    }

    
    
    
	public void spinWheel() {
		int spunNumber = Wheel.spinWheel();
		// animation to move that many spaces
		animateWheel(1);
		for(int i = 0; i<spunNumber; i++) {
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
>>>>>>> parent of 6c591f7... Updated all labels for the GUI
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
		case LAST:
			transition.setToX(currentX+20);
			transition.setToY(currentY+20);
			transition.setToX(currentX-20);
			transition.setToY(currentY-20);
			transition.setToX(currentX+10);
			transition.setToY(currentY+10);
			transition.setToX(currentX-10);
			transition.setToY(currentY-10);
		
		}
		transition.play();
		
<<<<<<< HEAD
=======
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
>>>>>>> parent of 6c591f7... Updated all labels for the GUI
	}
	public void sellFamily() {
		controllers.Controller.checkForFam();
	}
	
	public void giveUp() {
		controllers.Controller.giveUp();
	}
}

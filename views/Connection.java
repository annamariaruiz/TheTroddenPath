package views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import models.Wheel;

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
	
	public void sellFamily() {
		controllers.Controller.checkForFam();
	}
	
	public void giveUp() {
		controllers.Controller.giveUp();
	}
}

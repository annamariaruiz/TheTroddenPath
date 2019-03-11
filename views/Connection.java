package views;

import controllers.Controller;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import models.Player;
import models.PlayerChar;
import models.enums.TileDirection;

public class Connection
{
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
  private javafx.scene.layout.Pane spinner;
  
  @FXML
  private Text playerName = new Text();
  
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
  
  public Connection() {}
  
  public static void updateView() {}
  
  public void spinWheel()
  {
    int spunNumber = models.Wheel.spinWheel();
    
    animateWheel(1);
    for (int i = 0; i < spunNumber; i++) {
      animatePiece();
    }
    Controller.drawCard();
  }
  
  public void animateWheel(int spinAmount) {
    counter += 1;
    RotateTransition transition = new RotateTransition(Duration.seconds(2.5D), spinner);
    transition.setByAngle(44.0D);
    transition.play();
    switch (spinAmount) {
    case 1: 
      transition.setByAngle(20.0D);
    }
    
  }
  

  private static double player1X = 0.0D;
  private static double player1Y = 0.0D;
  private static double player2X = 0.0D;
  private static double player2Y = 0.0D;
  private static double player3X = 0.0D;
  private static double player3Y = 0.0D;
  private static double player4X = 0.0D;
  private static double player4Y = 0.0D;
  
  public void animatePiece()
  {
    Player currentPlayer = Controller.currentPlayer;
    int playerNum = currentPlayer.getPlayerID();
    int occupiedTile = ((PlayerChar)currentPlayer.getChars().get(0)).getOccupiedTile();
    TileDirection ntd = (TileDirection)((AbstractMap.SimpleEntry)Controller.TILES.get(occupiedTile)).getValue();
    TranslateTransition transition = new TranslateTransition();
    transition.setDuration(Duration.millis(1000.0D));
    ((PlayerChar)currentPlayer.getChars().get(0)).changeTile(1);
    double currentY;
    double currentY;
    double currentY;
    double currentX;
    double currentY; switch (playerNum) {
    case 2: 
      transition.setNode(player2);
      double currentX = player2X;
      currentY = player2Y;
      break;
    case 3: 
      transition.setNode(player3);
      double currentX = player3X;
      currentY = player3Y;
      break;
    case 4: 
      transition.setNode(player4);
      double currentX = player4X;
      currentY = player4Y;
      break;
    default: 
      transition.setNode(player1);
      currentX = player1X;
      currentY = player1Y;
    }
    
    switch (ntd) {
    case LEFT: 
      transition.setToY(currentY + 40.0D);
      currentY += 40.0D;
      break;
    case DOWN: 
      transition.setToY(currentY - 40.0D);
      currentY -= 40.0D;
      break;
    case RIGHT: 
      transition.setToX(currentX - 40.0D);
      currentX -= 40.0D;
      break;
    case UP: 
      transition.setToX(currentX + 40.0D);
      currentX += 40.0D;
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
    }
    
    

    playerName.setText(NAME);
    
    shekels.setText("Shekels: " + ((PlayerChar)currentPlayer.getChars().get(0)).getShekels());
    prestige.setText("Prestige: " + ((PlayerChar)currentPlayer.getChars().get(0)).getShekels());
    wellness.setText("Wellness: " + ((PlayerChar)currentPlayer.getChars().get(0)).getWellness());
    limbsRemaining.setText("Limbs Remaining: " + ((PlayerChar)currentPlayer.getChars().get(0)).getLimbs().size());
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < currentPlayer.getChars().size(); i++) {
      sb.append(((PlayerChar)currentPlayer.getChars().get(i)).getRole() + ": " + getCharsgetCHARNAME);
    }
    family.setText(sb.toString());
  }
  
  public void sellFamily() {}
  
  public void giveUp() {}
}

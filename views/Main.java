package views;

import controllers.Controller;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.enums.NextTileDirection;

public class Main extends Application
{
  public Main() {}
  
  private Stage window = new Stage();
  private Scene startScene;
  private Scene boardGame; private ArrayList<Tile> tiles = new ArrayList();
  
  public static void main(String[] args) {
    launch(args);
  }
  
  public void start(Stage primaryStage) throws IOException
  {
    window = primaryStage;
    window.setTitle("The Trodden Path");
    Parent start = (Parent)FXMLLoader.load(getClass().getResource("Start.fxml"));
    
    startScene = new Scene(start, 600.0D, 300.0D);
    window.setResizable(false);
    window.setScene(startScene);
    window.show();
    PlayerInit.playerNum();
  }
  
  public void startGame() throws IOException {
    Parent root = (Parent)FXMLLoader.load(getClass().getResource("Game.fxml"));
    boardGame = new Scene(root, 1300.0D, 700.0D);
    window.setResizable(false);
    window.setScene(boardGame);
    window.show();
    Controller.run();
    Controller.initPlayers(PlayerInit.getNames());
  }
  
  private static void createTileArrayList() {
    Tile localTile1;
    for (int i = 0; i < 13; i++) {
      localTile1 = new Tile(NextTileDirection.RIGHT);
    }
    
    for (int i = 0; i < 8; i++) {
      localTile1 = new Tile(NextTileDirection.UP);
    }
    
    for (int i = 0; i < 2; i++) {
      localTile1 = new Tile(NextTileDirection.LEFT);
    }
    
    for (int i = 0; i < 6; i++) {
      localTile1 = new Tile(NextTileDirection.DOWN);
    }
    
    for (int i = 0; i < 2; i++) {
      localTile1 = new Tile(NextTileDirection.LEFT);
    }
    
    for (int i = 0; i < 6; i++) {
      localTile1 = new Tile(NextTileDirection.UP);
    }
    
    for (int i = 0; i < 2; i++) {
      localTile1 = new Tile(NextTileDirection.LEFT);
    }
    
    for (int i = 0; i < 6; i++) {
      localTile1 = new Tile(NextTileDirection.DOWN);
    }
    
    for (int i = 0; i < 2; i++) {
      localTile1 = new Tile(NextTileDirection.LEFT);
    }
    
    for (int i = 0; i < 6; i++) {
      localTile1 = new Tile(NextTileDirection.UP);
    }
    
    for (int i = 0; i < 2; i++) {
      localTile1 = new Tile(NextTileDirection.LEFT);
    }
    
    for (int i = 0; i < 6; i++) {
      localTile1 = new Tile(NextTileDirection.DOWN);
    }
    
    for (int i = 0; i < 2; i++) {
      localTile1 = new Tile(NextTileDirection.LEFT);
    }
    
    for (int i = 0; i < 6; i++) {
      localTile1 = new Tile(NextTileDirection.UP);
    }
    
    for (int i = 0; i < 2; i++) {
      localTile1 = new Tile(NextTileDirection.LEFT);
    }
    
    for (int i = 0; i < 6; i++) {
      localTile1 = new Tile(NextTileDirection.DOWN);
    }
    
    for (int i = 0; i < 2; i++) {
      localTile1 = new Tile(NextTileDirection.LEFT);
    }
    
    for (int i = 0; i < 6; i++) {
      localTile1 = new Tile(NextTileDirection.UP);
    }
    
    for (int i = 0; i < 2; i++) {
      localTile1 = new Tile(NextTileDirection.LEFT);
    }
    
    for (int i = 0; i < 6; i++) {
      localTile1 = new Tile(NextTileDirection.DOWN);
    }
    
    for (int i = 0; i < 2; i++) {
      localTile1 = new Tile(NextTileDirection.LEFT);
    }
    
    for (int i = 0; i < 4; i++) {
      localTile1 = new Tile(NextTileDirection.UP);
    }
    

    Tile last = new Tile(NextTileDirection.LAST);
  }
}

package views;
	
import java.io.IOException;
import java.util.ArrayList;
import views.PlayerInit;
import controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import views.enums.NextTileDirection;

public class Main extends Application {
	
	private Stage window = new Stage();
	private Scene startScene, boardGame;
	private ArrayList<Tile> tiles = new ArrayList<>();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		window = primaryStage;
		window.setTitle("The Trodden Path");
		Parent start = FXMLLoader.load(getClass().getResource("Start.fxml"));
		
		startScene = new Scene(start, 600, 300);
		window.setScene(startScene);
		window.show();
	}
	
	public void startGame() throws IOException {
		if(Controller.checkForWin()) {
			Parent winner = FXMLLoader.load(getClass().getResource("Game.fxml"));
			window.setScene(new Scene(winner, 400, 300));
			window.show();
		}
		
		Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
		boardGame = new Scene(root, 1300, 700);
		window.setScene(boardGame);
		window.show();
		PlayerInit.playerNum();
	}
	
	public void changeInfo() {
		Label playerName = new Label();
		Label wellness = new Label();
		Label limbsRemaining = new Label();
		Label shekels = new Label();
		Label prestige = new Label();
		Label family = new Label();
	}
	
	private static void createTileArrayList() {
		// 0 Tiles
		for(int i = 0; i<13; i++) {
			Tile right = new Tile(NextTileDirection.RIGHT);
		}
		// 13 Tiles
		for(int i = 0; i<8; i++) {
			Tile up = new Tile(NextTileDirection.UP);
		}
		// 21 Tiles
		for(int i = 0; i<2; i++) {
			Tile left = new Tile(NextTileDirection.LEFT);
		}
		// 23 Tiles
		for(int i = 0; i<6; i++) {
			Tile down = new Tile(NextTileDirection.DOWN);
		}
		// 29 Tiles
		for(int i = 0; i<2; i++) {
			Tile left = new Tile(NextTileDirection.LEFT);
		}
		// 31 Tiles
		for(int i = 0; i<6; i++) {
			Tile up = new Tile(NextTileDirection.UP);
		}
		// 37 Tiles
		for(int i = 0; i<2; i++) {
			Tile left = new Tile(NextTileDirection.LEFT);
		}
		// 39 Tiles
		for(int i = 0; i<6; i++) {
			Tile down = new Tile(NextTileDirection.DOWN);
		}
		// 45 Tiles
		for(int i = 0; i<2; i++) {
			Tile left = new Tile(NextTileDirection.LEFT);
		}
		// 47 TIles
		for(int i = 0; i<6; i++) {
			Tile up = new Tile(NextTileDirection.UP);
		}
		// 53 Tiles
		for(int i = 0; i<2; i++) {
			Tile left = new Tile(NextTileDirection.LEFT);
		}
		// 55 Tiles
		for(int i = 0; i<6; i++) {
			Tile down = new Tile(NextTileDirection.DOWN);
		}
		// 61 Tiles
		for(int i = 0; i<2; i++) {
			Tile left = new Tile(NextTileDirection.LEFT);
		}
		// 63 Tiles
		for(int i = 0; i<6; i++) {
			Tile up = new Tile(NextTileDirection.UP);
		}
		// 69 TIles
		for(int i = 0; i<2; i++) {
			Tile left = new Tile(NextTileDirection.LEFT);
		}
		// 71 Tiles
		for(int i = 0; i<6; i++) {
			Tile down = new Tile(NextTileDirection.DOWN);
		}
		// 77 Tiles
		for(int i = 0; i<2; i++) {
			Tile left = new Tile(NextTileDirection.LEFT);
		}
		// 79 Tiles
		for(int i = 0; i<6; i++) {
			Tile up = new Tile(NextTileDirection.UP);
		}
		// 85 tiles
		for(int i = 0; i<2; i++) {
			Tile left = new Tile(NextTileDirection.LEFT);
		}
		// 87 Tiles
		for(int i = 0; i<6; i++) {
			Tile down = new Tile(NextTileDirection.DOWN);
		}
		// 93 Tiles
		for(int i = 0; i<2; i++) {
			Tile left = new Tile(NextTileDirection.LEFT);
		}
		// 95 Tiles
		for(int i = 0; i<4; i++) {
			Tile up = new Tile(NextTileDirection.UP);
		}
		//99 TIles
		
		Tile last = new Tile(NextTileDirection.LAST);
		}
	}

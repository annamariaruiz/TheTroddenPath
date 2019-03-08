package views;
	
import java.io.IOException;
import java.util.ArrayList;

import controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import views.enums.NextTileDirection;

public class Main extends Application {
	
	private static Stage window = new Stage();
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
		window.setResizable(false);
		window.setScene(startScene);
		window.show();
		PlayerInit.playerNum();
	}
	
	public void startGame() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
		boardGame = new Scene(root, 1200, 700);
		window.setResizable(false);
		window.setScene(boardGame);
		window.show();
		Controller.initPlayers(PlayerInit.getNames());
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

	public static void winScreen() {
		window.close();
		Stage winScreen = new Stage();
		winScreen.initModality(Modality.APPLICATION_MODAL);
		winScreen.setTitle("Game Over!");
		Text label = new Text();
		label.setText("Game Completed");
		VBox layout = new VBox(30);
		Scene scene = new Scene(layout, 300, 100);
		winScreen.setScene(scene);
		winScreen.show();
	}
}
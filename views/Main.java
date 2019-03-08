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
		window.setResizable(false);
		window.setScene(startScene);
		window.show();
		PlayerInit.playerNum();
	}
	
	public void startGame() throws IOException {
		Controller.initPlayers(PlayerInit.getNames());
		Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
		boardGame = new Scene(root, 1300, 700);
		window.setResizable(false);
		window.setScene(boardGame);
		window.show();
	}
}
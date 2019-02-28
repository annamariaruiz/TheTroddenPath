package application;
	
import java.io.IOException;
import controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage window = new Stage();
	private Scene startScene, boardGame;
	
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
	}
}
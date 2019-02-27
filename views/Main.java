package views;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	
	
	Stage window;
	Button startGame, sellChildren, spinWheel, giveUP;
	Scene startScene, boardGame, win;
	
	
	@Override
	public void start(Stage primaryStage) {
		//setting window as stage
		window = primaryStage;
		window.setTitle("The Trodden Path");
		
		//button to run game
		startGame = new Button("Start Game");
		startGame.setOnAction(e -> {
			System.out.println("Controller.run()");
			window.setScene(boardGame);
		});
		
		//layout and scene
		VBox startLayout = new VBox(5);
		startLayout.setPadding(new Insets(30, 40, 30, 40));
		startLayout.getChildren().add(startGame);
		startScene = new Scene(startLayout, 1300, 700);		
		
		//show stage
		window.setScene(startScene);
		window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

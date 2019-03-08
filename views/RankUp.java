package views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RankUp {

	public static void rankUpBoth() {
		String name ="";
		Stage prompt = new Stage();
		
		prompt.initModality(Modality.APPLICATION_MODAL);
		prompt.setTitle("Rank Up");
		
		Text label = new Text();
		label.setText("Congrats! You now have at least 50 shekels in your possesion and at least 50 prestige to your name! Time to rank up");
		Button knight = new Button("Knight");
		knight.setOnAction(e ->{
			
		});
		Button priest = new Button("Priest");
		Button merchant = new Button("Merchant");
		Button duke = new Button("Duke");
		Label question = new Label("Choose your path");
		
		HBox buttons = new HBox(20);
		buttons.getChildren().addAll(knight, priest, merchant, duke);
		VBox layout = new VBox(15);
		layout.getChildren().addAll(label, buttons, question);
		Scene scene = new Scene(layout, 300, 300);
		prompt.setScene(scene);
		prompt.show();
	}
	
	public static void rankUpPrestige() {
		String name ="";
		Stage prompt = new Stage();
		
		prompt.initModality(Modality.APPLICATION_MODAL);
		prompt.setTitle("Rank Up");
		
		Text label = new Text();
		label.setText("Congrats! You now have at least 50 prestige to your name! Time to rank up");
		Button knight = new Button("Knight");
		knight.setOnAction(e ->{
			
		});
		Button priest = new Button("Priest");
		Label question = new Label("Choose your path");
		
		HBox buttons = new HBox(20);
		buttons.getChildren().addAll(knight, priest);
		VBox layout = new VBox(15);
		layout.getChildren().addAll(label, buttons, question);
		Scene scene = new Scene(layout, 300, 300);
		prompt.setScene(scene);
		prompt.show();
	}
	
	public static void rankUpShekels() {
		String name ="";
		Stage prompt = new Stage();
		
		prompt.initModality(Modality.APPLICATION_MODAL);
		prompt.setTitle("Rank Up");
		
		Text label = new Text();
		label.setText("Congrats! You now have at least 50 to your name! Time to rank up");
		Button duke = new Button("Duke");
		duke.setOnAction(e ->{
			
		});
		
		Button merchant = new Button("Priest");
		Label question = new Label("Choose your path");
		
		HBox buttons = new HBox(20);
		buttons.getChildren().addAll(duke, merchant);
		VBox layout = new VBox(15);
		layout.getChildren().addAll(label, buttons, question);
		Scene scene = new Scene(layout, 300, 300);
		prompt.setScene(scene);
		prompt.show();
	}
}

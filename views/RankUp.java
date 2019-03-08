package views;

import controllers.Controller;
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
		label.setText("Congrats! You now have 500 shekels in your possesion and 500 prestige to your name! Time to rank up");
		Button knight = new Button("Knight");
		knight.setOnAction(e -> Controller.rankUpKnight());
		
		Button priest = new Button("Priest");
		priest.setOnAction(e -> Controller.rankUpPriest());
		
		Button merchant = new Button("Merchant");
		merchant.setOnAction(e -> Controller.rankUpMerchant());
		
		Label question = new Label("Choose your path");
		
		HBox buttons = new HBox(20);
		buttons.getChildren().addAll(knight, priest, merchant);
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
		label.setText("Congrats! You now have 500 prestige to your name! Time to rank up");
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
		Stage prompt = new Stage();
		prompt.setTitle("Congrats Merchant!");
		prompt.initModality(Modality.APPLICATION_MODAL);
		
		Text label = new Text();
		label.setText("When you have more than 50 shekels, you become a merchant and gain 100 more shekels!");
		Button ok = new Button("Awesome!");
		ok.setOnAction(e -> {
			Controller.rankUpMerchant();
			prompt.close();
		});
		
		VBox layout = new VBox(15);
		Scene scene = new Scene(layout, 50, 300);
		prompt.setScene(scene);
		prompt.show();
	}
	
	public static void rankUpDuke() {
		Stage prompt = new Stage();
		
		prompt.initModality(Modality.APPLICATION_MODAL);
		prompt.setTitle("On your way up to Duke!");
		
		Text label = new Text();
		label.setText("Congrats! You now have 500 shekels to your name! Time to rank up");
		Button duke = new Button("Woah, awesome!");
		duke.setOnAction(e ->{
			Controller.rankUpDuke();
			prompt.close();
		});

		VBox layout = new VBox(15);
		layout.getChildren().addAll(label, duke);
		Scene scene = new Scene(layout, 300, 300);
		prompt.setScene(scene);
		prompt.show();
	}
}

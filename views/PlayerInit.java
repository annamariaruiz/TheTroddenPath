package views;

import java.util.ArrayList;

import controllers.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PlayerInit {
	
	private static ArrayList<String> names = new ArrayList<>();
	
	//ask for number of players
	public static void playerNum() {
		Stage prompt = new Stage();
		
		prompt.initModality(Modality.APPLICATION_MODAL);
		prompt.setTitle("Players");
		
		Text label = new Text();
		label.setText("How many players?");
		TextField playerNum = new TextField();
		Button submit = new Button("Submit");
		Text error = new Text();
		error.setText("");
		submit.setOnAction(e -> {
			try {
				int number = Integer.parseInt(playerNum.getText());
				if(number<5 && number>1) {
					Controller.initPlayers(number);
					prompt.close();
				}
				else if(number > 4) {
					error.setText("That is too many players");
				}
				else {
					error.setText("That is too few players");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Not a number");
				error.setText("Are you sure that's a number?");
			}
		});
		
		VBox layout = new VBox(15);
		layout.getChildren().addAll(label, playerNum, submit, error);
		
		Scene scene = new Scene(layout, 200, 250);
		prompt.setScene(scene);
		prompt.show();
	}
	
	//ask for Player name
	public static void playerName() {
		String name ="";
		Stage prompt = new Stage();
		
		prompt.initModality(Modality.APPLICATION_MODAL);
		prompt.setTitle("Player name?");
		
		Text label = new Text();
		label.setText("What is your name?");
		TextField playerName = new TextField();
		Button submit = new Button("Submit");
		
		submit.setOnAction(e -> {
			names.add(playerName.getText());
			prompt.close();
		});
		
		VBox layout = new VBox(15);
		layout.getChildren().addAll(label, playerName, submit);
		Scene scene = new Scene(layout, 300, 300);
		prompt.setScene(scene);
		prompt.show();
	}

	public static ArrayList<String> getNames() {
		return names;
	}
}

package views;

import controllers.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SellFamily {

	//connected to button to sell family. calls method in controllers.Controller depending on which family they want to sell
	public static void sellFamily(){
		Stage prompt = new Stage();
		
		prompt.initModality(Modality.APPLICATION_MODAL);
		prompt.setTitle("Sell Family Member");
		
		Text label = new Text();
		label.setText("Which kind of family member do you want to sell?");
		Button spouse = new Button("Spouse");
		Button son = new Button("Son");
		Button daughter = new Button("Daughter");
		
		spouse.setOnAction(e -> Controller.sellSpouse());
		son.setOnAction(e -> Controller.sellSon());
		daughter.setOnAction(e -> Controller.sellDaughter());
		
		HBox buttons = new HBox(20);
		VBox layout = new VBox(15);
		layout.getChildren().addAll(label, buttons);
		Scene scene = new Scene(layout, 400, 300);
		prompt.setScene(scene);
		prompt.show();
	}
	
	public static void familyError() {
		// TODO Auto-generated method stub
		
	}
}

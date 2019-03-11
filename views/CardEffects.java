package views;

<<<<<<< HEAD
=======
import controllers.Controller;
>>>>>>> parent of 06fe034... Revert "Merge branch 'master' of https://github.com/lilhappyburrito/TheTroddenPath"
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.ChanceCard;

public class CardEffects {

	public static void message(ChanceCard chanceCard) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Card Effect");
		
		Text text = new Text();
		text.setText(chanceCard.getEffectString());
		Button button = new Button("Okay");
<<<<<<< HEAD
		button.setOnAction(e -> stage.close());
=======
		button.setOnAction(e -> {
			stage.close();
			Controller.rankUpChar(Controller.currentPlayer);
		});
>>>>>>> parent of 06fe034... Revert "Merge branch 'master' of https://github.com/lilhappyburrito/TheTroddenPath"
		
		VBox layout = new VBox(15);
		layout.getChildren().addAll(text, button);
		Scene scene = new Scene(layout, 300, 100);
		stage.setScene(scene);
		stage.show();
	}
}

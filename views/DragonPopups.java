package views;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.PlayerChar;

public class DragonPopups
{
  public DragonPopups() {}
  
  public static void attackMessage(PlayerChar pChar)
  {
    Stage prompt = new Stage();
    prompt.setTitle("You're being attack!");
    prompt.initModality(javafx.stage.Modality.APPLICATION_MODAL);
    
    Text label = new Text();
    label.setText(CHARNAME + ", you we're attacked and couldn't escape");
    javafx.scene.control.Button button = new javafx.scene.control.Button("");
    
    VBox layout = new VBox();
    layout.getChildren().addAll(new javafx.scene.Node[] { label, button });
    javafx.scene.Scene scene = new javafx.scene.Scene(layout, 100.0D, 300.0D);
    prompt.setScene(scene);
    prompt.show();
  }
}

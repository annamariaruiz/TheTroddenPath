/*    */ package views;
/*    */ 
/*    */ import javafx.scene.Scene;
/*    */ import javafx.scene.control.Button;
/*    */ import javafx.scene.layout.VBox;
/*    */ import javafx.scene.text.Text;
/*    */ import javafx.stage.Stage;
/*    */ import models.PlayerChar;
/*    */ 
/*    */ public class DragonPopups
/*    */ {
/*    */   public static void attackMessage(PlayerChar pChar)
/*    */   {
/* 14 */     Stage prompt = new Stage();
/* 15 */     prompt.setTitle("You're being attack!");
/* 16 */     prompt.initModality(javafx.stage.Modality.APPLICATION_MODAL);
/*    */     
/* 18 */     Text label = new Text();
/* 19 */     label.setText(pChar.CHARNAME + ", you we're attacked and couldn't escape");
/* 20 */     Button button = new Button("");
/*    */     
/* 22 */     VBox layout = new VBox();
/* 23 */     layout.getChildren().addAll(new javafx.scene.Node[] { label, button });
/* 24 */     Scene scene = new Scene(layout, 100.0D, 300.0D);
/* 25 */     prompt.setScene(scene);
/* 26 */     prompt.show();
/*    */   }
/*    */ }


/* Location:              C:\Users\arbymont\Desktop\troddenpath.jar!\views\DragonPopups.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
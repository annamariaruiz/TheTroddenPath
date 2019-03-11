/*     */ package views;
/*     */ 
/*     */ import controllers.Controller;
/*     */ import java.util.AbstractMap.SimpleEntry;
/*     */ import java.util.ArrayList;
/*     */ import javafx.animation.RotateTransition;
/*     */ import javafx.animation.TranslateTransition;
/*     */ import javafx.fxml.FXML;
/*     */ import javafx.scene.shape.Circle;
/*     */ import javafx.scene.text.Text;
/*     */ import javafx.util.Duration;
/*     */ import models.Player;
/*     */ import models.PlayerChar;
/*     */ import models.enums.TileDirection;
/*     */ 
/*     */ public class Connection
/*     */ {
/*  18 */   private int counter = 0;
/*     */   
/*     */   @FXML
/*     */   private Circle player1;
/*     */   
/*     */   @FXML
/*     */   private Circle player2;
/*     */   
/*     */   @FXML
/*     */   private Circle player3;
/*     */   
/*     */   @FXML
/*     */   private Circle player4;
/*     */   
/*     */   @FXML
/*     */   private javafx.scene.layout.Pane spinner;
/*     */   
/*     */   @FXML
/*  36 */   private Text playerName = new Text();
/*     */   
/*     */   @FXML
/*  39 */   private Text shekels = new Text();
/*     */   
/*     */   @FXML
/*  42 */   private Text prestige = new Text();
/*     */   
/*     */   @FXML
/*  45 */   private Text wellness = new Text();
/*     */   
/*     */   @FXML
/*  48 */   private Text limbsRemaining = new Text();
/*     */   
/*     */   @FXML
/*  51 */   private Text family = new Text();
/*     */   
/*     */   @FXML
/*  54 */   private Text position = new Text();
/*     */   
/*     */ 
/*     */   public static void updateView() {}
/*     */   
/*     */ 
/*     */   public void spinWheel()
/*     */   {
/*  62 */     int spunNumber = models.Wheel.spinWheel();
/*     */     
/*  64 */     animateWheel(1);
/*  65 */     for (int i = 0; i < spunNumber; i++) {
/*  66 */       animatePiece();
/*     */     }
/*  68 */     Controller.drawCard();
/*     */   }
/*     */   
/*     */   public void animateWheel(int spinAmount) {
/*  72 */     this.counter += 1;
/*  73 */     RotateTransition transition = new RotateTransition(Duration.seconds(2.5D), this.spinner);
/*  74 */     transition.setByAngle(44.0D);
/*  75 */     transition.play();
/*  76 */     switch (spinAmount) {
/*     */     case 1: 
/*  78 */       transition.setByAngle(20.0D);
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*  84 */   private static double player1X = 0.0D;
/*  85 */   private static double player1Y = 0.0D;
/*  86 */   private static double player2X = 0.0D;
/*  87 */   private static double player2Y = 0.0D;
/*  88 */   private static double player3X = 0.0D;
/*  89 */   private static double player3Y = 0.0D;
/*  90 */   private static double player4X = 0.0D;
/*  91 */   private static double player4Y = 0.0D;
/*     */   
/*     */   public void animatePiece()
/*     */   {
/*  95 */     Player currentPlayer = Controller.currentPlayer;
/*  96 */     int playerNum = currentPlayer.getPlayerID();
/*  97 */     int occupiedTile = ((PlayerChar)currentPlayer.getChars().get(0)).getOccupiedTile();
/*  98 */     TileDirection ntd = (TileDirection)((AbstractMap.SimpleEntry)Controller.TILES.get(occupiedTile)).getValue();
/*  99 */     TranslateTransition transition = new TranslateTransition();
/* 100 */     transition.setDuration(Duration.millis(1000.0D));
/* 101 */     ((PlayerChar)currentPlayer.getChars().get(0)).changeTile(1);
/*     */     double currentY;
/*     */     double currentY;
/*     */     double currentY;
/*     */     double currentX;
/* 106 */     double currentY; switch (playerNum) {
/*     */     case 2: 
/* 108 */       transition.setNode(this.player2);
/* 109 */       double currentX = player2X;
/* 110 */       currentY = player2Y;
/* 111 */       break;
/*     */     case 3: 
/* 113 */       transition.setNode(this.player3);
/* 114 */       double currentX = player3X;
/* 115 */       currentY = player3Y;
/* 116 */       break;
/*     */     case 4: 
/* 118 */       transition.setNode(this.player4);
/* 119 */       double currentX = player4X;
/* 120 */       currentY = player4Y;
/* 121 */       break;
/*     */     default: 
/* 123 */       transition.setNode(this.player1);
/* 124 */       currentX = player1X;
/* 125 */       currentY = player1Y;
/*     */     }
/*     */     
/* 128 */     switch (ntd) {
/*     */     case LEFT: 
/* 130 */       transition.setToY(currentY + 40.0D);
/* 131 */       currentY += 40.0D;
/* 132 */       break;
/*     */     case DOWN: 
/* 134 */       transition.setToY(currentY - 40.0D);
/* 135 */       currentY -= 40.0D;
/* 136 */       break;
/*     */     case RIGHT: 
/* 138 */       transition.setToX(currentX - 40.0D);
/* 139 */       currentX -= 40.0D;
/* 140 */       break;
/*     */     case UP: 
/* 142 */       transition.setToX(currentX + 40.0D);
/* 143 */       currentX += 40.0D;
/*     */     }
/*     */     
/* 146 */     transition.play();
/*     */     
/* 148 */     switch (playerNum) {
/*     */     case 1: 
/* 150 */       player1X = currentX;
/* 151 */       player1Y = currentY;
/* 152 */       break;
/*     */     case 2: 
/* 154 */       player2X = currentX;
/* 155 */       player2Y = currentY;
/* 156 */       break;
/*     */     case 3: 
/* 158 */       player3X = currentX;
/* 159 */       player3Y = currentY;
/* 160 */       break;
/*     */     case 4: 
/* 162 */       player4X = currentX;
/* 163 */       player4Y = currentY;
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 168 */     this.playerName.setText(currentPlayer.NAME);
/*     */     
/* 170 */     this.shekels.setText("Shekels: " + ((PlayerChar)currentPlayer.getChars().get(0)).getShekels());
/* 171 */     this.prestige.setText("Prestige: " + ((PlayerChar)currentPlayer.getChars().get(0)).getShekels());
/* 172 */     this.wellness.setText("Wellness: " + ((PlayerChar)currentPlayer.getChars().get(0)).getWellness());
/* 173 */     this.limbsRemaining.setText("Limbs Remaining: " + ((PlayerChar)currentPlayer.getChars().get(0)).getLimbs().size());
/* 174 */     StringBuilder sb = new StringBuilder();
/* 175 */     for (int i = 1; i < currentPlayer.getChars().size(); i++) {
/* 176 */       sb.append(((PlayerChar)currentPlayer.getChars().get(i)).getRole() + ": " + ((PlayerChar)currentPlayer.getChars().get(i)).CHARNAME);
/*     */     }
/* 178 */     this.family.setText(sb.toString());
/*     */   }
/*     */   
/*     */   public void sellFamily() {}
/*     */   
/*     */   public void giveUp() {}
/*     */ }


/* Location:              C:\Users\arbymont\Desktop\troddenpath.jar!\views\Connection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
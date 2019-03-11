/*     */ package views;
/*     */ 
/*     */ import controllers.Controller;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import javafx.application.Application;
/*     */ import javafx.fxml.FXMLLoader;
/*     */ import javafx.scene.Parent;
/*     */ import javafx.scene.Scene;
/*     */ import javafx.stage.Stage;
/*     */ import views.enums.NextTileDirection;
/*     */ 
/*     */ 
/*     */ public class Main
/*     */   extends Application
/*     */ {
/*  17 */   private Stage window = new Stage();
/*     */   private Scene startScene;
/*  19 */   private Scene boardGame; private ArrayList<Tile> tiles = new ArrayList();
/*     */   
/*     */   public static void main(String[] args) {
/*  22 */     launch(args);
/*     */   }
/*     */   
/*     */   public void start(Stage primaryStage) throws IOException
/*     */   {
/*  27 */     this.window = primaryStage;
/*  28 */     this.window.setTitle("The Trodden Path");
/*  29 */     Parent start = (Parent)FXMLLoader.load(getClass().getResource("Start.fxml"));
/*     */     
/*  31 */     this.startScene = new Scene(start, 600.0D, 300.0D);
/*  32 */     this.window.setResizable(false);
/*  33 */     this.window.setScene(this.startScene);
/*  34 */     this.window.show();
/*  35 */     PlayerInit.playerNum();
/*     */   }
/*     */   
/*     */   public void startGame() throws IOException {
/*  39 */     Parent root = (Parent)FXMLLoader.load(getClass().getResource("Game.fxml"));
/*  40 */     this.boardGame = new Scene(root, 1300.0D, 700.0D);
/*  41 */     this.window.setResizable(false);
/*  42 */     this.window.setScene(this.boardGame);
/*  43 */     this.window.show();
/*  44 */     Controller.run();
/*  45 */     Controller.initPlayers(PlayerInit.getNames());
/*     */   }
/*     */   
/*     */   private static void createTileArrayList() {
/*     */     Tile localTile1;
/*  50 */     for (int i = 0; i < 13; i++) {
/*  51 */       localTile1 = new Tile(NextTileDirection.RIGHT);
/*     */     }
/*     */     
/*  54 */     for (int i = 0; i < 8; i++) {
/*  55 */       localTile1 = new Tile(NextTileDirection.UP);
/*     */     }
/*     */     
/*  58 */     for (int i = 0; i < 2; i++) {
/*  59 */       localTile1 = new Tile(NextTileDirection.LEFT);
/*     */     }
/*     */     
/*  62 */     for (int i = 0; i < 6; i++) {
/*  63 */       localTile1 = new Tile(NextTileDirection.DOWN);
/*     */     }
/*     */     
/*  66 */     for (int i = 0; i < 2; i++) {
/*  67 */       localTile1 = new Tile(NextTileDirection.LEFT);
/*     */     }
/*     */     
/*  70 */     for (int i = 0; i < 6; i++) {
/*  71 */       localTile1 = new Tile(NextTileDirection.UP);
/*     */     }
/*     */     
/*  74 */     for (int i = 0; i < 2; i++) {
/*  75 */       localTile1 = new Tile(NextTileDirection.LEFT);
/*     */     }
/*     */     
/*  78 */     for (int i = 0; i < 6; i++) {
/*  79 */       localTile1 = new Tile(NextTileDirection.DOWN);
/*     */     }
/*     */     
/*  82 */     for (int i = 0; i < 2; i++) {
/*  83 */       localTile1 = new Tile(NextTileDirection.LEFT);
/*     */     }
/*     */     
/*  86 */     for (int i = 0; i < 6; i++) {
/*  87 */       localTile1 = new Tile(NextTileDirection.UP);
/*     */     }
/*     */     
/*  90 */     for (int i = 0; i < 2; i++) {
/*  91 */       localTile1 = new Tile(NextTileDirection.LEFT);
/*     */     }
/*     */     
/*  94 */     for (int i = 0; i < 6; i++) {
/*  95 */       localTile1 = new Tile(NextTileDirection.DOWN);
/*     */     }
/*     */     
/*  98 */     for (int i = 0; i < 2; i++) {
/*  99 */       localTile1 = new Tile(NextTileDirection.LEFT);
/*     */     }
/*     */     
/* 102 */     for (int i = 0; i < 6; i++) {
/* 103 */       localTile1 = new Tile(NextTileDirection.UP);
/*     */     }
/*     */     
/* 106 */     for (int i = 0; i < 2; i++) {
/* 107 */       localTile1 = new Tile(NextTileDirection.LEFT);
/*     */     }
/*     */     
/* 110 */     for (int i = 0; i < 6; i++) {
/* 111 */       localTile1 = new Tile(NextTileDirection.DOWN);
/*     */     }
/*     */     
/* 114 */     for (int i = 0; i < 2; i++) {
/* 115 */       localTile1 = new Tile(NextTileDirection.LEFT);
/*     */     }
/*     */     
/* 118 */     for (int i = 0; i < 6; i++) {
/* 119 */       localTile1 = new Tile(NextTileDirection.UP);
/*     */     }
/*     */     
/* 122 */     for (int i = 0; i < 2; i++) {
/* 123 */       localTile1 = new Tile(NextTileDirection.LEFT);
/*     */     }
/*     */     
/* 126 */     for (int i = 0; i < 6; i++) {
/* 127 */       localTile1 = new Tile(NextTileDirection.DOWN);
/*     */     }
/*     */     
/* 130 */     for (int i = 0; i < 2; i++) {
/* 131 */       localTile1 = new Tile(NextTileDirection.LEFT);
/*     */     }
/*     */     
/* 134 */     for (int i = 0; i < 4; i++) {
/* 135 */       localTile1 = new Tile(NextTileDirection.UP);
/*     */     }
/*     */     
/*     */ 
/* 139 */     Tile last = new Tile(NextTileDirection.LAST);
/*     */   }
/*     */ }


/* Location:              C:\Users\arbymont\Desktop\troddenpath.jar!\views\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
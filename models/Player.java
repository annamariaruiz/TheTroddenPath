/*    */ package models;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Player
/*    */ {
/*    */   public final String NAME;
/*    */   private ArrayList<PlayerChar> chars;
/*  9 */   private static int playerNum = 0;
/* 10 */   private int playerID = 0;
/*    */   
/*    */   public Player(String name) {
/* 13 */     playerNum += 1;
/* 14 */     setPlayerID(playerNum);
/* 15 */     this.NAME = name;
/* 16 */     this.chars = new ArrayList();
/* 17 */     this.chars.add(new PlayerChar());
/*    */   }
/*    */   
/*    */   public Player() {
/* 21 */     playerNum += 1;
/* 22 */     this.NAME = ("Player " + playerNum);
/* 23 */     this.chars = new ArrayList();
/* 24 */     this.chars.add(new PlayerChar());
/*    */   }
/*    */   
/*    */   public ArrayList<PlayerChar> getChars()
/*    */   {
/* 29 */     return this.chars;
/*    */   }
/*    */   
/*    */   public void setChars(ArrayList<PlayerChar> chars) {
/* 33 */     this.chars = chars;
/*    */   }
/*    */   
/*    */   public static int getPlayerNum() {
/* 37 */     return playerNum;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String toString()
/*    */   {
/* 44 */     StringBuilder builder = new StringBuilder();
/* 45 */     builder.append("Player Name: ").append(this.NAME)
/* 46 */       .append("\nAmount of characters: ").append(getChars().size());
/* 47 */     return builder.toString();
/*    */   }
/*    */   
/*    */   public int getPlayerID() {
/* 51 */     return this.playerID;
/*    */   }
/*    */   
/*    */   public void setPlayerID(int playerID) {
/* 55 */     this.playerID = playerID;
/*    */   }
/*    */ }


/* Location:              C:\Users\arbymont\Desktop\troddenpath.jar!\models\Player.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
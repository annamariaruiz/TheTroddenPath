/*    */ package models;
/*    */ 
/*    */ public class Dragon extends BoardChar
/*    */ {
/*    */   private int turn;
/*    */   
/*    */   public Dragon() {
/*  8 */     setTurn(0);
/*    */   }
/*    */   
/*    */   public int getTurn()
/*    */   {
/* 13 */     return this.turn;
/*    */   }
/*    */   
/*    */   public void setTurn(int turn) {
/* 17 */     this.turn = turn;
/*    */   }
/*    */   
/*    */   public void increaseTurn() {
/* 21 */     this.turn += 1;
/*    */   }
/*    */   
/*    */   public int[] getDragonTiles() {
/* 25 */     int[] dragonTiles = new int[5];
/* 26 */     for (int i = 0; i < dragonTiles.length; i++) {
/* 27 */       dragonTiles[i] = (getOccupiedTile() + i - 2);
/*    */     }
/*    */     
/* 30 */     return dragonTiles;
/*    */   }
/*    */   
/*    */   public void setOccupiedTile(int occupiedTile)
/*    */   {
/* 35 */     if ((occupiedTile < 5) || (occupiedTile > 95)) {
/* 36 */       throw new IllegalArgumentException("Error: The dragon may only occupy a tile at least five spaces away from the start and the end.");
/*    */     }
/*    */     
/* 39 */     this.occupiedTile = occupiedTile;
/*    */   }
/*    */   
/*    */   public void setWellness(int wellness)
/*    */   {
/* 44 */     if ((wellness < 0) || (wellness > 500)) {
/* 45 */       throw new IllegalArgumentException("Error: A dragon's health ranges from 0 to 500.");
/*    */     }
/*    */     
/* 48 */     this.wellness = wellness;
/*    */   }
/*    */ }


/* Location:              C:\Users\arbymont\Desktop\troddenpath.jar!\models\Dragon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
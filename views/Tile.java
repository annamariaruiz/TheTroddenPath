/*    */ package views;
/*    */ 
/*    */ import views.enums.NextTileDirection;
/*    */ 
/*    */ public class Tile
/*    */ {
/*  7 */   private static int tileNum = 0;
/*    */   private final NextTileDirection ntd;
/*    */   
/*    */   public Tile(NextTileDirection ntd) {
/* 11 */     tileNum += 1;
/* 12 */     this.ntd = ntd;
/*    */   }
/*    */   
/*    */   public int getTileNum() {
/* 16 */     return tileNum;
/*    */   }
/*    */   
/*    */   public NextTileDirection getNtd()
/*    */   {
/* 21 */     return this.ntd;
/*    */   }
/*    */ }


/* Location:              C:\Users\arbymont\Desktop\troddenpath.jar!\views\Tile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
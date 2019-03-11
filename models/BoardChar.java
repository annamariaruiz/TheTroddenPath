/*    */ package models;
/*    */ 
/*    */ public abstract class BoardChar
/*    */ {
/*    */   protected int occupiedTile;
/*    */   protected int wellness;
/*    */   
/*    */   public int getOccupiedTile() {
/*  9 */     return this.occupiedTile;
/*    */   }
/*    */   
/*    */   public abstract void setOccupiedTile(int paramInt);
/*    */   
/*    */   public int getWellness() {
/* 15 */     return this.wellness;
/*    */   }
/*    */   
/*    */   public abstract void setWellness(int paramInt);
/*    */   
/*    */   public void changeTile(int advance) {
/* 21 */     setOccupiedTile(getOccupiedTile() + advance);
/*    */   }
/*    */   
/*    */   public void changeWellness(int wellnessGain) {
/* 25 */     setWellness(getWellness() + wellnessGain);
/*    */   }
/*    */ }


/* Location:              C:\Users\arbymont\Desktop\troddenpath.jar!\models\BoardChar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
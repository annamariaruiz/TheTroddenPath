/*    */ package models;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class Wheel
/*    */ {
/*  9 */   private static Random rng = new Random();
/*    */   
/*    */ 
/*    */   public static int spinWheel(int numOfPlayers)
/*    */   {
/* 14 */     ArrayList<Integer> spins = new ArrayList();
/* 15 */     int player1Spin = rng.nextInt(10) + 1;
/* 16 */     spins.add(Integer.valueOf(player1Spin));
/* 17 */     int player2Spin = 0;
/* 18 */     int player3Spin = 0;
/* 19 */     int player4Spin = 0;
/* 20 */     if (numOfPlayers > 1)
/*    */     {
/* 22 */       player2Spin = rng.nextInt(10) + 1;
/* 23 */       spins.add(Integer.valueOf(player2Spin));
/* 24 */       if (numOfPlayers > 2)
/*    */       {
/* 26 */         player3Spin = rng.nextInt(10) + 1;
/* 27 */         spins.add(Integer.valueOf(player3Spin));
/*    */       }
/* 29 */       if (numOfPlayers > 3)
/*    */       {
/* 31 */         player4Spin = rng.nextInt(10) + 1;
/* 32 */         spins.add(Integer.valueOf(player4Spin));
/*    */       }
/*    */     }
/* 35 */     Collections.sort(spins);
/*    */     
/* 37 */     int winningNum = ((Integer)spins.get(spins.size() - 1)).intValue();
/*    */     
/* 39 */     if ((winningNum == player1Spin) && (winningNum != player2Spin) && (winningNum != player3Spin) && (winningNum != player4Spin)) {
/* 40 */       return 1;
/*    */     }
/*    */     
/* 43 */     if ((winningNum != player1Spin) && (winningNum == player2Spin) && (winningNum != player3Spin) && (winningNum != player4Spin)) {
/* 44 */       return 2;
/*    */     }
/*    */     
/* 47 */     if ((winningNum != player1Spin) && (winningNum != player2Spin) && (winningNum == player3Spin) && (winningNum != player4Spin)) {
/* 48 */       return 3;
/*    */     }
/*    */     
/* 51 */     if ((winningNum != player1Spin) && (winningNum != player2Spin) && (winningNum != player3Spin) && (winningNum == player4Spin)) {
/* 52 */       return 4;
/*    */     }
/*    */     
/*    */ 
/* 56 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public static int spinWheel()
/*    */   {
/* 62 */     return rng.nextInt(10) + 1;
/*    */   }
/*    */ }


/* Location:              C:\Users\arbymont\Desktop\troddenpath.jar!\models\Wheel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
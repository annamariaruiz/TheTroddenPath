package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Wheel
{
  private static Random rng = new Random();
  
  public Wheel() {}
  
  public static int spinWheel(int numOfPlayers) {
    ArrayList<Integer> spins = new ArrayList();
    int player1Spin = rng.nextInt(10) + 1;
    spins.add(Integer.valueOf(player1Spin));
    int player2Spin = 0;
    int player3Spin = 0;
    int player4Spin = 0;
    if (numOfPlayers > 1)
    {
      player2Spin = rng.nextInt(10) + 1;
      spins.add(Integer.valueOf(player2Spin));
      if (numOfPlayers > 2)
      {
        player3Spin = rng.nextInt(10) + 1;
        spins.add(Integer.valueOf(player3Spin));
      }
      if (numOfPlayers > 3)
      {
        player4Spin = rng.nextInt(10) + 1;
        spins.add(Integer.valueOf(player4Spin));
      }
    }
    Collections.sort(spins);
    
    int winningNum = ((Integer)spins.get(spins.size() - 1)).intValue();
    
    if ((winningNum == player1Spin) && (winningNum != player2Spin) && (winningNum != player3Spin) && (winningNum != player4Spin)) {
      return 1;
    }
    
    if ((winningNum != player1Spin) && (winningNum == player2Spin) && (winningNum != player3Spin) && (winningNum != player4Spin)) {
      return 2;
    }
    
    if ((winningNum != player1Spin) && (winningNum != player2Spin) && (winningNum == player3Spin) && (winningNum != player4Spin)) {
      return 3;
    }
    
    if ((winningNum != player1Spin) && (winningNum != player2Spin) && (winningNum != player3Spin) && (winningNum == player4Spin)) {
      return 4;
    }
    

    return 0;
  }
  

  public static int spinWheel()
  {
    return rng.nextInt(10) + 1;
  }
}

package models;

import java.util.ArrayList;
import java.util.Random;
import models.enums.CharClass;
import models.enums.TileColor;

public class ChanceCard
{
  public final TileColor TILECOLOR;
  private int effectIndex;
  private String effectString;
  private String classMod;
  private String[] yValues = { "dysentary.", "measels.", "typhoid fever.", "polio.", "smallpox.", 
    "cholera.", "the Black Death.", "got kicked by a horse.", "got spit on by a peon.", 
    "got a splinter." };
  private PlayerChar pChar;
  private Player player;
  private ArrayList<PlayerChar> playerChars;
  private boolean repeatTurn;
  private boolean skipTurn; private static Random rng = new Random();
  
  private int x = 0;
  private int y = 0;
  
  public ChanceCard(TileColor tileColor, Player player)
  {
    playerChars = player.getChars();
    pChar = ((PlayerChar)playerChars.get(0));
    TILECOLOR = tileColor;
    setPlayerChar(pChar);
    setRepeatTurn(false);
    setSkipTurn(false);
    setPlayer(player);
    setClassMod("");
    



    if (TILECOLOR == TileColor.GREEN) {
      effectIndex = rng.nextInt(10);
    } else if (TILECOLOR == TileColor.RED) {
      effectIndex = (rng.nextInt(8) + 10);
    } else if (TILECOLOR == TileColor.BLUE) {
      effectIndex = (rng.nextInt(4) + 18);
    } else {
      effectIndex = rng.nextInt(22);
    }
    

    findEffect();
  }
  

  public void findEffect()
  {
    if (effectIndex == 11) {
      y = (rng.nextInt(3) + 7);
      if (y == 7) {
        x = 15;
      } else if (y == 8) {
        x = 10;
      } else {
        x = 5;
      }
    } else if (effectIndex == 12) {
      y = rng.nextInt(7);
    } else {
      x = (rng.nextInt(20) + 1);
    }
    
    String[] effects = {
      "Gain " + x * 3 + " shekels", 
      "Gain " + x * 3 + " prestige", 
      "You found bandages for your wounds. Gain " + x + " wellness", 
      "Take another turn.", 
      "You got treatment for your disease. Gain " + x * 2 + " wellness.", 
      "You got married.", 
      "You had a baby girl.", 
      "You have a baby boy.", 
      "Gain " + x * 3 + " shekels", 
      "Gain " + x * 3 + " prestige", 
      "You got in a bar fight and lost. Lose " + x + " wellness and " + x * 2 + " prestige.", 
      "You " + yValues[y] + " Lose " + x + " wellness.", 
      "Oops! You have contracted " + yValues[y], 
      "Your spouse is declared a witch and is burned at the stake. Lose your spouse.", 
      "You forgot one of your children at the last town. Lose a child.", 
      "Uh oh, you got tarred and feathered. Lose your next turn.", 
      "You were mugged. Lose " + x * 2 + " shekels.", 
      "You did something naughty. Lose " + x * 2 + " prestige.", 
      "You had too much fun at the local tavern and have ended up with a child. Lose " + x * 3 + " prestige, but gain a child.", 
      "You sell your son off for work. Lose a son, but gain " + x * 3 + " shekels.", 
      "You sell your daugther off for marriage. Lose a daughter, but gain " + x * 3 + " prestige and shekels.", 
      "You got in a bar fight and won! Lose " + x + " wellness, but gain " + x * 3 + " prestige." };
    
    effectString = effects[effectIndex];
    setEffectString(effectString);
    applyEffect(pChar, effectIndex);
  }
  
  private void editShekels(PlayerChar pChar, boolean gain, int x)
  {
    int shekels = pChar.getShekels();
    CharClass classType = pChar.getCharClass();
    
    if ((classType.equals(CharClass.MERCHANT)) || (classType.equals(CharClass.DUKE))) {
      if (gain) {
        x *= 2;
        setClassMod("Because of your class, you gain twice as many shekels.");
      } else {
        x /= 2;
        setClassMod("Because of your class, you lose half as many shekels.");
      }
    }
    if (!gain) {
      x *= -1;
    }
    
    pChar.setShekels(shekels + x);
  }
  
  private void editPrestige(PlayerChar pChar, boolean gain, int x) {
    int prestige = pChar.getPrestige();
    CharClass classType = pChar.getCharClass();
    
    if ((classType.equals(CharClass.DUKE)) || (classType.equals(CharClass.PRIEST))) {
      if (gain) {
        x *= 2;
        setClassMod("Because of your class, you gain twice as much prestige.");
      } else {
        x /= 2;
        setClassMod("Because of your class, you lose half as much prestige.");
      }
    }
    if (!gain) {
      x *= -1;
    }
    
    pChar.setPrestige(prestige + x);
  }
  
  private void editWellness(PlayerChar pChar, boolean gain, int x) {
    int wellness = pChar.getWellness();
    CharClass classType = pChar.getCharClass();
    
    if ((classType.equals(CharClass.PRIEST)) && 
      (gain)) {
      x *= 2;
      setClassMod("Because of your class, you gain twice as much wellness.");
    }
    
    if ((classType.equals(CharClass.KNIGHT)) && 
      (!gain)) {
      x /= 2;
      setClassMod("Because of your class, you lose half as much wellness.");
    }
    
    if (!gain) {
      x *= -1;
    }
    
    pChar.setWellness(wellness + x);
  }
  




  public void applyEffect(PlayerChar pChar, int effectIndex)
  {
    switch (effectIndex) {
    case 0: 
      editShekels(pChar, true, x * 3);
      break;
    case 1: 
      editPrestige(pChar, true, x * 3);
      break;
    case 2: 
      editWellness(pChar, true, x);
      break;
    case 3: 
      setRepeatTurn(true);
      break;
    case 4: 
      editWellness(pChar, true, x * 2);
      break;
    case 5: 
      boolean has = checkFamily("spouse");
      if ((!has) && (pChar.getCharClass() != CharClass.PRIEST)) {
        addFamily("spouse");
      } else {
        setClassMod("Your card had no effect.");
      }
      break;
    case 6: 
      if (pChar.getCharClass() != CharClass.PRIEST) {
        addFamily("daughter");
      }
      break;
    case 7: 
      if (pChar.getCharClass() != CharClass.PRIEST) {
        addFamily("son");
      }
      break;
    case 8: 
      editShekels(pChar, true, x * 3);
      break;
    case 9: 
      editPrestige(pChar, true, x * 3);
      break;
    case 10: 
      if (pChar.getCharClass() == CharClass.KNIGHT) {
        setEffectString("You got in a bar fight, and it was a flawless victory. Gain " + x * 5 + " prestige.");
        editPrestige(pChar, true, x * 5);
      } else {
        editPrestige(pChar, false, x * 2);
        editWellness(pChar, false, x);
      }
      break;
    case 11: 
      if (y == 7) {
        editWellness(pChar, false, x);
      } else if (y == 8) {
        editWellness(pChar, false, x);
      } else {
        editWellness(pChar, false, x);
      }
      break;
    case 12: 
      if (y == 0) {
        x = 5;
        editWellness(pChar, false, 5);
      } else if (y == 1) {
        x = 10;
        editWellness(pChar, false, 10);
      } else if (y == 2) {
        x = 15;
        editWellness(pChar, false, 15);
      } else if (y == 3) {
        x = 20;
        editWellness(pChar, false, 20);
      } else if (y == 4) {
        x = 30;
        editWellness(pChar, false, 30);
      } else if (y == 5) {
        x = 40;
        editWellness(pChar, false, 40);
      } else if (y == 6) {
        x = 50;
        editWellness(pChar, false, 50);
      }
      break;
    case 13: 
      boolean has = checkFamily("spouse");
      if (has) {
        removeFamily("spouse");
      } else {
        setClassMod("Your card had no effect.");
      }
      break;
    case 14: 
      boolean has = checkFamily("son");
      if (has) {
        removeFamily("son");
      } else {
        has = checkFamily("daughter");
        if (has) {
          removeFamily("daughter");
        } else {
          setClassMod("Your card had no effect.");
        }
      }
      break;
    case 15: 
      setSkipTurn(true);
      break;
    case 16: 
      editShekels(pChar, false, x * 2);
      break;
    case 17: 
      editPrestige(pChar, false, x * 2);
      break;
    case 18: 
      if (pChar.getCharClass() != CharClass.PRIEST) {
        int familyNum = rng.nextInt(2);
        String role; String role; if (familyNum == 0) {
          role = "son";
        } else {
          role = "daughter";
        }
        addFamily(role);
        editPrestige(pChar, false, x * 3);
      } else {
        setClassMod("Your card had no effect.");
      }
      break;
    case 19: 
      boolean has = checkFamily("son");
      if (has) {
        removeFamily("son");
        editShekels(pChar, true, x * 3);
      } else {
        setClassMod("Your card had no effect.");
      }
      break;
    case 20: 
      boolean has = checkFamily("daughter");
      if (has) {
        removeFamily("daughter");
        editShekels(pChar, true, x * 3);
        editPrestige(pChar, true, x * 3);
      } else {
        setClassMod("Your card had no effect.");
      }
      break;
    case 21: 
      if (pChar.getCharClass() == CharClass.KNIGHT) {
        setEffectString("You got in a bar fight, and it was a flawless victory. Gain " + x * 5 + " prestige.");
        editPrestige(pChar, true, x * 5);
      } else {
        editWellness(pChar, false, x);
        editPrestige(pChar, true, x * 3);
      }
      break;
    }
  }
  
  public void addFamily(String role) {
    boolean gender = false;
    

    if (role.equals("son")) {
      gender = true;
    } else if (role.equals("daughter")) {
      gender = false;
    } else {
      int genderNum = rng.nextInt(2);
      if (genderNum == 0) {
        gender = true;
      }
    }
    PlayerChar newChar = new PlayerChar(gender, role);
    playerChars.add(newChar);
    player.setChars(playerChars);
  }
  
  public void removeFamily(String role) {
    for (int i = 0; i < playerChars.size(); i++) {
      if (((PlayerChar)playerChars.get(i)).getRole().equals(role)) {
        playerChars.remove(i);
        player.setChars(playerChars);
        i = playerChars.size();
      }
    }
  }
  
  public boolean checkFamily(String role) {
    boolean has = false;
    String charRole = null;
    
    for (int i = 0; i < playerChars.size(); i++) {
      charRole = ((PlayerChar)playerChars.get(i)).getRole();
      if (charRole.equals(role)) {
        has = true;
        i = playerChars.size();
      }
    }
    
    return has;
  }
  
  public String getEffectString() {
    return effectString;
  }
  
  public void setEffectString(String effectString) {
    this.effectString = effectString;
  }
  
  public int getEffectNum() {
    return effectIndex;
  }
  
  public void setEffectNum(int effectNum) {
    if ((effectNum < 0) || (effectNum > 21)) {
      throw new IllegalArgumentException("The value of effectNum must be between 0 and 19.");
    }
    effectIndex = effectNum;
  }
  
  public PlayerChar getPlayerChar() {
    return pChar;
  }
  
  public void setPlayerChar(PlayerChar pChar) {
    this.pChar = pChar;
  }
  
  public Player getPlayer() {
    return player;
  }
  
  public void setPlayer(Player player) {
    this.player = player;
  }
  
  public boolean repeatTurn() {
    return repeatTurn;
  }
  
  public void setRepeatTurn(boolean repeatTurn) {
    this.repeatTurn = repeatTurn;
  }
  
  public boolean skipTurn() {
    return skipTurn;
  }
  
  public void setSkipTurn(boolean skipTurn) {
    this.skipTurn = skipTurn;
  }
  
  public String getClassMod() {
    return classMod;
  }
  
  public void setClassMod(String classMod) {
    this.classMod = classMod;
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append(player.NAME).append(" draws a card.\n").append(getEffectString())
      .append("\n").append(getClassMod());
    return builder.toString();
  }
}

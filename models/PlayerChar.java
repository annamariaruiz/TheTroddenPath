/*     */ package models;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import models.enums.CharClass;
/*     */ 
/*     */ public class PlayerChar extends BoardChar
/*     */ {
/*     */   private ArrayList<Boolean> limbs;
/*     */   private CharClass charClass;
/*     */   private int shekels;
/*     */   private int prestige;
/*  13 */   private static int playerNum = 0;
/*     */   public final String CHARNAME;
/*  15 */   private Random rng = new Random();
/*  16 */   private String role = "";
/*     */   
/*     */ 
/*     */   private final boolean gender;
/*     */   
/*     */ 
/*  22 */   private String[] fNames = {
/*  23 */     "Zoe", "Christine", "Henrietta", "Anna", "Josephine", "Crystal", "Gennias", "Candy", "Katherine", "Elizabeth", "Mary", "Laicey", "Brenna", "Heather", "Molly", "Marissa", "Patricia", "Jessica" };
/*     */   
/*  25 */   private String[] mNames = {
/*  26 */     "Lucas", "Riley", "Lane", "CJ", "Chris", "Troy", "Eric", "Kyle", "Wesley", "Dakota", "Adam", "Henry", "Joseph", "Harold", "Spencer", "Joshua", "Cameron", "Justin", "Robert" };
/*     */   
/*     */   public PlayerChar()
/*     */   {
/*  30 */     int genderNum = this.rng.nextInt(2);
/*  31 */     switch (genderNum) {
/*     */     case 0: 
/*  33 */       this.gender = false;
/*  34 */       break;
/*     */     default: 
/*  36 */       this.gender = true;
/*     */     }
/*     */     
/*  39 */     if (this.gender) {
/*  40 */       this.CHARNAME = this.mNames[this.rng.nextInt(this.mNames.length)];
/*     */     }
/*     */     else {
/*  43 */       this.CHARNAME = this.fNames[this.rng.nextInt(this.fNames.length)];
/*     */     }
/*  45 */     this.limbs = new ArrayList();
/*  46 */     this.limbs.add(Boolean.valueOf(true));
/*  47 */     this.limbs.add(Boolean.valueOf(true));
/*  48 */     this.limbs.add(Boolean.valueOf(true));
/*  49 */     this.limbs.add(Boolean.valueOf(true));
/*  50 */     this.charClass = CharClass.CITIZEN;
/*  51 */     this.shekels = 0;
/*  52 */     this.prestige = 0;
/*  53 */     playerNum += 1;
/*  54 */     this.role = "player";
/*  55 */     setWellness(100);
/*     */   }
/*     */   
/*     */   public PlayerChar(boolean gender, String role)
/*     */   {
/*  60 */     this.limbs = new ArrayList();
/*  61 */     this.limbs.add(Boolean.valueOf(true));
/*  62 */     this.limbs.add(Boolean.valueOf(true));
/*  63 */     this.limbs.add(Boolean.valueOf(true));
/*  64 */     this.limbs.add(Boolean.valueOf(true));
/*  65 */     if (gender) {
/*  66 */       this.CHARNAME = this.mNames[this.rng.nextInt(this.mNames.length)];
/*     */     } else {
/*  68 */       this.CHARNAME = this.fNames[this.rng.nextInt(this.fNames.length)];
/*     */     }
/*  70 */     this.charClass = CharClass.CITIZEN;
/*  71 */     this.shekels = 0;
/*  72 */     this.prestige = 0;
/*  73 */     this.gender = gender;
/*  74 */     this.role = role;
/*  75 */     setWellness(100);
/*     */   }
/*     */   
/*     */   public PlayerChar(String CHARNAME, boolean gender, ArrayList<Boolean> limbs, CharClass charClass, int shekels, int prestige)
/*     */   {
/*  80 */     this.limbs = limbs;
/*  81 */     this.charClass = charClass;
/*  82 */     this.shekels = shekels;
/*  83 */     this.prestige = prestige;
/*  84 */     this.CHARNAME = CHARNAME;
/*  85 */     this.gender = gender;
/*  86 */     setWellness(100);
/*     */   }
/*     */   
/*     */   public ArrayList<Boolean> getLimbs()
/*     */   {
/*  91 */     return this.limbs;
/*     */   }
/*     */   
/*     */   public void setLimbs(ArrayList<Boolean> limbs) {
/*  95 */     this.limbs = limbs;
/*     */   }
/*     */   
/*     */   public CharClass getCharClass() {
/*  99 */     return this.charClass;
/*     */   }
/*     */   
/*     */   public void setCharClass(CharClass charClass) {
/* 103 */     this.charClass = charClass;
/*     */   }
/*     */   
/*     */   public int getShekels() {
/* 107 */     return this.shekels;
/*     */   }
/*     */   
/*     */   public void setShekels(int shekels) {
/* 111 */     if (shekels < 0) {
/* 112 */       shekels = 0;
/*     */     }
/*     */     
/* 115 */     this.shekels = shekels;
/*     */   }
/*     */   
/*     */   public int getPrestige() {
/* 119 */     return this.prestige;
/*     */   }
/*     */   
/*     */   public void setPrestige(int prestige) {
/* 123 */     if (prestige < 0) {
/* 124 */       prestige = 0;
/*     */     }
/*     */     
/* 127 */     this.prestige = prestige;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setOccupiedTile(int occupiedTile)
/*     */   {
/* 133 */     this.occupiedTile = occupiedTile;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setWellness(int wellness)
/*     */   {
/* 139 */     if (wellness > 100) {
/* 140 */       wellness = 100;
/*     */     }
/*     */     
/* 143 */     if (wellness < 0) {
/* 144 */       wellness = 0;
/*     */     }
/*     */     
/* 147 */     this.wellness = wellness;
/*     */   }
/*     */   
/*     */   public static int getPlayerNum()
/*     */   {
/* 152 */     return playerNum;
/*     */   }
/*     */   
/*     */   public static void setPlayerNum(int playerNum)
/*     */   {
/* 157 */     playerNum = playerNum;
/*     */   }
/*     */   
/*     */   public String getRole() {
/* 161 */     return this.role;
/*     */   }
/*     */   
/*     */   public void setRole(String role) {
/* 165 */     this.role = role;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 170 */     StringBuilder builder = new StringBuilder();
/* 171 */     builder.append("Player Character: ")
/* 172 */       .append("\nName: ").append(this.CHARNAME)
/* 173 */       .append("\nRole: ").append(getRole())
/* 174 */       .append("\nClass: ").append(getCharClass())
/* 175 */       .append("\nWellness: ").append(getWellness())
/* 176 */       .append("\nShekels: ").append(getShekels())
/* 177 */       .append("\nPrestige: ").append(getPrestige())
/* 178 */       .append("\nPlayer number: ").append(getPlayerNum());
/* 179 */     return builder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\arbymont\Desktop\troddenpath.jar!\models\PlayerChar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
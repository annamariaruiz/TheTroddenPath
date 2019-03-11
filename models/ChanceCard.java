/*     */ package models;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import models.enums.CharClass;
/*     */ import models.enums.TileColor;
/*     */ 
/*     */ public class ChanceCard
/*     */ {
/*     */   public final TileColor TILECOLOR;
/*     */   private int effectIndex;
/*     */   private String effectString;
/*     */   private String classMod;
/*  14 */   private String[] yValues = { "dysentary.", "measels.", "typhoid fever.", "polio.", "smallpox.", 
/*  15 */     "cholera.", "the Black Death.", "got kicked by a horse.", "got spit on by a peon.", 
/*  16 */     "got a splinter." };
/*     */   private PlayerChar pChar;
/*     */   private Player player;
/*     */   private ArrayList<PlayerChar> playerChars;
/*     */   private boolean repeatTurn;
/*  21 */   private boolean skipTurn; private static Random rng = new Random();
/*     */   
/*  23 */   private int x = 0;
/*  24 */   private int y = 0;
/*     */   
/*     */   public ChanceCard(TileColor tileColor, Player player)
/*     */   {
/*  28 */     this.playerChars = player.getChars();
/*  29 */     this.pChar = ((PlayerChar)this.playerChars.get(0));
/*  30 */     this.TILECOLOR = tileColor;
/*  31 */     setPlayerChar(this.pChar);
/*  32 */     setRepeatTurn(false);
/*  33 */     setSkipTurn(false);
/*  34 */     setPlayer(player);
/*  35 */     setClassMod("");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  40 */     if (this.TILECOLOR == TileColor.GREEN) {
/*  41 */       this.effectIndex = rng.nextInt(10);
/*  42 */     } else if (this.TILECOLOR == TileColor.RED) {
/*  43 */       this.effectIndex = (rng.nextInt(8) + 10);
/*  44 */     } else if (this.TILECOLOR == TileColor.BLUE) {
/*  45 */       this.effectIndex = (rng.nextInt(4) + 18);
/*     */     } else {
/*  47 */       this.effectIndex = rng.nextInt(22);
/*     */     }
/*     */     
/*     */ 
/*  51 */     findEffect();
/*     */   }
/*     */   
/*     */ 
/*     */   public void findEffect()
/*     */   {
/*  57 */     if (this.effectIndex == 11) {
/*  58 */       this.y = (rng.nextInt(3) + 7);
/*  59 */       if (this.y == 7) {
/*  60 */         this.x = 15;
/*  61 */       } else if (this.y == 8) {
/*  62 */         this.x = 10;
/*     */       } else {
/*  64 */         this.x = 5;
/*     */       }
/*  66 */     } else if (this.effectIndex == 12) {
/*  67 */       this.y = rng.nextInt(7);
/*     */     } else {
/*  69 */       this.x = (rng.nextInt(20) + 1);
/*     */     }
/*     */     
/*  72 */     String[] effects = {
/*  73 */       "Gain " + this.x * 3 + " shekels", 
/*  74 */       "Gain " + this.x * 3 + " prestige", 
/*  75 */       "You found bandages for your wounds. Gain " + this.x + " wellness", 
/*  76 */       "Take another turn.", 
/*  77 */       "You got treatment for your disease. Gain " + this.x * 2 + " wellness.", 
/*  78 */       "You got married.", 
/*  79 */       "You had a baby girl.", 
/*  80 */       "You have a baby boy.", 
/*  81 */       "Gain " + this.x * 3 + " shekels", 
/*  82 */       "Gain " + this.x * 3 + " prestige", 
/*  83 */       "You got in a bar fight and lost. Lose " + this.x + " wellness and " + this.x * 2 + " prestige.", 
/*  84 */       "You " + this.yValues[this.y] + " Lose " + this.x + " wellness.", 
/*  85 */       "Oops! You have contracted " + this.yValues[this.y], 
/*  86 */       "Your spouse is declared a witch and is burned at the stake. Lose your spouse.", 
/*  87 */       "You forgot one of your children at the last town. Lose a child.", 
/*  88 */       "Uh oh, you got tarred and feathered. Lose your next turn.", 
/*  89 */       "You were mugged. Lose " + this.x * 2 + " shekels.", 
/*  90 */       "You did something naughty. Lose " + this.x * 2 + " prestige.", 
/*  91 */       "You had too much fun at the local tavern and have ended up with a child. Lose " + this.x * 3 + " prestige, but gain a child.", 
/*  92 */       "You sell your son off for work. Lose a son, but gain " + this.x * 3 + " shekels.", 
/*  93 */       "You sell your daugther off for marriage. Lose a daughter, but gain " + this.x * 3 + " prestige and shekels.", 
/*  94 */       "You got in a bar fight and won! Lose " + this.x + " wellness, but gain " + this.x * 3 + " prestige." };
/*     */     
/*  96 */     this.effectString = effects[this.effectIndex];
/*  97 */     setEffectString(this.effectString);
/*  98 */     applyEffect(this.pChar, this.effectIndex);
/*     */   }
/*     */   
/*     */   private void editShekels(PlayerChar pChar, boolean gain, int x)
/*     */   {
/* 103 */     int shekels = pChar.getShekels();
/* 104 */     CharClass classType = pChar.getCharClass();
/*     */     
/* 106 */     if ((classType.equals(CharClass.MERCHANT)) || (classType.equals(CharClass.DUKE))) {
/* 107 */       if (gain) {
/* 108 */         x *= 2;
/* 109 */         setClassMod("Because of your class, you gain twice as many shekels.");
/*     */       } else {
/* 111 */         x /= 2;
/* 112 */         setClassMod("Because of your class, you lose half as many shekels.");
/*     */       }
/*     */     }
/* 115 */     if (!gain) {
/* 116 */       x *= -1;
/*     */     }
/*     */     
/* 119 */     pChar.setShekels(shekels + x);
/*     */   }
/*     */   
/*     */   private void editPrestige(PlayerChar pChar, boolean gain, int x) {
/* 123 */     int prestige = pChar.getPrestige();
/* 124 */     CharClass classType = pChar.getCharClass();
/*     */     
/* 126 */     if ((classType.equals(CharClass.DUKE)) || (classType.equals(CharClass.PRIEST))) {
/* 127 */       if (gain) {
/* 128 */         x *= 2;
/* 129 */         setClassMod("Because of your class, you gain twice as much prestige.");
/*     */       } else {
/* 131 */         x /= 2;
/* 132 */         setClassMod("Because of your class, you lose half as much prestige.");
/*     */       }
/*     */     }
/* 135 */     if (!gain) {
/* 136 */       x *= -1;
/*     */     }
/*     */     
/* 139 */     pChar.setPrestige(prestige + x);
/*     */   }
/*     */   
/*     */   private void editWellness(PlayerChar pChar, boolean gain, int x) {
/* 143 */     int wellness = pChar.getWellness();
/* 144 */     CharClass classType = pChar.getCharClass();
/*     */     
/* 146 */     if ((classType.equals(CharClass.PRIEST)) && 
/* 147 */       (gain)) {
/* 148 */       x *= 2;
/* 149 */       setClassMod("Because of your class, you gain twice as much wellness.");
/*     */     }
/*     */     
/* 152 */     if ((classType.equals(CharClass.KNIGHT)) && 
/* 153 */       (!gain)) {
/* 154 */       x /= 2;
/* 155 */       setClassMod("Because of your class, you lose half as much wellness.");
/*     */     }
/*     */     
/* 158 */     if (!gain) {
/* 159 */       x *= -1;
/*     */     }
/*     */     
/* 162 */     pChar.setWellness(wellness + x);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void applyEffect(PlayerChar pChar, int effectIndex)
/*     */   {
/* 171 */     switch (effectIndex) {
/*     */     case 0: 
/* 173 */       editShekels(pChar, true, this.x * 3);
/* 174 */       break;
/*     */     case 1: 
/* 176 */       editPrestige(pChar, true, this.x * 3);
/* 177 */       break;
/*     */     case 2: 
/* 179 */       editWellness(pChar, true, this.x);
/* 180 */       break;
/*     */     case 3: 
/* 182 */       setRepeatTurn(true);
/* 183 */       break;
/*     */     case 4: 
/* 185 */       editWellness(pChar, true, this.x * 2);
/* 186 */       break;
/*     */     case 5: 
/* 188 */       boolean has = checkFamily("spouse");
/* 189 */       if ((!has) && (pChar.getCharClass() != CharClass.PRIEST)) {
/* 190 */         addFamily("spouse");
/*     */       } else {
/* 192 */         setClassMod("Your card had no effect.");
/*     */       }
/* 194 */       break;
/*     */     case 6: 
/* 196 */       if (pChar.getCharClass() != CharClass.PRIEST) {
/* 197 */         addFamily("daughter");
/*     */       }
/* 199 */       break;
/*     */     case 7: 
/* 201 */       if (pChar.getCharClass() != CharClass.PRIEST) {
/* 202 */         addFamily("son");
/*     */       }
/* 204 */       break;
/*     */     case 8: 
/* 206 */       editShekels(pChar, true, this.x * 3);
/* 207 */       break;
/*     */     case 9: 
/* 209 */       editPrestige(pChar, true, this.x * 3);
/* 210 */       break;
/*     */     case 10: 
/* 212 */       if (pChar.getCharClass() == CharClass.KNIGHT) {
/* 213 */         setEffectString("You got in a bar fight, and it was a flawless victory. Gain " + this.x * 5 + " prestige.");
/* 214 */         editPrestige(pChar, true, this.x * 5);
/*     */       } else {
/* 216 */         editPrestige(pChar, false, this.x * 2);
/* 217 */         editWellness(pChar, false, this.x);
/*     */       }
/* 219 */       break;
/*     */     case 11: 
/* 221 */       if (this.y == 7) {
/* 222 */         editWellness(pChar, false, this.x);
/* 223 */       } else if (this.y == 8) {
/* 224 */         editWellness(pChar, false, this.x);
/*     */       } else {
/* 226 */         editWellness(pChar, false, this.x);
/*     */       }
/* 228 */       break;
/*     */     case 12: 
/* 230 */       if (this.y == 0) {
/* 231 */         this.x = 5;
/* 232 */         editWellness(pChar, false, 5);
/* 233 */       } else if (this.y == 1) {
/* 234 */         this.x = 10;
/* 235 */         editWellness(pChar, false, 10);
/* 236 */       } else if (this.y == 2) {
/* 237 */         this.x = 15;
/* 238 */         editWellness(pChar, false, 15);
/* 239 */       } else if (this.y == 3) {
/* 240 */         this.x = 20;
/* 241 */         editWellness(pChar, false, 20);
/* 242 */       } else if (this.y == 4) {
/* 243 */         this.x = 30;
/* 244 */         editWellness(pChar, false, 30);
/* 245 */       } else if (this.y == 5) {
/* 246 */         this.x = 40;
/* 247 */         editWellness(pChar, false, 40);
/* 248 */       } else if (this.y == 6) {
/* 249 */         this.x = 50;
/* 250 */         editWellness(pChar, false, 50);
/*     */       }
/* 252 */       break;
/*     */     case 13: 
/* 254 */       boolean has = checkFamily("spouse");
/* 255 */       if (has) {
/* 256 */         removeFamily("spouse");
/*     */       } else {
/* 258 */         setClassMod("Your card had no effect.");
/*     */       }
/* 260 */       break;
/*     */     case 14: 
/* 262 */       boolean has = checkFamily("son");
/* 263 */       if (has) {
/* 264 */         removeFamily("son");
/*     */       } else {
/* 266 */         has = checkFamily("daughter");
/* 267 */         if (has) {
/* 268 */           removeFamily("daughter");
/*     */         } else {
/* 270 */           setClassMod("Your card had no effect.");
/*     */         }
/*     */       }
/* 273 */       break;
/*     */     case 15: 
/* 275 */       setSkipTurn(true);
/* 276 */       break;
/*     */     case 16: 
/* 278 */       editShekels(pChar, false, this.x * 2);
/* 279 */       break;
/*     */     case 17: 
/* 281 */       editPrestige(pChar, false, this.x * 2);
/* 282 */       break;
/*     */     case 18: 
/* 284 */       if (pChar.getCharClass() != CharClass.PRIEST) {
/* 285 */         int familyNum = rng.nextInt(2);
/* 286 */         String role; String role; if (familyNum == 0) {
/* 287 */           role = "son";
/*     */         } else {
/* 289 */           role = "daughter";
/*     */         }
/* 291 */         addFamily(role);
/* 292 */         editPrestige(pChar, false, this.x * 3);
/*     */       } else {
/* 294 */         setClassMod("Your card had no effect.");
/*     */       }
/* 296 */       break;
/*     */     case 19: 
/* 298 */       boolean has = checkFamily("son");
/* 299 */       if (has) {
/* 300 */         removeFamily("son");
/* 301 */         editShekels(pChar, true, this.x * 3);
/*     */       } else {
/* 303 */         setClassMod("Your card had no effect.");
/*     */       }
/* 305 */       break;
/*     */     case 20: 
/* 307 */       boolean has = checkFamily("daughter");
/* 308 */       if (has) {
/* 309 */         removeFamily("daughter");
/* 310 */         editShekels(pChar, true, this.x * 3);
/* 311 */         editPrestige(pChar, true, this.x * 3);
/*     */       } else {
/* 313 */         setClassMod("Your card had no effect.");
/*     */       }
/* 315 */       break;
/*     */     case 21: 
/* 317 */       if (pChar.getCharClass() == CharClass.KNIGHT) {
/* 318 */         setEffectString("You got in a bar fight, and it was a flawless victory. Gain " + this.x * 5 + " prestige.");
/* 319 */         editPrestige(pChar, true, this.x * 5);
/*     */       } else {
/* 321 */         editWellness(pChar, false, this.x);
/* 322 */         editPrestige(pChar, true, this.x * 3);
/*     */       }
/*     */       break;
/*     */     }
/*     */   }
/*     */   
/*     */   public void addFamily(String role) {
/* 329 */     boolean gender = false;
/*     */     
/*     */ 
/* 332 */     if (role.equals("son")) {
/* 333 */       gender = true;
/* 334 */     } else if (role.equals("daughter")) {
/* 335 */       gender = false;
/*     */     } else {
/* 337 */       int genderNum = rng.nextInt(2);
/* 338 */       if (genderNum == 0) {
/* 339 */         gender = true;
/*     */       }
/*     */     }
/* 342 */     PlayerChar newChar = new PlayerChar(gender, role);
/* 343 */     this.playerChars.add(newChar);
/* 344 */     this.player.setChars(this.playerChars);
/*     */   }
/*     */   
/*     */   public void removeFamily(String role) {
/* 348 */     for (int i = 0; i < this.playerChars.size(); i++) {
/* 349 */       if (((PlayerChar)this.playerChars.get(i)).getRole().equals(role)) {
/* 350 */         this.playerChars.remove(i);
/* 351 */         this.player.setChars(this.playerChars);
/* 352 */         i = this.playerChars.size();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean checkFamily(String role) {
/* 358 */     boolean has = false;
/* 359 */     String charRole = null;
/*     */     
/* 361 */     for (int i = 0; i < this.playerChars.size(); i++) {
/* 362 */       charRole = ((PlayerChar)this.playerChars.get(i)).getRole();
/* 363 */       if (charRole.equals(role)) {
/* 364 */         has = true;
/* 365 */         i = this.playerChars.size();
/*     */       }
/*     */     }
/*     */     
/* 369 */     return has;
/*     */   }
/*     */   
/*     */   public String getEffectString() {
/* 373 */     return this.effectString;
/*     */   }
/*     */   
/*     */   public void setEffectString(String effectString) {
/* 377 */     this.effectString = effectString;
/*     */   }
/*     */   
/*     */   public int getEffectNum() {
/* 381 */     return this.effectIndex;
/*     */   }
/*     */   
/*     */   public void setEffectNum(int effectNum) {
/* 385 */     if ((effectNum < 0) || (effectNum > 21)) {
/* 386 */       throw new IllegalArgumentException("The value of effectNum must be between 0 and 19.");
/*     */     }
/* 388 */     this.effectIndex = effectNum;
/*     */   }
/*     */   
/*     */   public PlayerChar getPlayerChar() {
/* 392 */     return this.pChar;
/*     */   }
/*     */   
/*     */   public void setPlayerChar(PlayerChar pChar) {
/* 396 */     this.pChar = pChar;
/*     */   }
/*     */   
/*     */   public Player getPlayer() {
/* 400 */     return this.player;
/*     */   }
/*     */   
/*     */   public void setPlayer(Player player) {
/* 404 */     this.player = player;
/*     */   }
/*     */   
/*     */   public boolean repeatTurn() {
/* 408 */     return this.repeatTurn;
/*     */   }
/*     */   
/*     */   public void setRepeatTurn(boolean repeatTurn) {
/* 412 */     this.repeatTurn = repeatTurn;
/*     */   }
/*     */   
/*     */   public boolean skipTurn() {
/* 416 */     return this.skipTurn;
/*     */   }
/*     */   
/*     */   public void setSkipTurn(boolean skipTurn) {
/* 420 */     this.skipTurn = skipTurn;
/*     */   }
/*     */   
/*     */   public String getClassMod() {
/* 424 */     return this.classMod;
/*     */   }
/*     */   
/*     */   public void setClassMod(String classMod) {
/* 428 */     this.classMod = classMod;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 433 */     StringBuilder builder = new StringBuilder();
/* 434 */     builder.append(this.player.NAME).append(" draws a card.\n").append(getEffectString())
/* 435 */       .append("\n").append(getClassMod());
/* 436 */     return builder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\arbymont\Desktop\troddenpath.jar!\models\ChanceCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
package cl.makinolas.atk.utils;

import cl.makinolas.atk.actors.friend.Enemies;

public class Formulas {
  
  // Experience gain formula
  public static double gainExp(int trainerPokemonLevel, int wildPokemonLevel, Enemies enemyType){
    double L = wildPokemonLevel;
    double Lp = trainerPokemonLevel;
    double b = enemyType.baseExperience;
    return (b * (L / 5) * Math.pow(2*L + 10, 2.5) / Math.pow(L + Lp + 10, 2.5)) + 1;
  }
  
  // for medium slow pokemon exp gain.
  public static double nextExpLevel(int level){
    return 6/5*Math.pow(level, 3) - 15*Math.pow(level, 2) + 100*level - 140;
  }
  
  // damage formula
  public static int getDamage(int attack1, int level1, int defense2, int level2, int attackBaseDamage){
    double attack = getOtherStat(attack1, level1);
    double defense = getOtherStat(defense2, level2);
    
    double randomMultiplier = Math.random()* 0.15 + 0.85;
    double criticalRandomizer = Math.random();
    double critical = 1;
    
    if( criticalRandomizer < 1/16){
      critical = 1.5;
    }
    //System.out.println("Attack pokemon: " + attack);
    //System.out.println("Defense pokemon: " + defense);
    double modifier = critical * randomMultiplier * 2;
    return (int) ((((2 * (double) level1) + 10) / 250) * (attack/defense) * attackBaseDamage * modifier) + 1;
  }
  
  // stats formula
  public static int getOtherStat(int baseStat, int level){
    return (((2 * baseStat) * level) / 100) + 5;    
  }
  
  // hp formula
  public static int getHpStat(int baseStat, int level){
    return (((2 * baseStat) * level) / 100) + level + 10;    
  }


  public static boolean checkCatch(float ballFactor, float enemyCatchRatio, int currentHP, int maxHP) {
    float bernulli = (3*maxHP - 2*currentHP) * ballFactor * enemyCatchRatio / (3*maxHP);
    return Math.random()<=bernulli;
  }

  public static int getMoney(int level, int experience) {
    float r = (float) Math.random();
    return (int) ((0.3f + 0.7f*r)*level*experience/20f);
  }
}

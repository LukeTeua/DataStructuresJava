/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment_2;

/**
 *
 * @author pycun
 */
public class GameData {
    //flags
    boolean loginFlag = false;
    boolean savedFlag = true;
   public GameDatabase db;

public GameData(){
 GameDatabase db = new GameDatabase();    
  db.dbsetup();

}
    
    int multiPoints = 0;
    int statPoints = 0;
    
    Player player = new Player();
    int playerHp = player.getHp();
    int playerDmg = player.getDmg();
    int playerLuck = player.getLuck();
    
    Monster monster = new Monster();
    int monsterHp = monster.getHp();
    int monsterDmg = monster.getDmg();
    int monsterLuck = monster.getLuck();
    
    //base stats
    int hpMulti = 0;
    int dmgMulti = 0;
    int luckMulti = 0;
    
    String rules = "Your aim is to kill as many monster as possible. Allocate your stats and multiplier.";
}

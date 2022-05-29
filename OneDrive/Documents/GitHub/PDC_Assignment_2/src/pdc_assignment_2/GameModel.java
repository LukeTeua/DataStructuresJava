/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment_2;

import java.util.Observable;
import java.util.Random;

/**
 *
 * @author pycun
 */
public class GameModel extends Observable{
    public GameDatabase db;
    public GameData data;
    public String username;
    public String password;
    int HpMulti;
    int DmgMulti;
    int LuckMulti;

    public GameModel(){
        this.db = new GameDatabase(); //create new instance of database
        this.db.dbsetup();
    }
    
    public void checkName(String username, String password){
        this.username = username;
        this.password = password;
        this.data = this.db.checkName(username, password);
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public boolean battle(){        
        int playerHp = data.playerHp;
        int monsterHp = data.monsterHp;

        while(true){
            monsterHp -= attack(data.playerDmg, data.playerLuck, data.luckMulti);
            if(playerHp <= 0){
                return false;
            }
            
            playerHp -= attack(data.monsterDmg, data.monsterLuck, 2);
            if(monsterHp <= 0){
                return true;
            }
        }
    }
    
    public void monsterLvlUp(){
        data.monsterDmg = data.monsterDmg * 2 ;
        data.monsterHp = data.monsterHp * 2;
        data.monsterLuck++;
    }
    
    public void monsterReset(){
        data.monsterHp = data.monster.getHp();
        data.monsterDmg = data.monster.getDmg();
        data.monsterLuck = data.monster.getLuck();
    }
    
    public void playerReset(){
        data.playerHp = data.player.getHp();
        data.playerDmg = data.player.getDmg();
        data.playerLuck = data.player.getLuck();
    }

    public int attack(int dmg, int luck, int luckMulti){
        int attack = dmg;
        Random rand = new Random();
        if(rand.nextInt(100) < 50){
            attack = attack + (luck * luckMulti);
        }
        return attack;
    }
    
    public void addMultiPoints(int points){
        data.multiPoints += points;
    }
    
    public void addHpMulti(int points){

        if(data.multiPoints >= points){
            for(int i=0; i< points; i++){
                data.hpMulti++;
            }
            data.multiPoints -= points;
        }  
        System.out.println(data.hpMulti);
    }
 
    public void addDmgMulti(int points){
        if(data.multiPoints >= points){
            for(int i=0; i<points; i++){
                data.dmgMulti++;
            }
            data.multiPoints -= points;
            System.out.println(data.dmgMulti);
        }
    }
    
    public void addLuckMulti(int points){
        if(data.multiPoints >= points){
            for(int i=0; i<points; i++){
                data.luckMulti++;
            }
            data.multiPoints -= points;
        }
    System.out.println(data.luckMulti);
    }
    
    public void addStatPoints(int points){
        for(int i = 0; i<points; i++){
            data.statPoints++;
        }
    }
    
    public void addHp(int points){
        if(data.statPoints >= points){
            data.playerHp += points * data.hpMulti;
            data.statPoints -= points;
        }
    }
    
    public void addDmg(int points){
        if(data.statPoints >= points){
            data.playerDmg += points * data.dmgMulti;
            data.statPoints -= points;
        }
    }
    
    public void addLuck(int points){
        if(data.statPoints >= points){
            data.playerLuck += points * data.luckMulti;
            data.statPoints -= points;
        } 
    }

  public int getHpMulti(){
        return data.hpMulti;
    }
    
    public int getDmgMulti(){
        return data.dmgMulti;
    }
    
    public int getLuckMulti(){
        return data.luckMulti;
    }
    
    public String getRules(){
        return data.rules;
    }
//returns stat
    public void save(){
        
        db.saveDB(data.hpMulti, data.dmgMulti, data.luckMulti, this.username);
        this.notifyObservers(this.data);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment_2;

/**
 *
 * @author pycun
 */
public class Monster extends Character {
    
    public Monster(){
        super();
    }
    public int getHp(){
        return Hp;
    }
    
    public int getDmg(){
        return (Dmg - 1);
    }
    
    public int getLuck(){
        return Luck;
    }
    
}

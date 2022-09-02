/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1dsa;

import java.util.Random;

/**
 *
 * @author lukey
 */
public class RandomCharacterGenerator {
   
    public char RandomCharGenerator(){
    Random rand = new Random();  
    // casting the integer into a char :)
    char c = (char)('a' +rand.nextInt(26));
    return c ; 
    }
    
    
}

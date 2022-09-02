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
public class CharGenerator {
   
    public String RandomCharGenerator(){
    Random rand = new Random();  
    // casting the integer into a char :)
    char a = (char)('a' +rand.nextInt(26));
    String c = String.valueOf(a);
    
    return c ; 
    }
    
    
}
        
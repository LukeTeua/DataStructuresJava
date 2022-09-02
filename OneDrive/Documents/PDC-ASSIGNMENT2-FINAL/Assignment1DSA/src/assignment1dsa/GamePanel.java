/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1dsa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
    

/**
 *
 * @author lukey
 */
public class GamePanel extends JPanel implements ActionListener{

    static final int SCREEN_WIDTH=800;
    static final int SCREEN_HEIGHT=800;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY=75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyparts = 3;
    int charX;
    int charY;
    char direction = 'R';
    boolean running = false;    
    Random random;
    Timer timer;
    
    
    GamePanel(){
        random=new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
   
    
    }
    public void StartGame(){
     spawnCharacter_X();
     spawnCharacter_Y();
     running = true;
     timer = new Timer(DELAY,this);
     timer.start();
    
    }
    
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    GamePanel panel = new GamePanel();
    for(int i = 0; i<SCREEN_HEIGHT/UNIT_SIZE;i++){
    g.drawLine(i*UNIT_SIZE,0 , i*UNIT_SIZE,SCREEN_HEIGHT);
    g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
    }
    draw(g);
    
    }
    

    public int spawnCharacter_X(){
    charX = random.nextInt((SCREEN_WIDTH/UNIT_SIZE)) *UNIT_SIZE;
    return this.charX;
    }
    public int spawnCharacter_Y(){
    charX = random.nextInt((SCREEN_WIDTH/UNIT_SIZE)) *UNIT_SIZE;
    return this.charY;
    }
    
    public void draw(Graphics g){
    g.setColor(Color.white);
    GamePanel p = new GamePanel();
    g.setFont(new Font(" Mopnospaced",30,30));
   
    CharGenerator d = new CharGenerator();
    g.drawString("S", 230, 200);
    
    }    
    
    
    public void move(){
    
    
    }
    
    public void checkCharacterEaten(){}
    
    public void checkCollisions(){
    
    }
    
    public void gameOver(){
    
    
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
    
    public class MyKeyAdapter extends KeyAdapter{
    @Override
     public void keyPressed(KeyEvent e){
     
     
     }
    
    }
    
    
    
}

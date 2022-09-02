/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1dsa;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lukey
 */
public class GameFrame extends JFrame {
    GameFrame(){

    this.add(new GamePanel());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
     this.pack();
    }
}

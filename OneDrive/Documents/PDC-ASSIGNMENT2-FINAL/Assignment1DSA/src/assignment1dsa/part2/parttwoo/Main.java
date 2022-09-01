/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1dsa.part2.parttwoo;

/**
 *
 * @author lukey
 */
import java.awt.Component;
import javax.swing.JFrame;

public class Main
{
    public static void main(final String[] args) {
        
        
        
        
        JFrame frame = new JFrame("Java Paint");
        frame.setDefaultCloseOperation(3);
        SimulatorPanel panel = new SimulatorPanel();
        frame.getContentPane().add(panel);
        frame.setSize(1350,1200);
        frame.setVisible(true);
    }
}
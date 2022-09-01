/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1dsa.part2.parttwoo;

/**
 *
 * @author lukey
 */


import java.util.logging.Level;
import java.util.logging.Logger;

public class Boat extends Thread
{
    static boolean arrived;
    int x;
    int y;
    int delay;
    boolean finished;
    boolean moving;
    String name;
    
    Island island;
    
    
    boolean sync_mode;
    int island_x;
    int island_y;
    
    public Boat( int x,  int y,  Island island) {
        this.finished = false;
        this.moving = false;
        
        this.island = island;
        this.name = "BOAT SIMULATOR";
        this.sync_mode = false;
        this.x = x;
        this.y = y;
        this.delay = Math.round((float)Math.random() * 4500.0f);
    }
    
    public void set_destination_of_Port( int x,  int y) {
        this.island_x = x;
        this.island_y = y;
    }
    
    @Override
    public void run() {
        while (this.delay > 0) {
            try {
                Thread.sleep(1L);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Boat.class.getName()).log(Level.SEVERE, null, ex);
            }
            --this.delay;
        }
        if (this.sync_mode) {
            synchronized (this.island) {
                while (this.island.docked) {
                    try {
                        Thread.sleep(8L);
                    }
                    catch (InterruptedException ex2) {
                        Logger.getLogger(Boat.class.getName()).log(Level.SEVERE, null, ex2);
                    }
                }
                this.island.docked = true;
            }
        }
        else {
            while (this.island.docked) {
                try {
                    Thread.sleep(8L);
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(Boat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.island.docked = true;
        }
        this.moving = true;
        while (this.x != this.island.x || this.y != this.island.y) {
            if (this.x < this.island.x) {
                ++this.x;
            }
            if (this.y < this.island.y) {
                ++this.y;
            }
            if (this.y > this.island.y) {
                --this.y;
            }
            try {
                Thread.sleep(1L);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Boat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Boat.arrived = true;
        this.moving = false;
        try {
            Thread.sleep(800L);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(Boat.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.island.docked = false;
        Boat.arrived = false;
        this.finished = true;
    }
    
    static {
        Boat.arrived = false;
    }
}
    

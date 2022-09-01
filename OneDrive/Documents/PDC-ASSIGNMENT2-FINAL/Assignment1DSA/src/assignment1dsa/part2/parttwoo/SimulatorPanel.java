package assignment1dsa.part2.parttwoo;

/**
 *
 * @author lukey
 */
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class SimulatorPanel extends JPanel implements KeyListener {

    int number_of_Ships;
    boolean initialize_program;
    Boat[] boats;
    Island portIsland;
    Image ship;
    Image island;
    Image boatdocked;

    public SimulatorPanel() {
        this.number_of_Ships = 20;
        this.initialize_program = false;
        
        //setting an array of ships
        this.boats = new Boat[this.number_of_Ships];
        
        
        
        
        this.addKeyListener(this);
        
        
        this.setFocusable(true);
        this.setBackground(Color.white);
        
        //set up a portisland 
        this.portIsland = new Island(1000, 800);
        
        
        
        for (int i = 0; i < this.number_of_Ships; ++i) {
            this.boats[i] = new Boat(20, i * 50, this.portIsland);
        }
        this.ship = new ImageIcon("boat.png").getImage();
        this.island = new ImageIcon("land.png").getImage();
        this.boatdocked = new ImageIcon("boat_land.png").getImage();
    }

    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Verdana", 1, 30));
        for (int i = 0; i < this.boats.length; ++i) {
            if (!this.boats[i].finished) {
                g.drawImage(this.ship, this.boats[i].x, this.boats[i].y, this);
            }
        }
        for (int i = 0; i < this.boats.length; ++i) {
            if (this.boats[i].moving) {
                for (int j = 0; j < this.boats.length; ++j) {
                    if (this.boats[j].moving && j != i && this.boats[j].x == this.boats[i].x && this.boats[j].y == this.boats[i].y) {
                        g.drawString("Ship Has Crashed",650, 50);
                    }
                }
            }
        }
        if (Boat.arrived) {
            g.drawImage(this.boatdocked, this.portIsland.x, this.portIsland.y - 26, this);
        } else {
            g.drawImage(this.island, this.portIsland.x, this.portIsland.y - 26, this);
        }
        this.repaint();
    }

    @Override
    public void keyTyped(final KeyEvent ke) {
    }

    @Override
    public void keyPressed(final KeyEvent ke) {
        if (!this.initialize_program) {
            for (int i = 0; i < this.boats.length; ++i) {
                this.boats[i].sync_mode = (ke.getKeyChar() == 's' || ke.getKeyChar() == 'S');
               
                this.boats[i].start();
            }
            this.initialize_program = true;
        }
    }

    @Override
    public void keyReleased(final KeyEvent ke) {
    }
}

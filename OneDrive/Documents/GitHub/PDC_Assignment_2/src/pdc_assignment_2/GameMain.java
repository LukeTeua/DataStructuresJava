package pdc_assignment_2;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Luke
 */
public class GameMain {

    public static void main(String[] args) {
        GameView view = new GameView();
        GameModel model = new GameModel();
        GameData data = new GameData();

        JFrame frame = new JFrame("Chop Chop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(view);
        frame.pack();
        frame.setVisible(true);
        GameController controller = new GameController(view, model, frame);
        model.addObserver(view);

    }

}

package pdc_assignment_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author pycun
 */
public class GameController implements ActionListener {
    public GameView view;
    public GameModel model;
    public GameData data;
    private JFrame frame;
    private boolean win;
    
    private int battleNum = 0;
            
    public GameController(GameView view, GameModel model, JFrame frame){
        this.view = view;
        this.model = model;
        this.frame = frame;
        
        this.view.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        Object source = e.getSource();
        
        switch (command) {
            case "Login":
                String username = this.view.userNameField.getText();
                String password = this.view.passwordField.getText();
                this.model.checkName(username, password);
                break;
                       

//fix this when get home 
           
            case "Play":
                model.monsterReset();
                model.playerReset();
                model.data.statPoints = 0;
                battleNum = 0;
                view.battleScreen();
                view.updateBattle(model.data.playerHp, model.data.playerDmg, model.data.playerLuck, model.data.monsterHp, model.data.monsterDmg, model.data.monsterLuck, battleNum);
                break;
            case "Battle":
                win = model.battle();
                if(win){
                    model.addStatPoints(3);
                    battleNum++;
                    model.monsterLvlUp();
                    view.updateBattle(model.data.playerHp, model.data.playerDmg, model.data.playerLuck, model.data.monsterHp, model.data.monsterDmg, model.data.monsterLuck, battleNum);
                }
                
                if(!win){
                    model.addMultiPoints(battleNum);
                    view.gameOverScreen();
                }
                break;
            case "To Main Menu":
                view.mainMenuScreen();
                model.save();
                break;
            case "Allocate Multiplier":
                view.multiplierPointsScreen();
                view.updateMultiPoint(model.data.multiPoints, model.data.hpMulti, model.data.dmgMulti, model.data.luckMulti);
                model.save();
                break;
            case "Stats":
                view.statPointsScreen();
                view.updateStatPoint(model.data.statPoints, model.data.playerHp, model.data.playerDmg, model.data.playerLuck);
                break;
            case "Game Rules":
                view.updateRules(model.getRules());
                view.rulesScreen();
                break;
            case "Multiplier":
                view.updateMultiplier(model.getHpMulti(), model.getDmgMulti(), model.getLuckMulti());
                
                view.multiplierScreen();
                break;
            case "Add Hp":
                try{
                    String userInput = this.view.addPointAmountField.getText();
                    this.model.addHp(Integer.parseInt(userInput));
                } catch(java.lang.NumberFormatException E){
                    System.out.println("Input a number please...");
                }
                view.updateStatPoint(model.data.statPoints, model.data.playerHp, model.data.playerDmg, model.data.playerLuck);
                break;
            case "Add Dmg":
                try{
                    String userInput = this.view.addPointAmountField.getText();
                    this.model.addDmg(Integer.parseInt(userInput));
                } catch(java.lang.NumberFormatException E){
                    System.out.println("Input a number please...");
                }
                view.updateStatPoint(model.data.statPoints, model.data.playerHp, model.data.playerDmg, model.data.playerLuck);
                break;
            case "Add Luck":
                try{
                    String userInput = this.view.addPointAmountField.getText();
                    this.model.addLuck(Integer.parseInt(userInput));
                } catch(java.lang.NumberFormatException E){
                    System.out.println("Input a number please...");
                }
                view.updateStatPoint(model.data.statPoints, model.data.playerHp, model.data.playerDmg, model.data.playerLuck);
                break;
            case "Back To Battle":
                view.battleScreen();
                view.updateBattle(model.data.playerHp, model.data.playerDmg, model.data.playerLuck, model.data.monsterHp, model.data.monsterDmg, model.data.monsterLuck, battleNum);
                break;
            case "Add Hp Multi":
                try{
                    String userInput = this.view.addMultiAmountField.getText();
                    this.model.addHpMulti(Integer.parseInt(userInput));
                } catch(java.lang.NumberFormatException E){
                    System.out.println("Input a number please...");
                }
                view.updateMultiPoint(model.data.multiPoints, model.data.hpMulti, model.data.dmgMulti, model.data.luckMulti);
                model.save();
                break;
            case "Add Dmg Multi":
                try{
                    String userInput = this.view.addMultiAmountField.getText();
                    this.model.addDmgMulti(Integer.parseInt(userInput));
                } catch(java.lang.NumberFormatException E){
                    System.out.println("Input a number please...");
                }
                view.updateMultiPoint(model.data.multiPoints, model.data.hpMulti, model.data.dmgMulti, model.data.luckMulti);
                model.save();
                break;
            case "Add Luck Multi":
                try{
                    String userInput = this.view.addMultiAmountField.getText();
                    this.model.addLuckMulti(Integer.parseInt(userInput));
                } catch(java.lang.NumberFormatException E){
                    System.out.println("Input a number please...");
                }
                view.updateMultiPoint(model.data.multiPoints, model.data.hpMulti, model.data.dmgMulti, model.data.luckMulti);
                model.save();
                break;
            case "Return to Main Menu":
                view.mainMenuScreen();
                model.save();
                break;
            default:
                break;
        }
    }
}

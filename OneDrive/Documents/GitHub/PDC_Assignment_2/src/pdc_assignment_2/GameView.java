/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment_2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pycun
 */
public class GameView extends JPanel implements Observer{
    
    //components for login screen
    public JTextField userNameField;
    public JTextField passwordField;
    private JButton loginButton;
    
    //components for game main menu
    private JButton playButton;
    private JButton gameRulesScreenButton;
    private JButton multiplierScreenButton;
    
    //components for game playing screen
    private JLabel playerBattleStatLabel;
    private JLabel monsterBattleStatLabel;
    private JLabel fightNumberLabel;
    private JButton battleButton;
    private JButton allocateStatButton;
    
    private JLabel pointsLabel;
    private JLabel playerStatLabel;
    private JButton addHpButton;
    private JButton addDmgButton;
    private JButton addLuckButton;
    public JTextField addPointAmountField;
    private JButton backToBattleButton;
    
    private JLabel multiLabel;
    private JLabel playerMultiLabel;
    private JButton addHpMultiButton;
    private JButton addDmgMultiButton;
    private JButton addLuckMultiButton;
    public JTextField addMultiAmountField;
    private JButton toMainMenuButton;
    
    private JButton toMultiMenuButton;
    
    //components for game rules screen
    private JLabel rulesDisplayLabel;
    
    //components for game multiplier screen
    private JLabel multiplierDisplayLabel;
    
    //both rules n multiplier screen have the same back button
    private JButton backButton;
    
    public GameView(){
        super(new BorderLayout());
        super.setPreferredSize(new Dimension(700,300));
        this.iniComp();
        this.loginScreen();

    }
    
    //initiate components
    public void iniComp(){
        userNameField = new JTextField(10);
        passwordField = new JTextField(10);
        loginButton = new JButton("Login");

        playButton = new JButton("Play");
        gameRulesScreenButton = new JButton("Game Rules");
        multiplierScreenButton = new JButton("Multiplier");

        playerBattleStatLabel = new JLabel("Player Hp");
        monsterBattleStatLabel = new JLabel("Monster Hp");
        fightNumberLabel = new JLabel("Fight Number");
        battleButton = new JButton("Battle");
        allocateStatButton = new JButton("Stats");

        pointsLabel = new JLabel("Skill Points");
        playerStatLabel = new JLabel("Player Stats: ");
        addHpButton = new JButton("Add Hp");
        addDmgButton = new JButton("Add Dmg");
        addLuckButton = new JButton("Add Luck");
        addPointAmountField = new JTextField(10);
        backToBattleButton = new JButton("Back To Battle");
    
        multiLabel = new JLabel("Multiplier Points");
        playerMultiLabel = new JLabel("Player Multiplier: ");
        addHpMultiButton = new JButton("Add Hp Multi");
        addDmgMultiButton = new JButton("Add Dmg Multi");
        addLuckMultiButton = new JButton("Add Luck Multi");
        addMultiAmountField = new JTextField(10);
        toMainMenuButton = new JButton("To Main Menu");
    
        toMultiMenuButton = new JButton("Allocate Multiplier");
        
        rulesDisplayLabel = new JLabel("Rules text");

        multiplierDisplayLabel = new JLabel("Multiplier");

        backButton = new JButton("Return to Main Menu");
    }
    
    //login screen
    public void loginScreen(){
        JPanel loginScreen = new JPanel();
        JPanel buttonArea = new JPanel();
        JLabel userNameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        
        loginScreen.add(userNameLabel);
        loginScreen.add(userNameField);
        loginScreen.add(passwordLabel);
        loginScreen.add(passwordField);
        buttonArea.add(loginButton);
        
        super.add(buttonArea, BorderLayout.SOUTH);
        super.add(loginScreen, BorderLayout.CENTER);
    }
    
    //main menu screen
    public void mainMenuScreen(){
        JPanel buttonArea = new JPanel();
        
        
        buttonArea.add(playButton);
        buttonArea.add(multiplierScreenButton);
        buttonArea.add(gameRulesScreenButton);
        JLabel label = new JLabel("WELCOME TO CHOP CHOP\nPlease Select one of the buttons to play");
     
        super.removeAll();
        super.add(buttonArea, BorderLayout.CENTER);
        super.revalidate();
        super.repaint();
    }
    
    //rules screen
    public void rulesScreen(){
        JPanel rulesScreenPanel = new JPanel();
        JPanel buttonArea = new JPanel();
        
        rulesScreenPanel.add(rulesDisplayLabel);
        buttonArea.add(backButton);
        
        super.removeAll();
        super.add(buttonArea, BorderLayout.SOUTH);
        super.add(rulesScreenPanel, BorderLayout.CENTER);
        super.revalidate();
        super.repaint();
    }
    
    //multiplier screen
    public void multiplierScreen(){
        JPanel multiplierScreenPanel = new JPanel();
        JPanel buttonArea = new JPanel();
        
        multiplierScreenPanel.add(multiplierDisplayLabel);
        buttonArea.add(backButton);
        
        super.removeAll();
        super.add(buttonArea, BorderLayout.SOUTH);
        super.add(multiplierScreenPanel, BorderLayout.CENTER);
        super.revalidate();
        super.repaint();
    }
    
    //stat points screen, part of game playing screen
    public void statPointsScreen(){
        JPanel playerStatPoint= new JPanel();
        JPanel statPointsAmount = new JPanel();
        JPanel buttonArea = new JPanel();
        
        JLabel amountOfPointsToAddLabel = new JLabel("Amount of Points to Add:");
        JLabel pointsAvailable = new JLabel("Amount of Points Available:");
        JLabel playerStat = new JLabel("Player Stats: ");
        
        statPointsAmount.add(pointsAvailable);
        statPointsAmount.add(pointsLabel);
        statPointsAmount.add(backToBattleButton);
        playerStatPoint.add(playerStat);
        playerStatPoint.add(playerStatLabel);
        buttonArea.add(amountOfPointsToAddLabel);
        buttonArea.add(addPointAmountField);
        buttonArea.add(addHpButton);
        buttonArea.add(addDmgButton);
        buttonArea.add(addLuckButton);
        
        super.removeAll();
        super.add(statPointsAmount, BorderLayout.NORTH);
        super.add(playerStatPoint, BorderLayout.CENTER);
        super.add(buttonArea, BorderLayout.SOUTH);
        super.revalidate();
        super.repaint();
    }
    
    //multiplier points screen, part of game playing screen
    public void multiplierPointsScreen(){
        JPanel playerMultiPoint = new JPanel();
        JPanel multiPointsAmount = new JPanel();
        JPanel buttonArea = new JPanel();
        
        JLabel amountOfPointsToAdd = new JLabel("Amount of Multiplier Points to Add:");
        JLabel pointsAvailable = new JLabel("Amount of Points Available:");
        JLabel playerMulti = new JLabel("Player Multiplier: ");
        
        multiPointsAmount.add(pointsAvailable);
        multiPointsAmount.add(multiLabel);
        multiPointsAmount.add(toMainMenuButton);
        playerMultiPoint.add(playerMulti);
        playerMultiPoint.add(playerMultiLabel);
        buttonArea.add(amountOfPointsToAdd);
        buttonArea.add(addMultiAmountField);
        buttonArea.add(addHpMultiButton);
        buttonArea.add(addDmgMultiButton);
        buttonArea.add(addLuckMultiButton);
        
        super.removeAll();
        super.add(multiPointsAmount, BorderLayout.NORTH);
        super.add(playerMultiPoint, BorderLayout.CENTER);
        super.add(buttonArea, BorderLayout.SOUTH);
        super.revalidate();
        super.repaint();
    }
    
    //battle screen, part of game playing screen
    public void battleScreen(){
        JPanel battleScreenNumber = new JPanel();
        JPanel battleScreen = new JPanel();
        JPanel buttonArea = new JPanel();
        
        JLabel playerHpBar = new JLabel("Player's Stats: ");
        JLabel monsterHpBar = new JLabel("Monster's Stats: ");
        JLabel fightNumber = new JLabel("Battle Number: ");
        
        battleScreen.add(playerHpBar);
        battleScreen.add(playerBattleStatLabel);
        battleScreen.add(monsterHpBar);
        battleScreen.add(monsterBattleStatLabel);
        battleScreenNumber.add(fightNumber);
        battleScreenNumber.add(fightNumberLabel);
        buttonArea.add(battleButton);
        buttonArea.add(allocateStatButton);
        
        super.removeAll();
        super.add(battleScreenNumber, BorderLayout.NORTH);
        super.add(battleScreen, BorderLayout.CENTER);
        super.add(buttonArea, BorderLayout.SOUTH);
        super.revalidate();
        super.repaint();
    }
    
    //game over screen
    public void gameOverScreen(){
        JPanel gameOverPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        
        JLabel gameOverMessage = new JLabel("GAME OVER, U DIED!!!");
        
        buttonPanel.add(toMultiMenuButton);
        gameOverPanel.add(gameOverMessage);
        super.removeAll();
        super.add(gameOverPanel, BorderLayout.CENTER);
        super.add(buttonPanel, BorderLayout.SOUTH);
        super.revalidate();
        super.repaint();
    }
    
    //update multiplier stats
    public void updateMultiplier(int hp, int dmg, int luck){
        multiplierDisplayLabel.setText("Current Multiplier: Hp: ["+hp+"] Dmg: ["+dmg+"] Luck: ["+luck+"]");
        super.repaint();
    }
    
    //update the rules in rules screen
    public void updateRules(String rules){
        rulesDisplayLabel.setText(rules);
        super.repaint();
    }
    
    //update stat points in stat screen
    public void updateStatPoint(int points, int hp, int dmg, int luck){
        pointsLabel.setText("["+Integer.toString(points)+"]");
        playerStatLabel.setText("Player's Hp: ["+hp+"] Player's Dmg: ["+dmg+"] Player's Luck: ["+luck+"]");
        super.repaint();
    }
    
    //update multiplier points in multiplier point screen
    public void updateMultiPoint(int points, int hp, int dmg, int luck){
        multiLabel.setText("["+Integer.toString(points)+"]");
        playerMultiLabel.setText("Player's Hp Multi: ["+hp+"] Player's Dmg Multi: ["+dmg+"] Player's Luck Multi: ["+luck+"]");
        super.repaint();
    }
    
    //update battle display
    public void updateBattle(int playerHp, int playerDmg, int playerLuck, int monsterHp, int monsterDmg, int monsterLuck, int battleNumber){
        playerBattleStatLabel.setText("Hp: ["+playerHp+"] Dmg: ["+playerDmg+"] Luck: ["+playerLuck+"]");
        monsterBattleStatLabel.setText("Hp: ["+monsterHp+"] Dmg: ["+monsterDmg+"] Luck: ["+monsterLuck+"]");
        fightNumberLabel.setText("["+battleNumber+"]");
        super.repaint();
    }
    
    //public gameover 
    
            
    public void addActionListener(ActionListener listener){
        loginButton.addActionListener(listener);
        playButton.addActionListener(listener);
        battleButton.addActionListener(listener);
        allocateStatButton.addActionListener(listener);
        gameRulesScreenButton.addActionListener(listener);
        multiplierScreenButton.addActionListener(listener);
        addHpButton.addActionListener(listener);
        addDmgButton.addActionListener(listener);
        addLuckButton.addActionListener(listener);
        backToBattleButton.addActionListener(listener);
        addHpMultiButton.addActionListener(listener);
        addDmgMultiButton.addActionListener(listener);
        addLuckMultiButton.addActionListener(listener);
        toMultiMenuButton.addActionListener(listener);
        toMainMenuButton.addActionListener(listener);
        backButton.addActionListener(listener);
    }
    
    @Override
    public void update(Observable o, Object arg){
        GameData data = (GameData) arg;
        if(!data.loginFlag){
            this.userNameField.setText("Invalid");
            this.passwordField.setText("Invalid");
        }        
    }
}

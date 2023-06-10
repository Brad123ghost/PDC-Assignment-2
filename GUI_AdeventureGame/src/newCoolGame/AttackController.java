/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Bradley
 */
public class AttackController implements ActionListener{
    GameMemory gMemory;
    GameFrame currentGFrame;
    Helper helper;
    Player player;
    Inventory inventory;
    StoryLine storyLine;
    Enemy currentEnemy;
    
    AttackPanel aPanel;
    GamePanel gPanel;
    
    public AttackController(GameFrame gFrame, AttackPanel aPanel, GamePanel gPanel) {
        this.gMemory = GameMemory.getGMemInstance();
        this.currentGFrame = gFrame;
        this.aPanel = aPanel;
        this.helper = Helper.getHelperInstance();
        this.player = Player.getPlayerInstance();
        this.inventory = Inventory.getInvInstance();
        this.storyLine = StoryLine.getStoryLineInstance();
        this.addAttackPanelListeners();
        
    }
    
    public void addAttackPanelListeners() {
        if(aPanel.getOptionOneBtn() != null) {
            aPanel.getOptionOneBtn().addActionListener(this);
        }
        if(aPanel.getOptionTwoBtn() != null) {
            aPanel.getOptionTwoBtn().addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if(this.storyLine.currentEnemy.getHealth() > 0 && (this.player.getHealth() > 0)) {
            if(e.getActionCommand().equals("Roll Dice")) {
                this.playerAttack();
            }
            if(e.getActionCommand().equals("Continue")){
                if(this.storyLine.currentEnemy.getHealth() > 0) {
                    this.enemyAttack();
                }
            }
            
        }
        if(e.getActionCommand().equals("Continue")){
            if(this.player.getHealth() > 0) {
                if(this.storyLine.currentEnemy.getHealth() == 0) {
                    this.aPanel.getStatusLabel().setText("");
                    this.aPanel.getStatus2Label().setText("");
                    String nodeName = storyLine.currentStoryNodeName;
                    StoryNode currentNode = storyLine.storyNodes.get(nodeName);
                    this.storyLine.currentStoryNodeName = currentNode.continuedNextName;
                    
                    this.currentGFrame.setMenuState(State.GAME_RESUME);
                    this.currentGFrame.checkState();
                }
            } else {
                this.aPanel.getStatusLabel().setText("You have died");
            }
            
        }
    }
    
    public void startEncounter() {
//        this.aPanel.startEncounter();
//System.out.println(storyLine);
        String nodeName = storyLine.currentStoryNodeName;
        StoryNode currentNode = storyLine.storyNodes.get(nodeName);

        storyLine.currentEnemy = currentNode.currentEnemy;
        this.aPanel.getTitle().setText("Your Turn");
        this.aPanel.playerTurn = true;
        this.aPanel.displayEncounter();
//        System.out.println("Enemy Health: " + storyLine.currentEnemy.getHealth());
//        this.currentEnemy = aPanel.enemy;
    }
    
    public void playerAttack() {
        this.aPanel.getTitle().setText("Your Turn");
        int diceRollResult = this.helper.diceRoll(7);
        double multiplier = diceRollResult * 0.1 + 1;
        
        double dmgToDeal = this.player.inventory.getCurrentWeapon().getStat() * multiplier;
//        System.out.println("Multiplier: " + multiplier);
//        System.out.println("Damage to Deal: " + dmgToDeal );
//        System.out.println("Enemy Health: " + storyLine.currentEnemy.getHealth());
       
        if(dmgToDeal > storyLine.currentEnemy.getHealth()) {
            int coins = this.storyLine.currentEnemy.getCoins();
            this.player.setCoins(this.player.getCoins()+coins);
            this.aPanel.updateStats();
            this.aPanel.getStatus2Label().setText("You killed it! You got +" + coins + " coins");
            storyLine.currentEnemy.setHealth(0);
        } else {
            storyLine.currentEnemy.setHealth(storyLine.currentEnemy.getHealth()-dmgToDeal);
        }
        this.aPanel.getStatusLabel().setText("Your damage was multiplied by x" + multiplier + " and you dealt " + dmgToDeal + " dmg");
        this.aPanel.updateStats();
        this.aPanel.playerTurn = false;
        this.aPanel.displayEncounter();
//        System.out.println("Dice roll: " + diceRollResult);
//        System.out.println("Enemy Health: " + this.currentEnemy.getHealth());    
    }
    
    public void enemyAttack() {
        this.aPanel.getTitle().setText("Enemy Turn");
        this.aPanel.update();
        int playerArmour = this.inventory.getCurrentArmour().getStat();
        double dmgMit = storyLine.currentEnemy.getAtkDamage() * playerArmour*0.01;
        double dmgToDeal = storyLine.currentEnemy.getAtkDamage() - dmgMit;
        
        if(dmgToDeal > this.player.getHealth()) {
            this.player.setHealth(0);
        } else {
            this.player.setHealth(this.player.getHealth()-dmgToDeal);
        }
        
        this.aPanel.getStatusLabel().setText("Incoming damage was mitigated by " + dmgMit +" dmg. You took " + dmgToDeal + " dmg");
        this.aPanel.updateStats();
        this.aPanel.playerTurn = true;
        this.aPanel.displayEncounter();
//        System.out.println("Player Health: " + this.player.getHealth()); 
    }
}

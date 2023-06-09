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
public class GameController implements ActionListener{
    GameMemory gMemory;
    GameFrame currentGFrame;
    StoryLine storyLine;
    Helper helper;
    Player player;
    
    GamePanel gPanel;
    
    public GameController(GameFrame gFrame, GamePanel gPanel) {
        this.gMemory = GameMemory.getGMemInstance();
        this.currentGFrame = gFrame;
        this.gPanel = gPanel;
        storyLine = StoryLine.getStoryLineInstance();
        helper = Helper.getHelperInstance();
        player = Player.getPlayerInstance();
        
    }
    
    public void addGamePanelListeners() {
        if(gPanel.getOptionOneBtn() != null) {
            gPanel.getOptionOneBtn().addActionListener(this);
        }
        if(gPanel.getOptionTwoBtn() != null) {
            gPanel.getOptionTwoBtn().addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println(e.getSource());
//        System.out.println(e.getID());
        StoryNode currentNode = storyLine.storyNodes.get(storyLine.currentStoryNode);
//        System.out.println(e.getActionCommand());
//        System.out.println(e.toString());
        if(e.getActionCommand().equals("Fight It")) {
            storyLine.currentStoryNode = currentNode.leftNodeName;
            String nodeName = storyLine.currentStoryNode;
            currentNode = storyLine.storyNodes.get(nodeName);
            
            currentGFrame.setMenuState(State.ATTACK);
            currentGFrame.checkState();
            
        } else if(e.getActionCommand().equals("Flip Coin")) {
            String nodeName = storyLine.currentStoryNode;
            currentNode = storyLine.storyNodes.get(nodeName);
            System.out.println(e.getActionCommand());
            this.riverCoinFlip();

            this.gPanel.getOptionTwoBtn().setText("Continue");

            
        }
        else if(e.getActionCommand().equals("Continue") && !currentNode.continuedNextName.equals("")) {
            String nodeName = storyLine.currentStoryNode;
            currentNode = storyLine.storyNodes.get(nodeName);
            gPanel.clear();
            this.gPanel.displayCurrentStory(currentNode.continuedNextName);
        }
        else {
            
//            StoryNode currentNode = storyLine.storyNodes.get(storyLine.currentStoryNode);
            String leftChoice = currentNode.leftNodeName;
            String rightChoice = currentNode.rightNodeName;
//            System.out.println(storyLine.currentStoryNode);
            gPanel.clear();
            if(e.getActionCommand().equals(currentNode.leftChoiceText)) {
                gPanel.displayCurrentStory(leftChoice);
            } else if(e.getActionCommand().equals(currentNode.rightChoiceText)) {
                gPanel.displayCurrentStory(rightChoice);
            }
        }

    }
    
    public void riverCoinFlip() {
        int diceRollResult = this.helper.diceRoll(2) + 1;
        if(diceRollResult == 1) {
            gPanel.getStatus().setText("Heads! You regain your balance, and carefully continue.");
        } else if(diceRollResult == 2) {
            gPanel.getStatus().setText("Tails! You try to regain your balance but, slip and lost 5hp");
            this.player.setHealth(this.player.getHealth()-5);
            this.gPanel.updateStats();
        }
        
        
    }
    
//    public void playerAttack() {
//        String line1 = "Your Turn";
//        String line2 = "Roll a dice to increase base"
//    }
    
    public void enemyAttack() {
        
    }
}

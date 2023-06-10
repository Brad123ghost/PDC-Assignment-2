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
    
    public void eventHandlePause() {
        currentGFrame.setMenuState(State.PAUSE_GAME);
        currentGFrame.checkState();
    }
    
    public void addGamePanelListeners() {
        gPanel.getPauseScreenBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandlePause();
            }
        });
        if(gPanel.getOptionOneBtn() != null) {
            gPanel.getOptionOneBtn().addActionListener(this);
        }
        if(gPanel.getOptionTwoBtn() != null) {
            gPanel.getOptionTwoBtn().addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StoryNode currentNode = storyLine.storyNodes.get(storyLine.currentStoryNodeName);
        if(e.getActionCommand().equals("Save & Quit")) {
            gMemory.slManager.savePlayerData();
            currentGFrame.setMenuState(State.EXIT_GAME);
            currentGFrame.checkState();
        } else if(e.getActionCommand().equals("Fight It") || e.getActionCommand().equals("Attack It")) {
            if(!currentNode.leftNodeName.equals("")) {
                storyLine.currentStoryNodeName = currentNode.leftNodeName;
                String nodeName = storyLine.currentStoryNodeName;
                currentNode = storyLine.storyNodes.get(nodeName);
                
            } else {
                storyLine.currentStoryNodeName = currentNode.rightNodeName;
                String nodeName = storyLine.currentStoryNodeName;
                currentNode = storyLine.storyNodes.get(nodeName);
            }
            
            currentGFrame.setMenuState(State.ATTACK);
            currentGFrame.checkState();
            
        } else if(e.getActionCommand().equals("Flip Coin")) {
            String nodeName = storyLine.currentStoryNodeName;
            currentNode = storyLine.storyNodes.get(nodeName);
            System.out.println(e.getActionCommand());
            this.riverCoinFlip();

            this.gPanel.getOptionTwoBtn().setText("Continue");  
        }
        else if(e.getActionCommand().equals("Continue") && !currentNode.continuedNextName.equals("")) {
            String nodeName = storyLine.currentStoryNodeName;
            currentNode = storyLine.storyNodes.get(nodeName);
            gPanel.clear();
            this.gPanel.displayCurrentStory(currentNode.continuedNextName);
        } else if(e.getActionCommand().equals("Shop")) {
            System.out.println("SHOP OPENED");
            currentGFrame.setMenuState(State.SHOP);
            currentGFrame.checkState();
        }
        else {
            String leftChoice = currentNode.leftNodeName;
            String rightChoice = currentNode.rightNodeName;
            gPanel.clear();
            if(currentNode.leftNodeName == "forestCoins" || currentNode.rightNodeName == "forestCoins") {
                this.foundCoins(4);
            } else if(currentNode.leftNodeName == "pathCoins" && e.getActionCommand().equals("Check it Out")) {
                this.foundCoins(10);
            }
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
    
    public void foundCoins(int coins) {
        gPanel.getStatus().setText("You got +" + coins + " coins");
        this.player.setCoins(this.player.getCoins() + coins);
        this.gPanel.updateStats();
    }
    
    
    public void enemyAttack() {
        
    }
}

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
    
    GamePanel gPanel;
    
    public GameController(GameFrame gFrame, GamePanel gPanel) {
        this.gMemory = GameMemory.getGMemInstance();
        this.currentGFrame = gFrame;
        this.gPanel = gPanel;
        storyLine = StoryLine.getStoryLineInstance();
        
        
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
//        System.out.println(e.getActionCommand());
//        System.out.println(e.toString());
        StoryNode currentNode = storyLine.storyNodes.get(storyLine.currentStory);
        String leftChoice = currentNode.optionOne;
        String rightChoice = currentNode.optionTwo;
        System.out.println(storyLine.currentStory);
        gPanel.clear();
        if(e.getActionCommand().equals(currentNode.oneNextChoice)) {
            gPanel.displayCurrentStory(leftChoice);
        } else if(e.getActionCommand().equals(currentNode.twoNextChoice)) {
            gPanel.displayCurrentStory(rightChoice);
        }

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import java.util.ArrayList;

/**
 *
 * @author Bradley
 */
public class StoryNode {
    String name;
    ArrayList<String> text;
    String leftNodeName;
    String rightNodeName;
    String continuedNextName;
    String leftChoiceText;
    String rightChoiceText;
    Enemy currentEnemy;
    
    public StoryNode(String name, ArrayList<String> text, String optionOne, String optionTwo, String continuedNextName, String oneNextChoice, String twoNextChoice) {
        this.name = name;
        this.text = text;
        this.leftNodeName = optionOne;
        this.rightNodeName = optionTwo;
        this.continuedNextName = continuedNextName;
        this.leftChoiceText = oneNextChoice;
        this.rightChoiceText = twoNextChoice;
    }
    
}

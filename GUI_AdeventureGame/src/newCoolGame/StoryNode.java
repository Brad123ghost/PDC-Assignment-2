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
    String optionOne;
    String optionTwo;
    String oneNextChoice;
    String twoNextChoice;
    
    public StoryNode(String name, ArrayList<String> text, String optionOne, String optionTwo, String oneNextChoice, String twoNextChoice) {
        this.name = name;
        this.text = text;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.oneNextChoice = oneNextChoice;
        this.twoNextChoice = twoNextChoice;
    }
}

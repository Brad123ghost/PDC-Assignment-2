/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

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
    
    public StoryNode(String name, ArrayList<String> text, String optionOne, String optionTwo) {
        this.name = name;
        this.text = text;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
    }
}

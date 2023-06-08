/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Bradley
 */
public class StoryLine {
    HashMap<String, StoryNode> storyNodes;
    ArrayList<String> text;
    String currentStory;
    private StoryLine(){};
    public static StoryLine storyLineInstance;
    
    public static synchronized StoryLine getStoryLineInstance() {
        if(storyLineInstance == null) {
            storyLineInstance = new StoryLine();
            storyLineInstance.storyNodes = new HashMap<>();
            storyLineInstance.createBeachStart();
        }
        
        return storyLineInstance;
    }
  
    
    public void createBeachStart() {
        text = new ArrayList<>();
        String line1 = "You wake up on a beach, you find a forest on your left and the ocean is to your right.\n";
        String line2 = "You begin to look around, but you find that no one is around. You decide to grab the\n";
        String line3 = "stick beside you to use as a weapon and piece together some cloth for clothing.";
        text.add(line1);
        text.add(line2);
        text.add(line3);
        String nodeName = "beachStart";
        
        StoryNode newNode = new StoryNode(nodeName, text, "", "beachExplore", "", "Continue");
        
        storyNodes.put(nodeName, newNode);
        this.createBeachExplore();
    }
    
    public void createBeachExplore() {
        text = new ArrayList<>();
        String line1 = "You start wandering around trying to locate where you are,\n";
        String line2 = "out of nowhere a Sand Crab appears.";
        text.add(line1);
        text.add(line2);
        String nodeName = "beachExplore";
        
        StoryNode newNode = new StoryNode(nodeName, text, "beachEncounter", "beachRun", "Fight It", "Run Away");
        
        storyNodes.put(nodeName, newNode);
    }
}

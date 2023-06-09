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
     String currentStoryNode;
     Enemy currentEnemy;
     GameMemory gMem;
    private StoryLine(){};
    public static StoryLine storyLineInstance;
    
    public static synchronized StoryLine getStoryLineInstance() {
        if(storyLineInstance == null) {
            storyLineInstance = new StoryLine();
            storyLineInstance.storyNodes = new HashMap<>();
            storyLineInstance.setUpStoryNodes();
        }
        
        return storyLineInstance;
    }
  
    public void setUpStoryNodes() {
        storyLineInstance.gMem = GameMemory.getGMemInstance();

        this.createBeachStart();
        this.createBeachExplore();
        this.createBeachEncounter();
        this.createBeachRun();
        this.createForestStart();
        this.createForestExplore();
        this.createForestRiverCross();
        this.createForestRiverAnotherWay();
        this.createForestRustling();
        
        
        this.createForestRiverCrossed();
    }
    
    public void setNodeEnemy(String name, StoryNode node) {
        node.currentEnemy = gMem.getEnemy(name);
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
        String leftNodeName = "";
        String rightNodeName = "beachExplore";
        String continuedNextName = "";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);
        storyNodes.put(nodeName, newNode);
    }
    
    public void createBeachExplore() {
        text = new ArrayList<>();
        String line1 = "You start wandering around trying to locate where you are,\n";
        String line2 = "out of nowhere a Sand Crab appears.";
        text.add(line1);
        text.add(line2);
        
        String nodeName = "beachExplore";
        String leftNodeName = "beachEncounter";
        String rightNodeName = "beachRun";
        String continuedNextName = "";
        String leftChoiceText = "Fight It";
        String rightChoiceText = "Run Away";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);
        storyNodes.put(nodeName, newNode);
    }
    
    public void createBeachEncounter() {
        text = new ArrayList<>();
        String line1 = "You Decided to fight the Sand Crab";
        text.add(line1);
        
        String nodeName = "beachEncounter";
        String leftNodeName = "";
        String rightNodeName = "fight";
        String continuedNextName = "forestStart";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);
        this.setNodeEnemy("Sand Crab", newNode);
        storyNodes.put(nodeName, newNode);
    }
    
    public void createBeachRun() {
        text = new ArrayList<>();
        String line1 = "You quickly run into the forest inorder to avoid the Sand Crab";
        text.add(line1);
        
        String nodeName = "beachRun";
        String leftNodeName = "";
        String rightNodeName = "forestStart";
        String continuedNextName = "";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);
        storyNodes.put(nodeName, newNode);
    }
    
    public void createForestStart() {
        text = new ArrayList<>();
        String line1 = "You are starting to get worried you'll be lost forever.\n";
        String line2 = "In a desperate attempt to find civilization, you start walking into the forest.";
        text.add(line1);
        text.add(line2);
        
        String nodeName = "forestStart";
        String leftNodeName = "";
        String rightNodeName = "forestExplore";
        String continuedNextName = "";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);
        storyNodes.put(nodeName, newNode);
    }
    
    public void createForestExplore() {
        text = new ArrayList<>();
        String line1 = "After walking for some time you reach a river, the water is running downstream";
        String line2 = "at a slow steady pace. As you scan up and down river, you realize that the river";
        String line3 = "runs for awhile however, you notice that there is a log which looks quite";
        String line4 = "slippery but, bridges across the river.";
        text.add(line1);
        text.add(line2);
        text.add(line3);
        text.add(line4);
        
        String nodeName = "forestExplore";
        String leftNodeName = "forestRiverCross";
        String rightNodeName = "forestRiverAnotherWay";
        String continuedNextName = "";
        String leftChoiceText = "Cross the log";
        String rightChoiceText = "Find another way";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);
        storyNodes.put(nodeName, newNode);
    }
    
    public void createForestRiverCross() {
        text = new ArrayList<>();
        String line1 = "You quickly make your way towards the log.\n";
        String line2 = "As you do cross you feel like you are going loose your balance and silp.";
        String line3 = "Flip a coin: Heads - Safely Cross, Tails - Slip";
        text.add(line1);
        text.add(line2);
        text.add(line3);
        
        String nodeName = "forestRiverCross";
        String leftNodeName = "";
        String rightNodeName = "forestRiverCrossed";
        String continuedNextName = "forestRiverCrossed";
        String leftChoiceText = "";
        String rightChoiceText = "Flip Coin";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);
        storyNodes.put(nodeName, newNode);
    }
    
    public void createForestRiverAnotherWay() {
        text = new ArrayList<>();
        String line1 = "You decided that the log was too slippery and instead decided to walk";
        String line2 = "along the riverside to find another way.";
        text.add(line1);
        text.add(line2);
        
        String nodeName = "forestRiverAnotherWay";
        String leftNodeName = "";
        String rightNodeName = "forestRustling";
        String continuedNextName = "";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);
        storyNodes.put(nodeName, newNode);
    }
    
     public void createForestRustling() {
        text = new ArrayList<>();
        String line1 = "While walking along the river, you hear some rustling in the distance.\n";
        String line2 = "Could it be another person?\n";
        String line3 = "Will you let your curiosity win?";
        text.add(line1);
        text.add(line2);
        text.add(line3);
        
        String nodeName = "forestRustling";
        String leftNodeName = "forestRustlingInvestigate";
        String rightNodeName = "forestRustlingIgnore";
        String continuedNextName = "";
        String leftChoiceText = "Investigate";
        String rightChoiceText = "Ignore";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);
        storyNodes.put(nodeName, newNode);
    }
    
    public void createForestRiverCrossed() {
        text = new ArrayList<>();
        String line1 = "You have just crossed the river and see a path.";
        String line2 = "As you make your way towards the path a strong Skeleton stops you";
        String line3 = "in your tracks, you have no option but to fight your way through.";
        text.add(line1);
        text.add(line2);
        text.add(line3);
        
        String nodeName = "forestRiverCrossed";
        String leftNodeName = "pathEncounterOne";
        String rightNodeName = "";
        String continuedNextName = "";
        String leftChoiceText = "Fight It";
        String rightChoiceText = "";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);
        this.setNodeEnemy("Skeleton", newNode);
        storyNodes.put(nodeName, newNode);
    }
   // ADD RIVERCROSSED
}

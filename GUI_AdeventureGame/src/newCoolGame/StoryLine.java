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
        this.createForestRustlingInvestigate();
        this.createForestEncounter();
        this.createForestSneakAway();
        this.createForestRustlingIgnore();
        this.createForestCoins();
        this.createForestBridge();
        this.createForestRiverCrossed();
        this.createPathEncounterOne();
        this.createPathContinue();
        this.createPathGlimmer();
        this.createPathCoins();
        this.createPathEncounterTwo();
        this.createTownStart();
        this.createTownContinue();
        this.createTownLeave();
        this.createActOneEnd();
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
    
    public void createForestRustlingInvestigate() {
        text = new ArrayList<>();
        String line1 = "You let curiosity get the best of you and you quitely walk over to investigate.\n";
        String line2 = "You reach the bush where the sound is comming from and decide to peek over.\n";
        String line3 = "It is not human, infact it's a Zombie";
        text.add(line1);
        text.add(line2);
        text.add(line3);
        
        String nodeName = "forestRustlingInvestigate";
        String leftNodeName = "forestEncounter";
        String rightNodeName = "forestSneakAway";
        String continuedNextName = "";
        String leftChoiceText = "Attack It";
        String rightChoiceText = "Sneak Away";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);
        
        storyNodes.put(nodeName, newNode);
    }
    
    public void createForestEncounter() {
        text = new ArrayList<>();
        String line1 = "You Decided to attack the Zombie";
        text.add(line1);
        
        String nodeName = "forestEncounter";
        String leftNodeName = "";
        String rightNodeName = "fight";
        String continuedNextName = "forestBridge";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);
        this.setNodeEnemy("Zombie", newNode);
        storyNodes.put(nodeName, newNode);
    }
    
    public void createForestSneakAway() {
        text = new ArrayList<>();
        String line1 = "You let curiosity get the better of you but in the end you snuck away";
        text.add(line1);
        
        String nodeName = "forestSneakAway";
        String leftNodeName = "";
        String rightNodeName = "forestCoins";
        String continuedNextName = "";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);

        storyNodes.put(nodeName, newNode);
    }
    
    public void createForestRustlingIgnore() {
        text = new ArrayList<>();
        String line1 = "You did not let curiosity get the best of you and kept walking.";
        text.add(line1);
        
        String nodeName = "forestRustlingIgnore";
        String leftNodeName = "";
        String rightNodeName = "forestCoins";
        String continuedNextName = "";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);

        storyNodes.put(nodeName, newNode);
    }
    
    public void createForestCoins() {
        text = new ArrayList<>();
        String line1 = "As you kept walkig you happen to stumble on a small pouch.";
        String line2 = "You picked up the pouch, open it, and to your supprise you found 4 coins";
        text.add(line1);
        text.add(line2);
        
        String nodeName = "forestCoins";
        String leftNodeName = "";
        String rightNodeName = "forestBridge";
        String continuedNextName = "";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);

        storyNodes.put(nodeName, newNode);
    }
    
    public void createForestBridge() {
        text = new ArrayList<>();
        String line1 = "Looking ahead you see a sturdy bridge which spans the river's width.\n";
        String line2 = "You excitedly run towards the bridge and cross it.";
        text.add(line1);
        text.add(line2);
        
        String nodeName = "forestBridge";
        String leftNodeName = "";
        String rightNodeName = "forestRiverCrossed";
        String continuedNextName = "";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
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
   
    public void createPathEncounterOne() {
        text = new ArrayList<>();
        String line1 = "You are fighting the Skeleton";
        text.add(line1);
        
        String nodeName = "forestEncounterOne";
        String leftNodeName = "";
        String rightNodeName = "fight";
        String continuedNextName = "pathContinue";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);
        this.setNodeEnemy("Skeleton", newNode);
        storyNodes.put(nodeName, newNode);
    }
    
    public void createPathContinue() {
        text = new ArrayList<>();
        String line1 = "After a hard fought battle, you defeated the skeleton\n";
        String line2 = "and you continue your journey following the path.";
        text.add(line1);
        text.add(line2);

        
        String nodeName = "pathContinue";
        String leftNodeName = "";
        String rightNodeName = "pathGlimmer";
        String continuedNextName = "";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);
       
        storyNodes.put(nodeName, newNode);
    }
    
    public void createPathGlimmer() {
        text = new ArrayList<>();
        String line1 = "Whilst traveling on the path, you see in the distance what seems to";
        String line2 = "be a small town, you tunnel vision onto the town, however, something";
        String line3 = "else catches your attention.It seems to be glimmer. You wonder what it could be.";
        text.add(line1);
        text.add(line2);
        text.add(line3);

        
        String nodeName = "pathGlimmer";
        String leftNodeName = "pathCoins";
        String rightNodeName = "pathEncounterTwo";
        String continuedNextName = "";
        String leftChoiceText = "Check it Out";
        String rightChoiceText = "Follow Path";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);

        storyNodes.put(nodeName, newNode);
    }
    
    public void createPathCoins() {
        text = new ArrayList<>();
        String line1 = "You walked towards the glimmer which turns out to be 10 coins.";
        String line2 = "You continue back on the path towards town.";
        text.add(line1);
        text.add(line2);
        
        String nodeName = "pathCoins";
        String leftNodeName = "";
        String rightNodeName = "pathEncounterTwo";
        String continuedNextName = "";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);

        storyNodes.put(nodeName, newNode);
    }
    
    public void createPathEncounterTwo() {
        text = new ArrayList<>();
        String line1 = "As you reach the town you notice an Armoured Crab guarding the entrance";
        String line2 = "Lilly, a towns member shouts at you to defeat the Armoured Crab so that";
        String line3 = "she can open the gates for you.";
        text.add(line1);
        text.add(line2);
        text.add(line3);
        
        String nodeName = "pathEncounterTwo";
        String leftNodeName = "";
        String rightNodeName = "fight";
        String continuedNextName = "pathContinue";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);
        this.setNodeEnemy("Armoured Crab", newNode);
        storyNodes.put(nodeName, newNode);
    }
    
    public void createTownStart() {
        text = new ArrayList<>();
        String line1 = "After defeating the Armoured Crab, Lilly hurriedly opens";
        String line2 = "the gates and lets you in. She tells you, people that end up on";
        String line3 = "this island has been exiled. In order to escape the island you have";
        String line4 = "to venture to the top of the mountain and defeat Avatik";
        text.add(line1);
        text.add(line2);
        text.add(line3);
        text.add(line4);
        
        String nodeName = "townStart";
        String leftNodeName = "";
        String rightNodeName = "townContinue";
        String continuedNextName = "";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);

        storyNodes.put(nodeName, newNode);
    }
    
    public void createTownContinue() {
        text = new ArrayList<>();
        String line1 = "As you walk around exploring the town\n";
        String line2 = "you find a merchant and he offers you some upgrades.";
        text.add(line1);
        text.add(line2);
        
        String nodeName = "townStart";
        String leftNodeName = "";
        String rightNodeName = "shop";
        String continuedNextName = "townLeave";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);

        storyNodes.put(nodeName, newNode);
    }
    
    public void createTownLeave() {
        text = new ArrayList<>();
        String line1 = "Just as you were leaving town to pursue Avatik, Caspiro";
        String line2 = "approaches you and hands over a map to the moutain.";
        String line3 = "You take the map and leave town.";
        text.add(line1);
        text.add(line2);
        text.add(line3);
        
        String nodeName = "townLeave";
        String leftNodeName = "";
        String rightNodeName = "actOneEnd";
        String continuedNextName = "";
        String leftChoiceText = "";
        String rightChoiceText = "Continue";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);

        storyNodes.put(nodeName, newNode);
    }
    
    public void createActOneEnd() {
        text = new ArrayList<>();
        String line1 = "Act One End!";
        String line2 = "Thanks For Playing!";
        String line3 = "To be Continued...";
        text.add(line1);
        text.add(line2);
        text.add(line3);
        
        String nodeName = "actOneEnd";
        String leftNodeName = "";
        String rightNodeName = "end";
        String continuedNextName = "";
        String leftChoiceText = "";
        String rightChoiceText = "Quit";
        
        StoryNode newNode = new StoryNode(nodeName, text, leftNodeName, rightNodeName, continuedNextName, leftChoiceText, rightChoiceText);

        storyNodes.put(nodeName, newNode);
    }
}

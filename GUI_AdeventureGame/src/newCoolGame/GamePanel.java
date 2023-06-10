/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Bradley
 */
public class GamePanel extends InGameTemplate{
//    StoryLine storyLine;
//    JButton option1;
//    JButton option2;
   
    JButton pauseScreenBtn;
    JLabel status;
    JLabel displayHealth;
    JLabel displayCoins;
    JLabel displayWeaponName;
    JLabel displayArmourName;
    Player player;
    Inventory inventory;
    StoryLine story;
    private JButton option1Btn;
    private JButton option2Btn;
    ArrayList<JLabel> displayText;
    
    
    public GamePanel() {
        player = Player.getPlayerInstance();
        inventory = Inventory.getInvInstance();
        story = StoryLine.getStoryLineInstance();
 
        option1Btn = new JButton();
        option1Btn.setBounds(100, 300, 150, 30);
        option1Btn.setContentAreaFilled(true);
        option1Btn.setFocusPainted(false);
        option1Btn.setBackground(Color.orange);

        option2Btn = new JButton();
        option2Btn.setBounds(650, 300, 150, 30);
        option2Btn.setContentAreaFilled(true);
        option2Btn.setFocusPainted(false);
        option2Btn.setBackground(Color.orange);
        
    }
    
    public void displayCurrentStory(String nodeName) {
        
        StoryNode currentSNode = story.storyNodes.get(nodeName);
//        System.out.println("Node Name: " + currentSNode.name);
        story.currentStoryNode = currentSNode.name;
        player.setProgress(currentSNode.name);
        displayText = new ArrayList<>();
     
        for(int i = 0; i < currentSNode.text.size(); i++) {
            displayText.add(new JLabel(currentSNode.text.get(i)));
            displayText.get(i).setBounds(100, 130+30*i, 800, 30);
            displayText.get(i).setForeground(Color.white);
            displayText.get(i).setFont(new Font("Arial", Font.PLAIN, 18));
            this.add(displayText.get(i));
        }
        if(!currentSNode.leftNodeName.equals("")){
            option1Btn.setText(currentSNode.leftChoiceText);
            this.add(option1Btn);
        } else {
            this.remove(option1Btn);
        }
        if(!currentSNode.rightNodeName.equals("")){
            option2Btn.setText(currentSNode.rightChoiceText);
            this.add(option2Btn);
        } else {
            this.remove(option1Btn);
        }
        
        this.update();
    }
    
    public void updateStats() {
        super.displayHealth.setText("Health: " + player.health);
        super.displayCoins.setText("Coins: " + player.coins);
        Weapon currentWeapon = inventory.getCurrentWeapon();
        super.displayWeaponName.setText("Weapon: " + currentWeapon.getName() + " (+" + currentWeapon.getStat() + ")");
        Armour currentArmour = inventory.getCurrentArmour();
        super.displayArmourName.setText("Armour: " + currentArmour.getName() + " (+" + currentArmour.getStat() + ")");   
        this.update();
    }
    
    public void clear() {
        for(JLabel label : displayText) {
            this.remove(label);
        }
        super.status.setText("");
    }
    
    public void update() {
        this.validate();
        this.repaint();
    }
    
  
    public JButton getOptionOneBtn() {
        return this.option1Btn;
    }
    
    public JButton getOptionTwoBtn() {
        return this.option2Btn;
    }
    
   
    
}

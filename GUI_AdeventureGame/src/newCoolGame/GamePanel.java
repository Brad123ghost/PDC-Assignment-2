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
public class GamePanel extends JPanel{
//    StoryLine storyLine;
//    JButton option1;
//    JButton option2;
    int width = 960;
    int height = 540;
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
        
        pauseScreenBtn = new JButton("Options");
        pauseScreenBtn.setBounds(10, 10, 80, 30);
        pauseScreenBtn.setContentAreaFilled(true);
        pauseScreenBtn.setFocusPainted(false);
        pauseScreenBtn.setFont(new Font("Arial", Font.PLAIN, 12));
        pauseScreenBtn.setBackground(Color.white);
        this.add(pauseScreenBtn);
        
        status = new JLabel();
        status.setBounds(100, 290, 800, 30);
        status.setForeground(Color.green);
        status.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(status); 
        
        this.setLayout(null);
        displayHealth = new JLabel();
        displayHealth.setBounds(10, 470, 120, 30);
        displayHealth.setForeground(Color.white);
        displayHealth.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(displayHealth);
        
        displayCoins = new JLabel();
        displayCoins.setBounds(130, 470, 100, 30);
        displayCoins.setForeground(Color.white);
        displayCoins.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(displayCoins);
        
        displayWeaponName = new JLabel();
        displayWeaponName.setBounds(740, 445, 200, 30);
        displayWeaponName.setForeground(Color.white);
        displayWeaponName.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(displayWeaponName);
        
        displayArmourName = new JLabel();
        displayArmourName.setBounds(740, 470, 200, 30);
        displayArmourName.setForeground(Color.white);
        displayArmourName.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(displayArmourName);
        
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
        displayHealth.setText("Health: " + player.health);

        displayCoins.setText("Coins: " + player.coins);
        
        Weapon currentWeapon = inventory.getCurrentWeapon();
        displayWeaponName.setText("Weapon: " + currentWeapon.getName() + " (+" + currentWeapon.getStat() + ")");
        
        Armour currentArmour = inventory.getCurrentArmour();
        displayArmourName.setText("Armour: " + currentArmour.getName() + " (+" + currentArmour.getStat() + ")");
        
        this.update();
    }
    
    public void clear() {
        for(JLabel label : displayText) {
            this.remove(label);
        }
        this.status.setText("");
    }
    
    public void update() {
        this.validate();
        this.repaint();
    }
    
    public JButton getPauseScreenBtn() {
        return this.pauseScreenBtn;
    }
    
    public JButton getOptionOneBtn() {
        return this.option1Btn;
    }
    
    public JButton getOptionTwoBtn() {
        return this.option2Btn;
    }
    
    public JLabel getStatus() {
        return this.status;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 960, 540);
    }
}

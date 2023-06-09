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
public class AttackPanel extends JPanel{
//    StoryLine storyLine;
//    JButton option1;
//    JButton option2;
    int width = 960;
    int height = 540;
    JLabel title;
    JLabel description;
    JLabel enemyName;
    JLabel enemyHealth;
    JLabel enemyAtkDmg;
    JLabel reward;
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
    boolean playerTurn = true;
    
    public AttackPanel() {
        player = Player.getPlayerInstance();
        inventory = Inventory.getInvInstance();
        story = StoryLine.getStoryLineInstance();
        
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
        
        option1Btn = new JButton("Roll Dice");
        option1Btn.setBounds(100, 350, 150, 30);
        option1Btn.setContentAreaFilled(true);
        option1Btn.setFocusPainted(false);
        option1Btn.setBackground(Color.orange);
        
        option2Btn = new JButton("Continue");
        option2Btn.setBounds(650, 350, 150, 30);
        option2Btn.setContentAreaFilled(true);
        option2Btn.setFocusPainted(false);
        option2Btn.setBackground(Color.orange);
        
        title = new JLabel("Your Turn");
        title.setBounds(100, 100, 800, 30);
        title.setForeground(Color.white);
        title.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(title);
        
        description = new JLabel("Roll a dice to increase your base damage");
        description.setBounds(100, 130, 800, 30);
        description.setForeground(Color.white);
        description.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(description);
        
        enemyName = new JLabel();
        enemyName.setBounds(120, 170, 800, 30);
        enemyName.setForeground(Color.white);
        enemyName.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(enemyName);
        
        enemyHealth = new JLabel();
        enemyHealth.setBounds(130, 200, 800, 30);
        enemyHealth.setForeground(Color.white);
        enemyHealth.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(enemyHealth);
        
        enemyAtkDmg = new JLabel();
        enemyAtkDmg.setBounds(130, 230, 800, 30);
        enemyAtkDmg.setForeground(Color.white);
        enemyAtkDmg.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(enemyAtkDmg);
        
        reward = new JLabel();
        reward.setBounds(130, 260, 800, 30);
        reward.setForeground(Color.white);
        reward.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(reward);   
        
        status = new JLabel();
        status.setBounds(100, 290, 800, 30);
        status.setForeground(Color.green);
        status.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(status); 
    }
    
//    public void startEncounter() {
//        String nodeName = story.currentStoryNode;
//        System.out.println(nodeName + "fsefsefsefesfsefesf");
//        StoryNode currentNode = story.storyNodes.get(nodeName);
//        this.enemy = currentNode.currentEnemy;
//        System.out.println(enemy.getName() + "fesfsefsefsefsefesf");
//    }
    
    public void displayEncounter() {
        System.out.println(story.currentEnemy);
        System.out.println("Hello");
        System.out.println(story.currentStoryNode);
        if(playerTurn == true) {
            this.remove(option2Btn);
            this.add(option1Btn);
        } else {
            this.remove(option1Btn);
            this.add(option2Btn);
        }
    }
    
    public void updateStats() {
        displayHealth.setText("Health: " + player.health);
        displayCoins.setText("Coins: " + player.coins);
        Weapon currentWeapon = inventory.getCurrentWeapon();
        displayWeaponName.setText("Weapon: " + currentWeapon.getName() + " (+" + currentWeapon.getStat() + ")");
        Armour currentArmour = inventory.getCurrentArmour();
        displayArmourName.setText("Armour: " + currentArmour.getName() + " (+" + currentArmour.getStat() + ")");
        enemyName.setText(story.currentEnemy.getName() + " Stats:");
        enemyHealth.setText("Health: " + story.currentEnemy.getHealth());
        enemyAtkDmg.setText("Damage: " + story.currentEnemy.getAtkDamage());
        reward.setText("Reward: " + story.currentEnemy.getCoins() + " coins");
        
        this.update();
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
    
    public JLabel getStatusLabel() {
        return this.status;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 960, 540);
    }
}

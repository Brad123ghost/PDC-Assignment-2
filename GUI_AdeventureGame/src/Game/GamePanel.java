/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
    JLabel displayHealth;
    JLabel displayCoins;
    JLabel displayWeaponName;
    JLabel displayArmourName;
    Player player;
    StoryLine story;
    
    public GamePanel() {
        player = Player.getPlayerInstance();
        story = new StoryLine();
        
        this.setLayout(null);
        displayHealth = new JLabel("HP: 100");
        displayHealth.setBounds(10, 470, 80, 30);
        displayHealth.setForeground(Color.white);
        displayHealth.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(displayHealth);
        
        displayCoins = new JLabel("Coins: 0");
        displayCoins.setBounds(90, 470, 80, 30);
        displayCoins.setForeground(Color.white);
        displayCoins.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(displayCoins);
        
        displayWeaponName = new JLabel("Weapon: Stick (+5)");
        displayWeaponName.setBounds(740, 445, 200, 30);
        displayWeaponName.setForeground(Color.white);
        displayWeaponName.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(displayWeaponName);
        
        displayArmourName = new JLabel("Armour: Leather (+10)");
        displayArmourName.setBounds(740, 470, 200, 30);
        displayArmourName.setForeground(Color.white);
        displayArmourName.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(displayArmourName);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 960, 540);
    }
}

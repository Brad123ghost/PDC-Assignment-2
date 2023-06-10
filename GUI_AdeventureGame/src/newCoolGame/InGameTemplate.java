/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

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
public class InGameTemplate extends JPanel{
    int width = 960;
    int height = 540;
    
    JButton pauseScreenBtn;
    JLabel status;
    JLabel displayHealth;
    JLabel displayCoins;
    JLabel displayWeaponName;
    JLabel displayArmourName;
    
    public InGameTemplate() {
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
    }
    
     public JButton getPauseScreenBtn() {
        return this.pauseScreenBtn;
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

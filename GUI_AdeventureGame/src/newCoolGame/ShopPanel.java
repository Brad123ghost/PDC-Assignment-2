/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Bradley
 */
public class ShopPanel extends InGameTemplate{
    private Player player;
    private Inventory inventory;
    private FontMetrics fm;
    private Rectangle2D bounds;
    
    private JButton upgradeWeaponBtn;
    private JButton upgradeArmourBtn;
    private JButton upgradeHealthBtn;
    private JButton exitShopBtn;
    
    String msg = "";
    
    public ShopPanel() {
        player = Player.getPlayerInstance();
        inventory = Inventory.getInvInstance();
        
        upgradeWeaponBtn = new JButton();
        upgradeWeaponBtn.setBounds((this.width/2)-375, 240, 200, 50);
        upgradeWeaponBtn.setContentAreaFilled(true);
        upgradeWeaponBtn.setFocusPainted(false);
        upgradeWeaponBtn.setBackground(Color.orange);
        this.add(upgradeWeaponBtn);
        
        upgradeArmourBtn = new JButton();
        upgradeArmourBtn.setBounds((this.width/2)-100, 240, 200, 50);
        upgradeArmourBtn.setContentAreaFilled(true);
        upgradeArmourBtn.setFocusPainted(false);
        upgradeArmourBtn.setBackground(Color.orange);
        this.add(upgradeArmourBtn);
        
        upgradeHealthBtn = new JButton("+5 Health - 5 Coins");
        upgradeHealthBtn.setBounds((this.width/2)+175, 240, 200, 50); 
        upgradeHealthBtn.setContentAreaFilled(true);
        upgradeHealthBtn.setFocusPainted(false);
        upgradeHealthBtn.setBackground(Color.orange);
        this.add(upgradeHealthBtn);
        
        exitShopBtn = new JButton("Exit Shop");
        exitShopBtn.setBounds(this.width/2-100, 350, 200, 50); 
        exitShopBtn.setContentAreaFilled(true);
        exitShopBtn.setFocusPainted(false);
        exitShopBtn.setBackground(Color.orange);
        this.add(exitShopBtn);
        
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
    
    public void update() {
        this.validate();
        this.repaint();
    }
    
    public JButton getUpgradeWeaponBtn() {
        return this.upgradeWeaponBtn;
    }
    
    public JButton getUpgradeArmourBtn() {
        return this.upgradeArmourBtn;
    }
    public JButton getUpgradeHealthBtn() {
        return this.upgradeHealthBtn;
    }
    public JButton getExitShopBtn() {
        return this.exitShopBtn;
    }
    
    public void setMessage(String msg) {
        this.msg = msg;
    }
    
    public String getMessage() {
        return this.msg;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
 
        g.setColor(Color.GREEN);
        
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        this.getMetrics(g, "SHOP");
        g.drawString("SHOP", (this.width-(int)bounds.getWidth())/2, 100); 
        
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        this.getMetrics(g, "(CANNOT REOPEN SHOP ONCE YOU LEAVE)");
        g.drawString("(CANNOT REOPEN SHOP ONCE YOU LEAVE)", (this.width-(int)bounds.getWidth())/2, 125); 
        if(msg.contains("coins")){
             g.setColor(Color.red);
        } else {
             g.setColor(Color.GREEN);
        }
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        this.getMetrics(g, msg);
        g.drawString(msg, (this.width-(int)bounds.getWidth())/2, 200); 
    }
    public void getMetrics(Graphics g, String boundText) {
        fm = g.getFontMetrics();
        bounds = fm.getStringBounds(boundText, g);
    }
    
    
}

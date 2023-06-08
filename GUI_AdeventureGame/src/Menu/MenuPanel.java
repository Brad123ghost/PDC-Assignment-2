/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Bradley
 */
public class MenuPanel extends MenuTemplate{
//    private JPanel panel;
    
    private JButton newGameBtn;
    private JButton loadGameBtn;
    private JButton exitGameBtn;
    private String titleName;
 
    
 
    public MenuPanel() {
        super.setTitleText("Adventure Game");
        this.setLayout(null);
        this.titleName = "Adventure Game";
        newGameBtn = new JButton("New Game");
        newGameBtn.setBounds(this.width/2-75, 200, 150, 50);
        newGameBtn.setContentAreaFilled(true);
        newGameBtn.setFocusPainted(false);
        newGameBtn.setOpaque(true);
        newGameBtn.setBackground(Color.orange);
        this.add(newGameBtn);
        
        loadGameBtn = new JButton("Load Game");
        loadGameBtn.setBounds(this.width/2-75, 275, 150, 50);
        loadGameBtn.setContentAreaFilled(true);
        loadGameBtn.setFocusPainted(false);
        loadGameBtn.setOpaque(true);
        loadGameBtn.setBackground(Color.orange);
        this.add(loadGameBtn);
        
        exitGameBtn = new JButton("Exit Game");
        exitGameBtn.setBounds(this.width/2-75, 350, 150, 50); 
        exitGameBtn.setContentAreaFilled(true);
        exitGameBtn.setFocusPainted(false);
        exitGameBtn.setOpaque(true);
        exitGameBtn.setBackground(Color.orange);
        this.add(exitGameBtn);
 
        System.out.println("Menu View Created");
    }
    
    public JButton getNGBtn() {
        return this.newGameBtn;
    }
    
    public JButton getLGBtn() {
        return this.loadGameBtn;
    }
    
    public JButton getEGBtn() {
        return this.exitGameBtn;
    }
    
//    public MenuPanel getMPanel() {
//        return this.
//    }
    
}
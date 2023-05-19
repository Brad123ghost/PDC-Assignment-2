/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_adeventuregame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Bradley
 */
public class MenuPanel extends JPanel {
//    JPanel buttonCluster = new JPanel();
//    
//    JLabel title = new JLabel("Adventure Game");
    JButton newGameBtn = new JButton("New Game");
    JButton loadGameBtn = new JButton("Load Game");
    JButton exitGameBtn = new JButton("Exit Game");
    String titleName = "Adventure Game";
    Star[] stars = new Star[50];
    Thread[] threads = new Thread[50];
    int starSize = 3;
    FontMetrics fm;
    Rectangle2D bounds;
    int width = 960;
    int height = 540;
    MenuController mController;
    
//    GridBagConstraints gbc = new GridBagConstraints();
    public MenuPanel() {
        for(int i = 0; i < 50; ++i) {
            this.stars[i] = new Star(i);
            this.threads[i] = new Thread(stars[i]);
            threads[i].start();
        }
        
      
        this.add(newGameBtn);
        this.add(loadGameBtn);
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 960, 540);
        g.setColor(Color.white);
        for(int i = 0; i < this.stars.length; ++i) {
            g.fillOval(stars[i].x, stars[i].y, starSize, starSize);
        }
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        this.getMetrics(g, titleName);
        g.drawString(titleName, (this.width-(int)bounds.getWidth())/2, 60); 
        
//        g.setColor(Color.white);
//        g.setFont(new Font("Airal", Font.PLAIN, 20));
//        this.getMetrics(g, "New Game");
//        g.fillRoundRect((this.width-(int)bounds.getWidth())/2-10, 120, (int)bounds.getWidth()+20, (int)bounds.getHeight()+20,10,10);
//        g.setColor(Color.red);
//        g.drawString("New Game", (this.width-(int)bounds.getWidth())/2, 150);
//        this.getMetrics(g, "Load Game");
//        g.drawString("Load Game",(this.width-(int)bounds.getWidth())/2, 200);
//        this.getMetrics(g, "Exit Game");
//        g.drawString("Exit Game",(this.width-(int)bounds.getWidth())/2, 250);
      
        repaint(); 
    }

    
    public void getMetrics(Graphics g, String boundText) {
        fm = g.getFontMetrics();
        bounds = fm.getStringBounds(boundText, g);
    }
    

}

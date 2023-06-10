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
import javax.swing.JPanel;

/**
 *
 * @author Bradley
 */
public class MenuTemplate extends JPanel{
    private String titleText = "";
    int width = 960;
    int height = 540;
    
     FontMetrics fm;
     Rectangle2D bounds;
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 960, 540);
        
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        this.getMetrics(g, titleText);
        g.drawString(titleText, (this.width-(int)bounds.getWidth())/2, 100); 
    }
    
    public void getMetrics(Graphics g, String boundText) {
        fm = g.getFontMetrics();
        bounds = fm.getStringBounds(boundText, g);
    }
    
    public void setTitleText(String title){
        this.titleText = title;
    }
}

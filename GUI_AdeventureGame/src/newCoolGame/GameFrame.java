/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Bradley
 */
public class GameFrame extends JFrame{
    private JFrame frame;
    
    private Menu menuModel;
    private MenuPanel menuPanel;
//    private JPanel menuJPanel;
    
    int width = 960;
    int height = 540;
    
    public GameFrame() {
        this.frame = new JFrame("Adventure Game");
        this.frame.setSize(width, height);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.menuPanel = new MenuPanel();
        this.menuModel = new Menu(menuPanel);
        
//        this.menuJPanel = menuPanel.getPanel();
        
        this.frame.add(menuPanel);
        this.frame.setVisible(true);
    }
}

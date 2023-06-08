/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import Menu.MenuController;
import Menu.MenuPanel;
import Menu.MenuState;
import Menu.NewGamePanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Bradley
 */
public class GameFrame{
    private JFrame frame;
    
    private MenuController menuModel;
    private MenuPanel menuPanel;
    private NewGamePanel newGamePanel;
//    private JPanel menuJPanel;
    MenuState mState = MenuState.MAIN_MENU;
    int width = 960;
    int height = 540;
    
    public GameFrame() {
        this.frame = new JFrame("Adventure Game");
        this.frame.setSize(width, height);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                int x = JOptionPane.showConfirmDialog(null, "Do you really want to quit?", "Close", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
//                if(x == JOptionPane.YES_OPTION) {
//                    e.getWindow().dispose();
//                    System.out.println("Closed");
//                } else {
//                    System.out.println("Not Closed");
//                }
//            }
//        });
        
        this.menuPanel = new MenuPanel();
        this.newGamePanel = new NewGamePanel();
        this.menuModel = new MenuController(this, menuPanel, newGamePanel);
        
//        this.menuJPanel = menuPanel.getPanel();
        
        this.frame.add(menuPanel);
//this.frame.add(newGamePanel);
        this.frame.setVisible(true);
    }
    
    public void checkState() {
        switch(mState) {
            case MAIN_MENU:
                this.frame.remove(newGamePanel);
                this.frame.add(menuPanel);
                break;
            case NEW_GAME:
                this.frame.remove(menuPanel);
                this.frame.add(newGamePanel);
                break;
            case EXIT_GAME:
//                int x = JOptionPane.showConfirmDialog(null, "Do you really want to quit?", "Close", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
//                if(x == JOptionPane.YES_OPTION) {
//                    JOptionPane.showConfirmDialog(null, "Progress has been saved!", "Saved", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
//                    this.frame.dispose();
//                    System.out.println("Closed");
//                } else {
//                    System.out.println("Not Closed");
//                }
                this.frame.dispose();
                break;
                
        }
        
        this.frame.revalidate();
        this.frame.repaint();
    }
    
    public void setMenuState(MenuState newState) {
        this.mState = newState;
    }
 
}

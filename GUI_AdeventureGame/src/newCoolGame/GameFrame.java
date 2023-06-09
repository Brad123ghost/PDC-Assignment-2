/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Bradley
 */
public class GameFrame{
    private JFrame frame;
    
    // Game Memory
    GameMemory gMemory;
    StoryLine story;
    
    // Menu Panel/Controller
    private MenuController menuController;
    private MenuPanel menuPanel;
    private NewGamePanel newGamePanel;
    private LoadPanel loadPanel;
    private PausedPanel pausedPanel;
    
    // Game Panel/Controller
    private GameController gameController;
    private GamePanel gamePanel;
    private AttackPanel attackPanel;
    private AttackController attackController;
//    private
    
//    private JPanel menuJPanel;
    State mState = State.MAIN_MENU;
    int width = 960;
    int height = 540;
    
    public GameFrame() {
        gMemory = GameMemory.getGMemInstance();
        gMemory.gMemSetup();
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
        this.loadPanel = new LoadPanel();
        this.pausedPanel = new PausedPanel();
        this.menuController = new MenuController(this, menuPanel, newGamePanel, loadPanel, pausedPanel);
        
        
        gMemory.queryShopUpgrades();
        gMemory.queryEnemies();
        this.story = StoryLine.getStoryLineInstance();
        this.gamePanel = new GamePanel();
        this.gameController = new GameController(this, gamePanel);
        this.attackPanel = new AttackPanel();
        this.attackController = new AttackController(this, attackPanel);
        this.frame.add(menuPanel);
        this.frame.setVisible(true);
        
        

    }
    
    public void checkState() {
        switch(mState) {
            case MAIN_MENU:
                this.frame.remove(newGamePanel);
                this.frame.remove(gamePanel);
                this.frame.remove(attackPanel);
                this.frame.remove(pausedPanel);
                this.frame.add(menuPanel);
              
                break;
            case NEW_GAME:
                this.frame.remove(menuPanel);
//                this.frame.remove(gamePanel);
                this.frame.remove(loadPanel);
                this.frame.remove(pausedPanel);
                this.frame.add(newGamePanel);
                break;
            case LOAD_GAME:
                this.frame.remove(menuPanel);
                this.frame.remove(gamePanel);
                this.frame.remove(attackPanel);
                this.frame.remove(pausedPanel);
                this.frame.add(loadPanel);
                break;
            case GAME_START:
                this.gamePanel.updateStats();
                this.gamePanel.displayCurrentStory("beachStart");
                this.gameController.addGamePanelListeners();
                this.frame.remove(menuPanel);
                this.frame.remove(newGamePanel);
                this.frame.remove(pausedPanel);
                this.frame.remove(attackPanel);
                this.frame.add(gamePanel);
                break;
            case ATTACK:
                this.attackController.addAttackPanelListeners();
                this.attackController.startEncounter();
                this.attackPanel.updateStats();
                this.frame.remove(menuPanel);
                this.frame.remove(gamePanel);
                this.frame.remove(pausedPanel);
                this.frame.add(attackPanel);
                break;
            case GAME_RESUME:
                this.gamePanel.clear();
                this.gamePanel.updateStats();
                this.gamePanel.displayCurrentStory(story.currentStoryNode);
                this.frame.remove(menuPanel);
                this.frame.remove(newGamePanel);
                this.frame.remove(attackPanel);
                this.frame.remove(pausedPanel);
                this.frame.add(gamePanel);
                break;
            case PAUSE_GAME:
                this.frame.remove(gamePanel);
                this.frame.remove(attackPanel);
                this.frame.add(pausedPanel);
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
    
    public void setMenuState(State newState) {
        this.mState = newState;
    }
 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import newCoolGame.State;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import newCoolGame.GameFrame;

/**
 *
 * @author Bradley
 */
public class MenuController {
    GameMemory gMemory;
    GameFrame currentGFrame;
    
    MenuPanel mPanel;
    NewGamePanel ngPanel;
    LoadPanel lPanel;
    PausedPanel pPanel;
    GamePanel gPanel;
    ShopPanel sPanel;
    
    SaveLoadManager saveLoadManager;
    
    public MenuController(GameFrame gFrame, MenuPanel mPanel, NewGamePanel ngPanel, LoadPanel loadPanel, PausedPanel pPanel, LoadPanel lPanel, GamePanel gPanel, ShopPanel sPanel) {
        this.gMemory = GameMemory.getGMemInstance();
        this.currentGFrame = gFrame;
        this.mPanel = mPanel;
        this.ngPanel = ngPanel;
        this.lPanel = lPanel;
        this.pPanel = pPanel;
        this.gPanel = gPanel;
        this.sPanel = sPanel;
        this.eventListener();
        this.saveLoadManager = new SaveLoadManager();
    }
    
    private void eventHandleNewGame() {
//        System.out.println("New Game");
        currentGFrame.setMenuState(State.NEW_GAME);
        currentGFrame.checkState();
    }
    private void eventHandleLoadGame() {
//        System.out.println("Load Game");
//        gMemory.slManager.getPlayerList();
//        System.out.println(gMemory.userList.get(0));
        currentGFrame.setMenuState(State.LOAD_PANEL);
        currentGFrame.checkState();
    }
    
    private void eventHandleMainMenu() {
        ngPanel.setErrorMsg("");
        ngPanel.setErrorMsg2("");
        ngPanel.getNameField().setText("");
        lPanel.getUserJList().clearSelection();
        lPanel.getLoadUserBtn().setEnabled(false);
        currentGFrame.setMenuState(State.MAIN_MENU);
        currentGFrame.checkState();
    }
    
    private void eventHandleLoadPlayerData() {
        String name = (String)lPanel.getUserJList().getSelectedValue();
        gMemory.slManager.retrievePlayerData(name);
        
        currentGFrame.setMenuState(State.LOAD_SAVE);
        currentGFrame.checkState();
    }
    
    private void eventHandleExitGame() {
//        System.out.println("Exit Game");
        currentGFrame.setMenuState(State.EXIT_GAME);
        currentGFrame.checkState();
    }
    
    private void eventHandleStartGame() {
//        System.out.println("Start Game");
        JTextField nameField = ngPanel.getNameField();
        String name = nameField.getText().toLowerCase();
        System.out.println(name);
        if(!checkValidString(name)) {
            ngPanel.setErrorMsg2("");
            ngPanel.setErrorMsg("Invalid Input!");
        } else {
            boolean resultExistUser = gMemory.slManager.searchPlayer(name);
            
            if(resultExistUser == true) {
                ngPanel.setErrorMsg("");
                ngPanel.setErrorMsg2("Player already exist!");
            } else {
                gMemory.createNewPlayer(name);
                currentGFrame.setMenuState(State.GAME_START);
                currentGFrame.checkState();
            }
            
        } 
    }
    private void eventHandleResumeGame() {
        currentGFrame.setMenuState(State.GAME_RESUME);
        currentGFrame.checkState();
    }
    
    private void eventHandleSaveExitGame() {
//        saveLoadManager.savePlayerData();
        gMemory.slManager.savePlayerData();
        currentGFrame.setMenuState(State.EXIT_GAME);
        currentGFrame.checkState();
    }
    
    private void eventListener() {
        mPanel.getNGBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleNewGame();
            }
        });
        mPanel.getLGBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleLoadGame();
            }
        });
        
        lPanel.getBackBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleMainMenu();
            }
        });
        
        lPanel.getLoadUserBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleLoadPlayerData();
            }
        });
        
        lPanel.getUserJList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                lPanel.getLoadUserBtn().setEnabled(true);
            }     
        });

        mPanel.getEGBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleExitGame();
            }
        });
        
        ngPanel.getStartBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleStartGame();
            }
        });
        
        ngPanel.getBackBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleMainMenu();
            }
        });
        
        pPanel.getRGBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleResumeGame();
            }
        });
        
        pPanel.getSEBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleSaveExitGame();
            }
        });
    }
    
    public void eventHandleTestMenu() {
        gMemory.getGMemInstance().player = null;
        gMemory.getGMemInstance().inventory = null;
        gMemory.getGMemInstance().shop = null;
        gMemory.getGMemInstance().dbManager = null;
        gMemory.resetGMemInstance();
        currentGFrame.setMenuState(State.MAIN_MENU);
        currentGFrame.checkState();
    }
    
    
    private boolean checkValidString(String toCheck) {
        if(!toCheck.matches("[a-zA-Z]+") || toCheck.equals("")) {
            return false;
        }
        
        return true;
    }
}

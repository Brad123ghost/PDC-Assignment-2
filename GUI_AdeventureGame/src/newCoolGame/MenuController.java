/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import newCoolGame.State;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
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
    
    SaveLoadManager saveLoadManager;
    
    public MenuController(GameFrame gFrame, MenuPanel mPanel, NewGamePanel ngPanel, LoadPanel loadPanel, PausedPanel pPanel) {
        this.gMemory = GameMemory.getGMemInstance();
        this.currentGFrame = gFrame;
        this.mPanel = mPanel;
        this.ngPanel = ngPanel;
        this.lPanel = lPanel;
        this.pPanel = pPanel;
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
        currentGFrame.setMenuState(State.LOAD_GAME);
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
        String name = nameField.getText();
        System.out.println(name);
        if(!checkValidString(name)) {
            ngPanel.setErrorMsg();
        } else {
            gMemory.createNewPlayer(name);
            currentGFrame.setMenuState(State.GAME_START);
            currentGFrame.checkState();
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
    
    private boolean checkValidString(String toCheck) {
        if(!toCheck.matches("[a-zA-Z]+") || toCheck.equals("")) {
            return false;
        }
        
        return true;
    }
}

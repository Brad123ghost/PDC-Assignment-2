/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import newCoolGame.GameFrame;

/**
 *
 * @author Bradley
 */
public class MenuController {
    GameFrame currentGFrame;
    
    MenuPanel mPanel;
    NewGamePanel ngPanel;
    
    public MenuController(GameFrame gFrame, MenuPanel mPanel, NewGamePanel ngPanel) {
        this.currentGFrame = gFrame;
        this.mPanel = mPanel;
        this.ngPanel = ngPanel;
        this.eventListener();
    }
    
    private void eventHandleNewGame() {
        System.out.println("New Game");
        currentGFrame.setMenuState(MenuState.NEW_GAME);
        currentGFrame.checkState();
    }
    private void eventHandleLoadGame() {
        System.out.println("Load Game");
    }
    private void eventHandleExitGame() {
        System.out.println("Exit Game");
        currentGFrame.setMenuState(MenuState.EXIT_GAME);
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
    }
}
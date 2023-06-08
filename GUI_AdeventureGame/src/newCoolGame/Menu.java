/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Bradley
 */
public class Menu {
    MenuPanel mPanel;
    
    public Menu(MenuPanel mPanel) {
        this.mPanel = mPanel;
        this.eventListener();
    }
    
    private void eventHandleNewGame() {
        System.out.println("New Game");
    }
    private void eventHandleLoadGame() {
        System.out.println("Load Game");
    }
    private void eventHandleExitGame() {
        System.out.println("Exit Game");
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

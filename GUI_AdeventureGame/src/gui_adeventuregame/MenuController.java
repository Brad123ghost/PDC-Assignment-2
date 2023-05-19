/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_adeventuregame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Bradley
 */
public class MenuController implements Observer{

    private MenuPanel mView;
    
    public MenuController() {
        System.out.println("Menu Controller Created");
    }
    
    public void controllerAddView(MenuPanel mView) {
        this.mView = mView;
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
    
    public void eventListener() {
        mView.getNGBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleNewGame();
            }
        });
        mView.getLGBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleLoadGame();
            }
        });
        mView.getEGBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleExitGame();
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

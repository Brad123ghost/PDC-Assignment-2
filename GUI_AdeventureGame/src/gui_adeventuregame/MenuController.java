///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package gui_adeventuregame;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JPanel;
//
///**
// *
// * @author Bradley
// */
//
//public class MenuController{
//
//    private MenuPanel mView;
//    private JPanel currentPanel;
//    
//    public MenuController() {
//        System.out.println("Menu Controller Created");
//    }
//    
//    public void controllerAddView(MenuPanel mView) {
//        this.mView = mView;
//        currentPanel = this.mView.getCurrentPanel();
//    }
//
//    private void eventHandleNewGame() {
//        System.out.println("New Game");
//        mView.setState(GameState.NEW_GAME_MENU);
//    }
//    private void eventHandleLoadGame() {
//        System.out.println("Load Game");
//        mView.setState(GameState.LOAD_GAME_MENU);
//    }
//    private void eventHandleExitGame() {
//        System.out.println("Exit Game");
//    }
//    
////    public void eventListener() {
////        currentPanel.getNGBtn().addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                eventHandleNewGame();
////            }
////        });
////        mView.getLGBtn().addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                eventHandleLoadGame();
////            }
////        });
////        mView.getEGBtn().addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                eventHandleExitGame();
////            }
////        });
////    }
//
//    
//    
//}

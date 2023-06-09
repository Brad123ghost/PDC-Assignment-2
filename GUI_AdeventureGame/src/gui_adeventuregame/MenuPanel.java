///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package gui_adeventuregame;
//
//import gui_adeventuregame.panelstates.MainMenu;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.FontMetrics;
//import java.awt.Graphics;
//import java.awt.GridBagConstraints;
//import java.awt.geom.Rectangle2D;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
///**
// *
// * @author Bradley
// */
//public class MenuPanel extends JPanel implements Runnable{
////    JPanel buttonCluster = new JPanel();
////    
////    JLabel title = new JLabel("Adventure Game");
//    private JButton newGameBtn;
//    private JButton loadGameBtn;
//    private JButton exitGameBtn;
//    String titleName;
////    Star[] stars = new Star[50];
////    Thread[] threads = new Thread[50];
////    int starSize = 3;
//    FontMetrics fm;
//    Rectangle2D bounds;
//    int width = 960;
//    int height = 540;
//    MenuController mController;
//    
//    private JTextField nameField;
//    private JButton createCharacter;
//    private GameState menuState;
//    
////    GridBagConstraints gbc = new GridBagConstraints();
//    public MenuPanel() {
//        
//        this.menuState = GameState.MAIN_MENU;
//        this.setLayout(null);
//        this.titleName = "Adventure Game";
//        newGameBtn = new JButton("New Game");
//        newGameBtn.setBounds(this.width/2-75, 200, 150, 50);
//        this.add(newGameBtn);
//        
//        loadGameBtn = new JButton("Load Game");
//        loadGameBtn.setBounds(this.width/2-75, 275, 150, 50);
//        this.add(loadGameBtn);
//        
//        exitGameBtn = new JButton("Exit Game");
//        exitGameBtn.setBounds(this.width/2-75, 350, 150, 50); 
//        this.add(exitGameBtn);
//        
//        System.out.println("Menu View Created");
//    }
//    
//    public JPanel getCurrentPanel() {
//        return this.currentPanel;
//    }
//    
//    public void setState(GameState state) {
//        this.menuState = state;
//    }
//
//    public void getMetrics(Graphics g, String boundText) {
//        fm = g.getFontMetrics();
//        bounds = fm.getStringBounds(boundText, g);
//    }
//
//    @Override
//    public void run() {
//        checkGameState();
//    }
//    
//    public void checkGameState() {
//        
//    }
//   
//}

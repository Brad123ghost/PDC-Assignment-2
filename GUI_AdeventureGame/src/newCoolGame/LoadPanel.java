/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Bradley
 */
public class LoadPanel extends MenuTemplate{
    GameMemory gMem;
    
//    JScrollPane userList;
    JList userList;
    JButton loadUserBtn;
    JButton backBtn;

    public LoadPanel() {
        gMem = GameMemory.getGMemInstance();
        gMem.slManager.getPlayerList();
        super.setTitleText("Load Saves");
        this.setLayout(null);
        DefaultListModel<String> model = new DefaultListModel();
        
        for(int i = 0; i < gMem.userList.size(); i++) {
            System.out.println(gMem.userList.get(i));
        }
        
        userList = new JList(model);
        for(int i = 0; i < gMem.userList.size(); i++) {
            model.add(i, gMem.userList.get(i));
        }
        
        JScrollPane scrollPane = new JScrollPane(userList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(this.width/2-100, 150, 200, 150);
        scrollPane.setBackground(Color.white);
        
        this.add(scrollPane);
        loadUserBtn = new JButton("Load");
        loadUserBtn.setBounds(this.width/2-75, 350, 150, 50); 
        loadUserBtn.setContentAreaFilled(true);
        loadUserBtn.setFocusPainted(false);
        loadUserBtn.setBackground(Color.orange);
        loadUserBtn.setEnabled(false);
        this.add(loadUserBtn);
        
        backBtn = new JButton("Back");
        backBtn.setBounds(this.width/2-75, 410, 150, 50); 
        backBtn.setContentAreaFilled(true);
        backBtn.setFocusPainted(false);
        backBtn.setBackground(Color.orange);
        this.add(backBtn);
    }
    
    public JButton getLoadUserBtn() {
        return this.loadUserBtn;
    }
    
    public JButton getBackBtn() {
        return this.backBtn;
    }
    
    public JList getUserJList() {
        return this.userList;
    }
}

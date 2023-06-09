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

    public LoadPanel() {
        gMem = GameMemory.getGMemInstance();
        gMem.slManager.getPlayerList();
        super.setTitleText("Load Saves");
        this.setLayout(null);
        DefaultListModel<String> model = new DefaultListModel();
        
        userList = new JList(model);
//        userNameField.setLocation(this.width/2, 150);
//        userList.setBounds(this.width/2-125, 200, 250, 150);
//        userList.setBackground(Color.white);
        for(int i = 0; i < gMem.userList.size(); i++) {
            model.add(i, gMem.userList.get(i));
        }
//        this.add(userList);
        
        JScrollPane scrollPane = new JScrollPane(userList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(this.width/2-100, 150, 200, 150);
        scrollPane.setBackground(Color.white);
        
        this.add(scrollPane);
        loadUserBtn = new JButton("Load");
        loadUserBtn.setBounds(this.width/2-75, 350, 150, 50); 
        loadUserBtn.setContentAreaFilled(true);
        loadUserBtn.setFocusPainted(false);
        loadUserBtn.setBackground(Color.orange);
        this.add(loadUserBtn);
    }
}

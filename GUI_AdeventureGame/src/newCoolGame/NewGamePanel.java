/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Bradley
 */
public class NewGamePanel extends MenuTemplate{
    private JTextField userNameField;
    private JButton startGameBtn;
    private JButton backBtn;
    private JLabel errorMsg;
    private JLabel errorMsg2;
    
    public NewGamePanel() {
        super.setTitleText("Enter Your Name");
        this.setLayout(null);
        errorMsg = new JLabel();
        errorMsg.setBounds(this.width/2-50, 260, 101, 30);
        errorMsg.setForeground(Color.red);
        errorMsg.setFont(new Font("SansSerif", Font.PLAIN, 18));
//        errorMsg.setVisible(false);
        this.add(errorMsg);
        
        errorMsg2 = new JLabel();
        errorMsg2.setBounds(this.width/2-90, 260, 180, 30);
        errorMsg2.setForeground(Color.red);
        errorMsg2.setFont(new Font("SansSerif", Font.PLAIN, 18));
        this.add(errorMsg2);
        
        userNameField = new JTextField();
//        userNameField.setLocation(this.width/2, 150);
        userNameField.setBounds(this.width/2-125, 300, 250, 30);
        userNameField.setBackground(Color.white);
        this.add(userNameField);
        
        startGameBtn = new JButton("Start");
        startGameBtn.setBounds(this.width/2-75, 350, 150, 50); 
        startGameBtn.setContentAreaFilled(true);
        startGameBtn.setFocusPainted(false);
        startGameBtn.setBackground(Color.orange);
        this.add(startGameBtn);
        
        backBtn = new JButton("Back");
        backBtn.setBounds(this.width/2-75, 410, 150, 50); 
        backBtn.setContentAreaFilled(true);
        backBtn.setFocusPainted(false);
        backBtn.setBackground(Color.orange);
        this.add(backBtn);
    }
    
    public JTextField getNameField() {
        return this.userNameField;
    }
    
    public JButton getStartBtn() {
        return this.startGameBtn;
    }
    
    public JButton getBackBtn() {
        return this.backBtn;
    }
    
    public void setErrorMsg(String msg) {
        this.errorMsg.setText(msg);
    }
    
    public void setErrorMsg2(String msg) {
        this.errorMsg2.setText(msg);
    }
}

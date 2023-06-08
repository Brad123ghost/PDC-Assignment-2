/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

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
    private JLabel errorMsg;
    
    public NewGamePanel() {
        super.setTitleText("Enter Your Name");
        this.setLayout(null);
        errorMsg = new JLabel("Invalid Input!");
        errorMsg.setBounds(this.width/2-50, 260, 101, 30);
        errorMsg.setForeground(Color.red);
        errorMsg.setFont(new Font("SansSerif", Font.PLAIN, 18));
        errorMsg.setVisible(false);
        this.add(errorMsg);
        
        userNameField = new JTextField();
//        userNameField.setLocation(this.width/2, 150);
        userNameField.setBounds(this.width/2-125, 300, 250, 30);
        userNameField.setBackground(Color.white);
        this.add(userNameField);
        
        startGameBtn = new JButton("Start");
        startGameBtn.setBounds(this.width/2-75, 350, 150, 50); 
        startGameBtn.setContentAreaFilled(true);
        startGameBtn.setFocusPainted(false);
        startGameBtn.setOpaque(true);
        startGameBtn.setBackground(Color.orange);
        this.add(startGameBtn);
    }
    
    public JTextField getNameField() {
        return this.userNameField;
    }
    
    public JButton getStartBtn() {
        return this.startGameBtn;
    }
    
    public void setErrorMsg() {
        this.errorMsg.setVisible(true);
    }
}

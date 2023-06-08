/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Bradley
 */
public class NewGamePanel extends MenuTemplate{
    private JTextField userNameField;
    private JButton submitNameBtn;
    
    public NewGamePanel() {
        super.setTitleText("Enter Your Name");
        this.setLayout(null);
        userNameField = new JTextField();
        this.add(userNameField);
        
        submitNameBtn = new JButton("Start");
        submitNameBtn.setBounds(this.width/2-75, 350, 150, 50); 
        submitNameBtn.setContentAreaFilled(true);
        submitNameBtn.setFocusPainted(false);
        submitNameBtn.setOpaque(true);
        submitNameBtn.setBackground(Color.orange);
        this.add(submitNameBtn);
    }
    
    public JTextField getNameField() {
        return this.userNameField;
    }
    
    public JButton submitNameBtn() {
        return this.submitNameBtn;
    }
}

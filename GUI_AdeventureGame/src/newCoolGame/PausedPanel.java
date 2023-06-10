/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author Bradley
 */
public class PausedPanel extends MenuTemplate{
    private JButton resumeGameBtn;
    private JButton saveExitBtn;
    
    public PausedPanel() {
        super.setTitleText("Game Paused");
        this.setLayout(null);
        resumeGameBtn = new JButton("Resume Game");
        resumeGameBtn.setBounds(this.width/2-75, 200, 150, 50);
        resumeGameBtn.setContentAreaFilled(true);
        resumeGameBtn.setFocusPainted(false);
        resumeGameBtn.setBackground(Color.orange);
        this.add(resumeGameBtn);
        
        saveExitBtn = new JButton("Save & Exit");
        saveExitBtn.setBounds(this.width/2-75, 275, 150, 50);
        saveExitBtn.setContentAreaFilled(true);
        saveExitBtn.setFocusPainted(false);
        saveExitBtn.setBackground(Color.orange);
        this.add(saveExitBtn);
        


    }
    
    public JButton getRGBtn() {
        return this.resumeGameBtn;
    }
    
    public JButton getSEBtn() {
        return this.saveExitBtn;
    }

}

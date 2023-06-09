/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import java.util.Random;

/**
 *
 * @author Bradley
 */
public class Helper {
    public static Helper helperInstance;
    private Helper() {}
    
    public static synchronized Helper getHelperInstance() {
        if(helperInstance == null) {
            helperInstance = new Helper();
        }
        
        return helperInstance;
    }
    
    public int diceRoll(int max) {
        return (new Random()).nextInt(max);
    }
}

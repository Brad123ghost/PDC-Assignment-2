/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

/**
 *
 * @author Bradley
 */
public class ShopController {
    GameMemory gMemory;
    GameFrame currentGFrame;
    
    ShopPanel shopPanel;
    
    public ShopController(GameFrame currentGFrame, ShopPanel sPanel) {
        gMemory = GameMemory.getGMemInstance();
        
        this.currentGFrame = currentGFrame;
        this.shopPanel = sPanel;
    }
}

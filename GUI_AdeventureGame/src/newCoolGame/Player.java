/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import newCoolGame.Inventory;

/**
 *
 * @author Bradley
 */
public class Player {
    int playerID;
    String name;
    double health;
    String progress;
    int coins;
    Inventory inventory;
    public static Player playerInstance;

    private Player() {};
    
    public static synchronized Player getPlayerInstance() {
        if(playerInstance == null) {
            playerInstance = new Player();
            playerInstance.name = null;
            playerInstance.health = 100;
            playerInstance.progress = null;
            playerInstance.inventory = Inventory.getInvInstance();
        }
        
        return playerInstance;
    }
    
    public void setName(String name) {
        this.name = name;
    }
 
}

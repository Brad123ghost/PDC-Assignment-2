/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

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
    static Player playerInstance;

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
}

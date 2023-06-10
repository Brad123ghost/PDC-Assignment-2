/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import Database.DBManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import newCoolGame.Inventory;

/**
 *
 * @author Bradley
 */
public class Player {
    int lastID;
    int playerID;
    String name;
    double health;
    String progress;
    int coins;
    Inventory inventory;
    public static Player playerInstance;
    DBManager dbManager = DBManager.getDBInstance();

    private Player() {};
    
    public static synchronized Player getPlayerInstance() {
        if(playerInstance == null) {
            playerInstance = new Player();
            playerInstance.name = null;
            playerInstance.health = 100;
            playerInstance.progress = null;
            playerInstance.inventory = Inventory.getInvInstance();
            playerInstance.setPlayerID();
        }
        
        return playerInstance;
    }
    
    private void setPlayerID() {
        String selectQuery = "SELECT COUNT(*) FROM PLAYER";
        
        try {
            ResultSet rs = dbManager.queryDB(selectQuery);
            if(rs != null) {
                while(rs.next()) {
                    lastID = rs.getInt("1");
                }  
            } else {
                lastID = 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameMemory.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(lastID);
        this.playerID = lastID+1;
    }
    
    public double getHealth() {
        return this.health;
    }
    public void setHealth(double health) {
        this.health = health;
        double rounded = this.health;
        rounded = Math.round(rounded * 100);
        rounded = rounded/100;
        this.health = rounded;
    }
    
    public String getProgress() {
        return this.progress;
    }
    public void setProgress(String progress) {
        this.progress = progress;
    }
    
    public int getCoins() {
        return this.coins;
    }
    public void setCoins(int coins) {
        this.coins = coins;
    }
    
    public void upgradeHealth() {
        this.health += 5;
    }
 
}

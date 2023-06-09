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

/**
 *
 * @author Bradley
 */
public class SaveLoadManager {
    GameMemory gMem;
    DBManager dbManager;
    
    public SaveLoadManager() {
        gMem = GameMemory.getGMemInstance();
        dbManager = DBManager.getDBInstance();
    }
    
    public void savePlayerData() {
        Player player = gMem.player;
        int playerID = player.playerID;
        String name = player.name;
        String progressID = player.getProgress();
        double health = player.getHealth();
        int coins = player.getCoins();
        int weaponID = player.inventory.getCurrentWeapon().getID();
        int armourID = player.inventory.getCurrentArmour().getID();
        
        String insertQuery = "INSERT INTO PLAYER VALUES ("
                + playerID + ",'"
                + name + "','"
                + progressID + "',"
                + health + ","
                + coins + ","
                + weaponID + ","
                + armourID +")";
        
        dbManager.updateDB(insertQuery);
        System.out.println("Saved");
    }
    
    public void getPlayerList() {
        String selectQuery = "SELECT Name FROM PLAYER";   
         try {
            ResultSet rs = dbManager.queryDB(selectQuery);
            if(rs.next()) {
                gMem.userList.add(rs.getString("Name"));
            }  
        } catch (SQLException ex) {
            Logger.getLogger(SaveLoadManager.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}

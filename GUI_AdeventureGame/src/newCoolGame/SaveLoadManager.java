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
        String name = player.name.toLowerCase();
        String progressID = player.getProgress();
        double health = player.getHealth();
        int coins = player.getCoins();
        int weaponID = player.inventory.getCurrentWeapon().getID();
        int armourID = player.inventory.getCurrentArmour().getID();
        
        String insertQuery = "";
        String updateQuery = "";
        System.out.println(searchPlayer(name));
        if(!searchPlayer(name)) {
            insertQuery = "INSERT INTO PLAYER VALUES ("
                + playerID + ",'"
                + name + "','"
                + progressID + "',"
                + health + ","
                + coins + ","
                + weaponID + ","
                + armourID +")";
            dbManager.updateDB(insertQuery);
            System.out.println("Player Saved");
        } else {
            updateQuery = "UPDATE PLAYER SET"
                    + "PROGRESSID = '" + progressID + "',"
                    + "HEALTH = " + health + ","
                    + "COINS = " + coins + ","
                    + "WEAPONID = " + weaponID + ","
                    + "ARMOURID = " + armourID
                    + "WHERE PLAYERID = " + playerID; 
            dbManager.updateDB(updateQuery);
            System.out.println("Player Updated");
        }

        System.out.println("Saved");
    }
    
    public void getPlayerList() {
        String selectQuery = "SELECT Name FROM PLAYER";   
        try {
            ResultSet rs = dbManager.queryDB(selectQuery);
            while(rs.next()) {
                gMem.userList.add(rs.getString("Name"));
            }  
        } catch (SQLException ex) {
            Logger.getLogger(SaveLoadManager.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void retrievePlayerData(String name) {
        String selectQuery = "SELECT * FROM PLAYER WHERE NAME = '" + name +"'"; 
        try {
            ResultSet rs = dbManager.queryDB(selectQuery);
            if(rs.next()) {
                gMem.player.playerID = rs.getInt("PlayerID");
                gMem.player.name = rs.getString("Name");
                gMem.player.progress = rs.getString("progressID");
                gMem.player.health = rs.getDouble("Health");
                gMem.player.coins = rs.getInt("Coins");
                gMem.player.inventory.setCurrentWeapon((Weapon)gMem.shop.getWeapIndex(rs.getInt("WeaponID")));
                gMem.player.inventory.setCurrentArmour((Armour)gMem.shop.getArmourIndex(rs.getInt("ArmourID")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaveLoadManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public boolean searchPlayer(String name) {
        String selectQuery = "SELECT * FROM PLAYER WHERE NAME = '" + name +"'";
        ResultSet rs = dbManager.queryDB(selectQuery);
        try {
            if(rs.next()) {
                return true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import Database.DBManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bradley
 */
public class GameMemory {
    
    Player player;
    Inventory inventory;
    Shop shop;
    DBManager dbManager;
    GameMemory gameMemInstance;
    HashMap<String, Enemy> enemies;
    private static GameMemory gameMemoryInstance;
    ArrayList<String> userList;
    SaveLoadManager slManager;
    
    private GameMemory(){}
    
    public static synchronized GameMemory getGMemInstance() {
        if(gameMemoryInstance == null) {
            gameMemoryInstance = new GameMemory();   
        }
        
        return gameMemoryInstance;
    }
    
    public void gMemSetup() {
        gameMemoryInstance.player = Player.getPlayerInstance();
        gameMemoryInstance.inventory = Inventory.getInvInstance();
        gameMemoryInstance.shop = Shop.getShopInstance();
        gameMemoryInstance.dbManager = DBManager.getDBInstance();
        gameMemoryInstance.enemies = new HashMap<>();
        gameMemoryInstance.userList = new ArrayList<>();
        gameMemoryInstance.slManager = new SaveLoadManager();
    }
    
    public void resetMem() {
        gameMemoryInstance = new GameMemory();
    }
    
    public void queryShopUpgrades() {
        this.queryWeaponUpgrades();
        this.queryArmourUpgrades();
    }
    
    private void queryWeaponUpgrades() {
        String selectQuery = "SELECT * FROM WEAPON";
        
        try {
            ResultSet rs = dbManager.queryDB(selectQuery);
            while(rs.next()) {
                int id = rs.getInt("WeaponID");
                String name = rs.getString("Name");
                int stat = rs.getInt("Stat");
                int price = rs.getInt("Price");
                shop.addWeaponUpgrade(new Weapon(id, name, stat, price));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameMemory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void queryArmourUpgrades() {
        String selectQuery = "SELECT * FROM ARMOUR";
        
        try {
            ResultSet rs = dbManager.queryDB(selectQuery);
            while(rs.next()) {
                int id = rs.getInt("ArmourID");
                String name = rs.getString("Name");
                int stat = rs.getInt("Stat");
                int price = rs.getInt("Price");
                shop.addArmourUpgrade(new Armour(id, name, stat, price));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameMemory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void queryEnemies() {
        String selectQuery = "SELECT * FROM ENEMY";
        try {
            ResultSet rs = dbManager.queryDB(selectQuery);
            while(rs.next()) {
                int id = rs.getInt("EnemyID");
                String name = rs.getString("EnemyName");
                int health = rs.getInt("Health");
                int damage = rs.getInt("Damage");
                int coins = rs.getInt("Coins");
                enemies.put(name, new Enemy(id, name, health, damage, coins));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameMemory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void createNewPlayer(String name) {
        player.name = name;
        inventory.setCurrentWeapon((Weapon)shop.getWeapIndex(0));
        inventory.setCurrenArmour((Armour)shop.getArmourIndex(0));
        System.out.println("New player");
    }
    
    public Enemy getEnemy(String enemyName) {
        System.out.println(enemies.get(enemyName));
        return enemies.get(enemyName);
    }
}

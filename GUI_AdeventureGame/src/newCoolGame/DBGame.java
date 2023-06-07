/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import java.sql.Connection;
import java.sql.Statement;
import javax.management.Query;

/**
 *
 * @author Bradley
 */
public class DBGame {
    private final DBManager dbManager;
//    private final Connection conn;
//    private Statement stmt;
    
    public DBGame() {
        dbManager = new DBManager();
//        conn = dbManager.getConnection();
    }
    
    public void createPlayerTable() {
        String createQuery = "CREATE TABLE PLAYER ("
                + "PLAYERID INT,"
                + "NAME VARCHAR(255),"
                + "PROGRESSID VARCHAR(255),"
                + "HEALTH INT, COINS INT,"
                + "WEAPONID INT,"
                + "ARMOURID INT)";
        
        dbManager.updateDB(createQuery);
    }
    
    public void createWeaponTable() {
        String createQuery = "CREATE TABLE WEAPON ("
                + "WeaponID INT,"
                + "Name VARCHAR(255),"
                + "Stat INT,"
                + "Price INT)";
        String insertQuery = "INSERT INTO WEAPON VALUES "
                + "(1, 'Stick', 5, 0),"
                + "(2, 'Spear', 10, 10),"
                + "(3, 'Axe', 15, 20),"
                + "(4, 'Sword', 20, 30),";

        dbManager.updateDB(createQuery);
        dbManager.updateDB(insertQuery);
    }
    
    public void createArmourTable() {
        String createQuery = "CREATE TABLE ARMOUR ("
                + "WeaponID INT,"
                + "Name VARCHAR(255),"
                + "Stat INT,"
                + "Price INT)";
        String insertQuery = "INSERT INTO ARMOUR VALUES "
                + "(1, 'Cloth', 5, 0),"
                + "(2, 'Leather', 10, 10),"
                + "(3, 'Chain', 15, 20),"
                + "(4, 'Iron', 20, 30),";

        dbManager.updateDB(createQuery);
        dbManager.updateDB(insertQuery);
    }
    
    public void createEnemyTable() {
        String createQuery = "CREATE TABLE ENEMY ("
                + "EnemyID INT,"
                + "EnemyName VARCHAR(255),"
                + "Health INT,"
                + "Damage INT,"
                + "Coins INT)";
        String insertQuery = "INSERT INTO ARMOUR VALUES "
                + "(1, 'Sand Crab', 10, 2, 4),"
                + "(2, 'Zombie', 12, 4, 6),"
                + "(3, 'Skeleton', 14, 6, 8),"
                + "(4, 'Armoured Crab', 18, 8, 15),"
                + "(5, 'Undying', 35, 9, 10),"
                + "(6, 'Cannibal', 35, 6, 10),"
                + "(7, 'Avatik', 55, 12, 20),";

        dbManager.updateDB(createQuery);
        dbManager.updateDB(insertQuery);
    }
}

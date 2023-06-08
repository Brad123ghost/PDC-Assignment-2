/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

/**
 *
 * @author Bradley
 */
public class DBGame {
    private final DBManager dbManager;
    private final Connection conn;
//    private Statement stmt;
    
    public DBGame() {
        dbManager = DBManager.getDBInstance();
        conn = dbManager.getConnection();
    }
    
    public void dbSetUp() {
        if(!this.checkDBTable("PLAYER")) {
            this.createPlayerTable();
        }

        this.createWeaponTable();
        this.createArmourTable();
        this.createEnemyTable();
    }
    
    private void createPlayerTable() {
        String createQuery = "CREATE TABLE PLAYER ("
                + "PLAYERID INT,"
                + "NAME VARCHAR(255),"
                + "PROGRESSID VARCHAR(255),"
                + "HEALTH INT, COINS INT,"
                + "WEAPONID INT,"
                + "ARMOURID INT)";
        
        dbManager.updateDB(createQuery);
    }
    
    private void createWeaponTable() {
        this.dropTable("WEAPON");
        String createQuery = "CREATE TABLE WEAPON ("
                + "WeaponID INT,"
                + "Name VARCHAR(255),"
                + "Stat INT,"
                + "Price INT)";
        String insertQuery = "INSERT INTO WEAPON VALUES "
                + "(1, 'Stick', 5, 0),"
                + "(2, 'Spear', 10, 10),"
                + "(3, 'Axe', 15, 20),"
                + "(4, 'Sword', 20, 30)";

        dbManager.updateDB(createQuery);
        dbManager.updateDB(insertQuery);
    }
    
    private void createArmourTable() {
        this.dropTable("ARMOUR");
        String createQuery = "CREATE TABLE ARMOUR ("
                + "ArmourID INT,"
                + "Name VARCHAR(255),"
                + "Stat INT,"
                + "Price INT)";
        String insertQuery = "INSERT INTO ARMOUR VALUES "
                + "(1, 'Cloth', 5, 0),"
                + "(2, 'Leather', 10, 10),"
                + "(3, 'Chain', 15, 20),"
                + "(4, 'Iron', 20, 30)";

        dbManager.updateDB(createQuery);
        dbManager.updateDB(insertQuery);
    }
    
    private void createEnemyTable() {
        this.dropTable("ENEMY");
        String createQuery = "CREATE TABLE ENEMY ("
                + "EnemyID INT,"
                + "EnemyName VARCHAR(255),"
                + "Health INT,"
                + "Damage INT,"
                + "Coins INT)";
        String insertQuery = "INSERT INTO ENEMY VALUES "
                + "(1, 'Sand Crab', 10, 2, 4),"
                + "(2, 'Zombie', 12, 4, 6),"
                + "(3, 'Skeleton', 14, 6, 8),"
                + "(4, 'Armoured Crab', 18, 8, 15),"
                + "(5, 'Undying', 35, 9, 10),"
                + "(6, 'Cannibal', 35, 6, 10),"
                + "(7, 'Avatik', 55, 12, 20)";

        dbManager.updateDB(createQuery);
        dbManager.updateDB(insertQuery);
    }

//    public boolean checkExistingDB() {
//        try {
//            DatabaseMetaData dbmd = conn.getMetaData();
//            ResultSet rs = databaseMetadata.getTables(null)
//        } catch (SQLException ex) {
//            Logger.getLogger(DBGame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return false;
//    }
      
    
    private boolean checkDBTable(String tableName) {
        try {
            DatabaseMetaData databaseMetadata = conn.getMetaData();
            ResultSet rs = databaseMetadata.getTables(null, null, tableName, null);
            if(rs.next()) {
                return true;
            }  
        } catch (SQLException ex) {
            Logger.getLogger(DBGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private void dropTable(String tableName) {
        try {
            DatabaseMetaData databaseMetadata = conn.getMetaData();
            ResultSet rs = databaseMetadata.getTables(null, null, tableName, null);
            if(rs.next()) {
                String query = "DROP TABLE " + tableName;
                dbManager.updateDB(query); 
            }  
        } catch (SQLException ex) {
            Logger.getLogger(DBGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

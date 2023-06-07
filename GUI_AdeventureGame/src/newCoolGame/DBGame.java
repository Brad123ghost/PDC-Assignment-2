/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Bradley
 */
public class DBGame {
    private final DBManager dbManager;
    private final Connection conn;
    private Statement stmt;
    
    public DBGame() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }
}

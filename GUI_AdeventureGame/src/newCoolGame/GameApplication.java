/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

/**
 *
 * @author Bradley
 */
public class GameApplication {
    public static void main(String[] args) {
        DBGame gameDB = new DBGame();
        gameDB.dbSetUp();
        GameFrame game = new GameFrame();
    }
}

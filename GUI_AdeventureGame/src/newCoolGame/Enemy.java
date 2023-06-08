/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

/**
 *
 * @author Bradley
 */
public class Enemy {
    private int id;
    private String name;
    private double health;
    private int atkDamage;
    private int coins;
    
    public Enemy(int id, String name, int health, int atkDamage, int coins) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.atkDamage = atkDamage;
        this.coins = coins;
    }
    
    public String getName() {
        return name;
    }
    public double getHealth() {
        return health;
    }
    public void setHealth(double health) {
        this.health = health;
    }
    public int getAtkDamage() {
        return atkDamage;
    }
    public int getCoins() {
        return coins;
    }
}

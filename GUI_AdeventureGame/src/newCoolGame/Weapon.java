/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

/**
 *
 * @author Bradley
 */
public class Weapon extends Node{
    public Weapon(int id, String name, int stat, int price) {
        super(id, name, stat, price);
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
    
}

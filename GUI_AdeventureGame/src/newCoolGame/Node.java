/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

/**
 *
 * @author Bradley
 */
public abstract class Node {
    private int id;
    private String name;
    private int stat;
    private int price;
    
    public Node(int id, String name, int stat, int price) {
        this.id = id;
        this.name = name;
        this.stat = stat;
        this.price = price;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    public int getStat() {
        return this.stat;
    }
}

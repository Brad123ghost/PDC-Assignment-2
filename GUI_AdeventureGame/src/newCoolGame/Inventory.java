/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import java.util.ArrayList;

/**
 *
 * @author Bradley
 */
public class Inventory {
    static Inventory invInstance;
    private static Weapon currentWeapon;
    private static Armour currentArmour;
    private Inventory(){};
    
    public static synchronized Inventory getInvInstance() {
        if(invInstance == null) {
            invInstance = new Inventory();
        }
        return invInstance;
    }
    
    
    public void setCurrentWeapon(Weapon weapon) {
        currentWeapon = weapon;
    }
    public void setCurrenArmour(Armour armour) {
        currentArmour = armour;
    }
}

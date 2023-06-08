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
public class Shop {
    private ArrayList<Node> weaponUpgrades;
    private ArrayList<Node> armourUpgrades;
    
    public Shop() {
        weaponUpgrades = new ArrayList<>();
        armourUpgrades = new ArrayList<>();
    }
    
    public void addWeaponUpgrade(Weapon weapon) {
        weaponUpgrades.add(weapon);
    }
    public void addArmourUpgrade(Armour armour) {
        armourUpgrades.add(armour);
    }
    
    public ArrayList<Node> getWeapUpgrades() {
        return this.weaponUpgrades;
    }
    
    public ArrayList<Node> getArmourUpgrades() {
        return this.armourUpgrades;
    }
}

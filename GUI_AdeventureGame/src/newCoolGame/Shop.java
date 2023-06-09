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
    private Shop() {};
    static Shop shopInstance;
    
    public static synchronized Shop getShopInstance() {
        if(shopInstance == null) {
            shopInstance = new Shop();
            shopInstance.weaponUpgrades = new ArrayList<>();
            shopInstance.armourUpgrades = new ArrayList<>();
        }
        return shopInstance;
    }
    
    
    public void addWeaponUpgrade(Weapon weapon) {
        weaponUpgrades.add(weapon);
    }
    public void addArmourUpgrade(Armour armour) {
        armourUpgrades.add(armour);
    }
    
    public ArrayList<Node> getWeapUpgradesList() {
        return this.weaponUpgrades;
    }
    
    public ArrayList<Node> getArmourUpgradesList() {
        return this.armourUpgrades;
    }
    
    public Node getWeapIndex(int index) {
        return weaponUpgrades.get(index);
    }
    
    public Node getArmourIndex(int index) {
        return armourUpgrades.get(index);
    }
}

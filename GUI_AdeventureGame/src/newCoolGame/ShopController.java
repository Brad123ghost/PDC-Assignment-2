/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newCoolGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Bradley
 */
public class ShopController {
    GameMemory gMemory;
    GameFrame currentGFrame;
    Shop shop;
    Player player;
    Inventory inv;
    private int coins;
    private Weapon nextWeap;
    private Armour nextArmour;
    
    ShopPanel sPanel;
    
    public ShopController(GameFrame currentGFrame, ShopPanel sPanel) {
        gMemory = GameMemory.getGMemInstance();
        shop = Shop.getShopInstance();
        player = Player.getPlayerInstance();
        inv = Inventory.getInvInstance();
        
        this.currentGFrame = currentGFrame;
        this.sPanel = sPanel;
        
        this.addShopPanelListeners();
    }
    
    public void updateUpgrades() {
        Weapon currentWeap = inv.getCurrentWeapon();
        Armour currentArm = inv.getCurrentArmour();
        int weapSize = shop.getWeapUpgradesList().size();
        int armourSize = shop.getArmourUpgradesList().size();
        
        int currentWeapID = currentWeap.getID();
        int currentArmourID = currentArm.getID();
        
        if(currentWeapID < weapSize) {
            nextWeap = (Weapon) shop.getWeapIndex(currentWeapID);
            sPanel.getUpgradeWeaponBtn().setText(nextWeap.getName() + " +" + nextWeap.getStat() + " Dmg - " + nextWeap.getPrice() + " Coins");
        } else{
            sPanel.getUpgradeWeaponBtn().setText("Max Upgrades");
            sPanel.getUpgradeWeaponBtn().setEnabled(false);
        }
        
        if(currentArmourID < armourSize) {
            nextArmour = (Armour) shop.getArmourIndex(currentArmourID);
            sPanel.getUpgradeArmourBtn().setText(nextArmour.getName() + " +" + nextArmour.getStat() + " Def - " + nextArmour.getPrice() + " Coins");
        } else{
            sPanel.getUpgradeArmourBtn().setText("Max Upgrades");
            sPanel.getUpgradeArmourBtn().setEnabled(false);
        }
        
        
    }
    
    public void eventHandlePause() {
        currentGFrame.setMenuState(State.PAUSE_GAME);
        currentGFrame.checkState();
    }
    
    public void eventHandleWeapon() {
        int upgradePrice = nextWeap.getPrice();
        coins = player.getCoins();
        
        if(coins > upgradePrice) {
            sPanel.setMessage("Weapon Upgraded");
            player.setCoins(coins - upgradePrice);
            inv.setCurrentWeapon(nextWeap);
            sPanel.updateStats();
            this.updateUpgrades();
        } else {
            sPanel.setMessage("You do not have enough coins");
        }
        sPanel.update();
    }
    
    public void eventHandleArmour() {
        int upgradePrice = nextArmour.getPrice();
        coins = player.getCoins();
        
        if(coins > upgradePrice) {
            sPanel.setMessage("Armour Upgraded");
            player.setCoins(coins - upgradePrice);
            inv.setCurrentArmour(nextArmour);
            sPanel.updateStats();
            this.updateUpgrades();
        } else {
            sPanel.setMessage("You do not have enough coins");
        }
        sPanel.update();
    }
    
    public void eventHandleHealth() {
        int upgradePrice = 5;
        coins = player.getCoins();
        
        if(coins > upgradePrice) {
            sPanel.setMessage("Health Upgraded");
            player.setCoins(coins - upgradePrice);
            player.setHealth(player.getHealth() + 5);
            sPanel.updateStats();
            this.updateUpgrades();
        } else {
            sPanel.setMessage("You do not have enough coins");
        }
        sPanel.update();
    }
    
    public void eventHandleExitShop() {
        sPanel.setMessage("");
        currentGFrame.setMenuState(State.GAME_RESUME);
        currentGFrame.checkState();
    }
    public void addShopPanelListeners() {
        sPanel.getPauseScreenBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandlePause();
            }
        });
        
        sPanel.getUpgradeWeaponBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleWeapon();
            }
        });
        sPanel.getUpgradeArmourBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleArmour();
            }
        });
        sPanel.getUpgradeHealthBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleHealth();
            }
        });
        sPanel.getExitShopBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandleExitShop();
            }
        });
    }
}

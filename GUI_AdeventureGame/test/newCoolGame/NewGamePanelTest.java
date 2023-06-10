/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package newCoolGame;

import Database.DBGame;
import Database.DBManager;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bradley
 */
public class NewGamePanelTest {
    DBManager dbManager;
    GameFrame instance;
    public NewGamePanelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DBGame gameDB = new DBGame();
        gameDB.dbSetUp();
        dbManager = DBManager.getDBInstance();
        instance = new GameFrame();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Testing for a 'Space' character in name field
     */
    @Test
    public void testInvalidNameSpaces() {
        JTextField nameField = instance.getNewGamePanel().getNameField();
        nameField.setText("Test Name");
        JButton startBtn = instance.getNewGamePanel().getStartBtn();
        startBtn.doClick();
        
        String expResult = "Invalid Input!";
        String result = instance.getNewGamePanel().getErrorMsgOne().getText();
        assertEquals(expResult, result);
    }
    
    /**
     * Testing for a number in name field
     */
    @Test
    public void testInvalidNameNumbers() {
        JTextField nameField = instance.getNewGamePanel().getNameField();
        nameField.setText("Test123");
        JButton startBtn = instance.getNewGamePanel().getStartBtn();
        startBtn.doClick();
        
        String expResult = "Invalid Input!";
        String result = instance.getNewGamePanel().getErrorMsgOne().getText();
        assertEquals(expResult, result);
    }
    
    /**
     * Testing for no input in name field
     */
    @Test
    public void testInvalidNameNoInput() {
        JTextField nameField = instance.getNewGamePanel().getNameField();
        nameField.setText("");
        JButton startBtn = instance.getNewGamePanel().getStartBtn();
        startBtn.doClick();
        
        String expResult = "Invalid Input!";
        String result = instance.getNewGamePanel().getErrorMsgOne().getText();
        assertEquals(expResult, result);
    }
    
    /**
     * Testing for duplicate/existing player
     */
    @Test
    public void testNameDuplicatesAndSave() {
        dbManager.updateDB("DELETE FROM PLAYER WHERE NAME = 'realuser'");
        // First user
        JTextField nameField = instance.getNewGamePanel().getNameField();
        nameField.setText("realuser");
        JButton startBtn = instance.getNewGamePanel().getStartBtn();
        startBtn.doClick();
        
        // Save
        JButton saveAndExit = instance.getPausedPanel().getSEBtn();
        saveAndExit.doClick();
        
        // Second User
        JTextField newNameField = instance.getNewGamePanel().getNameField();
        newNameField.setText("realuser");
        JButton newStartBtn = instance.getNewGamePanel().getStartBtn();
        newStartBtn.doClick();
        
        String expResult = "Player already exist!";
        String result = instance.getNewGamePanel().getErrorMsgTwo().getText();
        assertEquals(expResult, result);
    }
    
    /**
     * Testing for health upgrade.
     */
    @Test
    public void testSuccessfulHealthUpgrade() {
        dbManager.updateDB("DELETE FROM PLAYER WHERE NAME = 'realuser'");
        JTextField nameField = instance.getNewGamePanel().getNameField();
        nameField.setText("realuser");
        JButton startBtn = instance.getNewGamePanel().getStartBtn();
        startBtn.doClick();
        
        // Give player 5 coins to test health upgrade
        instance.gMemory.player.setCoins(5);
        JButton upgradeHealthBtn = instance.getShopPanel().getUpgradeHealthBtn();
        upgradeHealthBtn.doClick();
        
        double expResult = 105.0;
        double result = instance.gMemory.player.getHealth();
        assertEquals(expResult, result, 0.0000001);
    }
    
    /**
     * Testing for health upgrade.
     */
    @Test
    public void testUnsuccessfulUpgrade() {
        dbManager.updateDB("DELETE FROM PLAYER WHERE NAME = 'realuser'");
        JTextField nameField = instance.getNewGamePanel().getNameField();
        nameField.setText("realuser");
        JButton startBtn = instance.getNewGamePanel().getStartBtn();
        startBtn.doClick();
        
        // Give player 5 coins to test health upgrade
        instance.gMemory.player.setCoins(4);
        JButton upgradeHealthBtn = instance.getShopPanel().getUpgradeHealthBtn();
        upgradeHealthBtn.doClick();
        
        String expResult = "You do not have enough coins";
        String result = instance.getShopPanel().getMessage();
        
 
        assertEquals(expResult, result);
    }
    
}

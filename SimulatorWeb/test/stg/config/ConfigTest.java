/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stg.config;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 490501
 */
public class ConfigTest {
    
    public ConfigTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getParameter method, of class Config.
     */
    @Test
    public void testGetParameter() {
        System.out.println("getParameter");
        String key = "";
        Config instance = null;
        try {
            instance = new Config();
        } catch (IOException ex) {
            Logger.getLogger(ConfigTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String expResult = "";
        String result = instance.getParameter(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveProperty method, of class Config.
     */
    @Test
    public void testSaveProperty() throws Exception {
        System.out.println("saveProperty");
        String key = "";
        String value = "";
        Config instance = new Config();
        instance.saveProperty(key, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Config.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Config.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

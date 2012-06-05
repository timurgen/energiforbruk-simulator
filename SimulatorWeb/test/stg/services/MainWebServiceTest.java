/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stg.services;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 490501
 */
public class MainWebServiceTest {
    
    public MainWebServiceTest() {
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
     * Test of autentificate method, of class MainWebService.
     */
    @Test
    public void testAutentificate() {
        System.out.println("autentificate");
        String username = "";
        String password = "";
        MainWebService instance = new MainWebService();
        String expResult = "";
        String result = instance.autentificate(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

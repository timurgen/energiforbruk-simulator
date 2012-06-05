/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnectors;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 490501
 */
public class UserDBTest {
    
    public UserDBTest() {
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
     * Test of getAllU method, of class UserDB.
     */
    @Test
    public void testGetAllU() {
        System.out.println("getAllU");
        UserDB instance = new UserDB();
        instance.getAllU();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIfUsernameExists method, of class UserDB.
     */
    @Test
    public void testCheckIfUsernameExists() {
        System.out.println("checkIfUsernameExists");
        String name = "";
        UserDB instance = new UserDB();
        boolean expResult = false;
        boolean result = instance.checkIfUsernameExists(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIfEmailExists method, of class UserDB.
     */
    @Test
    public void testCheckIfEmailExists() {
        System.out.println("checkIfEmailExists");
        String email = "";
        UserDB instance = new UserDB();
        boolean expResult = false;
        boolean result = instance.checkIfEmailExists(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

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
public class MysqlAdapterTest {
    
    public MysqlAdapterTest() {
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
     * Test of checkIfNameExists method, of class MysqlAdapter.
     */
    @Test
    public void testCheckIfNameExists() throws Exception {
        System.out.println("checkIfNameExists");
        String name = "";
        MysqlAdapter instance = new MysqlAdapter();
        boolean expResult = false;
        boolean result = instance.checkIfNameExists(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIfEmailExists method, of class MysqlAdapter.
     */
    @Test
    public void testCheckIfEmailExists() throws Exception {
        System.out.println("checkIfEmailExists");
        String email = "";
        MysqlAdapter instance = new MysqlAdapter();
        boolean expResult = false;
        boolean result = instance.checkIfEmailExists(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUserToDataBase method, of class MysqlAdapter.
     */
    @Test
    public void testAddUserToDataBase() throws Exception {
        System.out.println("addUserToDataBase");
        String name = "";
        String email = "";
        String password = "";
        MysqlAdapter instance = new MysqlAdapter();
        boolean expResult = false;
        boolean result = instance.addUserToDataBase(name, email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of autentificateUser method, of class MysqlAdapter.
     */
    @Test
    public void testAutentificateUser() throws Exception {
        System.out.println("autentificateUser");
        String name = "";
        String password = "";
        MysqlAdapter instance = new MysqlAdapter();
        int expResult = 0;
        int result = instance.autentificateUser(name, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStandarts method, of class MysqlAdapter.
     */
    @Test
    public void testGetStandarts() throws Exception {
        System.out.println("getStandarts");
        MysqlAdapter instance = new MysqlAdapter();
        instance.getStandarts();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MysqlAdapter.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        MysqlAdapter.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

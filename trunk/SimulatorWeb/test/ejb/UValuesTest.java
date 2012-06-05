/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 490501
 */
public class UValuesTest {
    
    public UValuesTest() {
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
     * Test of getName method, of class UValues.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        UValues instance = new UValues();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class UValues.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        UValues instance = new UValues();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOuterWall method, of class UValues.
     */
    @Test
    public void testGetOuterWall() {
        System.out.println("getOuterWall");
        UValues instance = new UValues();
        double expResult = 0.0;
        double result = instance.getOuterWall();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOuterWall method, of class UValues.
     */
    @Test
    public void testSetOuterWall() {
        System.out.println("setOuterWall");
        double outerWall = 0.0;
        UValues instance = new UValues();
        instance.setOuterWall(outerWall);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoof method, of class UValues.
     */
    @Test
    public void testGetRoof() {
        System.out.println("getRoof");
        UValues instance = new UValues();
        double expResult = 0.0;
        double result = instance.getRoof();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoof method, of class UValues.
     */
    @Test
    public void testSetRoof() {
        System.out.println("setRoof");
        double roof = 0.0;
        UValues instance = new UValues();
        instance.setRoof(roof);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFloor method, of class UValues.
     */
    @Test
    public void testGetFloor() {
        System.out.println("getFloor");
        UValues instance = new UValues();
        double expResult = 0.0;
        double result = instance.getFloor();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFloor method, of class UValues.
     */
    @Test
    public void testSetFloor() {
        System.out.println("setFloor");
        double floor = 0.0;
        UValues instance = new UValues();
        instance.setFloor(floor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDoorsAndWindows method, of class UValues.
     */
    @Test
    public void testGetDoorsAndWindows() {
        System.out.println("getDoorsAndWindows");
        UValues instance = new UValues();
        double expResult = 0.0;
        double result = instance.getDoorsAndWindows();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDoorsAndWindows method, of class UValues.
     */
    @Test
    public void testSetDoorsAndWindows() {
        System.out.println("setDoorsAndWindows");
        double doorsAndWindows = 0.0;
        UValues instance = new UValues();
        instance.setDoorsAndWindows(doorsAndWindows);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class UValues.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UValues instance = new UValues();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class UValues.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UValues instance = new UValues();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UValues.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UValues instance = new UValues();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

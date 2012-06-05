/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author 490501
 */
public class SurfaceTest {
    
    public SurfaceTest() {
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
     * Test of addWindow method, of class Surface.
     */
    @Test
    public void testAddWindow() throws Exception {
        System.out.println("addWindow");
        double dimXint = 0.0;
        double dimYint = 0.0;
        double uValue = 0.0;
        Surface instance = new Surface();
        instance.addWindow(dimXint, dimYint, uValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeWindow method, of class Surface.
     */
    @Test
    public void testRemoveWindow_int() {
        System.out.println("removeWindow");
        int i = 0;
        Surface instance = new Surface();
        instance.removeWindow(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeWindow method, of class Surface.
     */
    @Test
    public void testRemoveWindow_Surface() {
        System.out.println("removeWindow");
        Surface s = null;
        Surface instance = new Surface();
        instance.removeWindow(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeHeatLoss method, of class Surface.
     */
    @Test
    public void testComputeHeatLoss_double_double() {
        System.out.println("computeHeatLoss");
        double tempInside = 0.0;
        double tempOutside = 0.0;
        Surface instance = new Surface();
        double expResult = 0.0;
        double result = instance.computeHeatLoss(tempInside, tempOutside);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeHeatLoss method, of class Surface.
     */
    @Test
    public void testComputeHeatLoss_double() {
        System.out.println("computeHeatLoss");
        double tempDifference = 0.0;
        Surface instance = new Surface();
        double expResult = 0.0;
        double result = instance.computeHeatLoss(tempDifference);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeHeatLoss method, of class Surface.
     */
    @Test
    public void testComputeHeatLoss_0args() {
        System.out.println("computeHeatLoss");
        Surface instance = new Surface();
        double expResult = 0.0;
        double result = instance.computeHeatLoss();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeConsumption method, of class Surface.
     */
    @Test
    public void testComputeConsumption() {
        System.out.println("computeConsumption");
        int hours = 0;
        Surface instance = new Surface();
        Double[] expResult = null;
        Double[] result = instance.computeConsumption(hours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTempSequence method, of class Surface.
     */
    @Test
    public void testCreateTempSequence() throws Exception {
        System.out.println("createTempSequence");
        double[] tempInside = null;
        double[] tempOutside = null;
        Surface instance = new Surface();
        instance.createTempSequence(tempInside, tempOutside);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countSquareOfWindows method, of class Surface.
     */
    @Test
    public void testCountSquareOfWindows() {
        System.out.println("countSquareOfWindows");
        Surface instance = new Surface();
        double expResult = 0.0;
        double result = instance.countSquareOfWindows();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDimX method, of class Surface.
     */
    @Test
    public void testGetDimX() {
        System.out.println("getDimX");
        Surface instance = new Surface();
        double expResult = 0.0;
        double result = instance.getDimX();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDimX method, of class Surface.
     */
    @Test
    public void testSetDimX() {
        System.out.println("setDimX");
        double dimX = 0.0;
        Surface instance = new Surface();
        instance.setDimX(dimX);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDimY method, of class Surface.
     */
    @Test
    public void testGetDimY() {
        System.out.println("getDimY");
        Surface instance = new Surface();
        double expResult = 0.0;
        double result = instance.getDimY();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDimY method, of class Surface.
     */
    @Test
    public void testSetDimY() {
        System.out.println("setDimY");
        double dimY = 0.0;
        Surface instance = new Surface();
        instance.setDimY(dimY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrientation method, of class Surface.
     */
    @Test
    public void testGetOrientation() {
        System.out.println("getOrientation");
        Surface instance = new Surface();
        char expResult = ' ';
        char result = instance.getOrientation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrientation method, of class Surface.
     */
    @Test
    public void testSetOrientation() {
        System.out.println("setOrientation");
        char orientation = ' ';
        Surface instance = new Surface();
        instance.setOrientation(orientation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSquare method, of class Surface.
     */
    @Test
    public void testGetSquare() {
        System.out.println("getSquare");
        Surface instance = new Surface();
        double expResult = 0.0;
        double result = instance.getSquare();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSquare method, of class Surface.
     */
    @Test
    public void testSetSquare() {
        System.out.println("setSquare");
        double square = 0.0;
        Surface instance = new Surface();
        instance.setSquare(square);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getuValue method, of class Surface.
     */
    @Test
    public void testGetuValue() {
        System.out.println("getuValue");
        Surface instance = new Surface();
        double expResult = 0.0;
        double result = instance.getuValue();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setuValue method, of class Surface.
     */
    @Test
    public void testSetuValue() {
        System.out.println("setuValue");
        double uValue = 0.0;
        Surface instance = new Surface();
        instance.setuValue(uValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWindows method, of class Surface.
     */
    @Test
    public void testGetWindows() {
        System.out.println("getWindows");
        Surface instance = new Surface();
        ArrayList expResult = null;
        ArrayList result = instance.getWindows();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWindows method, of class Surface.
     */
    @Test
    public void testSetWindows() {
        System.out.println("setWindows");
        ArrayList<Surface> windows = null;
        Surface instance = new Surface();
        instance.setWindows(windows);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempDifference method, of class Surface.
     */
    @Test
    public void testGetTempDifference() {
        System.out.println("getTempDifference");
        Surface instance = new Surface();
        double expResult = 0.0;
        double result = instance.getTempDifference();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTempDifference method, of class Surface.
     */
    @Test
    public void testSetTempDifference() {
        System.out.println("setTempDifference");
        double tempDifference = 0.0;
        Surface instance = new Surface();
        instance.setTempDifference(tempDifference);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempDifferences method, of class Surface.
     */
    @Test
    public void testGetTempDifferences() {
        System.out.println("getTempDifferences");
        Surface instance = new Surface();
        double[] expResult = null;
        double[] result = instance.getTempDifferences();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTempDifferences method, of class Surface.
     */
    @Test
    public void testSetTempDifferences() {
        System.out.println("setTempDifferences");
        double[] tempDifferences = null;
        Surface instance = new Surface();
        instance.setTempDifferences(tempDifferences);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Surface.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Surface instance = new Surface();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

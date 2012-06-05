/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 490501
 */
public class SimulationUnitTest {
    
    public SimulationUnitTest() {
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
     * Test of computeConsumption method, of class SimulationUnit.
     */
    @Test
    public void testComputeConsumption() {
        System.out.println("computeConsumption");
        int hours = 0;
        SimulationUnit instance = new SimulationUnit();
        Double[] expResult = null;
        Double[] result = instance.computeConsumption(hours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeHeatLoss method, of class SimulationUnit.
     */
    @Test
    public void testComputeHeatLoss_double_double() {
        System.out.println("computeHeatLoss");
        double tempInside = 0.0;
        double tempOutside = 0.0;
        SimulationUnit instance = new SimulationUnit();
        double expResult = 0.0;
        double result = instance.computeHeatLoss(tempInside, tempOutside);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeHeatLoss method, of class SimulationUnit.
     */
    @Test
    public void testComputeHeatLoss_double() {
        System.out.println("computeHeatLoss");
        double tempDifference = 0.0;
        SimulationUnit instance = new SimulationUnit();
        double expResult = 0.0;
        double result = instance.computeHeatLoss(tempDifference);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeHeatLoss method, of class SimulationUnit.
     */
    @Test
    public void testComputeHeatLoss_0args() {
        System.out.println("computeHeatLoss");
        SimulationUnit instance = new SimulationUnit();
        double expResult = 0.0;
        double result = instance.computeHeatLoss();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addWall method, of class SimulationUnit.
     */
    @Test
    public void testAddWall() {
        System.out.println("addWall");
        Surface s = null;
        SimulationUnit instance = new SimulationUnit();
        instance.addWall(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFloor method, of class SimulationUnit.
     */
    @Test
    public void testAddFloor() {
        System.out.println("addFloor");
        Surface s = null;
        SimulationUnit instance = new SimulationUnit();
        instance.addFloor(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSurface method, of class SimulationUnit.
     */
    @Test
    public void testRemoveSurface_int() {
        System.out.println("removeSurface");
        int i = 0;
        SimulationUnit instance = new SimulationUnit();
        instance.removeSurface(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSurface method, of class SimulationUnit.
     */
    @Test
    public void testRemoveSurface_Surface() {
        System.out.println("removeSurface");
        Surface s = null;
        SimulationUnit instance = new SimulationUnit();
        instance.removeSurface(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeSquareIfFloorDoesntExist method, of class SimulationUnit.
     */
    @Test
    public void testComputeSquareIfFloorDoesntExist() {
        System.out.println("computeSquareIfFloorDoesntExist");
        SimulationUnit instance = new SimulationUnit();
        instance.computeSquareIfFloorDoesntExist();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeTempDifferenceFromInsideTempAndOutSideTemp method, of class SimulationUnit.
     */
    @Test
    public void testComputeTempDifferenceFromInsideTempAndOutSideTemp() throws Exception {
        System.out.println("computeTempDifferenceFromInsideTempAndOutSideTemp");
        SimulationUnit instance = new SimulationUnit();
        instance.computeTempDifferenceFromInsideTempAndOutSideTemp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newVentilation method, of class SimulationUnit.
     */
    @Test
    public void testNewVentilation() {
        System.out.println("newVentilation");
        SimulationUnit instance = new SimulationUnit();
        instance.newVentilation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addVentilation method, of class SimulationUnit.
     */
    @Test
    public void testAddVentilation() {
        System.out.println("addVentilation");
        Ventilation v = null;
        SimulationUnit instance = new SimulationUnit();
        instance.addVentilation(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveAsTxt method, of class SimulationUnit.
     */
    @Test
    public void testSaveAsTxt() {
        System.out.println("saveAsTxt");
        SimulationUnit instance = new SimulationUnit();
        instance.saveAsTxt();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadFromTxt method, of class SimulationUnit.
     */
    @Test
    public void testLoadFromTxt() {
        System.out.println("loadFromTxt");
        String path = "";
        SimulationUnit instance = new SimulationUnit();
        instance.loadFromTxt(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSquare method, of class SimulationUnit.
     */
    @Test
    public void testGetSquare() {
        System.out.println("getSquare");
        SimulationUnit instance = new SimulationUnit();
        double expResult = 0.0;
        double result = instance.getSquare();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSquare method, of class SimulationUnit.
     */
    @Test
    public void testSetSquare() {
        System.out.println("setSquare");
        double square = 0.0;
        SimulationUnit instance = new SimulationUnit();
        instance.setSquare(square);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSurfaces method, of class SimulationUnit.
     */
    @Test
    public void testGetSurfaces() {
        System.out.println("getSurfaces");
        SimulationUnit instance = new SimulationUnit();
        ArrayList expResult = null;
        ArrayList result = instance.getSurfaces();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSurfaces method, of class SimulationUnit.
     */
    @Test
    public void testSetSurfaces() {
        System.out.println("setSurfaces");
        ArrayList<Surface> surfaces = null;
        SimulationUnit instance = new SimulationUnit();
        instance.setSurfaces(surfaces);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempDiff method, of class SimulationUnit.
     */
    @Test
    public void testGetTempDiff() {
        System.out.println("getTempDiff");
        SimulationUnit instance = new SimulationUnit();
        double[] expResult = null;
        double[] result = instance.getTempDiff();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTempDiff method, of class SimulationUnit.
     */
    @Test
    public void testSetTempDiff() {
        System.out.println("setTempDiff");
        double[] tempDiff = null;
        SimulationUnit instance = new SimulationUnit();
        instance.setTempDiff(tempDiff);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempInside method, of class SimulationUnit.
     */
    @Test
    public void testGetTempInside() {
        System.out.println("getTempInside");
        SimulationUnit instance = new SimulationUnit();
        double[] expResult = null;
        double[] result = instance.getTempInside();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTempInside method, of class SimulationUnit.
     */
    @Test
    public void testSetTempInside() {
        System.out.println("setTempInside");
        double[] tempInside = null;
        SimulationUnit instance = new SimulationUnit();
        instance.setTempInside(tempInside);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempOutside method, of class SimulationUnit.
     */
    @Test
    public void testGetTempOutside() {
        System.out.println("getTempOutside");
        SimulationUnit instance = new SimulationUnit();
        double[] expResult = null;
        double[] result = instance.getTempOutside();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTempOutside method, of class SimulationUnit.
     */
    @Test
    public void testSetTempOutside() {
        System.out.println("setTempOutside");
        double[] tempOutside = null;
        SimulationUnit instance = new SimulationUnit();
        instance.setTempOutside(tempOutside);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

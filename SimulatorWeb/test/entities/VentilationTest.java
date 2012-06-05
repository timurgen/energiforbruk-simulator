/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 490501
 */
public class VentilationTest {
    
    public VentilationTest() {
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
     * Test of computeHeatLoss method, of class Ventilation.
     */
    @Test
    public void testComputeHeatLoss_double_double() {
        System.out.println("computeHeatLoss");
        double tempInside = 0.0;
        double tempOutside = 0.0;
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.computeHeatLoss(tempInside, tempOutside);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeHeatLoss method, of class Ventilation.
     */
    @Test
    public void testComputeHeatLoss_double() {
        System.out.println("computeHeatLoss");
        double tempDifference = 0.0;
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.computeHeatLoss(tempDifference);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeHeatLoss method, of class Ventilation.
     */
    @Test
    public void testComputeHeatLoss_0args() {
        System.out.println("computeHeatLoss");
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.computeHeatLoss();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAirFlowRateNatural method, of class Ventilation.
     */
    @Test
    public void testGetAirFlowRateNatural_0args() throws Exception {
        System.out.println("getAirFlowRateNatural");
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.getAirFlowRateNatural();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAirFlowRateNatural method, of class Ventilation.
     */
    @Test
    public void testGetAirFlowRateNatural_double() throws Exception {
        System.out.println("getAirFlowRateNatural");
        double cd = 0.0;
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.getAirFlowRateNatural(cd);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVentilationRate method, of class Ventilation.
     */
    @Test
    public void testGetVentilationRate() throws Exception {
        System.out.println("getVentilationRate");
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.getVentilationRate();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAreaOfOpening method, of class Ventilation.
     */
    @Test
    public void testGetAreaOfOpening() {
        System.out.println("getAreaOfOpening");
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.getAreaOfOpening();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAreaOfOpening method, of class Ventilation.
     */
    @Test
    public void testSetAreaOfOpening() {
        System.out.println("setAreaOfOpening");
        double areaOfOpening = 0.0;
        Ventilation instance = new Ventilation();
        instance.setAreaOfOpening(areaOfOpening);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDensityOfAir method, of class Ventilation.
     */
    @Test
    public void testGetDensityOfAir() {
        System.out.println("getDensityOfAir");
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.getDensityOfAir();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDensityOfAir method, of class Ventilation.
     */
    @Test
    public void testSetDensityOfAir() {
        System.out.println("setDensityOfAir");
        double densityOfAir = 0.0;
        Ventilation instance = new Ventilation();
        instance.setDensityOfAir(densityOfAir);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeDensityofAir method, of class Ventilation.
     */
    @Test
    public void testComputeDensityofAir() {
        System.out.println("computeDensityofAir");
        double temp = 0.0;
        double humidity = 0.0;
        double pressure = 0.0;
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.computeDensityofAir(temp, humidity, pressure);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeightOfPipe method, of class Ventilation.
     */
    @Test
    public void testGetHeightOfPipe() {
        System.out.println("getHeightOfPipe");
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.getHeightOfPipe();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeightOfPipe method, of class Ventilation.
     */
    @Test
    public void testSetHeightOfPipe() {
        System.out.println("setHeightOfPipe");
        double heightOfPipe = 0.0;
        Ventilation instance = new Ventilation();
        instance.setHeightOfPipe(heightOfPipe);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempDiff method, of class Ventilation.
     */
    @Test
    public void testGetTempDiff() {
        System.out.println("getTempDiff");
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.getTempDiff();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTempDiff method, of class Ventilation.
     */
    @Test
    public void testSetTempDiff() {
        System.out.println("setTempDiff");
        double tempDiff = 0.0;
        Ventilation instance = new Ventilation();
        instance.setTempDiff(tempDiff);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempInside method, of class Ventilation.
     */
    @Test
    public void testGetTempInside() {
        System.out.println("getTempInside");
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.getTempInside();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTempInside method, of class Ventilation.
     */
    @Test
    public void testSetTempInside() {
        System.out.println("setTempInside");
        double tempInside = 0.0;
        Ventilation instance = new Ventilation();
        instance.setTempInside(tempInside);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempOutside method, of class Ventilation.
     */
    @Test
    public void testGetTempOutside() {
        System.out.println("getTempOutside");
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.getTempOutside();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTempOutside method, of class Ventilation.
     */
    @Test
    public void testSetTempOutside() {
        System.out.println("setTempOutside");
        double tempOutside = 0.0;
        Ventilation instance = new Ventilation();
        instance.setTempOutside(tempOutside);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVolume method, of class Ventilation.
     */
    @Test
    public void testGetVolume() {
        System.out.println("getVolume");
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.getVolume();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVolume method, of class Ventilation.
     */
    @Test
    public void testSetVolume() {
        System.out.println("setVolume");
        double volume = 0.0;
        Ventilation instance = new Ventilation();
        instance.setVolume(volume);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAirFlowRate method, of class Ventilation.
     */
    @Test
    public void testGetAirFlowRate() {
        System.out.println("getAirFlowRate");
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.getAirFlowRate();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAirFlowRate method, of class Ventilation.
     */
    @Test
    public void testSetAirFlowRate() {
        System.out.println("setAirFlowRate");
        double airFlowRate = 0.0;
        Ventilation instance = new Ventilation();
        instance.setAirFlowRate(airFlowRate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeatRecovery method, of class Ventilation.
     */
    @Test
    public void testGetHeatRecovery() {
        System.out.println("getHeatRecovery");
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.getHeatRecovery();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeatRecovery method, of class Ventilation.
     */
    @Test
    public void testSetHeatRecovery() {
        System.out.println("setHeatRecovery");
        double heatRecovery = 0.0;
        Ventilation instance = new Ventilation();
        instance.setHeatRecovery(heatRecovery);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPowerEffect method, of class Ventilation.
     */
    @Test
    public void testGetPowerEffect() {
        System.out.println("getPowerEffect");
        Ventilation instance = new Ventilation();
        double expResult = 0.0;
        double result = instance.getPowerEffect();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPowerEffect method, of class Ventilation.
     */
    @Test
    public void testSetPowerEffect() {
        System.out.println("setPowerEffect");
        double powerEffect = 0.0;
        Ventilation instance = new Ventilation();
        instance.setPowerEffect(powerEffect);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVentType method, of class Ventilation.
     */
    @Test
    public void testGetVentType() {
        System.out.println("getVentType");
        Ventilation instance = new Ventilation();
        int expResult = 0;
        int result = instance.getVentType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVentType method, of class Ventilation.
     */
    @Test
    public void testSetVentType() {
        System.out.println("setVentType");
        int ventType = 0;
        Ventilation instance = new Ventilation();
        instance.setVentType(ventType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeConsumption method, of class Ventilation.
     */
    @Test
    public void testComputeConsumption() {
        System.out.println("computeConsumption");
        int hours = 0;
        Ventilation instance = new Ventilation();
        Double[] expResult = null;
        Double[] result = instance.computeConsumption(hours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Ventilation.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Ventilation.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

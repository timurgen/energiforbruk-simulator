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
public class LightingTest {
    
    public LightingTest() {
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
     * Test of computeConsumption method, of class Lighting.
     */
    @Test
    public void testComputeConsumption() {
        System.out.println("computeConsumption");
        int hours = 0;
        Lighting instance = new Lighting();
        Double[] expResult = null;
        Double[] result = instance.computeConsumption(hours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLengthOfDay method, of class Lighting.
     */
    @Test
    public void testGetLengthOfDay() {
        System.out.println("getLengthOfDay");
        Lighting instance = new Lighting();
        double expResult = 0.0;
        double result = instance.getLengthOfDay();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDailyProfile method, of class Lighting.
     */
    @Test
    public void testGetDailyProfile() {
        System.out.println("getDailyProfile");
        Lighting instance = new Lighting();
        boolean[] expResult = null;
        boolean[] result = instance.getDailyProfile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDailyProfile method, of class Lighting.
     */
    @Test
    public void testSetDailyProfile() {
        System.out.println("setDailyProfile");
        boolean[] dailyProfile = null;
        Lighting instance = new Lighting();
        instance.setDailyProfile(dailyProfile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isIsTurnedOn method, of class Lighting.
     */
    @Test
    public void testIsIsTurnedOn() {
        System.out.println("isIsTurnedOn");
        Lighting instance = new Lighting();
        boolean expResult = false;
        boolean result = instance.isIsTurnedOn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsTurnedOn method, of class Lighting.
     */
    @Test
    public void testSetIsTurnedOn() {
        System.out.println("setIsTurnedOn");
        boolean isTurnedOn = false;
        Lighting instance = new Lighting();
        instance.setIsTurnedOn(isTurnedOn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLightOutput method, of class Lighting.
     */
    @Test
    public void testGetLightOutput() {
        System.out.println("getLightOutput");
        Lighting instance = new Lighting();
        double expResult = 0.0;
        double result = instance.getLightOutput();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLightOutput method, of class Lighting.
     */
    @Test
    public void testSetLightOutput() {
        System.out.println("setLightOutput");
        double lightOutput = 0.0;
        Lighting instance = new Lighting();
        instance.setLightOutput(lightOutput);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPower method, of class Lighting.
     */
    @Test
    public void testGetPower() {
        System.out.println("getPower");
        Lighting instance = new Lighting();
        double expResult = 0.0;
        double result = instance.getPower();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPower method, of class Lighting.
     */
    @Test
    public void testSetPower() {
        System.out.println("setPower");
        double power = 0.0;
        Lighting instance = new Lighting();
        instance.setPower(power);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isUseDailyProfile method, of class Lighting.
     */
    @Test
    public void testIsUseDailyProfile() {
        System.out.println("isUseDailyProfile");
        Lighting instance = new Lighting();
        boolean expResult = false;
        boolean result = instance.isUseDailyProfile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUseDailyProfile method, of class Lighting.
     */
    @Test
    public void testSetUseDailyProfile() {
        System.out.println("setUseDailyProfile");
        boolean useDailyProfile = false;
        Lighting instance = new Lighting();
        instance.setUseDailyProfile(useDailyProfile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDayOfYear method, of class Lighting.
     */
    @Test
    public void testGetDayOfYear() {
        System.out.println("getDayOfYear");
        Lighting instance = new Lighting();
        double expResult = 0.0;
        double result = instance.getDayOfYear();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDayOfYear method, of class Lighting.
     */
    @Test
    public void testSetDayOfYear() {
        System.out.println("setDayOfYear");
        double dayOfYear = 0.0;
        Lighting instance = new Lighting();
        instance.setDayOfYear(dayOfYear);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLattitude method, of class Lighting.
     */
    @Test
    public void testGetLattitude() {
        System.out.println("getLattitude");
        Lighting instance = new Lighting();
        double expResult = 0.0;
        double result = instance.getLattitude();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLattitude method, of class Lighting.
     */
    @Test
    public void testSetLattitude() {
        System.out.println("setLattitude");
        double lattitude = 0.0;
        Lighting instance = new Lighting();
        instance.setLattitude(lattitude);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Lighting.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Lighting.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

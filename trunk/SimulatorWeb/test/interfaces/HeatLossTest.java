/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 490501
 */
public class HeatLossTest {
    
    public HeatLossTest() {
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
     * Test of computeHeatLoss method, of class HeatLoss.
     */
    @Test
    public void testComputeHeatLoss_double_double() {
        System.out.println("computeHeatLoss");
        double tempInside = 0.0;
        double tempOutside = 0.0;
        HeatLoss instance = new HeatLossImpl();
        double expResult = 0.0;
        double result = instance.computeHeatLoss(tempInside, tempOutside);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeHeatLoss method, of class HeatLoss.
     */
    @Test
    public void testComputeHeatLoss_double() {
        System.out.println("computeHeatLoss");
        double tempDifference = 0.0;
        HeatLoss instance = new HeatLossImpl();
        double expResult = 0.0;
        double result = instance.computeHeatLoss(tempDifference);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeHeatLoss method, of class HeatLoss.
     */
    @Test
    public void testComputeHeatLoss() {
        System.out.println("computeHeatLoss");
        HeatLoss instance = new HeatLossImpl();
        double expResult = 0.0;
        double result = instance.computeHeatLoss();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class HeatLossImpl implements HeatLoss {

        public double computeHeatLoss(double tempInside, double tempOutside) {
            return 0.0;
        }

        public double computeHeatLoss(double tempDifference) {
            return 0.0;
        }

        public double computeHeatLoss() {
            return 0.0;
        }
    }
}

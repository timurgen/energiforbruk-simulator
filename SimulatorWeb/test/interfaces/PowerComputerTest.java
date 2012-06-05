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
public class PowerComputerTest {
    
    public PowerComputerTest() {
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
     * Test of computeConsumption method, of class PowerComputer.
     */
    @Test
    public void testComputeConsumption() {
        System.out.println("computeConsumption");
        int hours = 0;
        PowerComputer instance = new PowerComputerImpl();
        Double[] expResult = null;
        Double[] result = instance.computeConsumption(hours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PowerComputerImpl implements PowerComputer {

        public Double[] computeConsumption(int hours) {
            return null;
        }
    }
}

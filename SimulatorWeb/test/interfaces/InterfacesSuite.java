/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author 490501
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({interfaces.PowerComputerTest.class, interfaces.HeatLossTest.class})
public class InterfacesSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}

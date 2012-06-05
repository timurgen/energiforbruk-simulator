/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stg.config;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 490501
 */
public class TEATest {
    
    public TEATest() {
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
     * Test of encrypt method, of class TEA.
     */
    @Test
    public void testEncrypt() {
        System.out.println("encrypt");
        byte[] clear = null;
        TEA instance = null;
        byte[] expResult = null;
        byte[] result = instance.encrypt(clear);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decrypt method, of class TEA.
     */
    @Test
    public void testDecrypt() {
        System.out.println("decrypt");
        byte[] crypt = null;
        TEA instance = null;
        byte[] expResult = null;
        byte[] result = instance.decrypt(crypt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of brew method, of class TEA.
     */
    @Test
    public void testBrew() {
        System.out.println("brew");
        int[] buf = null;
        TEA instance = null;
        instance.brew(buf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unbrew method, of class TEA.
     */
    @Test
    public void testUnbrew() {
        System.out.println("unbrew");
        int[] buf = null;
        TEA instance = null;
        instance.unbrew(buf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pack method, of class TEA.
     */
    @Test
    public void testPack() {
        System.out.println("pack");
        byte[] src = null;
        int[] dest = null;
        int destOffset = 0;
        TEA instance = null;
        instance.pack(src, dest, destOffset);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unpack method, of class TEA.
     */
    @Test
    public void testUnpack() {
        System.out.println("unpack");
        int[] src = null;
        int srcOffset = 0;
        int destLength = 0;
        TEA instance = null;
        byte[] expResult = null;
        byte[] result = instance.unpack(src, srcOffset, destLength);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class TEA.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TEA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

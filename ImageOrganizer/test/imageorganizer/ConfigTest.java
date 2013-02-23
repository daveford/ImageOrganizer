/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageorganizer;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dave
 */
public class ConfigTest {
    
    public ConfigTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Get_DB_Settings method, of class Config.
     */
    @Test
    public void testGet_DB_Settings() {
        System.out.println("Get_DB_Settings");
        Config instance = new Config();
        Map expResult = new HashMap();
        expResult.put("Host", "localhost");
        expResult.put("Port", "3306");
        expResult.put("DB", "ImageOrganizerDB");
        expResult.put("USER", "image");
        expResult.put("PASS", "imageOrg");
        Map result = instance.Get_DB_Settings();
        //assertEquals(expResult.get("Host"), result.get("Host"));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageorganizer;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

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

    @Test
    public void testConfigGoodFile() {
        Config config;
        try{
            config = new Config("ImageOrganizerConfig.xml");
            assertNotNull(config);
        }
        catch(Exception ex){
            fail("Config threw exception: " + ex.getMessage());
        }
    }
    
    @Rule 
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void testConfigBadFileThrowException() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage("Config file not found");
        Config config = new Config("No_File.xml");
    }
    
    @Test
    public void testGetDbSettingsGoodSettings() throws Exception{
        Config config = new Config("ImageOrganizerConfig.xml");
        HashMap testMap = new HashMap();
        testMap.put("HOST", "localhost");
        testMap.put("USER", "image");
        testMap.put("PASS", "ImageOrganizer");
        testMap.put("DB", "imageorganizerdb");
        HashMap map = config.Get_Db_Settings();
        assertEquals(testMap.get("HOST"), map.get("HOST"));
    }
    
    @Test
    public void testGetSearchSettingsGoodSettings() throws Exception{
        Config config = new Config("ImageOrganizerConfig.xml");
        HashMap testMap = new HashMap();
        HashMap map = config.Get_Search_Settings();
        assertEquals(testMap.get("HOST"), map.get("HOST"));
    }
    
    @Test
    public void testGetInsertSettingsGoodSettings() throws Exception{
        Config config = new Config("ImageOrganizerConfig.xml");
        HashMap testMap = new HashMap();
        HashMap map = config.Get_Insert_Settings();
        assertEquals(testMap.get("HOST"), map.get("HOST"));
    }
    
    @Test
    public void testGetGuiSettingsGoodSettings() throws Exception{
        Config config = new Config("ImageOrganizerConfig.xml");
        HashMap testMap = new HashMap();
        HashMap map = config.Get_GUI_Settings();
        assertEquals(testMap.get("HOST"), map.get("HOST"));
    }
}

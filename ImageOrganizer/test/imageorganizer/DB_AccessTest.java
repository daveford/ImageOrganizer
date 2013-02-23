/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageorganizer;

import java.sql.*;
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
public class DB_AccessTest {
    
    public DB_AccessTest() {
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
     * Test of isConnected method, of class DB_Access.
     */
    @Test
    public void testIsConnected() {
        System.out.println("isConnected");
        String username="image", password="imageOrg", dbname="ImageOrganizerDB";
        String JDBC_DRIVER = "com.mysql.jdbc.Driver", host="localhost";
        String connString = "jdbc:mysql://localhost/ImageOrganizerDB";
        Connection conn;
        DB_Access instance = new DB_Access();
        instance.connect();
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(connString, username, password);
            boolean expResult = !conn.isClosed();
            boolean result = instance.isConnected();
            assertEquals(expResult, result);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of connect method, of class DB_Access.
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        String username="image", password="imageOrg", dbname="ImageOrganizerDB";
        String JDBC_DRIVER = "com.mysql.jdbc.Driver", host="localhost";
        String connString = "jdbc:mysql://localhost/ImageOrganizerDB";
        Connection conn;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(connString, username, password);
            DB_Access instance = new DB_Access();
            instance.connect();
            assertTrue(instance.isConnected());
        }
        catch(Exception ex){
            fail("unable to connect to database");
        }
    }
    
    /**
     * Test the disconnect method from DB_Access
     */
    @Test
    public void testDisconnect(){
       System.out.println("disconnect");
        String username="image", password="imageOrg", dbname="ImageOrganizerDB";
        String JDBC_DRIVER = "com.mysql.jdbc.Driver", host="localhost";
        String connString = "jdbc:mysql://localhost/ImageOrganizerDB";
        Connection conn;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(connString, username, password);
            DB_Access instance = new DB_Access();
            instance.connect();
            assertTrue(instance.isConnected());
            instance.disconnect();
            assertFalse(instance.isConnected());
        }
        catch(Exception ex){
            fail("unable to connect to database");
        } 
    }
    
    /**
     * Test the the executeSql() function
     */
    @Test
    public void testExecuteSql(){
        System.out.println("Testing executeSql function");
        DB_Access instance = new DB_Access();
        ResultSet rs;
    }
}

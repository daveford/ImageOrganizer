/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageorganizer;

import java.util.HashMap;
import java.sql.*;

/**
 *
 * @author Dave
 */
public class DB_Access {
    
    private String connString, username, password, dbname;
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private Config configuration;
    private HashMap<String, String> settings;
    private Connection conn;
    public DB_Access(){
        configuration = new Config();
        settings = (HashMap)configuration.Get_DB_Settings();
        connString = "jdbc:mysql://" + settings.get("Host") + 
                    "/" + settings.get("DB");
        username = settings.get("USER");
        password = settings.get("PASS");
        dbname = settings.get("DB");
    }
    
    public boolean isConnected(){
        try{
            return !conn.isClosed();
        }
        catch(Exception ex){
            return false;
        }
    }
    
    public void connect(){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(connString, username, password);
            System.out.println ("Database connection established");
        }
        catch (Exception ex) {
            System.err.println("Error connecting to database: " + ex.getMessage());
        }
    }
    
    public void disconnect(){
        try{
            conn.close();
        }
        catch(Exception ex){
            System.err.println("Error disconnecting from database: " + ex.getMessage());
        }
    }
    
    public ResultSet executeSql(String sql) throws SQLException{
        try{
            if(!this.isConnected()){
                this.connect();
            }
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        }
        catch(SQLException ex){
            throw ex;
        }
    }
}

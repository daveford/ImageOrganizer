/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageorganizer;

import java.util.HashMap;

/**
 *
 * @author Dave
 */
public class DBAccess {
    private final Config configFile;
    private HashMap<String, String> settings;
    
    public DBAccess(Config config){
        this.configFile = config;
        settings = config.Get_Db_Settings();
    }
}

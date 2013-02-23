/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageorganizer;

import java.io.File;

/**
 *
 * @author Dave
 */
public class Config {
    private final String CONFIG = "ImageOrganizerConfig.xml";
    private final File CONFIGFILE;
    
    public Config(String configFile) throws Exception{
        CONFIGFILE = new File(configFile);
        if(!CONFIGFILE.exists()){
            throw new Exception("Config file not found");
        }
    }
}

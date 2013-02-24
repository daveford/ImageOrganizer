/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageorganizer;

/**
 *
 * @author Dave
 */
public class ImageOrganizer {

    /**
     * @param args the command line arguments
     */
    private static final String CONFIGFILE = "ImageOrganizerConfig.xml";
    public static void main(String[] args) {
        Config config;
        try{
            config = new Config(CONFIGFILE);
        }
        catch(Exception ex){
            System.exit(1);
        }
    }
}

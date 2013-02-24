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
    private final String CONFIGFILE = "ImageOrganizerConfig.xml";
    public static void main(String[] args) {
        Config config;
        try{
            config = new Config("ImageOrganizerConfig.xml");
        }
        catch(Exception ex){
            System.exit(1);
        }
    }
}

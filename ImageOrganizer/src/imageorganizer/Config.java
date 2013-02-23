/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageorganizer;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

/**
 *
 * @author Dave
 */
public class Config {
    private final File configFile = new File("ImageOrganizerConfig.xml");
    private DocumentBuilderFactory dbf;
    
    public Config(){
        dbf = DocumentBuilderFactory.newInstance();        
    }
    
    public Map<String, String> Get_DB_Settings(){
        HashMap<String, String> map = new HashMap();

        Node node = readDbXml(configFile);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) node;
            map.put("Host", eElement.getElementsByTagName("host").item(0).getTextContent());
            map.put("Port", eElement.getElementsByTagName("port").item(0).getTextContent());
            map.put("DB", eElement.getElementsByTagName("db").item(0).getTextContent());
            map.put("USER", eElement.getElementsByTagName("username").item(0).getTextContent());
            map.put("PASS", eElement.getElementsByTagName("password").item(0).getTextContent());
        }
        //<HOST>:<PORT>/<DB>
        return map;
    }
    
    private Node readDbXml(File config){
        Document doc;
        try{
            DocumentBuilder builder = dbf.newDocumentBuilder();
            doc = builder.parse(configFile);
            doc.getDocumentElement().normalize();
            return doc.getElementsByTagName("database").item(0);
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return null;
    }
}

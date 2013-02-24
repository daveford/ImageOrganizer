/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageorganizer;

import java.io.File;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Dave
 */
public class Config {
    private final File CONFIGFILE;
    
    public Config(String configFile) throws Exception{
        CONFIGFILE = new File(configFile);
        if(!CONFIGFILE.exists()){
            throw new Exception("Config file not found");
        }
    }
    
    public HashMap<String, String> Get_Db_Settings(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        HashMap<String, String> map = new HashMap();
        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(CONFIGFILE);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("database");
            Node nNode = nList.item(0);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                map.put("HOST", eElement.getElementsByTagName("host").item(0).getTextContent());
                map.put("USER", eElement.getElementsByTagName("user").item(0).getTextContent());
                map.put("PASS", eElement.getElementsByTagName("pass").item(0).getTextContent());
                map.put("DB", eElement.getElementsByTagName("db").item(0).getTextContent());
            }
        }
        catch(Exception ex){
            
        }
        return map;
    }
    
    public HashMap<String, String> Get_Search_Settings(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        HashMap<String, String> map = new HashMap();
        
        return map;
    }
    
    public HashMap<String, String> Get_Insert_Settings(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        HashMap<String, String> map = new HashMap();
        
        return map;
    }
    
    public HashMap<String, String> Get_GUI_Settings(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        HashMap<String, String> map = new HashMap();
        
        return map;
    }
}

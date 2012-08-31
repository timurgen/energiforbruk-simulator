package DTDParser;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author 490501
 * @version 0.0.1
 */
public class DOMParser {
    private DocumentBuilderFactory dbf;
    private DocumentBuilder db;
    private Document dom;
    private String[] errorMessages;
    
    public DOMParser() {
        dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);
        
    }
    
    
    /**
     * 
     * @param _path path to xml file that contains a modell
     * 
     */
    public void loadXML(String _path) {
        try {
            db = dbf.newDocumentBuilder();
            db.setErrorHandler(new ErrorHndler(this));
            dom = db.parse(_path);    
            
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            Logger.getLogger(DOMParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @return 
     */
    public String[] getErrorMessages() {
        return errorMessages;
    }
    /**
     * 
     * @param errorMessages 
     */
    public void setErrorMessages(String[] errorMessages) {
        this.errorMessages = errorMessages;
    }
    
    
    
            
    

}

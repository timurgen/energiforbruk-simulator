package SchemaParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author 490501
 */
public class Reader {
    private DocumentBuilderFactory dbf;
    DocumentBuilder builder;
    private Document dom;
    
    public Reader() {
        dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);
    }
    
}

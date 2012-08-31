package DTDParser;

import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author abnormal
 */
public class ErrorHndler extends DefaultHandler{
    DOMParser p;
    String[] errorMessages;
    int errorCounter;
    
    public ErrorHndler(DOMParser _p) {
        this.p = _p;
        this.errorMessages = new String[30];
    }
    
    @Override
    public void startDocument() {
        System.out.println("parsing start");
    }
    
    @Override
    public void error(SAXParseException ex) {
        System.err.println(ex.getMessage());
        this.errorMessages[this.errorCounter++] = ex.getMessage();
        p.setErrorMessages(errorMessages);
    }
    
    @Override
    public void endDocument() {
        System.out.println("parsing done");
    }

}

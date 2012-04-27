
package simulator;

import entities.SimulationUnit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author 490501
 */
public class ProfileParser {
    private BufferedReader profileReader;
    private BufferedReader settingsReader;
    private SimulationUnit unit;
    
    
    public ProfileParser(String path, SimulationUnit u) throws FileNotFoundException {
        profileReader = new BufferedReader(new FileReader(path));
        unit = u;
        //settingsReader = new BufferedReader(new FileReader("settings.txt"));
        
    }
    
    public void parseProfile() {
        String line;
        StringTokenizer ts = new StringTokenizer("", "=");
        try {
            while((line = this.profileReader.readLine()) != null) {
                if(line.contains("//" )|| line.length() == 0) {
                    //det er kommentartegn eller tomt, gjør ingenting
                }
                else if(line.contains("area")) { //
                    ts = new StringTokenizer(line, "=");
                    ts.nextToken(); // navn av parameter 
                    unit.setArea(Double.valueOf(ts.nextToken())); // verdi
                    

                }
                else if(line.contains("type")) {
                    ts = new StringTokenizer(line, "=");
                    ts.nextToken(); // navn av parameter 
                    unit.setType(Integer.valueOf(ts.nextToken())); // verdi
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public SimulationUnit getUnit(){
        return unit;
    }
    
}

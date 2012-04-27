package simulator;

import entities.SimulationUnit;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class utfører beregning av strømforbruk i husholdiniga eller andre enheter
 * 
 * @author 490501
 */
public class Engine {
    //enheter som bruker strøm
    //profiler som påvirker strømforbruk
    //simuleringstype
    
    
    public static void main(String[] args) {//som argument vei til fil
        ArrayList<SimulationUnit> simulationUnits = new ArrayList<SimulationUnit>();
        try {
            simulationUnits.add(new SimulationUnit());
            ProfileParser parser = new ProfileParser(args[0], simulationUnits.get(0));
            parser.parseProfile();
            System.out.println(simulationUnits.get(0).toString());
        } catch (FileNotFoundException ex) {
            System.out.println("given profile file not found");
            System.exit(1);
        }
        
    }
    
}

package entities;

import java.util.ArrayList;
import simulatorengine.Environment;

import simulatorengine.ProfileParser;

public class SimulationUnit {
    /**
     * 
     */
    Environment env;
    /**
     * class of energy consumption
     * see here http://en.wikipedia.org/wiki/European_Union_energy_label
     */
    private char energyClass;
    
    /**list of power consumers at unit
     */
    private ArrayList<PowerConsumer> consumers; 

    /**area of building or room or another entity
     */
    private double area;

    /**need to have a table of types as for example 1 - enebolig, 2 - rekkehus osv
     */
    private int type;

    /**class som kan parse profile files
     */
    private ProfileParser parser;
    
    /**
     * oppsetter nytt profil
     * @param path to file with profile
     */
    public void setProfile(String path) {
            this.parser = new ProfileParser(path); 
    }
    
}

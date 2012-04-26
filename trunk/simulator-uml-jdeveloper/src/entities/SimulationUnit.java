package entities;

import java.util.ArrayList;
import simulatorengine.Environment;

import simulatorengine.Profile;

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

    /**class som kan parse profile files og holde rede p� egenskaper
     */
    private Profile profile;
    
    /**
     * oppsetter nytt profil
     * @param path to file with profile
     */
    public void setProfile(String path) {
            this.profile = new Profile(path); 
    }
    
}

package simulatorengine;

import java.io.BufferedReader;
import java.io.File;

public class ProfileParser {
    /**text file with simulation unit profile
     */
    private File profile; 
    /**class which can read text files line by line
     */
    private BufferedReader profileReader; 
    /**
     * default empty constructor
     */
    public ProfileParser() {
        
    }

    /**
     * @param profile File with profile for simulation unit
     */
    public ProfileParser(File profile) {
        super();
        this.profile = profile;
    }

    /**
     * @param path to text file with profile
     */
    public ProfileParser(String path) {
        super();
        this.profile = new File(path);
    }

    /**
     * leser fila med profil og lager 
     */
    public void loadProfile() {
        
    }
}

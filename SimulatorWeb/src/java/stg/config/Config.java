package stg.config;
/**
 * Denne klassen haandterer alle operasjoner knyttet til config fila
 * 
 * @author 490501
 * @version 1.0.0
 * 
 */
public class Config {
    
    
    public static String getParameter(String key) {
        String value = Config.findValue(key);
        value = decryptValue(value);
        return value;
    }
    
    
    /**
     * 
     * @param key
     * @return 
     */
    private static String findValue(String key) {
       return "hui"; 
    }
    /**
     * 
     * @param key
     * @return 
     */
    private static String decryptValue(String key) {
        return "decryptetd value";
    }

}

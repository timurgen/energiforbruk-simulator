package stg.config;

import java.io.*;
import java.net.URL;
import java.util.Properties;
import java.util.StringTokenizer;

/**
 * Denne klassen haandterer alle operasjoner knyttet til config fila
 * Innhold i fila kripteres! ikke endre manuelt
 * 
 * @author 490501
 * @version 1.0.0
 * 
 */
public class Config {
    /**
     * tea cipher algoritme
     */
    private TEA tea;
    
    /**
     * file med alle innstillinger
     */
    private File config;
    
    /**
     * leser fra fila
     */
    private BufferedReader br;
    
    /**
     * 
     */
    Properties properties;
    
    /**
     * Constructor
     * cipherkey inne, ikke forandre nøkkel mens det finnes noe inne fila  
     */
    public Config() throws FileNotFoundException, IOException {//passphrase inne
       tea = new TEA("A roza upala na lapu mogvaya".getBytes());
       properties = new Properties();
       properties.load(Config.class.getResourceAsStream("config.properties"));
    }
    
    /**
     * returns decrypted value from config file
     * @param key
     * @return value of given key
     */
    public String getParameter(String key) {
        String value = this.findValue(key);
        StringTokenizer st = new StringTokenizer(value,",");
        byte[] a = new byte[st.countTokens()];
        int i = 0;
        while(st.hasMoreTokens()) {
            a[i++] = Byte.valueOf(st.nextToken());
        }
        value = decryptValue(a);
        return value;
    }
    
    
    /**
     * returns value of given key (encrypted)
     * @param key
     * @return encrypted value of given key
     */
    private String findValue(String key) {
       return properties.getProperty(key); 
    }
    
    /**
     * decrypts given data 
     * @param crypted  - encrypted data
     * @return decrypted data as string
     */
    private String decryptValue(byte[] crypted) {
        byte[] decrypted = tea.decrypt(crypted);
        String s = new String(decrypted);
        return s;
    }
    
    /**
     * Encrypts given string
     * @param value string that must be encrypted
     * @return encrypted data as byte array
     */
    private byte[] encryptValue(String value) {
        byte[] original = value.getBytes();
        byte[] crypted = tea.encrypt(original);
        return crypted;
    }
    
    /**
     * Saves property file
     * @param key
     * @param value
     * @throws IOException 
     */
    public void saveProperty(String key, String value) throws IOException {
        byte[] cryptedValue = encryptValue(value);
        String cVal ="";
        for(int i = 0; i < cryptedValue.length; i++){
            cVal += cryptedValue[i]+",";
        }
        URL path = Config.class.getResource("config.properties");
        properties.setProperty(key, cVal);
        properties.store(new FileOutputStream(path.getPath()), "DO NOT CHANGE!");
    }
    
    
    /**
     * test
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        Config c = new Config();
        c.saveProperty("db.host", "jdbc:mysql://kark.hin.no:3306/");
        c.saveProperty("db.name", "aspen_v12");
        c.saveProperty("db.user", "aspen_v12");
        c.saveProperty("db.pass", "aspen@hinv12");
        c.saveProperty("db.salt", "yKertJNPG8¤(ghfj=&%dzxjkKLGedjmnGEker4ikrtuyEFG");
    }

}

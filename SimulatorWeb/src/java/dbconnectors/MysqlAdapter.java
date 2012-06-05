
package dbconnectors;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import ejb.UValues;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import stg.config.Config;

/**
 * Class håndterer alle operasjoner som er knyttet til databaser , alle forespørsler ligger her 
 * @author 490501
 */
public class MysqlAdapter {
    private String url;
    private Connection con;
    private String name;
    private String pass;
    private PreparedStatement pstmt;
    private Config conf;
    
    /**
     * Constructor open connection to database 
     * uses setting from config.properties
     */
    public MysqlAdapter() throws IOException {
        try {
            
            conf = new Config();
            Class.forName("com.mysql.jdbc.Driver");
            url = conf.getParameter("db.host")+conf.getParameter("db.name");
            name = conf.getParameter("db.user");
            pass = conf.getParameter("db.pass");
            con = (Connection) DriverManager.getConnection(url,name, pass);
            //stmt = con.createStatement();     bruker prepared statements i stedet for              
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MysqlAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch(SQLException e) {
            Logger.getLogger(MysqlAdapter.class.getName()).log(Level.SEVERE, null, e);
        }    
    }
    
    /**
     * 
     * @param name name of user which must be checked
     * @return true if user exists in database, otherwise false
     * @throws SQLException if any SQLException throws
     */
    public boolean checkIfNameExists(String name) throws SQLException {
        pstmt = (PreparedStatement) con.prepareStatement("SELECT * FROM users WHERE user=?");
        pstmt.setString(1, name);
        ResultSet executeQuery = pstmt.executeQuery();
        return executeQuery.next();        
    }
    
    /**
     * 
     * @param email email of user which must be checked
     * @return true if email exists in database, false - otherwise
     * @throws SQLException if any SQLException throws
     */
    public boolean checkIfEmailExists(String email) throws SQLException {
        pstmt = (PreparedStatement) con.prepareStatement("SELECT * FROM users WHERE email=?");
        pstmt.setString(1, email);
        ResultSet executeQuery = pstmt.executeQuery();
        return executeQuery.next();   
    }
    
    /**
     * Saves new user in database
     * @param name usernamr
     * @param email - brukerens epost
     * @param password - passord til bruker
     * @return
     * @throws Exception if user or email exist in database
     */
    public boolean addUserToDataBase(String name, String email, String password) throws Exception {
        //Sjekker alt en gang til
        if(checkIfNameExists(name))
            throw new Exception("username exixts in database");
        if(checkIfEmailExists(email))
            throw new Exception("email exists in database");
        String passHash = getHash(password);
        pstmt = (PreparedStatement) con.prepareStatement("INSERT INTO users (user, passwd, email) values(?,?,?)");
        pstmt.setString(1, name);
        pstmt.setString(2, passHash);
        pstmt.setString(3, email);
        pstmt.executeUpdate();
        return true;
    }
    
    /**
     * returns md5 hash (salted) of given data
     * @param data data to hashing
     * @return md5 hasho of given data
     * @throws IOException 
     */
    private String getHash(String data) throws IOException {
        //password hashing and salting
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MysqlAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        md.reset();
        String salt = conf.getParameter("db.salt");
        String s = data+salt+data+salt; //hemmelig saltingsmetode
        byte[] passByte = s.getBytes();
        byte[] hash = md.digest(passByte);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            result.append(Integer.toHexString(0xFF & hash[i]));
	}
        return result.toString();  
    }
    
    /**
     * 
     * @param name name of user 
     * @param password password  
     * @return id for autentificated user or <strong>-1</strong> if user does not exist
     * @throws NoSuchAlgorithmException
     * @throws FileNotFoundException
     * @throws IOException
     * @throws SQLException 
     */
    public int autentificateUser(String name, String password) throws IOException, SQLException {
        password = getHash(password);
        pstmt = (PreparedStatement) con.prepareStatement("SELECT id FROM users WHERE user = ? AND passwd = ?");
        pstmt.setString(1, name);
        pstmt.setString(2, password);
        ResultSet result = pstmt.executeQuery();
        if(result.next()) {
            return result.getInt(1);
        }
        else return -1;        
    }
    
    /**
     * returns all standarts with u-values from database
     */
    public void getStandarts() throws SQLException {
        UValues row = new UValues();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimulatorWebPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trn = em.getTransaction();
        trn.begin();
        javax.persistence.Query query = em.createNamedQuery("UValues.findAll");
        List result = query.getResultList();
        
        
        
    }
    
    //*******************************************test**************************************//
    public static void main(String[] args) throws SQLException, IOException, Exception {
        MysqlAdapter ms = null;
        try {
            ms = new MysqlAdapter();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MysqlAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MysqlAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        ms.getStandarts();
       
        System.out.println();
    } 
}

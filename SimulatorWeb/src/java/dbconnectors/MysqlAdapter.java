
package dbconnectors;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import stg.config.Config;

/**
 *
 * @author 490501
 */
public class MysqlAdapter {
    private String url;
    private Connection con;
    private String name;
    private String pass;
    private Statement stmt;
    private PreparedStatement pstmt;
    Config conf;
    
    /**
     * Constructor open connection to database 
     * uses setting from config.properties
     */
    public MysqlAdapter() throws FileNotFoundException, IOException {
        try {
            conf = new Config();
            Class.forName("com.mysql.jdbc.Driver");
            url = conf.getParameter("db.host")+conf.getParameter("db.name");
            name = conf.getParameter("db.user");
            pass = conf.getParameter("db.pass");
            con = (Connection) DriverManager.getConnection(url,name, pass);
            stmt = con.createStatement();
            
            
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
    
    //test
    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
        MysqlAdapter ms = null;
        try {
            ms = new MysqlAdapter();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MysqlAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MysqlAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        ms.checkIfNameExists("Timur");
    }
    
}

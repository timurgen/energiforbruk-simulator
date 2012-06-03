
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
    
    /**
     * Main constructor
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public MysqlAdapter() throws FileNotFoundException, IOException {
        try {
            Config conf = new Config();
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://kark.hin.no:3306/aspen_v12";
            name = "aspen_v12";
            pass = "aspen@hinv12";
            con = (Connection) DriverManager.getConnection(url,name, pass);
            stmt = con.createStatement();
            pstmt = (PreparedStatement) con.prepareStatement("SELECT * FROM users WHERE user=?");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MysqlAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch(SQLException e) {
            Logger.getLogger(MysqlAdapter.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    public boolean getUserByName(String name) throws SQLException {
        pstmt.setString(1, name);
        //String query = "SELECT * FROM users WHERE user=\""+name+"\"";
        //ResultSet executeQuery = stmt.executeQuery(query);
        ResultSet executeQuery = pstmt.executeQuery();
        return executeQuery.next(); 
        
    }
    
    //test
    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
        MysqlAdapter ms = new MysqlAdapter();
        ms.getUserByName("Timur");
    }
    
}

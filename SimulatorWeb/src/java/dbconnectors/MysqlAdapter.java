/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnectors;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.MySQLDataException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public MysqlAdapter() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://kark.hin.no:3306/aspen_v12";
            name = "aspen_v12";
            pass = "aspen@hinv12";
            con = (Connection) DriverManager.getConnection(url,name, pass);
            stmt = con.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MysqlAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch(SQLException e) {
            Logger.getLogger(MysqlAdapter.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    public boolean getUserByName(String name) throws SQLException {
        String query = "SELECT * FROM users WHERE user=\""+name+"\"";
        return stmt.execute(query);  
        
    }
    
}

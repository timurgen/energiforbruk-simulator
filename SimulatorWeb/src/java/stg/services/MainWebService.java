
package stg.services;

import dbconnectors.MysqlAdapter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author 490501
 */
@WebService(serviceName = "MainWebService")
public class MainWebService {

    /**
     * autentificate operation, returns user ID(int) or -1 if user des not exist or password is invalid
     */
    @WebMethod(operationName = "autentificate")
    public String autentificate(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        MysqlAdapter md;
        try {
            md = new MysqlAdapter();
           return String.valueOf(md.autentificateUser(username, password));
        } catch (IOException ex) {
            Logger.getLogger(MainWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch(SQLException ex) {
            Logger.getLogger(MainWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         
    }

    /**
     * Web service operation return  u values for given standart
     */
    @WebMethod(operationName = "getStandart")
    public double[] getStandart(@WebParam(name = "name") String name) {
        MysqlAdapter md;
        try {
           md = new MysqlAdapter();
           return md.getStandartValues(name);
        } catch(SQLException ex) {
            Logger.getLogger(MainWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         
    }
}

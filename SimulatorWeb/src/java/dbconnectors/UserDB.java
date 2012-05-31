/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnectors;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author 490501
 */
public class UserDB {
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public UserDB() {
        em = emf.createEntityManager();
        
    }
    
    public void getAllU() {
        List uvalues = em.createNamedQuery("findall").getResultList();
        
    }
    

    public boolean checkIfUsernameExists(String name) {
        return true;
        //TODO request to database with users
    }
    
    public boolean checkIfEmailExists(String email) {
        return true;
        //TODO request to database with users
    }
    
    
    
}

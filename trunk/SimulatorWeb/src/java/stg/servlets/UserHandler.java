package stg.servlets;

import dbconnectors.MysqlAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Denne servlet håndterer alle operasjoner som er knyttet til brukere
 * @author 490501
 */
@WebServlet(name = "UserHandler", urlPatterns = {"/user"})
public class UserHandler extends HttpServlet {
    

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        ServletContext srvCon = request.getServletContext();
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //sjekker om vi har definert "mode" i forespørsel
            if(request.getParameter("mode") == null) {
                out.println("fail request, mode == null");
                return;
            }
            //registration check
            if(request.getParameter("mode").equals("check")) {
                if(request.getParameter("name") == null | request.getParameter("email") == null){
                    out.println("name or email are equal to null");
                    return;
                }
                String name = (String)request.getParameter("name");
                String email= (String)request.getParameter("email");
                try {
                    out.print(checkIfUserExists(name, email));
                } catch (SQLException ex) {
                    Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, "Exception in check function", ex);
                } catch(IOException ex){
                    Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, "Exception in check function", ex);
                } 
                
            }
            //login
            else if(request.getParameter("mode").equals("login")) {
                if(request.getParameter("name") == null|request.getParameter("pass") == null) {
                    out.println("name or password are equal to null");
                    return;
                }
                String name = (String)request.getParameter("name");
                String pass= (String)request.getParameter("pass");
                int id = -1;
                try {
                    id = autentificatUser(name, pass);
                } catch (SQLException ex) {
                    Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                switch(id) {
                    case -1:
                        //TODO invalid navn eller passord send to error page
                        break;
                    case 1|2|3|4|5:
                        //TODO admins
                        return;
                    default:
                        //TODOvanlig bruker
                        //@DeclareRoles("autentificated_user")
                        
                        
                }
                 
                
                
            }
            //registration
            else if(request.getParameter("mode").equals("registration")) {
                //TODO plukke ut info
                //TODO sjekke om bruker registrert allerede
                //TODO legge til ny bruker
            }
            

        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean checkIfUserExists(String name, String email) throws SQLException, FileNotFoundException, IOException {
        MysqlAdapter md = new MysqlAdapter();
        return (md.checkIfNameExists(name) || md.checkIfEmailExists(email)) ? true : false;
    }
    
    private int autentificatUser(String name, String pass) throws IOException, SQLException {
        MysqlAdapter md = new MysqlAdapter();
        return md.autentificateUser(name, pass);
    }
}


package controleurs;

import beanEntite.Utilisateur;
import beansSession.beanUserLocal;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginControleur implements Serializable,SousControleurInterface        {
   
    private final beanUserLocal beanUser ;

    public LoginControleur() {
        beanUser= lookupbeanUserLocal();
    }
     
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
         HttpSession session = request.getSession();
         
         
         Utilisateur ut01= beanUser.getUserByCode(session.getAttribute("lg_password").toString());
         if (ut01.getRole() == 5)
         {
             return "admin";
         }
         
         
         
        return "include/login";
    }

    private beanUserLocal lookupbeanUserLocal() {
        try {
            Context c = new InitialContext();
            return (beanUserLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/beanUser!beansSession.beanUserLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    
    
}

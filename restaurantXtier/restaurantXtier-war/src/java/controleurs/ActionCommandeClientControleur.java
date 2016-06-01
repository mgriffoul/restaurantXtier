
package controleurs;

import beanEntite.LigneCommande;
import beansSession.BeanCommandeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//actionCom
public class ActionCommandeClientControleur implements SousControleurInterface{
    
    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        
        
        HttpSession session = request.getSession();
        
         //********
        //Preparation des URL 
        //********************
        String s1 = "carte";
        String prefix = "include/";
        String suffix = ".jsp";

        //URL par défaut
        String url = "include/IHM_Client/index";
        
        String act = request.getParameter("act");
        
        if("add".equalsIgnoreCase(act)){
            
            Long id = Long.valueOf(request.getParameter("id"));
            
        }
        
         request.setAttribute("contentInc", prefix + s1 + suffix);
        return url;
    }

    private BeanCommandeLocal lookupBeanCommandeLocal() {
        try {
            Context c = new InitialContext();
            return (BeanCommandeLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/BeanCommande!beansSession.BeanCommandeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}


package controleurs;

import beanEntite.Commande;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import transcient.SalleLocal;

public class RefreshClientControleur implements SousControleurInterface{
    SalleLocal salle = lookupSalleLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        
        
        HttpSession session = request.getSession();
        
         //********
        //Preparation des URL 
        //********************
        String s1 = "accueil";
        String prefix = "include/";
        String suffix = ".jsp";

        //URL par défaut
        String url = "include/IHM_Client/index";
        
        
        
        
        if("header".equalsIgnoreCase(request.getParameter("refresh"))){
            
            Integer cleCommande = (Integer) session.getAttribute("cleCommande");
            
            Commande co = salle.selectCommandeByCleCommande(cleCommande);
            session.setAttribute("commande", co);
            return prefix+"IHM_Client/include/header";
        }
        
        
        
        
        
        request.setAttribute("contentInc", prefix + s1 + suffix);
        return url;
        
    }

    private SalleLocal lookupSalleLocal() {
        try {
            Context c = new InitialContext();
            return (SalleLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/Salle!transcient.SalleLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}

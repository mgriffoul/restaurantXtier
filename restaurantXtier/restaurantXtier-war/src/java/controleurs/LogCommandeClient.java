
package controleurs;

import beanEntite.Categorie;
import beanEntite.Commande;
import beansSession.BeanCategorieLocal;
import beansSession.BeanCommandeLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import transcient.SalleLocal;


public class LogCommandeClient implements SousControleurInterface{
    BeanCategorieLocal beanCategorie = lookupBeanCategorieLocal();
    SalleLocal salle = lookupSalleLocal();
    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();
    
    

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
    
        
        //Recupération de la cle de commande et ajout dans la session
        Integer cleCommande = Integer.valueOf(request.getParameter("com"));
        System.out.println(">>>------------clecommande "+cleCommande);
        session.setAttribute("cleCommande", cleCommande);
        
        //Recuperation des categories
        List<Categorie> categories = beanCategorie.selectAllCategorie();
                        request.setAttribute("cat", categories);
        
        
        //recuperation de la comande et ajout dans la session
        Commande com = salle.selectCommandeByCleCommande(cleCommande);
        String passServ = com.getUtilisateur().getCode();
        
        session.setAttribute("codeServeur", passServ);
        session.setAttribute("commande", com);
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

    private SalleLocal lookupSalleLocal() {
        try {
            Context c = new InitialContext();
            return (SalleLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/Salle!transcient.SalleLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private BeanCategorieLocal lookupBeanCategorieLocal() {
        try {
            Context c = new InitialContext();
            return (BeanCategorieLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/BeanCategorie!beansSession.BeanCategorieLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

   
    
    
    
}

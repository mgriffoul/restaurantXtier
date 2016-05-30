package controleurs;

import beanEntite.Categorie;
import beanEntite.Commande;
import beanEntite.Ticket;
import beansSession.BeanCategorieLocal;
import beansSession.BeanCommandeLocal;
import beansSession.BeanTicketLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IHMCaisseControleur implements SousControleurInterface {
    
    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();
    
    BeanTicketLocal beanTicket = lookupBeanTicketLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        
        
        HttpSession session = request.getSession();
        
        
        String s1 = "accueil";
        String prefix = "include/";
        String suffix = ".jsp";
        
        //URL par défaut
        String inc1 = "include/IHM_Caisse/index";

        String section = request.getParameter("section");
        System.out.println(section);
        if("ticket".equalsIgnoreCase(section)){
            String nCom = request.getParameter("nCom");
            Commande c = beanCommande.selectCommandeByNumero(nCom);
            System.out.println(c);
            System.out.println("------------------");
            System.out.println(nCom);
            Ticket t = new Ticket();
            t.setCommande(c);
            request.setAttribute("affcom", c);
            inc1= "include/IHM_Caisse/index";
        }
        return inc1;
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

    private BeanTicketLocal lookupBeanTicketLocal() {
        try {
            Context c = new InitialContext();
            return (BeanTicketLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/BeanTicket!beansSession.BeanTicketLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
package controleurs;

import beanEntite.Categorie;
import beanEntite.Commande;
import beanEntite.LigneCommande;
import beanEntite.Ticket;
import beansSession.BeanCategorieLocal;
import beansSession.BeanCommandeLocal;
import beansSession.BeanLigneCommandeLocal;
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
    
    BeanLigneCommandeLocal beanLigneCommande = lookupBeanLigneCommandeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        
        
        HttpSession session = request.getSession();
        
        
        System.out.println(">>>>>>>>>>>>>>>>>>>> entree dans l'ihmcontroleur");
        
        String s1 = "accueil";
        String prefix = "include/";
        String suffix = ".jsp";
        
        //URL par défaut
        String inc1 = "include/IHM_Caisse/index";
        
        String inc = request.getParameter("incCaisse");

        System.out.println(inc);
        if("ticket".equalsIgnoreCase(inc)){
            String nCom = request.getParameter("nCom");
            Commande c = beanCommande.selectCommandeByNumero(nCom);
//            List<LigneCommande> lc = beanLigneCommande.selectLigneCommandeByCommande(nCom);
//            c.setLignesCommandes(lc);
            System.out.println(c.getNumero()+"//"+c.getStatut());
            System.out.println("------------------");
            System.out.println(nCom);
//            Ticket t = new Ticket();
//            t.setCommande(c);
            request.setAttribute("affcom", c);
 //           request.setAttribute("LigneComm", lc);
            System.out.println("DANS AFFICHAGE TICKET");
            s1= "ticket";
//            System.out.println("ticket = "+request.getAttribute("affcom"));
//            System.out.println(t.getCommande().getNumero());
        }
        System.out.println("inc1 = "+inc1);
        request.setAttribute("contentInc", prefix+s1+suffix);
        System.out.println("contentInc "+request.getAttribute("contentInc"));
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

    private BeanLigneCommandeLocal lookupBeanLigneCommandeLocal() {
       try {
            Context c = new InitialContext();
            return (BeanLigneCommandeLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/BeanLigneCommande!beansSession.BeanLigneCommandeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        } 
    }

}
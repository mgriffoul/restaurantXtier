package controleurs;

import beanEntite.Article;
import beanEntite.Categorie;
import beanEntite.Commande;
import beanEntite.LigneCommande;
import beanEntite.Ticket;
import beansSession.BeanArticleLocal;
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
import utilitaire.LigneCommandeWar;

public class IHMCaisseControleur implements SousControleurInterface {
    
    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();
    
    BeanTicketLocal beanTicket = lookupBeanTicketLocal();
    
    BeanLigneCommandeLocal beanLigneCommande = lookupBeanLigneCommandeLocal();
    
    BeanArticleLocal beanArticleLocal = lookupbeanArticleLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        
        
        HttpSession session = request.getSession();
        
        
        LigneCommandeWar lcw = new LigneCommandeWar();
        
        
        System.out.println(">>>>>>>>>>>>>>>>>>>> entree dans l'ihmcontroleur");
        
        String s1 = "accueil";
        String prefix = "include/";
        String suffix = ".jsp";
        
        //URL par défaut
        String inc1 = "include/IHM_Caisse/index";
        
        String inc = request.getParameter("incCaisse");

        System.out.println(inc);
        if("ticket".equalsIgnoreCase(inc)){
            Float total = 0F;
            String nCom = request.getParameter("nCom");
            Commande c = beanCommande.selectCommandeByNumero(nCom);
            System.out.println("id commande = "+c.getId());
            List<LigneCommande> liste = beanLigneCommande.selectLigneCommandeByIdCommande(c.getId());
            for (LigneCommande lc : liste) {
                lcw.setLigneCommande(lc);
                
                total += lcw.getPrixTotalTTC();
                
            }
            
            
//            System.out.println("liste = "+liste.size());
//            System.out.println("liste = "+liste.get(1).getArticle().getPrixHt());
//            for (LigneCommande lc : liste) {
////                Article a = beanArticleLocal.selectArticleByIdLigneCommande(lc.getId());
//                
//                System.out.println("article = / "+lc.toString());
//            }
            c.setLignesCommandes(liste);

            
            System.out.println("prix total = "+total);
            System.out.println(c.getNumero()+"//"+c.getStatut());
            System.out.println("------------------");
            System.out.println(nCom);
            
                System.out.println(c.getLignesCommandes());
request.setAttribute("prixTTC", total);
//            request.setAttribute("LigneComm", liste);
            
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

    private BeanArticleLocal lookupbeanArticleLocal() {
        try {
            Context c = new InitialContext();
            return (BeanArticleLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/BeanArticle!beansSession.BeanArticleLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        } 
    }

}
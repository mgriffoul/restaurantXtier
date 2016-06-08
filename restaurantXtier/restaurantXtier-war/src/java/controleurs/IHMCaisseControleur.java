package controleurs;

import beanEntite.Article;
import beanEntite.Categorie;
import beanEntite.Commande;
import beanEntite.Formule;
import beanEntite.LigneCommande;
import beanEntite.Ticket;
import beansSession.BeanArticleLocal;
import beansSession.BeanCategorieLocal;
import beansSession.BeanCommandeLocal;
import beansSession.BeanFormuleLocal;
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

    BeanFormuleLocal beanFormule = lookupBeanFormuleLocal();

    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();

    BeanTicketLocal beanTicket = lookupBeanTicketLocal();

    BeanLigneCommandeLocal beanLigneCommande = lookupBeanLigneCommandeLocal();

    BeanArticleLocal beanArticleLocal = lookupbeanArticleLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        LigneCommandeWar lcw = new LigneCommandeWar();

        String s1 = "accueil";
        String prefix = "include/";
        String suffix = ".jsp";

        //URL par défaut
        String inc1 = "include/IHM_Caisse/index";

        String inc = request.getParameter("incCaisse");

        System.out.println(inc);
        if ("ticket".equalsIgnoreCase(inc)) {
            Float total = 0F;
            String nCom = request.getParameter("nCom");
            Commande c = beanCommande.selectCommandeByNumero(nCom);
//            System.out.println("id commande = " + c.getId());
            List<LigneCommande> liste = beanLigneCommande.selectLigneCommandeByIdCommande(c.getId());
            for (LigneCommande lc : liste) {                
                if (lc.getRefFormule() != null) {
                    if (lc.getRefFormule().contains("pat")) {
                        Formule form = beanFormule.selectFormuleByReference("pat");
                        request.setAttribute("nomFormule", form.getNom());
                        request.setAttribute("prixFormule", form.getPrixTtc());
                    }
                    if (lc.getRefFormule().contains("entpl")) {
                        Formule form = beanFormule.selectFormuleByReference("entpl");
                        request.setAttribute("nomFormule", form.getNom());
                        request.setAttribute("prixFormule", form.getPrixTtc());
                    }
                    if (lc.getRefFormule().contains("piz")) {
                        Formule form = beanFormule.selectFormuleByReference("piz");
                        request.setAttribute("nomFormule", form.getNom());
                        request.setAttribute("prixFormule", form.getPrixTtc());
                    }
                }
                if (lc.getRefFormule() != null && lc.getArticle() != null){
                    lc.getArticle().setPrixHt(0F);
                }
                lcw.setLigneCommande(lc);
                //System.out.println("prix ligne = "+lc.getPrixHT());
                //System.out.println("ref form = "+lc.getRefFormule());
//                if(lc.getRefFormule() != null && lc.getPrixHT() > 0 ){
//            String ref = lc.getRefFormule();          
//            if(ref.contains("pat")){
//                Formule form = beanFormule.selectFormuleByReference("pat");
//                Article a = new Article();
//                a.setNom(form.getNom());
//                System.out.println("nom form = "+form.getNom());
//                a.setPrixHt(form.getPrix());
//                lc.setArticle(a);
//                
//            }if(ref.contains("entpl")){
//                Formule form = beanFormule.selectFormuleByReference("entpl");
//                Article a = new Article();
//                a.setNom(form.getNom());
//                System.out.println("nom form = "+form.getNom());
//                a.setPrixHt(form.getPrix());
//                lc.setArticle(a);
//            }if(ref.contains("piz")){
//                Formule form = beanFormule.selectFormuleByReference("piz");
//                Article a = new Article();
//                a.setNom(form.getNom());
//                System.out.println("nom form = "+form.getNom());
//                a.setPrixHt(form.getPrix());
//                lc.setArticle(a);
//            }
//                    
//                }
//                if(lc.getArticle() != null){
//                System.out.println("nom = "+lc.getArticle().getNom());
                total += lcw.getPrixTotalTTC();
                Float prix = lcw.getPrixTotalTTC();
                request.setAttribute("prixt", prix);
            }

            c.setLignesCommandes(liste);

            request.setAttribute("prixTTC", total);
//            request.setAttribute("LigneComm", liste);

            request.setAttribute("affcom", c);
            //           request.setAttribute("LigneComm", lc);
//            System.out.println("DANS AFFICHAGE TICKET");
            s1 = "ticket";
//            System.out.println("ticket = "+request.getAttribute("affcom"));
//            System.out.println(t.getCommande().getNumero());
        }
//        System.out.println("inc1 = " + inc1);
        request.setAttribute("contentInc", prefix + s1 + suffix);
//        System.out.println("contentInc " + request.getAttribute("contentInc"));
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

    private BeanFormuleLocal lookupBeanFormuleLocal() {
        try {
            Context c = new InitialContext();
            return (BeanFormuleLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/BeanFormule!beansSession.BeanFormuleLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}

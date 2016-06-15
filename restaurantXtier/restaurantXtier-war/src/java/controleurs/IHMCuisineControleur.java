package controleurs;

import beanEntite.LigneCommande;
import beansSession.BeanLigneCommandeLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IHMCuisineControleur implements SousControleurInterface {

    BeanLigneCommandeLocal beanLigneCommande = lookupBeanLigneCommandeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        String s1 = "accueil";
        String prefix = "include/";
        String suffix = ".jsp";
        String message = "";
        Date today = new Date();
        request.setAttribute("today", today);
        //URL par défaut
        String inc1 = "include/IHM_Cuisine/index";

        //Recupération de la sous section
        String ssSec = request.getParameter("inc");
        System.out.println("inc debut : " + ssSec);

        //Choix include en fonction de la ssSection
        //Tri par plat
        if ("plat".equalsIgnoreCase(ssSec)) {
            
            List<LigneCommande> ligneCommandes = beanLigneCommande.selectAllLigneCommandeTriByPlat();
            request.setAttribute("plat", ligneCommandes);
            List<LigneCommande> ligneCommandes2 = beanLigneCommande.selectLigneCommandeServies();
            request.setAttribute("servie", ligneCommandes2);
            message = "triées par plat";
            request.setAttribute("message", message);
            request.setAttribute("ssSec", ssSec);
            
            // actualisation via jsp plat
            String ssSec2 = request.getParameter("meth");
            System.out.println("test Meth : "+ssSec2);
            if ("actu".equalsIgnoreCase(ssSec2)) {
                inc1= "include/IHM_Cuisine/include/plat";
                return inc1;
            }
            s1 = "plat";
            
        }
        //Tri par etat
        if ("etat".equalsIgnoreCase(ssSec)) {
            System.out.println("==== on entre dans Etat ==== ");
            List<LigneCommande> ligneCommandes = beanLigneCommande.selectAllLigneCommandeTriByEtat();
            request.setAttribute("etat", ligneCommandes);
            List<LigneCommande> ligneCommandes2 = beanLigneCommande.selectLigneCommandeServies();
            request.setAttribute("servie", ligneCommandes2);
            message = "triées par état";
            request.setAttribute("message", message);
            request.setAttribute("ssSec", ssSec);

            // actualisation via jsp etat
            String ssSec2 = request.getParameter("meth");
            if ("actu".equalsIgnoreCase(ssSec2)) {
                inc1= "include/IHM_Cuisine/include/etat";
                return inc1;
            }
            s1 = "etat";


        }

        //Tri par chronologie
        if ("chr".equalsIgnoreCase(ssSec)) {
            
            List<LigneCommande> ligneCommandes = beanLigneCommande.selectLigneCommandeByChrono();
            request.setAttribute("chr", ligneCommandes);
            List<LigneCommande> ligneCommandes2 = beanLigneCommande.selectLigneCommandeServies();
            request.setAttribute("servie", ligneCommandes2);
            message = "triées par chronologie";
            request.setAttribute("message", message);
            request.setAttribute("ssSec", ssSec);
            
            // actualisation via jsp chr
            String ssSec2 = request.getParameter("meth");
            if ("actu".equalsIgnoreCase(ssSec2)) {
                inc1= "include/IHM_Cuisine/include/chr";
                return inc1;
            }
            s1 = "chr";   
        }
        
        //Tri par emplacement
        if ("table".equalsIgnoreCase(ssSec)) {
            
            List<LigneCommande> ligneCommandes = beanLigneCommande.selectLigneCommandeByEmplacement();
            request.setAttribute("table", ligneCommandes);
            List<LigneCommande> ligneCommandes2 = beanLigneCommande.selectLigneCommandeServies();
            request.setAttribute("servie", ligneCommandes2);
            message = "triées par table";
            request.setAttribute("message", message);
            request.setAttribute("ssSec", ssSec);
            
            // actualisation via jsp table
            String ssSec2 = request.getParameter("meth");
            if ("actu".equalsIgnoreCase(ssSec2)) {
                inc1= "include/IHM_Cuisine/include/table";
                return inc1;
            }
            s1 = "table";
        }

        //Tri par catégorie
        if ("cat".equalsIgnoreCase(ssSec)) {
            
            List<LigneCommande> ligneCommandes = beanLigneCommande.selectLigneCommandeByCategorie();
            request.setAttribute("cat", ligneCommandes);
            List<LigneCommande> ligneCommandes2 = beanLigneCommande.selectLigneCommandeServies();
            request.setAttribute("servie", ligneCommandes2);
            message = "triées par catégorie";
            request.setAttribute("message", message);
            request.setAttribute("ssSec", ssSec);
            // actualisation via jsp cat
            String ssSec2 = request.getParameter("meth");
            System.out.println("test Meth : "+ssSec2);
            if ("actu".equalsIgnoreCase(ssSec2)) {
                inc1= "include/IHM_Cuisine/include/cat";
                return inc1;
            }
            s1 = "cat";
        }
        
        //appel méthode changement d'etat
        String ssSec2 = request.getParameter("meth");
        if ("change".equalsIgnoreCase(ssSec2)) {
            s1 = request.getParameter("inc");
            //récupération de l'id de la LC 
            String s = request.getParameter("idLc");
            Long idLc = Long.parseLong(s);
            // appel de la méthode avec idLc en attribut
            LigneCommande ligneCommande = beanLigneCommande.changerEtatLigneCommande(idLc);

        }

        request.setAttribute("contentInc", prefix + s1 + suffix);
        return inc1;
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

package controleurs;

import beanEntite.LigneCommande;
import beansSession.BeanLigneCommandeLocal;
import java.io.Serializable;
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

        //URL par défaut
        String inc1 = "include/IHM_Cuisine/index";

        //Recupération de la sous section
        String ssSec = request.getParameter("inc");

        //Choix include en fonction de la ssSection
        //Tri par plat
        if ("plat".equalsIgnoreCase(ssSec)) {
            s1 = "plat";
            List<LigneCommande> ligneCommandes = beanLigneCommande.selectAllLigneCommandeTriByPlat();
             for(LigneCommande lc: ligneCommandes){
                System.out.println("test : "+lc);
            }
            request.setAttribute("plat", ligneCommandes);
        }
        //Tri par etat
        if("etat".equalsIgnoreCase(ssSec)){
            s1="etat";
            List<LigneCommande> ligneCommandes = beanLigneCommande.selectAllLigneCommandeTriByEtat();
            request.setAttribute("etat", ligneCommandes);
        }
        //Tri par chronologie
        if("chr".equalsIgnoreCase(ssSec)) {
        s1="chr";
        List<LigneCommande> ligneCommandes = beanLigneCommande.selectLigneCommandeByChrono();
        request.setAttribute("chr", ligneCommandes);
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

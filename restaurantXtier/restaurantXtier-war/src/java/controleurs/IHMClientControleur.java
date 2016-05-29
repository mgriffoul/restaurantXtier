package controleurs;

import beanEntite.Article;
import beanEntite.Categorie;
import beanEntite.Formule;
import beansSession.BeanCategorieLocal;
import beansSession.BeanFormuleLocal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IHMClientControleur implements SousControleurInterface {

    BeanFormuleLocal beanFormule = lookupBeanFormuleLocal();

    BeanCategorieLocal beanCategorie = lookupBeanCategorieLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        String s1 = "accueil";
        String prefix = "include/";
        String suffix = ".jsp";

        //URL par défaut
        String inc1 = "include/IHM_Client/index";

        //Recupération de la sous section
        String inc = request.getParameter("inc");

        //Choix include en fonction de la ssSection
        //LaCarte
        if("car".equalsIgnoreCase(inc)) {
            s1 = "carte";

            List<Categorie> categories = beanCategorie.selectAllCategorie();
            request.setAttribute("cat", categories);
        }

        //Affichage Formules
        if ("for".equalsIgnoreCase(inc)) {
            s1 = "formule";
            List<Formule> formules = beanFormule.selectAllFormule();

            for(Formule f : formules) {

                Collection<Article> allArticles = f.getArticles();
                ArrayList<Article> entrees = beanFormule.selectEntreesOfFormule(f);
                ArrayList<Article> plats = beanFormule.selectPlatsOfFormule(f);
                ArrayList<Article> desserts = beanFormule.selectDessertsOfFormule(f);
                ArrayList<Article> boissons = beanFormule.selectBoissonsOfFormule(f);

                f.setEntrees(entrees);
                f.setPlats(plats);
                f.setDesserts(desserts);
                f.setBoissons(boissons);
            }
            request.setAttribute("for", formules);
        }

        if ("com".equalsIgnoreCase(inc)) {
            s1 = "commande";
        }

        //Menu achat Formule
        if ("buyForm".equalsIgnoreCase(inc)) {

            s1 = "achatForm";

            Long id = Long.valueOf(request.getParameter("idForm"));

            Formule f = beanFormule.selectFormuleById(id);
            ArrayList<Article> entrees = beanFormule.selectEntreesOfFormule(f);
            ArrayList<Article> plats = beanFormule.selectPlatsOfFormule(f);
            ArrayList<Article> desserts = beanFormule.selectDessertsOfFormule(f);
            ArrayList<Article> boissons = beanFormule.selectBoissonsOfFormule(f);
            f.setEntrees(entrees);
            f.setPlats(plats);
            f.setDesserts(desserts);
            f.setBoissons(boissons);
            
            request.setAttribute("for", f);

        }

        
        
        request.setAttribute("contentInc", prefix + s1 + suffix);
        return inc1;
    }

    
    
    
    
    
    
    //import EJB
    private BeanCategorieLocal lookupBeanCategorieLocal() {
        try {
            Context c = new InitialContext();
            return (BeanCategorieLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/BeanCategorie!beansSession.BeanCategorieLocal");
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

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
        String ssSec = request.getParameter("inc");

        //Choix include en fonction de la ssSection
        //LaCarte
        if ("car".equalsIgnoreCase(ssSec)) {
            s1 = "carte";

            List<Categorie> categories = beanCategorie.selectAllCategorie();
            request.setAttribute("cat", categories);
        }
        //Les Formules
        if ("for".equalsIgnoreCase(ssSec)) {
            s1 = "formule";
            List<Formule> formules = beanFormule.selectAllFormule();

            for (Formule f : formules) {

                Collection<Article> allArticles = f.getArticles();
                System.out.println("All ARTICLE SIZE ____" + allArticles.size());
                ArrayList<Article> entrees = new ArrayList();
                ArrayList<Article> plats = new ArrayList();
                ArrayList<Article> desserts = new ArrayList();
                ArrayList<Article> boissons = new ArrayList();

                for (Article a : allArticles) {
                    switch (a.getSousCategorie().getCategorie().getOrdre()) {
                        case 1:
                            entrees.add(a);
                            break;
                        case 2:
                            plats.add(a);
                            break;
                        case 3:
                            desserts.add(a);
                            break;
                        case 4:
                            boissons.add(a);
                            break;
                    }
                }
                System.out.println("entrees size ::::" + entrees.size());
                f.setEntrees(entrees);
                System.out.println("plats size ::::" + plats.size());
                f.setPlats(plats);
                System.out.println("desserts size ::::" + desserts.size());
                f.setDesserts(desserts);
                System.out.println("boissons size ::::" + boissons.size());
                f.setBoissons(boissons);
            }

            
            
            request.setAttribute("for", formules);
        }

        if ("com".equalsIgnoreCase(ssSec)) {
            s1 = "commande";
        }

        request.setAttribute("contentInc", prefix + s1 + suffix);
        return inc1;
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

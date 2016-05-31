package controleurs;

import beanEntite.Article;
import beanEntite.Categorie;
import beanEntite.Commande;
import beanEntite.Emplacement;
import beanEntite.Formule;
import beanEntite.Utilisateur;
import beansSession.BeanCategorieLocal;
import beansSession.BeanFormuleLocal;
import beansSession.BeanUserLocal;
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

    BeanUserLocal beanUser = lookupBeanUserLocal();

    BeanFormuleLocal beanFormule = lookupBeanFormuleLocal();

    BeanCategorieLocal beanCategorie = lookupBeanCategorieLocal();

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

        //Recupération de la sous section
        String inc = request.getParameter("inc");

        //Recupreation de l'utilisateur
        Utilisateur util = (Utilisateur) session.getAttribute("user");
        System.out.println(">>>>>>>>>>>>>>>>>>UTIL : " + util);

        //Récupération de la commande lié à l'emplacement
        Commande commande = (Commande) session.getAttribute("commande");
        System.out.println(">>>>>>>>>>Commande :"+commande);
        
        //Test de l'utilisateur
        if (util != null) {

            if (util.getRole() == 4) {

                //Test de la commande
                if (commande != null) {

                //Choix include en fonction de la ssSection
                    //LaCarte
                    if ("car".equalsIgnoreCase(inc)) {
                        s1 = "carte";

                        List<Categorie> categories = beanCategorie.selectAllCategorie();
                        request.setAttribute("cat", categories);
                    }

                    //Affichage Formules
                    if ("for".equalsIgnoreCase(inc)) {
                        s1 = "formule";
                        List<Formule> formules = beanFormule.selectAllFormule();

                        for (Formule f : formules) {

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

                        Long idForm = Long.valueOf(request.getParameter("idForm"));

                        Formule f = beanFormule.selectFormuleById(idForm);
                        f = beanFormule.chargerFormule(f);

                        request.setAttribute("for", f);

                    }

                    if ("validForm".equalsIgnoreCase(inc)) {

                        Long idForm = Long.valueOf(request.getParameter("idForm"));

                        Formule f = beanFormule.selectFormuleById(idForm);
                        f = beanFormule.chargerFormule(f);

                        if ("0".equalsIgnoreCase(request.getParameter("entree"))
                                || "0".equalsIgnoreCase(request.getParameter("plat"))
                                || "0".equalsIgnoreCase(request.getParameter("dessert"))
                                || "0".equalsIgnoreCase(request.getParameter("boisson"))) {

                            s1 = "achatForm";
                            String msg = "Vous n'avez pas choisi tous les éléments de votre formule.";
                            request.setAttribute("message", msg);
                            request.setAttribute("for", f);
                        }

                    }
                    
                    //else commande
                } else {
                    url = "include/logclient"; 
                }
                
                //else Code ihm user
            } else {
                request.setAttribute("message", "Vous n'avez pas les droits pour accéder à cet interface");
                url = "include/login";
            }

            //else Util null
        } else {
            request.setAttribute("message", "Vous devez vous identifier pour accéder à cet interface");
            url = "include/login";
        }

        request.setAttribute("contentInc", prefix + s1 + suffix);
        return url;
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

    private BeanUserLocal lookupBeanUserLocal() {
        try {
            Context c = new InitialContext();
            return (BeanUserLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/BeanUser!beansSession.BeanUserLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}

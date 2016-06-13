package controleurs;

import beanEntite.Categorie;
import beanEntite.Commande;
import beanEntite.Formule;
import beanEntite.LigneCommande;
import beansSession.BeanCategorieLocal;
import beansSession.BeanFormuleLocal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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

public class RefreshClientControleur implements SousControleurInterface {

    BeanCategorieLocal beanCategorie = lookupBeanCategorieLocal();
    BeanFormuleLocal beanFormule = lookupBeanFormuleLocal();
    SalleLocal salle = lookupSalleLocal();

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

        Integer cleCommande = (Integer) session.getAttribute("cleCommande");

        //REcuperation des categories
        List<Categorie> categories = beanCategorie.selectAllCategorie();
        request.setAttribute("cat", categories);

        if ("header".equalsIgnoreCase(request.getParameter("refresh"))) {
            Commande co = salle.selectCommandeByCleCommande(cleCommande);
            session.setAttribute("commande", co);
            return prefix + "IHM_Client/include/header";
        }

        if ("commande".equalsIgnoreCase(request.getParameter("refresh"))) {

            Collection<LigneCommande> entrees = salle.getEntreesCommandees(cleCommande);
            Collection<LigneCommande> plats = salle.getPlatsCommandees(cleCommande);
            Collection<LigneCommande> desserts = salle.getDessertsCommandees(cleCommande);
            Collection<LigneCommande> formules = salle.getFormulesCommandees(cleCommande);
            Collection<LigneCommande> boissons = salle.getBoissonsCommandees(cleCommande);

            HashMap<Formule, Collection<LigneCommande>> hmf = new HashMap<>();
            Collection<String> refForms = new ArrayList();

            for (LigneCommande l : formules) {
                if (!refForms.contains(l.getRefFormule())) {
                    refForms.add(l.getRefFormule());
                }
            }

            for (String s : refForms) {
                Collection<LigneCommande> col = new ArrayList<>();
                for (LigneCommande l : formules) {
                    if (l.getRefFormule().equalsIgnoreCase(s)) {
                        col.add(l);
                        System.out.println("COL *SIZE======" + col.size());
                    }
                }
                hmf.put(beanFormule.selectFormuleByRef(s), col);
            }
            System.out.println("HMF SIZE <<<<>>>><<>>>" + hmf.size());
            request.setAttribute("boissons", boissons);
            request.setAttribute("entrees", entrees);
            request.setAttribute("plats", plats);
            request.setAttribute("desserts", desserts);
            request.setAttribute("formules", hmf);
            return prefix + "IHM_Client/include/commande";

        }

        request.setAttribute("contentInc", prefix + s1 + suffix);
        return url;

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

    private BeanFormuleLocal lookupBeanFormuleLocal() {
        try {
            Context c = new InitialContext();
            return (BeanFormuleLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/BeanFormule!beansSession.BeanFormuleLocal");
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

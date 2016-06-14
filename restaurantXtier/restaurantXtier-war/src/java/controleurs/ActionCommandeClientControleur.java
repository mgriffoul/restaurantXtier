package controleurs;

import beanEntite.Categorie;
import beanEntite.Commande;
import beanEntite.Formule;
import beanEntite.LigneCommande;
import beanEntite.Utilisateur;
import beansSession.BeanCategorieLocal;
import beansSession.BeanCommandeLocal;
import beansSession.BeanFormuleLocal;
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

//actionCom
public class ActionCommandeClientControleur implements SousControleurInterface {

    BeanCategorieLocal beanCategorie = lookupBeanCategorieLocal();

    BeanFormuleLocal beanFormule = lookupBeanFormuleLocal();

    SalleLocal salle = lookupSalleLocal();

    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        //********
        //Preparation des URL 
        //********************
        String s1 = "carte";
        String prefix = "include/";
        String suffix = ".jsp";

        //URL par défaut
        String url = "include/IHM_Client/index";
        //recuperation action
        String act = request.getParameter("act");

        //recuperation des categories
        List<Categorie> categories = beanCategorie.selectAllCategorie();
        request.setAttribute("cat", categories);

        //Recuperation commande et utilisateur session
        Integer cleCommande = (Integer) session.getAttribute("cleCommande");
        Commande commande = salle.selectCommandeByCleCommande(cleCommande);
        Float prixTotal = salle.getPrixTtcCommande(cleCommande);
        if (prixTotal == null) {
            prixTotal = 0F;
        }
        request.setAttribute("prixTotal", prixTotal);

        Utilisateur util = (Utilisateur) session.getAttribute("user");

        if (util != null) {
            if (util.getRole() == 4) {
                if (commande != null) {

                    if ("add".equalsIgnoreCase(act)) {
                        Long id = Long.valueOf(request.getParameter("id"));
                        salle.ajouterArticle(cleCommande, id);

                        prixTotal = salle.getPrixTtcCommande(cleCommande);
                        request.setAttribute("prixTotal", prixTotal);

                        return prefix + "IHM_Client/include/header";

                    }

                    if ("supp".equalsIgnoreCase(act)) {

                        if ("commandes".equalsIgnoreCase(request.getParameter("dom"))) {
                            Long id = Long.valueOf(request.getParameter("id"));
                            salle.enleverArticle(cleCommande, id);

                            Collection<LigneCommande> entrees = salle.getEntreesCommandees(cleCommande);
                            Collection<LigneCommande> plats = salle.getPlatsCommandees(cleCommande);
                            Collection<LigneCommande> desserts = salle.getDessertsCommandees(cleCommande);
                            Collection<LigneCommande> formules = salle.getFormulesCommandees(cleCommande);
                            Collection<LigneCommande> boissons = salle.getBoissonsCommandees(cleCommande);

                            HashMap<String, HashMap<Formule, Collection<LigneCommande>>> hmf = salle.getFormuleMapper(formules);

                            prixTotal = salle.getPrixTtcCommande(cleCommande);
                            if (prixTotal == null) {
                                prixTotal = 0F;
                            }

                            request.setAttribute("prixTotal", prixTotal);
                            request.setAttribute("boissons", boissons);
                            request.setAttribute("entrees", entrees);
                            request.setAttribute("plats", plats);
                            request.setAttribute("desserts", desserts);
                            request.setAttribute("formules", hmf);

                            return prefix + "IHM_Client/include/commande";
                        }
                        if ("header".equalsIgnoreCase(request.getParameter("dom"))) {
                            return prefix + "IHM_Client/include/header";
                        }
                    }

                    if ("suppFor".equalsIgnoreCase(request.getParameter("act"))) {
                        if ("commandes".equalsIgnoreCase(request.getParameter("dom"))) {
                            String refFormule = request.getParameter("id");
                            salle.enleverFormule(cleCommande, refFormule);

                            Collection<LigneCommande> entrees = salle.getEntreesCommandees(cleCommande);
                            Collection<LigneCommande> plats = salle.getPlatsCommandees(cleCommande);
                            Collection<LigneCommande> desserts = salle.getDessertsCommandees(cleCommande);
                            Collection<LigneCommande> formules = salle.getFormulesCommandees(cleCommande);
                            Collection<LigneCommande> boissons = salle.getBoissonsCommandees(cleCommande);

                            HashMap<String, HashMap<Formule, Collection<LigneCommande>>> hmf = salle.getFormuleMapper(formules);

                            prixTotal = salle.getPrixTtcCommande(cleCommande);
                            if (prixTotal == null) {
                                prixTotal = 0F;
                            }

                            request.setAttribute("prixTotal", prixTotal);
                            request.setAttribute("boissons", boissons);
                            request.setAttribute("entrees", entrees);
                            request.setAttribute("plats", plats);
                            request.setAttribute("desserts", desserts);
                            request.setAttribute("formules", hmf);

                            return prefix + "IHM_Client/include/commande";
                        }
                        if ("header".equalsIgnoreCase(request.getParameter("dom"))) {
                            return prefix + "IHM_Client/include/header";
                        }
                    }

                } else {//commande!=null
                    url = "include/logclient";
                }
            } else {//role!=4
                request.setAttribute("message", "Vous n'avez pas les droits pour accéder à cet interface");
                url = "include/login";
            }
        } else {//util == null
            request.setAttribute("message", "Vous devez vous identifier pour accéder à cet interface");
            url = "include/login";
        }
        request.setAttribute("contentInc", prefix + s1 + suffix);
        return url;
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

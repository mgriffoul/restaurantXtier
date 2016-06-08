package controleurs;

import beanEntite.Article;
import beanEntite.Categorie;
import beanEntite.Commande;
import beanEntite.Formule;
import beanEntite.LigneCommande;
import beanEntite.Utilisateur;
import beansSession.BeanArticleLocal;
import beansSession.BeanCategorieLocal;
import beansSession.BeanCommandeLocal;
import beansSession.BeanFormuleLocal;
import beansSession.BeanUserLocal;
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

public class IHMClientControleur implements SousControleurInterface {

    BeanArticleLocal beanArticle = lookupBeanArticleLocal();

    SalleLocal salle = lookupSalleLocal();

    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();

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
        Integer cleCommande = (Integer) session.getAttribute("cleCommande");
        Commande co = salle.selectCommandeByCleCommande(cleCommande);
        Float prixTotal = salle.getPrixTtcCommande(cleCommande);
        if(prixTotal==null){
            prixTotal=0F;
        }
        request.setAttribute("prixTotal", prixTotal);
        
        System.out.println(">>>>>>>>>>Commande :" + cleCommande);

        //Test de l'utilisateur
        if (util != null) {

            if (util.getRole() == 4) {

                //Test de la commande
                if (cleCommande != null) {

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

                            beanFormule.chargerFormule(f);
                        }
                        request.setAttribute("for", formules);
                    }

                    if ("com".equalsIgnoreCase(inc)) {
                        s1 = "commande";

                        
                        Collection<LigneCommande> entrees = salle.getEntreesCommandees(cleCommande);
                        Collection<LigneCommande> plats = salle.getPlatsCommandees(cleCommande);
                        Collection<LigneCommande> desserts = salle.getDessertsCommandees(cleCommande);
                        Collection<LigneCommande> formules = salle.getFormulesCommandees(cleCommande);
                        Collection<LigneCommande> boissons = salle.getBoissonsCommandees(cleCommande);
                        
                        HashMap<Formule, Collection<LigneCommande>> hmf = new HashMap<>();
                        Collection<String> refForms = new ArrayList();
                        
                        for(LigneCommande l : formules){
                            if(!refForms.contains((l.getRefFormule().substring(0, 3)))){
                                
                                String ref = l.getRefFormule().substring(0, 3);
                                System.out.println("SUBSTRING =" + ref);
                                refForms.add(ref);
                            }
                        }
                        
                        for(String s : refForms){
                          Collection<LigneCommande> col = new ArrayList<>();
                            for(LigneCommande l : formules){
                                if(l.getRefFormule().contains(s)){
                                    col.add(l);
                                    System.out.println("COL *SIZE======"+col.size());
                                }
                            }
                            hmf.put(beanFormule.selectFormuleByRef(s), col);
                        }
                        System.out.println("HMF SIZE <<<<>>>><<>>>"+hmf.size());
                        request.setAttribute("boissons", boissons);
                        request.setAttribute("entrees", entrees);
                        request.setAttribute("plats", plats);
                        request.setAttribute("desserts", desserts);
                        request.setAttribute("formules", hmf);
                        
                    }

                    //Menu achat Formule
                    if ("buyForm".equalsIgnoreCase(inc)) {

                        s1 = "achatForm";

                        Long idForm = Long.valueOf(request.getParameter("idForm"));

                        Formule f = beanFormule.selectFormuleById(idForm);
                        beanFormule.chargerFormule(f);

                        request.setAttribute("for", f);

                    }

                    if ("validForm".equalsIgnoreCase(inc)) {

                        //recup de la formule qui vient d'être choisie
                        Long idForm = Long.valueOf(request.getParameter("idForm"));
                        Formule f = beanFormule.selectFormuleById(idForm);

                        //test des choix faits par l'utilisateur et message d'erreur si oubli
                        if ("0".equalsIgnoreCase(request.getParameter("entree"))
                                || "0".equalsIgnoreCase(request.getParameter("plat"))
                                || "0".equalsIgnoreCase(request.getParameter("dessert"))
                                || "0".equalsIgnoreCase(request.getParameter("boisson"))) {

                            s1 = "achatForm";
                            String msg = "Vous n'avez pas choisi tous les éléments de votre formule.";
                            request.setAttribute("message", msg);
                            request.setAttribute("for", f);
                        } else {

                            s1 = "formule";
                            String message = "Formule ajoutée avec succès";

                            //récupération des articles choisis
                            Article entree = null;
                            Article plat = null;
                            Article dessert = null;
                            Article boisson = null;

                            if (request.getParameter("entree") != null) {
                                entree = beanArticle.selectArticleById(Long.valueOf(request.getParameter("entree")));
                            }
                            if (request.getParameter("plat") != null) {
                                plat = beanArticle.selectArticleById(Long.valueOf(request.getParameter("plat")));
                            }
                            if (request.getParameter("dessert") != null) {
                                dessert = beanArticle.selectArticleById(Long.valueOf(request.getParameter("dessert")));
                            }
                            if (request.getParameter("boisson") != null) {
                                boisson = beanArticle.selectArticleById(Long.valueOf(request.getParameter("boisson")));
                            }

                            salle.ajouterFormule(cleCommande, f.getId(), entree, plat, dessert, boisson);

                            //rechargement des formules pour affichage dans jsp formule.jsp
                            List<Formule> formules = beanFormule.selectAllFormule();

                            for (Formule fo : formules) {
                                beanFormule.chargerFormule(fo);
                            }
                            request.setAttribute("for", formules);
                            request.setAttribute("message", message);
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

    private BeanArticleLocal lookupBeanArticleLocal() {
        try {
            Context c = new InitialContext();
            return (BeanArticleLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/BeanArticle!beansSession.BeanArticleLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}

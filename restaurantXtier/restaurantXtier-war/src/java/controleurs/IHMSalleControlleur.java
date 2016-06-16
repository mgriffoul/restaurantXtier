package controleurs;

import beanEntite.Commande;
import beanEntite.Emplacement;
import beanEntite.Formule;
import beanEntite.LigneCommande;
import beanEntite.Utilisateur;
import beansSession.BeanCommandeLocal;
import beansSession.BeanEmplacementLocal;
import java.io.Serializable;
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
import transcient.GroupeEmplacementLocal;
import transcient.SalleLocal;

public class IHMSalleControlleur implements Serializable, SousControleurInterface {

    GroupeEmplacementLocal groupesEmplacement = lookupGroupesEmplacementLocal();

    SalleLocal salle = lookupSalleLocal();

    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();
    BeanEmplacementLocal beanEmplacement = lookupBeanEmplacementLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        String s1 = "accueil";
        String prefix = "include/";
        String suffix = ".jsp";

        //URL par défaut
        String inc1 = "include/IHM_Salle/index";

        //Recupération de la sous section
        String inc = request.getParameter("inc");

        //Choix include en fonction de la ssSection
        
        //Création de la commande
        if ("createOrder".equalsIgnoreCase(inc)) {
            Collection<Emplacement> emps = new ArrayList<>();
            Utilisateur ut01 = (Utilisateur) session.getAttribute("user");
            String[] emplacements = request.getParameterValues("table");
            for (String s : emplacements) {
                Emplacement emp = beanEmplacement.selectEmplacementByNumero(s);
                emp.setStatut("non valide");
                emps.add(emp);
                beanEmplacement.updateEmplacement(emp);
            }
            salle.creerCommande(emps, ut01);
            Collection<Emplacement> listEmplacement = beanEmplacement.selectAllEmplacement();
            request.setAttribute("listEmplacement", listEmplacement);
            request.setAttribute("OrderValide","ok");
            request.setAttribute("contentInc", s1);
        }

        //Affichage de la commande
        if ("showOrder".equalsIgnoreCase(inc)) {
            s1 = "commande";
            Integer cleCommande = Integer.parseInt(request.getParameter("table"));
            Commande c01 = salle.selectCommandeByCleCommande(cleCommande);
            
                        if ("en creation".equalsIgnoreCase(c01.getStatut())) {
                        } else {
                            String statutCommande = "inconnue";

                            switch (c01.getStatut()) {
                                case "non validee":
                                    statutCommande = "Votre commande est en attente de validation par un serveur.";
                                    break;
                                case "en cours":
                                    statutCommande = "Votre commande est en cours de service.";
                                    break;
                                case "terminee":
                                    statutCommande = "Nous préparons votre addition.";
                                    break;
                                case "payee":
                                    statutCommande = "Votre commande a été cloturée. Merci d'avoir choisi PIZZA + pour votre repas.";
                                    break;
                            }
                            request.setAttribute("statut", statutCommande);
                        }

                        Collection<LigneCommande> entrees = salle.getEntreesCommandees(cleCommande);
                        Collection<LigneCommande> plats = salle.getPlatsCommandees(cleCommande);
                        Collection<LigneCommande> desserts = salle.getDessertsCommandees(cleCommande);
                        Collection<LigneCommande> formules = salle.getFormulesCommandees(cleCommande);
                        Collection<LigneCommande> boissons = salle.getBoissonsCommandees(cleCommande);

                        HashMap<String, HashMap<Formule, Collection<LigneCommande>>> hmf = salle.getFormuleMapper(formules);
                        Collection<String> cleSet = hmf.keySet();

                                           
                        session.setAttribute("commande", c01);
                        request.setAttribute("cleSet", cleSet);
                        request.setAttribute("boissons", boissons);
                        request.setAttribute("entrees", entrees);
                        request.setAttribute("plats", plats);
                        request.setAttribute("desserts", desserts);
                        request.setAttribute("formules", hmf);
                        request.setAttribute("table", cleCommande);
                        
            request.setAttribute("contentInc", s1);
        }

        //Valider la commande
        if ("validOrder".equalsIgnoreCase(inc)) {
            s1 = "commande";
            Integer cleCommande = Integer.parseInt(request.getParameter("table"));
            Commande c01 = salle.selectCommandeByCleCommande(cleCommande);
            c01.setStatut("en cours");
            beanCommande.sauvegarderCommande(c01);
            request.setAttribute("commande", c01);
            request.setAttribute("contentInc", s1);
        }

        //Aide aux clients
        if ("helpTable".equalsIgnoreCase(inc)) {
            Integer cleCommande = Integer.parseInt(request.getParameter("com"));
            Commande c01 = salle.selectCommandeByCleCommande(cleCommande);
            Collection<Emplacement> emplacements = c01.getEmplacements();
            for (Emplacement emp : emplacements) {
                emp.setStatut("help");
                beanEmplacement.updateEmplacement(emp);
            }
            List<Emplacement> listEmplacement = beanEmplacement.selectAllEmplacement();
            request.setAttribute("listEmplacement", listEmplacement);
            request.setAttribute("commande", c01);
            request.setAttribute("contentInc", s1);
        }
        
        //Clients = commande validée
        if ("orderTable".equalsIgnoreCase(inc)) {
            Integer cleCommande = Integer.parseInt(request.getParameter("com"));
            Commande c01 = salle.selectCommandeByCleCommande(cleCommande);
            Collection<Emplacement> emplacements = c01.getEmplacements();
            for (Emplacement emp : emplacements) {
                emp.setStatut("valide");
                beanEmplacement.updateEmplacement(emp);
            }
            List<Emplacement> listEmplacement = beanEmplacement.selectAllEmplacement();
            request.setAttribute("listEmplacement", listEmplacement);
            request.setAttribute("commande", c01);
            request.setAttribute("contentInc", s1);
        }

        request.setAttribute("contentInc", prefix + s1 + suffix);
        return inc1;
    }

    private BeanEmplacementLocal lookupBeanEmplacementLocal() {
        try {
            Context c = new InitialContext();
            return (BeanEmplacementLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/BeanEmplacement!beansSession.BeanEmplacementLocal");
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

    private GroupeEmplacementLocal lookupGroupesEmplacementLocal() {
        try {
            Context c = new InitialContext();
            return (GroupeEmplacementLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/GroupesEmplacement!transcient.GroupeEmplacementLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}

package controleurs;

import beanEntite.Commande;
import beanEntite.Emplacement;
import beanEntite.Utilisateur;
import beansSession.BeanCommandeLocal;
import beansSession.BeanEmplacementLocal;
import java.io.Serializable;
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

public class LoginControleur implements Serializable, SousControleurInterface {

    SalleLocal salle1 = lookupSalleLocal1();

    GroupeEmplacementLocal groupesEmplacement = lookupGroupesEmplacementLocal();

    SalleLocal salle = lookupSalleLocal();

    BeanEmplacementLocal beanEmplacement = lookupBeanEmplacementLocal();

    beansSession.BeanUserLocal BeanUser = lookupBeanUserLocal();

    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String pass = request.getParameter("lg_password");

        if ("0000".equals(pass)) {
            return "include/admin";
        }

        Utilisateur ut01 = BeanUser.getUserByCode(pass);

        if (ut01 != null) {
            session.setAttribute("user", ut01);
            switch (ut01.getRole()) {
                case 1:
                    String s = "include/accueil.jsp";
                    request.setAttribute("contentInc", s);
                    return "include/IHM_Cuisine/index";
                case 2:
                    String string = "include/accueil.jsp";
                    request.setAttribute("contentInc", string);
                    List<Commande> c = beanCommande.selectCommandeTerminee();
                    request.setAttribute("commandefinie", c);
                    return "include/IHM_Caisse/index";
                case 3:
                    String salle_s1 = "include/accueil.jsp";
                    Collection<Emplacement> listEmplacement = groupesEmplacement.getEmplacementsList();         
                    request.setAttribute("listEmplacement", listEmplacement);
                    request.setAttribute("contentInc", salle_s1);
                    return "include/IHM_Salle/index";
                case 4:
                    HashMap<Integer, Commande> commandes = salle.getCommandes();
                    request.setAttribute("commandes", commandes);
                    return "include/IHM_Client/include/logclient";
                case 5:
                    return "include/admin";
            }
        } else {
            request.setAttribute("message", "Ce mot de passe ne correspond à aucune interface!");
        }
        return "include/login";
    }

    private beansSession.BeanUserLocal lookupBeanUserLocal() {
        try {
            Context c = new InitialContext();
            return (beansSession.BeanUserLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/BeanUser!beansSession.BeanUserLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
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

    private SalleLocal lookupSalleLocal1() {
        try {
            Context c = new InitialContext();
            return (SalleLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/Salle!transcient.SalleLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}

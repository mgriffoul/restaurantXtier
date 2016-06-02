package controleurs;

import beanEntite.Commande;
import beanEntite.Emplacement;
import beanEntite.Utilisateur;
import beansSession.BeanCommandeLocal;
import beansSession.BeanEmplacementLocal;
import java.io.Serializable;
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

public class IHMSalleControlleur implements Serializable, SousControleurInterface {
    
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
                Emplacement emp = beanEmplacement.selectEmplacementById(Long.parseLong(s));
                emp.setStatut("occupe");
                emps.add(emp);
                beanEmplacement.updateEmplacement(emp);
            }     
            Commande c01 = beanCommande.createCommande(emps, ut01);
            beanCommande.sauvegarderCommande(c01);
            request.setAttribute("commande", c01);
            List<Emplacement> listEmplacement = beanEmplacement.selectAllEmplacement();
            request.setAttribute("listEmplacement", listEmplacement);
            
        }

        //Création de la commande
        if ("showOrder".equalsIgnoreCase(inc)) {
            Commande c01 = beanCommande.selectCommandeById(Long.valueOf(request.getParameter("id")));
            request.setAttribute("commande", c01);
            s1 = "commande";
            
        }

        //Affichage Formules
        if ("for".equalsIgnoreCase(inc)) {
            
        }
        
        if ("com".equalsIgnoreCase(inc)) {
            
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
    
}

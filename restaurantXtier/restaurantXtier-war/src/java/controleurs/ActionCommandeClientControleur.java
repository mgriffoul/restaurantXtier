package controleurs;

import beanEntite.Commande;
import beanEntite.LigneCommande;
import beanEntite.Utilisateur;
import beansSession.BeanCommandeLocal;
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
    
    SalleLocal salle = lookupSalleLocal();

    BeanCommandeLocal beanCommande = lookupBeanCommandeLocal();
    

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        System.out.println("DANS CONTROLEUR");
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

        //Recuperation commande et utilisateur session
        Integer cleCommande = (Integer) session.getAttribute("cleCommande");
        Commande commande = salle.selectCommandeByCleCommande(cleCommande);
        System.out.println(">>>><<<<>>><<<<Commande : "+commande);
        
        Utilisateur util = (Utilisateur) session.getAttribute("user");
        System.out.println(">>>><<<<>>><<<<Utilisateur : "+util);
        
        
//        for (LigneCommande lc : commande.getLignesCommandes()) {
//            System.out.println("LC AVANT>>>>>>>>>>>" + lc);
//        }

        if (util != null) {
            if (util.getRole() == 4) {
                if (commande != null) {

                    if ("add".equalsIgnoreCase(act)) {
                        System.out.println("++++++++++add=act");
                        Long id = Long.valueOf(request.getParameter("id"));
                        salle.ajouterArticle(cleCommande, id);
                        for (LigneCommande lc : commande.getLignesCommandes()) {
                            System.out.println("LC>>>>>>>>>>>" + lc);
                        }
                        
                        return prefix+"IHM_Client/include/header";
                        
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

}


package controleurs;

import beanEntite.LigneCommande;
import beansSession.BeanLigneCommandeLocal;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IHMCuisine implements Serializable, SousControleurInterface{
    
    BeanLigneCommandeLocal beanLigneCommande = lookupBeanLigneCommandeLocal();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
      HttpSession session = request.getSession();
      List<LigneCommande> ligneCommandes = beanLigneCommande.selectAllLigneCommandeTriByPlat();
      request.setAttribute("ligneCommandes", ligneCommandes);
      return "include/IHM_Cuisine/accueil";
    }

    private BeanLigneCommandeLocal lookupBeanLigneCommandeLocal() {
        try {
            Context c = new InitialContext();
            return (BeanLigneCommandeLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/BeanLigneCommande!beansSession.BeanLigneCommandeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }


    
}

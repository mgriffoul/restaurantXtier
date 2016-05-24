
package controleurs;

import beanEntite.Emplacement;
import beanEntite.Utilisateur;
import beansSession.BeanEmplacementLocal;
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

public class IHMSalle implements Serializable, SousControleurInterface {
    
    
    
    BeanEmplacementLocal beanEmplacement = lookupBeanEmplacementLocal();

    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
      HttpSession session = request.getSession();
      List<Emplacement> listEmplacement = beanEmplacement.selectAllEmplacement();
      request.setAttribute("listEmplacement", listEmplacement);
      return "include/IHM_Salle/index";
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
    
}

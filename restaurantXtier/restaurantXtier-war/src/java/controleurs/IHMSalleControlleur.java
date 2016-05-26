
package controleurs;

import beanEntite.Emplacement;
import beansSession.BeanEmplacementLocal;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IHMSalleControlleur implements Serializable, SousControleurInterface {
    
    
    
    BeanEmplacementLocal beanEmplacement = lookupBeanEmplacementLocal();

    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
      HttpSession session = request.getSession();
      Emplacement emplacement = beanEmplacement.selectEmplacementById(Long.parseLong(request.getParameter("table")));
      emplacement.setStatut("occupe");
      
      return "include/IHM_Salle/accueil";
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

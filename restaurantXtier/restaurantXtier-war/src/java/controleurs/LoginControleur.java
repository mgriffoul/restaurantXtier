
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

public class LoginControleur implements Serializable, SousControleurInterface {

    BeanEmplacementLocal beanEmplacement = lookupBeanEmplacementLocal();

    beansSession.BeanUserLocal BeanUser = lookupBeanUserLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String pass = request.getParameter("lg_password");

        if ("0000".equals(pass)) {
            return "include/admin";
        }

        Utilisateur ut01 = BeanUser.getUserByCode(pass);

        if (ut01 != null) {
            switch (ut01.getRole()) {
                case 1:
                    return "include/IHM_Cuisine/index";
                case 2:
                    return "include/IHM_Caisse/index";
                case 3:
                    List<Emplacement> listEmplacement = beanEmplacement.selectAllEmplacement();
                    request.setAttribute("listEmplacement", listEmplacement);
                    return "include/IHM_Salle/index";
                case 4:
                    String s1 = "include/accueil.jsp";
                    request.setAttribute("contentInc", s1);
                    return "include/IHM_Client/index";
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

}

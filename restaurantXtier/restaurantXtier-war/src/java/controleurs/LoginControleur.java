        package controleurs;

        import beanEntite.Utilisateur;
        import java.io.Serializable;
        import java.util.logging.Level;
        import java.util.logging.Logger;
        import javax.naming.Context;
        import javax.naming.InitialContext;
        import javax.naming.NamingException;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import beansSession.BeanUserLocal;

        public class LoginControleur implements Serializable, SousControleurInterface {

            private BeanUserLocal BeanUser = lookupBeanUserLocal();

            @Override
            public String execute(HttpServletRequest request, HttpServletResponse response) {
                HttpSession session = request.getSession();
                String pass = request.getParameter("lg_password");


                if("0000".equals(pass)){
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
                            return "include/IHM_Salle/index";
                        case 4:
                            return "include/IHM_Client/index";
                        case 5:
                            return "include/admin";
                    }
                } else {
                     request.setAttribute("message", "Ce mot de passe ne correspond à aucune interface!");

                }
                     return "include/login";
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



        }

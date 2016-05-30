package beansSession;

import beanEntite.Utilisateur;
import javax.ejb.Local;
import javax.servlet.http.HttpSession;

@Local
public interface BeanUserLocal {

    public Utilisateur getUserByCode(String code);


}

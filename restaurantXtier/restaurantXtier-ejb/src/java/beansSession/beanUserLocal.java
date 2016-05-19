
package beansSession;

import beanEntite.Utilisateur;
import javax.ejb.Local;

@Local
public interface beanUserLocal {
    
    public Utilisateur getUserByCode(String code);
    
}

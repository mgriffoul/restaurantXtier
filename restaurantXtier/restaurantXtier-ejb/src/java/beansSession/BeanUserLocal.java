
package beansSession;

import beanEntite.Utilisateur;
import javax.ejb.Local;

@Local
public interface BeanUserLocal {
    
    public Utilisateur getUserByCode(String code);
}

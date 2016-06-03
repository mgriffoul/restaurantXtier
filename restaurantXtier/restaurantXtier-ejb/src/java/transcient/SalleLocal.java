
package transcient;

import beanEntite.Emplacement;
import beanEntite.Utilisateur;
import java.util.Collection;
import javax.ejb.Local;


@Local
public interface SalleLocal {
    
    public Integer creerCommande(Collection<Emplacement> emp, Utilisateur util);
    
}


package transcient;

import beanEntite.Emplacement;
import java.util.Collection;
import javax.ejb.Local;


@Local
public interface GroupeEmplacementLocal {
    
    public Integer ajouterGroupe(Collection<Emplacement> emp);
    
}

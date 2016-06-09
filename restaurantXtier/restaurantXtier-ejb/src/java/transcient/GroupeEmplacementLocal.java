
package transcient;

import beanEntite.Emplacement;
import java.util.Collection;
import javax.ejb.Local;


@Local
public interface GroupeEmplacementLocal {
    
    public Integer creerGroupe(Collection<Emplacement> emp);
    public Integer getKeyEmpByEmp(Emplacement emplacement);
}

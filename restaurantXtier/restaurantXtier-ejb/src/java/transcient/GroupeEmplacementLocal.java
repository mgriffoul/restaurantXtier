
package transcient;

import beanEntite.Emplacement;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;


@Local
public interface GroupeEmplacementLocal {
    
    public Integer creerGroupe(Collection<Emplacement> emp);
    public Integer getKeyEmpByEmpNum(Integer numero);
    public List<Emplacement> updateEmplacement();
    public Collection<Emplacement> selectEmplacementsByKey(Integer key);
}

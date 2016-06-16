package transcient;

import beanEntite.Emplacement;
import java.util.Collection;
import javax.ejb.Local;

@Local
public interface GroupeEmplacementLocal {

    public Integer creerGroupe(Collection<Emplacement> emp);

    public Integer getKeyEmpByEmpNum(Integer numero);

    public Collection<Emplacement> selectEmplacementsByKey(Integer key);

    public Collection<Emplacement> getEmplacementsList();
    
    public void updateEmplacement(String action, Integer key);
}

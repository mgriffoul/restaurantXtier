
package beansSession;

import beanEntite.Emplacement;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BeanEmplacementLocal {
    public List<Emplacement> selectAllEmplacement();
}

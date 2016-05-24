
package beansSession;

import beanEntite.Emplacement;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BeanEmplacement implements BeanEmplacementLocal {
   @PersistenceContext(name = "restaurantXtier-ejbPU")
    private EntityManager em;
    
    @Override
    public List<Emplacement> selectAllEmplacement() {
           String req = "Select e from Emplacement e";
           Query qr = em.createQuery(req);
           List<Emplacement> listEmplacement = qr.getResultList();
           return listEmplacement;
    }
}

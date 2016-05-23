
package beansSession;

import beanEntite.Utilisateur;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BeanUser implements BeanUserLocal {

    @PersistenceContext(unitName = "restaurantXtier-ejbPU")
    private EntityManager em;
    
    

    
    
    @Override
    public Utilisateur getUserByCode(String code) {
        return em.find(Utilisateur.class,code);      
    }

}


package beansSession;

import beanEntite.Utilisateur;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class beanUser implements beanUserLocal {

    @PersistenceContext(unitName = "restaurantXtier-ejbPU")
    private EntityManager em;
    
    
    @EJB
    private Utilisateur utilisateur;
    
    
    @Override
    public Utilisateur getUserByCode(String code) {
        return utilisateur = em.find(Utilisateur.class,code);      
    }

}

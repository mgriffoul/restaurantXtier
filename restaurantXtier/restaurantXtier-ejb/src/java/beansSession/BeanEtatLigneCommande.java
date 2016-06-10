
package beansSession;

import beanEntite.EtatLigneCommande;
import beanEntite.LigneCommande;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class BeanEtatLigneCommande implements BeanEtatLigneCommandeLocal {
    
    @PersistenceContext(unitName = "restaurantXtier-ejbPU")
    private EntityManager em;

    
    
    @Override
    public EtatLigneCommande selectEtatFromOrdre(Integer ordre) {
        String req = "Select e from EtatLigneCommande e where e.ordre=:paramordre";
        Query qr = em.createQuery(req);
        qr.setParameter("paramordre", ordre);
        EtatLigneCommande elc = (EtatLigneCommande)qr.getSingleResult();
        return elc;
    }

    public void persist(Object object) {
        em.persist(object);
    }

  
    
}

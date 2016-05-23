
package beansSession;

import beanEntite.Categorie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class BeanCategorie implements BeanCategorieLocal {

    @PersistenceContext(unitName = "restaurantXtier-ejbPU")
    private EntityManager em; 
    
    @Override
    public Categorie selectCategorieById(Long id) {
         return em.find(Categorie.class, id);
         
    }

    @Override
    public Categorie selectCategorieByNom(String nom) {
        String req = "Select c from Categorie c where c.nom = :paramnom";
        Query qr = em.createQuery(req);
        qr.setParameter("paramnom", nom);
        Categorie cat = (Categorie) qr.getSingleResult();
        return cat;
    }

    
    
    
    
}

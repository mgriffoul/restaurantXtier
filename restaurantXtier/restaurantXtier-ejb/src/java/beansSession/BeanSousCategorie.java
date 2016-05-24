package beansSession;

import beanEntite.SousCategorie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BeanSousCategorie implements BeanSousCategorieLocal {

    @PersistenceContext(name = "restaurantXtier-ejbPU")
    private EntityManager em;  
    
    @Override
    public SousCategorie selectSousCategorieById(Long id) {
        return em.find(SousCategorie.class, id);
    }

    @Override
    public SousCategorie selectSousCategorieByNom(String nom) {
         String req = "Select s from SousCategorie s where s.nom = :paramnom";
        Query qr = em.createQuery(req);
        qr.setParameter("paramnom", nom);
        SousCategorie sCat = (SousCategorie) qr.getSingleResult();
        return sCat;
    }

    @Override
    public List<SousCategorie> selectAllSousCategorie() {
            String req = "Select s from SousCategorie s";
           Query qr = em.createQuery(req);
           List<SousCategorie> sousCategories = qr.getResultList();
           return sousCategories;
    }

    @Override
    public List<SousCategorie> selectAllSousCategorieByCategorieId(Long id) {
        String rq = "Select s from SousCategorie s where s.categorie.id=:paramid";
        Query qr = em.createQuery(rq);
        qr.setParameter("paramid", id);
        List<SousCategorie> sousCategories = qr.getResultList();
        return sousCategories;
    }

   
    
}

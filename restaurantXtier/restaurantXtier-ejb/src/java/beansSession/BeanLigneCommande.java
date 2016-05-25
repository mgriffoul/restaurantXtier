package beansSession;

import beanEntite.LigneCommande;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BeanLigneCommande implements BeanLigneCommandeLocal {

    @PersistenceContext(unitName = "restaurantXtier-ejbPU")
    private EntityManager em;
    
    @Override
    public List<LigneCommande> selectLigneCommandeByIdCategorie(Long idCat) {
        String req = "select lc from LigneCommande lc "
                + "join lc.article a "
                + "join a.sousCategorie sc "
                + "join sc.categorie c "
                + "where a.sousCategorie.categorie.id=:paramIdCat";
           Query qr = em.createQuery(req);
           qr.setParameter("paramIdCat", idCat);
           List<LigneCommande> ligneCommandes = qr.getResultList();
           return ligneCommandes;
    }

}

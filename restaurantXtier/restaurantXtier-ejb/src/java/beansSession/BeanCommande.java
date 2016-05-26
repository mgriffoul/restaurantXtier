
package beansSession;

import beanEntite.Commande;
import beanEntite.LigneCommande;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BeanCommande implements BeanCommandeLocal {

 @PersistenceContext(unitName = "restaurantXtier-ejbPU")
 private EntityManager em;
 
 
   @Override
    public Commande selectCommandeById(Long id) {
         return em.find(Commande.class, id);
         
    }
    
    
    
 @Override
    public List<Commande> selectCommandeByDate(String date) {
        String req = "Select c from Commande c where c.date = :paramdate";
        Query qr = em.createQuery(req);
        qr.setParameter("paramnom", date);
        List<Commande> com = qr.getResultList();
        return com;
    }
    
    @Override
    public Commande selectCommandeByNumero(String numero) {
        String req = "Select c from Commande c where c.numero = :paramnumero";
        Query qr = em.createQuery(req);
        qr.setParameter("paramnumero", numero);
        Commande com = (Commande) qr.getSingleResult();
        return com;
    }
    
    @Override
    public List<LigneCommande> selectLigneCommandeByIdCommande(Long id) {
        String rq = "Select c.LigneCommande"
                + " from Commande c where c.id=:paramid";
        Query qr = em.createQuery(rq);
        qr.setParameter("paramid", id);
        List<LigneCommande> LigneCommande = qr.getResultList();
        return LigneCommande;
    }
    
 @Override
    public List<Commande> selectCommandeTerminee(){
        String req = "Select c from Commande c where c.statut=:paramstatut";
        String statut = "terminee";
        Query qr = em.createQuery(req);
        qr.setParameter("paramstatut", statut);
        List<Commande> liste = qr.getResultList();
        
        return liste;
    }
    
}

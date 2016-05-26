
package beansSession;

import beanEntite.Commande;
import beanEntite.Emplacement;
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
    public Commande newCommande(){
        Commande c = new Commande();
   
        return c;
        
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
        String statut = "terminée";
        Query qr = em.createQuery(req);
        qr.setParameter("paramstatut", statut);
        List<Commande> liste = qr.getResultList();
        for(Commande c: liste){
            List<Emplacement> emplacements = selectEmplacementByIdCommande(c.getId());
            c.setEmplacements(emplacements);
            String numero = selectNumCommandeByIdCommande(c.getId());
            c.setNumero(numero);
        }
        return liste;
    }
        
 @Override
    public List<Emplacement> selectEmplacementByIdCommande(Long id){
        String req = "Select c.emplacements from Commande c where c.id=:paramid";
        Query qr = em.createQuery(req);
        qr.setParameter("paramid", id);
        List<Emplacement> emplacements = qr.getResultList();
        return emplacements;
    }
    
 @Override
    public String selectNumCommandeByIdCommande(Long id){
        String req = "Select c.numero from Commande c where c.id=:paramid";
        Query qr = em.createQuery(req);
        qr.setParameter("paramid", id);
        String numero = (String)qr.getSingleResult();
        return numero;
    }
    
    public List<Integer> selectNumEmplacementById(Long id){
        String req = "Select e.numero from Emplacement e where e.id=:paramid";
        Query qr = em.createQuery(req);
        qr.setParameter("paramid", id);
        List<Integer> numero = qr.getResultList();
        return numero;
    } 
}

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

    @Override
    public List<LigneCommande> selectAllLigneCommandeTriByEtat() {
        String req = "select lc from LigneCommande lc order by lc.etat";
        Query qr = em.createQuery(req);
        List<LigneCommande> ligneCommandes = qr.getResultList();
        return ligneCommandes;
    }

    @Override
    public List<LigneCommande> selectAllLigneCommandeTriByPlat() {
        String req ="select lc from LigneCommande lc where lc.etat=null or lc.etat<>'servi' order by lc.article.nom";
        Query qr = em.createQuery(req);
        List<LigneCommande> ligneCommandes = qr.getResultList();
        return ligneCommandes;
    }

    @Override
    public LigneCommande changerEtatLigneCommande(Long id) {
       //test
        LigneCommande lCom= em.find(LigneCommande.class,id);
        System.out.println("recup etat :"+lCom.getEtat());
       String etat=lCom.getEtat()+" test";
        System.out.println("New etat : "+etat);
       lCom.setEtat(etat);
      
       return lCom;
    }

    @Override
    public List<LigneCommande> selectLigneCommandeServies() {
        String req ="select lc from LigneCommande lc where lc.etat='servi' "
                + "order by lc.article.nom ";
                
        Query qr = em.createQuery(req);
        List<LigneCommande> ligneCommandes = qr.getResultList();
        return ligneCommandes;
    }

    @Override
    public List<LigneCommande> selectLigneCommandeByChrono() {
        String req ="select lc from LigneCommande lc where lc.etat=null or lc.etat<>'servi' order by lc.commande.date";
        Query qr = em.createQuery(req);
        List<LigneCommande> ligneCommandes = qr.getResultList();
        return ligneCommandes;
    }

}

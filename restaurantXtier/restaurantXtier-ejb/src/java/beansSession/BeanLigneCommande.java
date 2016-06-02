package beansSession;

import beanEntite.Article;
import beanEntite.EtatLigneCommande;
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
        String req = "select lc from LigneCommande lc where lc.etatLc.ordre<>4 order by lc.etatLc.ordre";
        Query qr = em.createQuery(req);
        List<LigneCommande> ligneCommandes = qr.getResultList();
        return ligneCommandes;
    }

    @Override
    public List<LigneCommande> selectAllLigneCommandeTriByPlat() {
        String req = "select lc from LigneCommande lc where lc.etatLc.ordre<>4 order by lc.article.nom";
        Query qr = em.createQuery(req);
        List<LigneCommande> ligneCommandes = qr.getResultList();
        return ligneCommandes;
    }

    @Override
    public LigneCommande changerEtatLigneCommande(Long idLc) {
        LigneCommande lCom = em.find(LigneCommande.class, idLc);
        Integer newOrdre = lCom.getEtatLc().getOrdre() + 1; // on ajoute 1 au numéro d'ordre
        //il faut récupérer l'idEtat du nouveau numéro d'ordre
        String req = "select elc from EtatLigneCommande elc "
                + "where elc.ordre =:paramOrdre";
        Query qr = em.createQuery(req);
        qr.setParameter("paramOrdre", newOrdre);
        //récupération de l'objet EtatLigneCommande de la requête
        EtatLigneCommande elc = (EtatLigneCommande) qr.getSingleResult();
        //set du nouvelle idEtat dans la ligne de commande
        lCom.setEtatLc(elc);
        return lCom;
    }

    @Override
    public List<LigneCommande> selectLigneCommandeServies() {
        String req = "select lc from LigneCommande lc where lc.etatLc.ordre=4 order by lc.article.nom "; // changer ordre=1 par 3 lorsque BDD plus fournie

        Query qr = em.createQuery(req);
        List<LigneCommande> ligneCommandes = qr.getResultList();
        return ligneCommandes;
    }

    @Override
    public List<LigneCommande> selectLigneCommandeByChrono() {
        String req = "select lc from LigneCommande lc where lc.etatLc.ordre<>4 order by lc.commande.date";
        Query qr = em.createQuery(req);
        List<LigneCommande> ligneCommandes = qr.getResultList();
        return ligneCommandes;
    }

    @Override
    public List<LigneCommande> selectLigneCommandeByEmplacement() {
        String req = "select lc from LigneCommande lc where lc.etatLc.ordre<>4 order by lc.commande.numero";
        Query qr = em.createQuery(req);
        List<LigneCommande> ligneCommandes = qr.getResultList();
        return ligneCommandes;
    }

    @Override
    public List<LigneCommande> selectLigneCommandeByCategorie() {
        String req = "select lc from LigneCommande lc where lc.etatLc.ordre<>4 order by lc.article.sousCategorie.categorie.nom";
        Query qr = em.createQuery(req);
        List<LigneCommande> ligneCommandes = qr.getResultList();
        return ligneCommandes;
    }

    @Override
    public LigneCommande creerLigneDeCommandeArticle(Long idArticle) {
        Article a = em.find(Article.class, idArticle);
        
        String req = "select e from EtatLigneCommande e where e.ordre=1";
        Query qr = em.createQuery(req);
        EtatLigneCommande elc = (EtatLigneCommande) qr.getSingleResult();
        System.out.println("ELC dans BEAN LIGNE COMM "+elc);
        
        
        LigneCommande lc = new LigneCommande();
        lc.setArticle(a);
        lc.setPrixHT(a.getPrixHt());
        lc.setEtatLc(elc);
        
        return lc;
    }

    
    
}

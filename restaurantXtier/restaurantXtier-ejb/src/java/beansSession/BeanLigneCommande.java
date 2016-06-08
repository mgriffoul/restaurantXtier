package beansSession;

import beanEntite.Article;
import beanEntite.EtatLigneCommande;
import beanEntite.Formule;
import beanEntite.LigneCommande;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BeanLigneCommande implements BeanLigneCommandeLocal {

//    private LigneCommande lc;
    
    @EJB
    private BeanFormuleLocal beanFormuleLocal;

//    @Override
//    public LigneCommande getLc() {
//        return lc;
//    }
//
//    public void setLc(LigneCommande lc) {
//        this.lc = lc;
//    }
    
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
        String req = "select lc from LigneCommande lc "
                + "where lc.etatLc.ordre<>4 and lc.article.sousCategorie.categorie.ordre=1 "
                + "or lc.etatLc.ordre<>4 and lc.article.sousCategorie.categorie.ordre=2 "
                + "or lc.etatLc.ordre<>4 and lc.article.sousCategorie.categorie.ordre=3 "
                + "order by lc.etatLc.ordre";
        Query qr = em.createQuery(req);
        List<LigneCommande> ligneCommandes = qr.getResultList();
        return ligneCommandes;
    }

    @Override
    public List<LigneCommande> selectAllLigneCommandeTriByPlat() {
        String req = "select lc from LigneCommande lc "
                + "where lc.etatLc.ordre<>4 and lc.article.sousCategorie.categorie.ordre=1 "
                + "or lc.etatLc.ordre<>4 and lc.article.sousCategorie.categorie.ordre=2 "
                + "or lc.etatLc.ordre<>4 and lc.article.sousCategorie.categorie.ordre=3 "
                + "order by lc.article.nom";
        Query qr = em.createQuery(req);
        List<LigneCommande> ligneCommandes = qr.getResultList();
        return ligneCommandes;
    }

    @Override
    public List<LigneCommande> selectLigneCommandeServies() {
        Date d =new Date ();
        
        System.out.println("Date du jour : "+d);
        String req = "select lc from LigneCommande lc "
                + "where lc.etatLc.ordre=4 and lc.article.sousCategorie.categorie.ordre=1 "
                + "or lc.etatLc.ordre=4 and lc.article.sousCategorie.categorie.ordre=2 "
                + "or lc.etatLc.ordre=4 and lc.article.sousCategorie.categorie.ordre=3 "
                + "order by lc.article.nom "; 

        Query qr = em.createQuery(req);
        List<LigneCommande> ligneCommandes = qr.getResultList();
        return ligneCommandes;
    }

    @Override
    public List<LigneCommande> selectLigneCommandeByChrono() {
        String req = "select lc from LigneCommande lc "
                + "where lc.etatLc.ordre<>4 and lc.article.sousCategorie.categorie.ordre=1 "
                + "or lc.etatLc.ordre<>4 and lc.article.sousCategorie.categorie.ordre=2 "
                + "or lc.etatLc.ordre<>4 and lc.article.sousCategorie.categorie.ordre=3 "
                + "order by lc.commande.date";
        Query qr = em.createQuery(req);
        List<LigneCommande> ligneCommandes = qr.getResultList();
        return ligneCommandes;
    }

    @Override
    public List<LigneCommande> selectLigneCommandeByEmplacement() {
        String req = "select lc from LigneCommande lc "
                + "where lc.etatLc.ordre<>4 and lc.article.sousCategorie.categorie.ordre=1 "
                + "or lc.etatLc.ordre<>4 and lc.article.sousCategorie.categorie.ordre=2 "
                + "or lc.etatLc.ordre<>4 and lc.article.sousCategorie.categorie.ordre=3 "
                + "order by lc.commande.numero";
        Query qr = em.createQuery(req);
        List<LigneCommande> ligneCommandes = qr.getResultList();
        return ligneCommandes;
    }

    @Override
    public List<LigneCommande> selectLigneCommandeByCategorie() {
        String req = "select lc from LigneCommande lc "
                + "where lc.etatLc.ordre<>4 and lc.article.sousCategorie.categorie.ordre=1 "
                + "or lc.etatLc.ordre<>4 and lc.article.sousCategorie.categorie.ordre=2 "
                + "or lc.etatLc.ordre<>4 and lc.article.sousCategorie.categorie.ordre=3 "
                + "order by lc.article.sousCategorie.categorie.ordre";
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

    @Override
    public List<LigneCommande> selectLigneCommandeByIdCommande(Long id){
                String rq = "Select lc from LigneCommande lc where lc.commande.id=:paramid";
        Query qr = em.createQuery(rq);
        qr.setParameter("paramid", id);
        List<LigneCommande> lc = qr.getResultList();
        return lc;
    }
      
    @Override
    public Float getPrixLcTTC(LigneCommande lc){
        Float prix = 0F;
        System.out.println("article prix = "+lc.getPrixHT());
        if (lc.getRefFormule() == null){
            prix = lc.getArticle().getPrixTtc();
            System.out.println("PRIX ARTICLE = "+prix);
            return prix;
        }else if(lc.getRefFormule() != null && lc.getPrixHT() > 0 ){
            String ref = lc.getRefFormule();          
            if(ref.contains("pat")){
                Formule form = beanFormuleLocal.selectFormuleByReference("pat");
                prix = form.getPrixTtc();
                return prix;
            }if(ref.contains("entpl")){
                Formule form = beanFormuleLocal.selectFormuleByReference("entpl");
                prix = form.getPrixTtc();
                System.out.println("PRIX form enypl = "+prix);
                return prix;
            }if(ref.contains("piz")){
                Formule form = beanFormuleLocal.selectFormuleByReference("piz");
                System.out.println("PRIX form piz = "+prix);
                prix = form.getPrixTtc();
                return prix;
            }
        }else if(lc.getRefFormule() != null && lc.getPrixHT() == 0){
            prix = 0F;
            return prix;
        }
    return prix;
    }
    
    
    
}


package beansSession;

import beanEntite.Article;
import beanEntite.Categorie;
import beanEntite.SousCategorie;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class BeanCategorie implements BeanCategorieLocal {

    @EJB
    private BeanSousCategorieLocal beanSousCate;
    
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

    @Override
    public List<Categorie> selectAllCategorie() {
           String req = "Select c from Categorie c order by c.ordre";
           Query qr = em.createQuery(req);
           List<Categorie> categories = qr.getResultList();
           for(Categorie c : categories){
               List<SousCategorie> sousCategories = selectSousCategorieByIdCategorie(c.getId());
               c.setSousCategories(sousCategories);
               for(SousCategorie s : sousCategories){
                   List<Article> articles = beanSousCate.selectArticleByIdSousCategorie(s.getId());
                   s.setArticles(articles);
               }
           }
           return categories;
    }

    @Override
    public List<SousCategorie> selectSousCategorieByIdCategorie(Long id) {
        String rq = "Select c.sousCategories"
                + " from Categorie c where c.id=:paramid  ";
        Query qr = em.createQuery(rq);
        qr.setParameter("paramid", id);
        List<SousCategorie> sousCategories = qr.getResultList();
        return sousCategories;
    }

    
    
    
    
}

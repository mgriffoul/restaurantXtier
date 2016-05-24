
package beansSession;

import beanEntite.Article;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class BeanArticle implements BeanArticleLocal {

    @PersistenceContext(name = "restaurantXtier-ejbPU")
    private EntityManager em;
    
    @Override
    public Article selectArticleById(Long id) {
        return em.find(Article.class, id);
    }

    @Override
    public List<Article> selectArticleByIdSousCategorie(Long id) {
        String req = "Select a from Article a where a.sousCategorie.id = :paramid";
        Query qr = em.createQuery(req);
        qr.setParameter("paramid", id);
        List<Article> articles = qr.getResultList();
        return articles;
    }

    @Override
    public List<Article> selectArticleByIdFormule(Long id) {
        String req = "Select f.articles from Formule f where f.id = :paramid";
        Query qr = em.createQuery(req);
        qr.setParameter("paramid", id);
        List<Article> articles = qr.getResultList();
        return articles;
    }

//    
//     System.out.println("7) tous animaux pour un soigneur donné et un centre donné");
//        String req07 = "select a from Soigneur s "
//                + " join s.animaux  a "
//                + " where a.centre.id = :paramIdCentre"
//                + " and s.id = :paramIdSoigneur";

    
    @Override
    public List<Article> selectArtByIdFormAndIdCate(Long idFormule, Long idCategorie) {
        String req = "Select ";
        Query qr = em.createQuery(req);
        qr.setParameter("paramid", idFormule);
        List<Article> articles = qr.getResultList();
        return articles;
    }
    
    
    
}

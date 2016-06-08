
package beansSession;

import beanEntite.Article;
import beanEntite.SousCategorie;
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
    public List<Article> selectArtByIdFormAndIdCate(Long idFormule, Long idCategorie) {
        String req = "Select a from Formule f"
                + " join f.articles a"
                + " where f.id = :paramidform and"
                + " a.sousCategorie.categorie.id = :paramidcat";
        Query qr = em.createQuery(req);
        qr.setParameter("paramidform", idFormule);
        qr.setParameter("paramidcat", idCategorie);
        List<Article> articles = qr.getResultList();
        return articles;
    }

    @Override
    public SousCategorie findSousCategorieOfArticle(Long idArticle) {
        return null;
    }
    
    @Override
    public Article selectArticleByIdLigneCommande(Long id){
        String req = "select a from LigneCommande lc join lc.article a where lc.id=:paramId";
        Query qr = em.createQuery(req);
        qr.setParameter("paramId", id);
        Article article = (Article)qr.getSingleResult();
        return article;
    }
    
    
}

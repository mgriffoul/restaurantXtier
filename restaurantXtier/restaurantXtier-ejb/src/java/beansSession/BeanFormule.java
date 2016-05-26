package beansSession;

import beanEntite.Article;
import beanEntite.Categorie;
import beanEntite.Formule;
import beanEntite.SousCategorie;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BeanFormule implements BeanFormuleLocal {

    @EJB
    private BeanSousCategorieLocal sousCategorie;

    @EJB
    private BeanArticleLocal article;

    @PersistenceContext(unitName = "restaurantXtier-ejbPU")
    private EntityManager em;

    @Override
    public List<Article> selectArticleByIdFormule(Long id) {
        String req = "Select f.articles from Formule f where f.id = :paramid";
        Query qr = em.createQuery(req);
        qr.setParameter("paramid", id);
        List<Article> articles = qr.getResultList();
        return articles;
    }

    @Override
    public List<Formule> selectAllFormule() {
        String req = "Select f from Formule f";
        Query qr = em.createQuery(req);
        List<Formule> formules = qr.getResultList();
        for(Formule f : formules) {
            List<Article> articles = selectArticleByIdFormule(f.getId());
            f.setArticles(articles);
        }
        return formules;
    }

    

}

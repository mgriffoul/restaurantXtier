package beansSession;

import beanEntite.Article;
import beanEntite.Formule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BeanFormule implements BeanFormuleLocal {

    

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

    @Override
    public ArrayList<Article> selectEntreesOfFormule(Formule f) {
        Collection<Article> allArticles = selectArticleByIdFormule(f.getId());
        ArrayList<Article> entrees = new ArrayList();

        for (Article a : allArticles) {
            if (a.getSousCategorie().getCategorie().getOrdre() == 1) {
                entrees.add(a);
            }
        }

        return entrees;
    }

    @Override
    public ArrayList<Article> selectPlatsOfFormule(Formule f) {
        Collection<Article> allArticles = selectArticleByIdFormule(f.getId());
        ArrayList<Article> plats = new ArrayList();

        for (Article a : allArticles) {
            if (a.getSousCategorie().getCategorie().getOrdre() == 2) {
                plats.add(a);
            }
        }

        return plats;
    }

    @Override
    public ArrayList<Article> selectDessertsOfFormule(Formule f) {
        Collection<Article> allArticles = selectArticleByIdFormule(f.getId());
        ArrayList<Article> desserts = new ArrayList();

        for (Article a : allArticles) {
            if (a.getSousCategorie().getCategorie().getOrdre() == 3) {
                desserts.add(a);
            }
        }

        return desserts;
    }

    @Override
    public ArrayList<Article> selectBoissonsOfFormule(Formule f) {
        Collection<Article> allArticles = selectArticleByIdFormule(f.getId());
        ArrayList<Article> boissons = new ArrayList();

        for (Article a : allArticles) {
            if (a.getSousCategorie().getCategorie().getOrdre() == 4) {
                boissons.add(a);
            }
        }

        return boissons;
    }

    @Override
    public Formule selectFormuleById(Long id) {
       return em.find(Formule.class, id);
    }

    @Override
    public void chargerFormule(Formule f) {
        ArrayList<Article> entrees = selectEntreesOfFormule(f);
            ArrayList<Article> plats = selectPlatsOfFormule(f);
            ArrayList<Article> desserts = selectDessertsOfFormule(f);
            ArrayList<Article> boissons = selectBoissonsOfFormule(f);
            System.out.println("Boissons SIZE = "+boissons.size());
            f.setEntrees(entrees);
            f.setPlats(plats);
            f.setDesserts(desserts);
            f.setBoissons(boissons);
             
    }

    @Override
    public Formule selectFormuleByRef(String refFormule) {
       
        String req = "Select f from Formule f where f.refFormule=:paramref";
        Query qr = em.createQuery(req);
        qr.setParameter("paramref", refFormule);
        Formule f = (Formule) qr.getSingleResult();
        return f;
        
    }

}


package beansSession;

import beanEntite.Article;
import beanEntite.Formule;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;


@Local
public interface BeanFormuleLocal {
    
    public List<Formule> selectAllFormule();
    public Formule selectFormuleById(Long id);
    public List<Article> selectArticleByIdFormule(Long id);
    public ArrayList<Article> selectEntreesOfFormule(Formule f);
    public ArrayList<Article> selectPlatsOfFormule(Formule f);
    public ArrayList<Article> selectDessertsOfFormule(Formule f);
    public ArrayList<Article> selectBoissonsOfFormule(Formule f);
    public Formule chargerFormule (Formule f);
}

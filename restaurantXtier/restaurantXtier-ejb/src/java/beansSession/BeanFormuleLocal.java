
package beansSession;

import beanEntite.Article;
import beanEntite.Formule;
import java.util.List;
import javax.ejb.Local;


@Local
public interface BeanFormuleLocal {
    
    public List<Formule> selectAllFormule();
    public List<Article> selectArticleByIdFormule(Long id);
    
}

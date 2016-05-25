package beansSession;

import beanEntite.Article;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BeanArticleLocal {

    public Article selectArticleById(Long id);


    public List<Article> selectArticleByIdFormule(Long id);

    public List<Article> selectArtByIdFormAndIdCate(Long idFormule, Long idCategorie);

}


package beansSession;

import beanEntite.Categorie;
import beanEntite.SousCategorie;
import java.util.List;
import javax.ejb.Local;


@Local
public interface BeanCategorieLocal {
    
    public Categorie selectCategorieById(Long id);
    public Categorie selectCategorieByNom(String nom);
    public List<Categorie> selectAllCategorie();
    public List<SousCategorie> selectSousCategorieByIdCategorie(Long id);
    
}

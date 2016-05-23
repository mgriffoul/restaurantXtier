
package beansSession;

import beanEntite.SousCategorie;
import java.util.List;
import javax.ejb.Local;


@Local
public interface BeanSousCategorieLocal {
    
    public SousCategorie selectSousCategorieById(Long id);
    public SousCategorie selectSousCategorieByNom(String nom);
    public List<SousCategorie> selectAllSousCategorie();
    public List<SousCategorie> selectAllSousCategorieByCategorieId(Long id);
}
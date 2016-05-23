
package beansSession;

import beanEntite.Categorie;
import javax.ejb.Local;


@Local
public interface BeanCategorieLocal {
    
    public Categorie selectCategorieById(Long id);
    public Categorie selectCategorieByNom(String nom);
    
    
}

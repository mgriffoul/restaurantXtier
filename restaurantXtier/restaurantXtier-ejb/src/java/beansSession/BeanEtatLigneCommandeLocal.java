
package beansSession;

import beanEntite.EtatLigneCommande;
import javax.ejb.Local;


@Local
public interface BeanEtatLigneCommandeLocal {
    
     public EtatLigneCommande selectEtatFromOrdre(Integer ordre);
}

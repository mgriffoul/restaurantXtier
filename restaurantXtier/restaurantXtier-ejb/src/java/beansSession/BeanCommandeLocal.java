package beansSession;

import beanEntite.Commande;
import beanEntite.LigneCommande;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BeanCommandeLocal {
     public Commande selectCommandeById(Long id);
     public Commande selectCommandeByDate(String date);
     public Commande selectCommandeByNumero(String numero);
     public List<LigneCommande> selectLigneCommandeByIdCommande(Long id);
}

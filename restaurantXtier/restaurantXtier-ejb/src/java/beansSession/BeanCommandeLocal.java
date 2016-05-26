package beansSession;

import beanEntite.Commande;
import beanEntite.LigneCommande;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BeanCommandeLocal {
     public Commande selectCommandeById(Long id);
     
     public Commande selectCommandeByNumero(String numero);
     public List<LigneCommande> selectLigneCommandeByIdCommande(Long id);

    public List<Commande> selectCommandeByDate(String date);

    public List<Commande> selectCommandeTerminee();

     public Commande newCommande();
     
}

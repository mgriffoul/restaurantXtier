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
<<<<<<< HEAD

    public List<Commande> selectCommandeByDate(String date);

    public List<Commande> selectCommandeTerminee();

=======
     public Commande newCommande();
>>>>>>> bb8aed3ce087ea765d7d2060bf49933108da3d4c
}

package beansSession;

import beanEntite.Commande;
import beanEntite.Emplacement;
import beanEntite.LigneCommande;
import beanEntite.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BeanCommandeLocal {

    public List<Integer> selectNumEmplacementById(Long id);

    public String selectNumCommandeByIdCommande(Long id);

    public List<Emplacement> selectEmplacementByIdCommande(Long id);

    public List<Commande> selectCommandeTerminee();

    public void sauvegarderCommande(Commande commande);

    public Commande selectCommandeById(String id);

    public Commande newCommande();

    public Commande createCommande(ArrayList<Emplacement> emps, Utilisateur ut01);

    public String createNumeroCommande();
    
    public List<Commande> selectCommandeByDate(String date);
    
     public Commande selectCommandeByNumero(String numero);

}

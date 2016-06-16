package beansSession;

import beanEntite.Commande;
import beanEntite.Emplacement;
import beanEntite.Utilisateur;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BeanCommandeLocal {

    public List<Integer> selectNumEmplacementById(Long id);

    public String selectNumCommandeByIdCommande(Long id);

    public List<Emplacement> selectEmplacementByIdCommande(Long id);

    public List<Commande> selectCommandeTerminee();

    public void sauvegarderCommande(Commande commande);

    public Commande selectCommandeById(Long id);

    public Commande newCommande();

    public Commande createCommande(Collection<Emplacement> emps, Utilisateur ut01);

    public String createNumeroCommande(long id);
    
    public List<Commande> selectCommandeByDate(String date);
    
     public Commande selectCommandeByNumero(String numero);
     
     public List<Commande> selectCommandeEnCours(); 
     
     public Commande selectCommandeByNumeroEmplacement(String numero);
    
     public void ajouterLigneDeCommande(Commande co, Long idArticle);

    public Float getTotalCommandeTtc(String numero);

    public void changerEtatCommande(String nCom);

    public void updateCommande(Commande commande);
}

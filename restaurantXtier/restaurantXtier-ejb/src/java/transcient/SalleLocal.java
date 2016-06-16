
package transcient;

import beanEntite.Article;
import beanEntite.Commande;
import beanEntite.Emplacement;
import beanEntite.Formule;
import beanEntite.LigneCommande;
import beanEntite.Utilisateur;
import beansSession.BeanCommandeLocal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;


@Local
public interface SalleLocal {
    
    public Integer creerCommande(Collection<Emplacement> emp, Utilisateur util);
    
    public GroupeEmplacementLocal getGroupesEmplacement();

    public void setGroupesEmplacement(GroupeEmplacementLocal groupesEmplacement);

    public BeanCommandeLocal getBeanCommande();

    public void setBeanCommande(BeanCommandeLocal beanCommande);

    public HashMap<Integer, Commande> getCommandes();

    public void setCommandes(HashMap<Integer, Commande> commandes);

    public List<Commande> selectCommandeEnCours();

    public Commande selectCommandeByCleCommande(Integer cleCommande);
    
    public void ajouterArticle (Integer cleCommande, Long idArticle);
    
    public void ajouterFormule (Integer cleCommande, Long idFormule, Article entree, Article plat, Article dessert, Article boisson);
    
    public Collection<LigneCommande> getAllLigneCommandeFromCommande(Integer cleCommande);
    
    public Collection<LigneCommande> getEntreesCommandees(Integer cleCommande);
    
    public Collection<LigneCommande> getPlatsCommandees(Integer cleCommande);
    
    public Collection<LigneCommande> getDessertsCommandees(Integer cleCommande);
    
    public Collection<LigneCommande> getBoissonsCommandees(Integer cleCommande);
    
    public Collection<LigneCommande> getFormulesCommandees(Integer cleCommande);
    
    public void enleverArticle (Integer cleCommande, Long idArticle);
    
    public Float getPrixTtcCommande(Integer cleCommande);
    
    public void enleverFormule(Integer cleCommande, String refFormule);
    
    public  HashMap<String, HashMap<Formule, Collection<LigneCommande>>>  getFormuleMapper(Collection<LigneCommande> lcs);
  
    public void changerElcFromIdLigneCom (String numeroCommande, Long idLc);
    
}

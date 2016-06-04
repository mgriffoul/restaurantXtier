
package transcient;

import beanEntite.Commande;
import beanEntite.Emplacement;
import beanEntite.Utilisateur;
import beansSession.BeanCommandeLocal;
import java.util.Collection;
import java.util.HashMap;
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
    
}

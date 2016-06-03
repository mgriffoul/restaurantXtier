

package transcient;

import beanEntite.Commande;
import beanEntite.Emplacement;
import beanEntite.Utilisateur;
import beansSession.BeanCommandeLocal;
import java.util.Collection;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Singleton;


@Singleton
public class Salle implements SalleLocal {
    @EJB
    private GroupeEmplacementLocal groupesEmplacement;
    @EJB
    private BeanCommandeLocal beanCommande;

    private HashMap<Integer,Commande> commandes;

    
    
    //crée une commande, la rajoute dans la salle, crée le groupe d'emplacement à partir de la collection de table,
    //le rajoute dans le bean Groupe emplacement et retourne l'integer correspondant à la clef
    //de la commande.
    @Override
    public Integer creerCommande(Collection<Emplacement> emp, Utilisateur util) {
        
        Commande c01 = beanCommande.createCommande(emp, util);
        //appeler createnumerocommande quelquepart
        Integer keyCommande = groupesEmplacement.creerGroupe(emp);
        commandes.put(keyCommande, c01);
        
        return keyCommande;
    }

  
    
    
    
    
    
}

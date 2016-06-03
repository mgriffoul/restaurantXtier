

package transcient;

import beanEntite.Commande;
import java.util.HashMap;
import javax.ejb.Singleton;


@Singleton
public class Salle implements SalleLocal {

    private HashMap<Integer,Commande> commandes;
    
}

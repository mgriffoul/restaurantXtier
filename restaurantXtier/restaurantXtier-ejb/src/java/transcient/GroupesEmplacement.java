package transcient;

import beanEntite.Commande;
import beanEntite.Emplacement;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.Query;

@Singleton
public class GroupesEmplacement implements GroupeEmplacementLocal {

    private HashMap<Integer, Collection<Emplacement>> emplacements;

    @PostConstruct
    public void init() {
        emplacements = new HashMap<>();
    }

    public HashMap<Integer, Collection<Emplacement>> getEmplacements() {
        return emplacements;
    }

    public void setEmplacements(HashMap<Integer, Collection<Emplacement>> emplacements) {
        this.emplacements = emplacements;
    }

    
    @Override
    public Integer creerGroupe(Collection<Emplacement> emp) {
       Integer y = null;
        for (Emplacement e : emp) {
            if(y==null){
                y=e.getNumero();
            }
            if (e.getNumero() < y) {
                y = e.getNumero();
            }
        }
        emplacements.put(y, emp);
        return y;
    }
    
    

    
  
    

}

package transcient;

import beanEntite.Emplacement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
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
    public Integer ajouterGroupe(Collection<Emplacement> emp) {
        Integer y = null;
        Set st = emplacements.keySet();
        for (int i = 1; i < 500 && y == null; i++) {
            if (!st.contains(i)) {
                System.out.println("i==" + i);
                y = i;
            }
        }
        emplacements.put(y, emp);
        return y;
    }

}

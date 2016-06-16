package transcient;

import beanEntite.Commande;
import beanEntite.Emplacement;
import beansSession.BeanEmplacementLocal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;

@Singleton
public class GroupesEmplacement implements GroupeEmplacementLocal {

    @EJB
    private SalleLocal salle;

    @EJB
    private BeanEmplacementLocal beanEmplacement;

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
    public Integer getKeyEmpByEmpNum(Integer Numero) {
        for (Map.Entry<Integer, Collection<Emplacement>> entry : emplacements.entrySet()) {
            Collection<Emplacement> emp = entry.getValue();
            for (Emplacement e : emp) {
                if (e.getNumero().equals(Numero)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    @Override
    public Collection<Emplacement> selectEmplacementsByKey(Integer key) {
        Collection<Emplacement> listEmplacement = null;
        for (Map.Entry<Integer, Collection<Emplacement>> entry : emplacements.entrySet()) {
            if (entry.getKey().equals(key)) {
                listEmplacement = entry.getValue();
                return listEmplacement;
            }
        }
        return listEmplacement;
    }

    @Override
    public Integer creerGroupe(Collection<Emplacement> emp) {
        Integer y = null;
        for (Emplacement e : emp) {
            if (y == null) {
                y = e.getNumero();
            }
            if (e.getNumero() < y) {
                y = e.getNumero();
            }
        }
        emplacements.put(y, emp);
        return y;
    }

}

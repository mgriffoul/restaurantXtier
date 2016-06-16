package transcient;

import beanEntite.Emplacement;
import beansSession.BeanEmplacementLocal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;

@Singleton
public class GroupesEmplacement implements GroupeEmplacementLocal {

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
    public Collection<Emplacement> getEmplacementsList() {
        Collection<Emplacement> emp = new ArrayList<>();
        Collection<Emplacement> emp2 = new ArrayList<>();

        Collection<Emplacement> empList = beanEmplacement.selectAllEmplacement();

        for (Map.Entry<Integer, Collection<Emplacement>> entry : emplacements.entrySet()) {
            for (Emplacement e : entry.getValue()) {
                emp.add(e);
            }
        }
        System.out.println("EMPLACEMENT>>>>>>>>>>>>>>>>>>>" + emp);
        System.out.println("EMPLACEMENT>>>>>>>>>>>>>>>>>>>" + empList);

        for (Emplacement e : empList) {
            Emplacement ee = null;
            for (Emplacement ep : emp) {
                System.out.println(e.getNumero() + "  " + ep.getNumero());
                if (e.getNumero() == ep.getNumero()) {
                    ee = ep;
                }
                //                    e = ep;
            }
            if (ee == null) {
                emp2.add(e);
            } else {
                emp2.add(ee);
            }
        }
        return emp2;
    }
    
    public void updateEmplacement(String action, Integer key){
         Collection<Emplacement> list = emplacements.get(key);
         for (Emplacement e : list){
             e.setStatut(action);
         }
        emplacements.replace(key, list);
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
        for (Emplacement e : emp) {
            e.setStatut("non valide");
            e.setKeyCommande(y);
        }
        emplacements.put(y, emp);
        return y;
    }

}

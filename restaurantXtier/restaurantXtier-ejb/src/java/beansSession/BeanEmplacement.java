package beansSession;

import beanEntite.Commande;
import beanEntite.Emplacement;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import transcient.GroupeEmplacementLocal;
import transcient.SalleLocal;

@Stateless
public class BeanEmplacement implements BeanEmplacementLocal {
    @EJB
    private GroupeEmplacementLocal groupesEmplacement;
    
    @EJB
    private SalleLocal salle;

    


    @PersistenceContext(name = "restaurantXtier-ejbPU")
    private EntityManager em;

    @Override
    public List<Emplacement> selectAllEmplacement() {
        String req = "Select e from Emplacement e order by e.numero asc";
        Query qr = em.createQuery(req);
        List<Emplacement> listEmplacement = qr.getResultList();
        for(Emplacement emp : listEmplacement){
            emp.setStatut("libre");
            updateEmplacement(emp);
        }
        return listEmplacement;
    }

    @Override
    public Emplacement selectEmplacementById(Long id) {
        return em.find(Emplacement.class, id);
    }

    @Override
    public Emplacement selectEmplacementByNumero(String numero) {
        int num = Integer.parseInt(numero);
        String req = "Select e from Emplacement e where e.numero=:paramnumero";
        Query qr = em.createQuery(req);
        qr.setParameter("paramnumero", num);
        Emplacement emp = (Emplacement) qr.getSingleResult();
        return emp;
    }

    @Override
    public List<Emplacement> selectEmplPourComEnCours() {

        String req = "Select c.emplacements From Commande c"
                + " where c.statut = :paramstatut";

        Query qr = em.createQuery(req);
        qr.setParameter("paramstatut", "en cours");
        List<Emplacement> emplacements = qr.getResultList();

        return emplacements;
    }

    @Override
    public void updateEmplacement(Emplacement emplacement) {
        em.merge(emplacement);
    }
}

package beansSession;

import beanEntite.TypeCuisson;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CreationBdd implements CreationBddLocal {

    @PersistenceContext(unitName = "restaurantXtier-ejbPU")
    private EntityManager em;

    @Override
    public void genererBdd() {

        TypeCuisson typeCuisson = new TypeCuisson("rosé");

        em.persist(typeCuisson);

    }

}

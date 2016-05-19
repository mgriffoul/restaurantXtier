package beansSession;

import beanEntite.TypeCuisson;
import beanEntite.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CreationBdd implements CreationBddLocal {

    @PersistenceContext(unitName = "restaurantXtier-ejbPU")
    private EntityManager em;

    @Override
    public void genererBdd() {

//        TypeCuisson typeCuisson = new TypeCuisson("rosé");
//        em.persist(typeCuisson);
        
        // Création Utilisateurs
        Utilisateur u01 = new Utilisateur ("1111",1,"","");
        Utilisateur u02 = new Utilisateur ("2222",2,"","");
        Utilisateur u03 = new Utilisateur ("3331",3,"De Berranger","Ludo");
        Utilisateur u04 = new Utilisateur ("3332",3,"Griffoul","Mathieu");
        Utilisateur u05 = new Utilisateur ("3333",3,"Lièvre","Arnaud");
        Utilisateur u06 = new Utilisateur ("3334",3,"Gantner","Bruce");
        Utilisateur u07 = new Utilisateur ("4444",4,"","");
        
        em.persist(u01);
        em.persist(u02);
        em.persist(u03);
        em.persist(u04);
        em.persist(u05);
        em.persist(u06);
        em.persist(u07);

    }

}

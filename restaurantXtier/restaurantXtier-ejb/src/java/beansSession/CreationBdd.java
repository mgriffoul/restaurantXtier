package beansSession;

import beanEntite.Sauce;
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

        //Création Utilisateurs
        Utilisateur u01 = new Utilisateur("1111", 1, "", "");
        Utilisateur u02 = new Utilisateur("2222", 2, "", "");
        Utilisateur u03 = new Utilisateur("3331", 3, "De Berranger", "Ludo");
        Utilisateur u04 = new Utilisateur("3332", 3, "Griffoul", "Mathieu");
        Utilisateur u05 = new Utilisateur("3333", 3, "Lièvre", "Arnaud");
        Utilisateur u06 = new Utilisateur("3334", 3, "Gantner", "Bruce");
        Utilisateur u07 = new Utilisateur("4444", 4, "", "");
        Utilisateur u08 = new Utilisateur("0000",5,"","");
        //Fin création Utilisateur

        //Création Sauces
        Sauce s01 = new Sauce("Hollandaire");
        Sauce s02 = new Sauce("Poivre");
        Sauce s03 = new Sauce("Mayonnaise");
        Sauce s04 = new Sauce("Béarnaise");
        Sauce s05 = new Sauce("Beure blanc");
        //Fin création Sauces

        //Création des type de cuisson
        TypeCuisson tc01 = new TypeCuisson("Rosé");
        TypeCuisson tc02 = new TypeCuisson("Saignant");
        TypeCuisson tc03 = new TypeCuisson("A point");
        TypeCuisson tc04 = new TypeCuisson("Bien cuit");
        //Fin des type de cuisson
        
        

        em.persist(s01);
        em.persist(s02);
        em.persist(s03);
        em.persist(s04);
        em.persist(s05);
        
        em.persist(tc01);
        em.persist(tc01);
        em.persist(tc01);
        em.persist(tc01);

        em.persist(u01);
        em.persist(u02);
        em.persist(u03);
        em.persist(u04);
        em.persist(u05);
        em.persist(u06);
        em.persist(u07);

    }

}

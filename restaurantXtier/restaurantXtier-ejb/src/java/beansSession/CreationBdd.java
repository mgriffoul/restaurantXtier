package beansSession;

import beanEntite.Article;
import beanEntite.Categorie;
import beanEntite.SousCategorie;
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
        
        //Categories
        Categorie cat01 = new Categorie();
        cat01.setNom("Les Entrées");
        Categorie cat02 = new Categorie();
        cat02.setNom("Les Plats");
        Categorie cat03 = new Categorie();
        cat03.setNom("Les Desserts");
        Categorie cat04 = new Categorie();
        cat04.setNom("Les Boissons");
        Categorie cat05 = new Categorie();
        cat05.setNom("Les Vins");
        
        
        //SousCategories
        //sous cat de Entrées
        SousCategorie sCat01 = new SousCategorie(cat01, "Antipasti");
        SousCategorie sCat02 = new SousCategorie(cat01, "Salades");
        //sous cat de Plats
        SousCategorie sCat03 = new SousCategorie(cat02, "Les Pizza");
        SousCategorie sCat04 = new SousCategorie(cat02, "Les Pâtes");
        SousCategorie sCat05 = new SousCategorie(cat02, "Les viandes");
        //sous cat de Desserts
        SousCategorie sCat06 = new SousCategorie(cat03, "Patisseries");
        SousCategorie sCat07 = new SousCategorie(cat03, "Glaces");
        //sous cat les boissons
        SousCategorie sCat08 = new SousCategorie(cat04, "Les eaux minérales");
        SousCategorie sCat09 = new SousCategorie(cat04, "Sans Alcohol");
        SousCategorie sCat10 = new SousCategorie(cat04, "Cocktails");
        SousCategorie sCat11 = new SousCategorie(cat04, "Digestifs");
        SousCategorie sCat12 = new SousCategorie(cat04, "Boissons chaudes");
        //sous cat les vins
        SousCategorie sCat13 = new SousCategorie(cat05, "Les rouges");
        SousCategorie sCat14 = new SousCategorie(cat05, "Les blancs");
        SousCategorie sCat15 = new SousCategorie(cat05, "Les rosés");
        
        //tva1 5.5 ...tva2 10 .... tv3 20
        
        
        //Articles
        //antipasti
        String des1 = "pain grillé à l’ail, au fromage de chèvre OAC et épinards";
        Article ar01 = new Article(sCat01, tva2, "Bruschetta chèvre épinard", 3.5F,des1);
        String des2 = "pain grillé à l’ail, à la viande achées de boeuf, oignons et coriandre";
        Article ar02 = new Article(sCat01, tva2, "Bruschetta au boeuf", 3.5F,des2);
        String des3 = "pain grillé à l’ail, mozzarella gratiné au four, tomate fraiche coupé en dés, pesto maison";
        Article ar03 = new Article(sCat01, tva2, "Bruschetta napolitaine", 3.5F,des3);
        String des7 = "carpaccio de bœuf, roquettes, pesto maison, copeau de grana padano, câpres";
        Article ar08 = new Article(sCat01, tva2, "Carpaccion Piccolo", 6F,des7);
        //salades
        Article ar04 = new Article(sCat02, tva2, "Salade verte", 3F,null);
        String des4 = "Salade verte, tomate, olives, chorizo";
        Article ar05 = new Article(sCat02, tva2, "Salade Romaine", 7F,des4);
        String des5 = "roquettes, artichauts marinés, tomates séchées, huile d’olive, crème balsamique";
        Article ar06 = new Article(sCat02, tva2, "Salade d'artichauts marinés", 9F,des5);
        String des6 = "Salade verte, poulet grillé, tomate, oignon, crouton à l'ail, huile d'olive";
        Article ar07 = new Article(sCat02, tva2, "Salade César", 7F,des6);
        //Plats
        //Pizza
        String des9 = "tomate, fromage, origan";
        Article ar09 = new Article(sCat03, tva2, "Pizza Margherita", 6F,des7);
        String des10 = "tomate, fromage, anchois, câpres, olives, origan";
        Article ar10 = new Article(sCat03, tva2, "Pizza Napolitana", 6F,des7);
        String des11 = "tomate, fromage, épaule, œuf, origan";
        Article ar11 = new Article(sCat03, tva2, "Pizza Calzone ", 6F,des7);
        String des12 = "tomate, fromage, champignon, épaule, origan";
        Article ar12 = new Article(sCat03, tva2, "Pizza Régina", 6F,des7);
        String des13 = "tomate, fromage, gorgonzola, chèvre, camembert, parmesan";
        Article ar13 = new Article(sCat03, tva2, "Pizza Quatre Fromages", 6F,des7);
        String des14 = "tomate, fromage, champignons, saumon fumé, crème fraîche, origan";
        Article ar14 = new Article(sCat03, tva2, "Pizza salmoni", 6F,des7);
        
        
        em.persist(cat01);
        em.persist(cat02);
        em.persist(cat03);
        em.persist(cat04);
        em.persist(cat05);
        em.persist(sCat01);
        em.persist(sCat02);
        em.persist(sCat03);
        em.persist(sCat04);
        em.persist(sCat05);
        em.persist(sCat06);
        em.persist(sCat07);
        em.persist(sCat08);
        em.persist(sCat09);
        em.persist(sCat10);
        em.persist(sCat11);
        em.persist(sCat12);
        em.persist(sCat13);
        em.persist(sCat14);
        em.persist(sCat15);
        
        
        Article a01 = new Article();
        
        
        
    }

}

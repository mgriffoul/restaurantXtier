package beansSession;


import beanEntite.Article;
import beanEntite.Categorie;
import beanEntite.SousCategorie;

import beanEntite.Tva;

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

        
        // Création TVA
        Tva tva1 = new Tva (5.5f); // tva pour boisson non alcoolisées
        Tva tva2 = new Tva (10f); // tva pour tous les plats
        Tva tva3 = new Tva (20f); // tva pour boissons alcoolisées
        // fin création TVA
        em.persist(tva1);
        em.persist(tva2);
        em.persist(tva3);
        
        
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
        
        //tva1 5.5 ...tva2 10 .... tv3 20
        
        
        //Articles
        //antipasti
        String des1 = "pain grillé à l’ail, au fromage de chèvre OAC et épinards";
        Article ar01 = new Article(sCat01, tva2, "Bruschetta chèvre épinard", 3.5F,des1);
        em.persist(ar01);
        String des2 = "pain grillé à l’ail, à la viande achées de boeuf, oignons et coriandre";
        Article ar02 = new Article(sCat01, tva2, "Bruschetta au boeuf", 3.5F,des2);
        em.persist(ar02);
        String des3 = "pain grillé à l’ail, mozzarella gratiné au four, tomate fraiche coupé en dés, pesto maison";
        Article ar03 = new Article(sCat01, tva2, "Bruschetta napolitaine", 3.5F,des3);
        em.persist(ar03);
        String des7 = "carpaccio de bœuf, roquettes, pesto maison, copeau de grana padano, câpres";
        Article ar08 = new Article(sCat01, tva2, "Carpaccion Piccolo", 6F,des7);
        em.persist(ar08);
        //salades
        Article ar04 = new Article(sCat02, tva2, "Salade verte", 3F,null);
        em.persist(ar04);
        String des4 = "Salade verte, tomate, olives, chorizo";
        Article ar05 = new Article(sCat02, tva2, "Salade Romaine", 6F,des4);
        em.persist(ar05);
        String des5 = "roquettes, artichauts marinés, tomates séchées, huile d’olive, crème balsamique";
        Article ar06 = new Article(sCat02, tva2, "Salade d'artichauts marinés", 8F,des5);
        em.persist(ar06);
        String des6 = "Salade verte, poulet grillé, tomate, oignon, crouton à l'ail, huile d'olive";
        Article ar07 = new Article(sCat02, tva2, "Salade César", 8F,des6);
        em.persist(ar07);
        //Plats
        //Pizza
        String des9 = "tomate, fromage, origan";
        Article ar09 = new Article(sCat03, tva2, "Pizza Margherita", 11F,des7);
        em.persist(ar09);
        String des10 = "tomate, fromage, anchois, câpres, olives, origan";
        Article ar10 = new Article(sCat03, tva2, "Pizza Napolitana", 13F,des7);
        em.persist(ar10);
        String des11 = "tomate, fromage, épaule, œuf, origan";
        Article ar11 = new Article(sCat03, tva2, "Pizza Calzone ", 12F,des7);
        em.persist(ar11);
        String des12 = "tomate, fromage, champignon, épaule, origan";
        Article ar12 = new Article(sCat03, tva2, "Pizza Régina", 14F,des7);
        em.persist(ar12);
        String des13 = "tomate, fromage, gorgonzola, chèvre, camembert, parmesan";
        Article ar13 = new Article(sCat03, tva2, "Pizza Quatre Fromages", 14F,des7);
        em.persist(ar13);
        String des14 = "tomate, fromage, champignons, saumon fumé, crème fraîche, origan";
        Article ar14 = new Article(sCat03, tva2, "Pizza salmoni", 13F,des7);
        em.persist(ar14);
        
        
        String desA1 = "L'orée des bois s'invite dans ces verrines printanières au coulis de fruits rouges";
Article de1 = new Article(sCat06, tva2, "Pannacotta aux fruits des bois",5.8F,desA1);
em.persist(de1);
desA1 = "On craque pour ce grand classique italien au café composé de plusieurs couches de boudoirs et de mascarpone.";
Article de2 = new Article(sCat06, tva2, "Tiramisu",6.0F,desA1);
em.persist(de2);
desA1 = "des griottes très goûteuses semi-confites dans un sirop de sucre et cuites dans un jus de myrtille pour le plus grand plaisir de votre palais";
Article de3 = new Article(sCat06, tva2, "Coulant au chocolat et cerise amarena",6.5F,desA1);
em.persist(de3);
desA1 = "Un trésor de la plus pure tradition italienne. Idéal pour accompagner votre café";
Article de4 = new Article(sCat06, tva2, "Biscotti aux amandes et cerises séchées", 4.8F, desA1);
em.persist(de4);
desA1 = "Ce dessert napolitain se compose de petites billes sucrées et vanillées frites et trempées dans du miel";
Article de5 = new Article(sCat06, tva2, "Struffoli", 6.0F, desA1);
em.persist(de5);
desA1 = "Cette crème glacée parfumée aux fruits de saison va rafraîchir vos papilles";
Article de6 = new Article(sCat07, tva2, "Semifreddo", 6.0F, desA1);
em.persist(de6);
desA1 = "Un cappuccino glacé avec sa mousse de fuits onctueuse";
Article de7 = new Article(sCat07, tva2, "Cappuccino de fruits glacés", 7.0F, desA1);
em.persist(de7);
desA1 = "Stracciatella, Tarte au citron meringuée, Panacotta fraises des bois, Vanille, Café, Fruits de la Passion, Cassis, Citron, Mangue";
Article de8 = new Article(sCat07, tva2, "Sorbet glacé deux boules", 6.0F, desA1);
em.persist(de8);

// VIANDES

desA1 = "une escalope qui saute en bouche et fond délicatement sur la langue";
Article vi1 = new Article(sCat05, tva2, "Saltimbocca de veau à la mozzarella, tomates cerise au miel", 12.5F, desA1);
em.persist(vi1);
desA1 = "L’osso buco est un plat traditionnel milanais, très parfumé, constitué d'un ragoût jarret de veau, braisé au vin blanc sec et agrémenté de légumes";
Article vi2 = new Article(sCat05, tva2, "Osso bucco de veau à la milanaise", 14.5F, desA1);
em.persist(vi2);
desA1 = "Des escalopes de dinde finement tranchées, marinées aux herbes fraîches puis snackées";
Article vi3 = new Article(sCat05, tva2, "Piccata de dinde marinée aux herbes", 13.5F, desA1);
em.persist(vi3);
desA1 = "Fraîcheur du boeuf cru haché finement et assaisonné de câpres, tomates, oignons et basilic. ";
Article vi4 = new Article(sCat05, tva2, "Tartare de boeuf au basilic et crumble au parmesan", 15.5F, desA1);
em.persist(vi4);
        
        
// eaux minérales
		
		String desEau1="1L, plate, France. Sa source se situe à Vittel dans le département français des Vosges.";
		Article eau1 = new Article (sCat08,tva1,"Vittel",3F,desEau1);
		em.persist(eau1);
		String desEau2="1L, plate, Italie. Née à 1416 mètres dans un environnement pur et protégé de la pollution, elle est légère avec un taux très faible en sodium.";
		Article eau2 = new Article (sCat08,tva1,"Lurésia",3F,desEau2);
		em.persist(eau2);
		String desEau3="1L, gazeuse, France. Sa source se situe à Saint-Galmier dans le département de la Loire.";
		Article eau3 = new Article (sCat08,tva1,"Badoit",4F,desEau3);
		em.persist(eau3);
		String desEau4="1L, gazeuse, Italie. L'eau minérale San Pellegrino est produite depuis plus de 600 ans.";
		Article eau4 = new Article (sCat08,tva1,"Sanpellegrino",4F,desEau4);
                em.persist(eau4);
		// boissons non alcoolisées
		
		String desBoiSa1 = "33cl.";
		Article boiSa1 = new Article (sCat09,tva1,"Coca-Cola",5F,desBoiSa1);
		em.persist(boiSa1);
		String desBoiSa2 = "33cl.";
		Article boiSa2 = new Article (sCat09,tva1,"Coca-Cola Light",5F,desBoiSa2);
		em.persist(boiSa2);
		String desBoiSa3 = "25cl.";
		Article boiSa3 = new Article (sCat09,tva1,"Jus de Pomme",5F,desBoiSa3);
		em.persist(boiSa3);
		String desBoiSa4 = "25cl.";
		Article boiSa4 = new Article (sCat09,tva1,"Jus d'Orange",5F,desBoiSa4);
		em.persist(boiSa4);
		String desBoiSa5 = "25cl. Cocktail de fruits frais sans alcool.";
		Article boiSa5 = new Article (sCat09,tva1,"Cocktail de fruits",6F,desBoiSa5);
		em.persist(boiSa5);

		// cocktails
		
		String desCock1="Tequila, Jus d'Orange, sirop de Grenadine.";
		Article cock1 = new Article (sCat10,tva3,"Tequila Sunrise", 7F, desCock1);
		em.persist(cock1);
		String desCock2="Rhum, jus de Citron vert, Menthe, eau gazeuse, sirop de sucre de canne.";
		Article cock2 = new Article (sCat10,tva3,"Mojito", 7F, desCock2);
		em.persist(cock2);
		String desCock3="Vodka, curaçao bleu, jus de citron.";
		Article cock3 = new Article (sCat10,tva3,"Blue Lagoon", 7F, desCock3);
		em.persist(cock3);
		String desCock4="vodka, sirop de melon, Chambord, jus d'ananas, jus de cranberry";
		Article cock4 = new Article (sCat10,tva3,"Sex on the beach", 7F, desCock4);
		em.persist(cock4);
		
		// persist
		em.persist(eau1);
		em.persist(eau2);
		em.persist(eau3);
		em.persist(eau4);
		em.persist(boiSa1);
		em.persist(boiSa2);
		em.persist(boiSa3);
		em.persist(boiSa4);
		em.persist(boiSa5);
		em.persist(cock1);
		em.persist(cock2);
		em.persist(cock3);
		em.persist(cock4);



        
        // Création Utilisateurs
        Utilisateur u01 = new Utilisateur ("1111",1,"","");
        Utilisateur u02 = new Utilisateur ("2222",2,"","");
        Utilisateur u03 = new Utilisateur ("3331",3,"De Berranger","Ludo");
        Utilisateur u04 = new Utilisateur ("3332",3,"Griffoul","Mathieu");
        Utilisateur u05 = new Utilisateur ("3333",3,"Lièvre","Arnaud");
        Utilisateur u06 = new Utilisateur ("3334",3,"Gantner","Bruce");
        Utilisateur u07 = new Utilisateur ("4444",4,"","");
        // fin création Utilisateurs
        em.persist(u01);
        em.persist(u02);
        em.persist(u03);
        em.persist(u04);
        em.persist(u05);
        em.persist(u06);
        em.persist(u07);
        
        

        
    }

}

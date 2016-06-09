package beansSession;



import beanEntite.Sauce;
import beanEntite.TypeCuisson;
import beanEntite.Article;
import beanEntite.Categorie;
import beanEntite.Commande;
import beanEntite.Emplacement;
import beanEntite.EtatLigneCommande;
import beanEntite.Formule;
import beanEntite.LigneCommande;
import beanEntite.SousCategorie;
import beanEntite.Tva;
import beanEntite.Utilisateur;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BeanCreationBdd implements BeanCreationBddLocal {

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

        

        // Création TVA
        Tva tva1 = new Tva(5.5f); // tva pour boisson non alcoolisées
        Tva tva2 = new Tva(10f); // tva pour tous les plats
        Tva tva3 = new Tva(20f); // tva pour boissons alcoolisées
        // fin création TVA
        em.persist(tva1);
        em.persist(tva2);
        em.persist(tva3);

        //Categories
        Categorie cat01 = new Categorie();
        cat01.setNom("Les Entrées");
        cat01.setOrdre(1);
        Categorie cat02 = new Categorie();
        cat02.setNom("Les Plats");
        cat02.setOrdre(2);
        Categorie cat03 = new Categorie();
        cat03.setNom("Les Desserts");
        cat03.setOrdre(3);
        Categorie cat04 = new Categorie();
        cat04.setNom("Les Boissons");
        cat04.setOrdre(4);
        Categorie cat05 = new Categorie();
        cat05.setNom("Les Vins");
        cat05.setOrdre(5);
        //SousCategories
        //sous cat de Entrées
        SousCategorie sCat01 = new SousCategorie(cat01, "Antipasti",1);
        SousCategorie sCat02 = new SousCategorie(cat01, "Salades",2);
        //sous cat de Plats
        SousCategorie sCat03 = new SousCategorie(cat02, "Les Pizza",1);
        SousCategorie sCat04 = new SousCategorie(cat02, "Les Pâtes",2);
        SousCategorie sCat05 = new SousCategorie(cat02, "Les viandes",3);
        //sous cat de Desserts
        SousCategorie sCat06 = new SousCategorie(cat03, "Patisseries",1);
        SousCategorie sCat07 = new SousCategorie(cat03, "Glaces",2);
        //sous cat les boissons
        SousCategorie sCat08 = new SousCategorie(cat04, "Les eaux minérales",1);
        SousCategorie sCat09 = new SousCategorie(cat04, "Sans Alcohol",2);
        SousCategorie sCat10 = new SousCategorie(cat04, "Cocktails",3);
        SousCategorie sCat11 = new SousCategorie(cat04, "Digestifs",4);
        SousCategorie sCat12 = new SousCategorie(cat04, "Boissons chaudes",5);
        //sous cat les vins
        SousCategorie sCat13 = new SousCategorie(cat05, "Les rouges",1);
        SousCategorie sCat14 = new SousCategorie(cat05, "Les blancs",2);
        SousCategorie sCat15 = new SousCategorie(cat05, "Les rosés",3);

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

        //tva1 5.5 ...tva2 10 .... tv3 21
        //********
        //Articles
        //********
        //antipasti
        String des1 = "pain grillé à l’ail, au fromage de chèvre OAC et épinards";
        Article ar01 = new Article(sCat01, tva2, "Bruschetta chèvre épinard", 3.5F, des1);
        em.persist(ar01);
        String des2 = "pain grillé à l’ail, à la viande achées de boeuf, oignons et coriandre";
        Article ar02 = new Article(sCat01, tva2, "Bruschetta au boeuf", 3.5F, des2);
        em.persist(ar02);
        String des3 = "pain grillé à l’ail, mozzarella gratiné au four, tomate fraiche coupé en dés, pesto maison";
        Article ar03 = new Article(sCat01, tva2, "Bruschetta napolitaine", 3.5F, des3);
        em.persist(ar03);
        String des7 = "carpaccio de bœuf, roquettes, pesto maison, copeau de grana padano, câpres";
        Article ar08 = new Article(sCat01, tva2, "Carpaccion Piccolo", 6F, des7);
        em.persist(ar08);
        //salades
        Article ar04 = new Article(sCat02, tva2, "Salade verte", 3F, null);
        em.persist(ar04);
        String des4 = "Salade verte, tomate, olives, chorizo";
        Article ar05 = new Article(sCat02, tva2, "Salade Romaine", 6F, des4);
        em.persist(ar05);
        String des5 = "roquettes, artichauts marinés, tomates séchées, huile d’olive, crème balsamique";
        Article ar06 = new Article(sCat02, tva2, "Salade d'artichauts marinés", 8F, des5);
        em.persist(ar06);
        String des6 = "Salade verte, poulet grillé, tomate, oignon, crouton à l'ail, huile d'olive";
        Article ar07 = new Article(sCat02, tva2, "Salade César", 8F, des6);
        em.persist(ar07);
        //Plats
        //Pizza
        String des9 = "tomate, fromage, origan";
        Article ar09 = new Article(sCat03, tva2, "Pizza Margherita", 11F, des9);
        em.persist(ar09);
        String des10 = "tomate, fromage, anchois, câpres, olives, origan";
        Article ar10 = new Article(sCat03, tva2, "Pizza Napolitana", 13F, des10);
        em.persist(ar10);
        String des11 = "tomate, fromage, épaule, œuf, origan";
        Article ar11 = new Article(sCat03, tva2, "Pizza Calzone ", 12F, des11);
        em.persist(ar11);
        String des12 = "tomate, fromage, champignon, épaule, origan";
        Article ar12 = new Article(sCat03, tva2, "Pizza Régina", 14F, des12);
        em.persist(ar12);
        String des13 = "tomate, fromage, gorgonzola, chèvre, camembert, parmesan";
        Article ar13 = new Article(sCat03, tva2, "Pizza Quatre Fromages", 14F, des13);
        em.persist(ar13);
        String des14 = "tomate, fromage, champignons, saumon fumé, crème fraîche, origan";
        Article ar14 = new Article(sCat03, tva2, "Pizza salmoni", 13F, des14);
        em.persist(ar14);
// VIANDES
        String desA1 = "une escalope qui saute en bouche et fond délicatement sur la langue";
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
//Pates
        String desp01 = "tagliatelles, crème fraîche, lardons, jaune d’œuf";
        Article pa01 = new Article(sCat04, tva2, "Tagliatelles Carbonara", 12.5F, desp01);
        em.persist(pa01);
        String desp02 = "raviolis farcis au quatre fromages, sauce au quatre fromages, crème fraiche";
        Article pa02 = new Article(sCat04, tva2, "Raviolis Quatre Fromages", 11.5F, desp02);
        em.persist(pa02);
        String desp03 = "Linguines, tomate, ail, fruit de mer";
        Article pa03 = new Article(sCat04, tva2, "Linguines aux Fruits de Mer", 13.5F, desp03);
        em.persist(pa03);
        String desp04 = "tortellini farcie au comté et au basilic, crème fraîche et parmesan, copeaux de grana padana";
        Article pa04 = new Article(sCat04, tva2, "Tortellini au Parmesan", 12F, desp04);
        em.persist(pa04);
        String desp05 = "rigatoni, légumes grillées, pesto maison, sauce tomate, huile d’olives";
        Article pa05 = new Article(sCat04, tva2, "Rigatoni aux légumes du soleil", 12F, desp05);
        em.persist(pa05);
        String desp06 = "raviolis farcies aux cèpes, crème fraiche, champignons";
        Article pa06 = new Article(sCat04, tva2, "Raviolis Con Funghi", 14F, desp06);
        em.persist(pa06);
        
        
        
        
        
        
        
        
        //DESSERT
        //patisserie
         desA1 = "L'orée des bois s'invite dans ces verrines printanières au coulis de fruits rouges";
        Article de1 = new Article(sCat06, tva2, "Pannacotta aux fruits des bois", 5.8F, desA1);
        em.persist(de1);
        desA1 = "On craque pour ce grand classique italien au café composé de plusieurs couches de boudoirs et de mascarpone.";
        Article de2 = new Article(sCat06, tva2, "Tiramisu", 6.0F, desA1);
        em.persist(de2);
        desA1 = "des griottes très goûteuses semi-confites dans un sirop de sucre et cuites dans un jus de myrtille pour le plus grand plaisir de votre palais";
        Article de3 = new Article(sCat06, tva2, "Coulant au chocolat et cerise amarena", 6.5F, desA1);
        em.persist(de3);
        desA1 = "Un trésor de la plus pure tradition italienne. Idéal pour accompagner votre café";
        Article de4 = new Article(sCat06, tva2, "Biscotti aux amandes et cerises séchées", 4.8F, desA1);
        em.persist(de4);
        desA1 = "Ce dessert napolitain se compose de petites billes sucrées et vanillées frites et trempées dans du miel";
        Article de5 = new Article(sCat06, tva2, "Struffoli", 6.0F, desA1);
        em.persist(de5);
        //glaces
        desA1 = "Cette crème glacée parfumée aux fruits de saison va rafraîchir vos papilles";
        Article de6 = new Article(sCat07, tva2, "Semifreddo", 6.0F, desA1);
        em.persist(de6);
        desA1 = "Un cappuccino glacé avec sa mousse de fuits onctueuse";
        Article de7 = new Article(sCat07, tva2, "Cappuccino de fruits glacés", 7.0F, desA1);
        em.persist(de7);
        desA1 = "Stracciatella, Tarte au citron meringuée, Panacotta fraises des bois, Vanille, Café, Fruits de la Passion, Cassis, Citron, Mangue";
        Article de8 = new Article(sCat07, tva2, "Sorbet glacé deux boules", 6.0F, desA1);
        em.persist(de8);


// eaux minérales
        String desEau1 = "1L, plate, France. Sa source se situe à Vittel dans le département français des Vosges.";
        Article eau1 = new Article(sCat08, tva1, "Vittel", 3F, desEau1);
        em.persist(eau1);
        String desEau2 = "1L, plate, Italie. Née à 1416 mètres dans un environnement pur et protégé de la pollution, elle est légère avec un taux très faible en sodium.";
        Article eau2 = new Article(sCat08, tva1, "Lurésia", 3F, desEau2);
        em.persist(eau2);
        String desEau3 = "1L, gazeuse, France. Sa source se situe à Saint-Galmier dans le département de la Loire.";
        Article eau3 = new Article(sCat08, tva1, "Badoit", 4F, desEau3);
        em.persist(eau3);
        String desEau4 = "1L, gazeuse, Italie. L'eau minérale San Pellegrino est produite depuis plus de 600 ans.";
        Article eau4 = new Article(sCat08, tva1, "Sanpellegrino", 4F, desEau4);
        em.persist(eau4);
		// boissons non alcoolisées

        String desBoiSa1 = "33cl.";
        Article boiSa1 = new Article(sCat09, tva1, "Coca-Cola", 5F, desBoiSa1);
        em.persist(boiSa1);
        String desBoiSa2 = "33cl.";
        Article boiSa2 = new Article(sCat09, tva1, "Coca-Cola Light", 5F, desBoiSa2);
        em.persist(boiSa2);
        String desBoiSa3 = "25cl.";
        Article boiSa3 = new Article(sCat09, tva1, "Jus de Pomme", 5F, desBoiSa3);
        em.persist(boiSa3);
        String desBoiSa4 = "25cl.";
        Article boiSa4 = new Article(sCat09, tva1, "Jus d'Orange", 5F, desBoiSa4);
        em.persist(boiSa4);
        String desBoiSa5 = "25cl. Cocktail de fruits frais sans alcool.";
        Article boiSa5 = new Article(sCat09, tva1, "Cocktail de fruits", 6F, desBoiSa5);
        em.persist(boiSa5);

		// cocktails
        String desCock1 = "Tequila, Jus d'Orange, sirop de Grenadine.";
        Article cock1 = new Article(sCat10, tva3, "Tequila Sunrise", 7F, desCock1);
        em.persist(cock1);
        String desCock2 = "Rhum, jus de Citron vert, Menthe, eau gazeuse, sirop de sucre de canne.";
        Article cock2 = new Article(sCat10, tva3, "Mojito", 7F, desCock2);
        em.persist(cock2);
        String desCock3 = "Vodka, curaçao bleu, jus de citron.";
        Article cock3 = new Article(sCat10, tva3, "Blue Lagoon", 7F, desCock3);
        em.persist(cock3);
        String desCock4 = "vodka, sirop de melon, Chambord, jus d'ananas, jus de cranberry";
        Article cock4 = new Article(sCat10, tva3, "Sex on the beach", 7F, desCock4);
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

        
        
        // digestifs

String desDig1="4cl. Eau-de-vie d'origine normande obtenue par distillation de cidre ou de poiré.";
Article dig1 = new Article (sCat11,tva3,"Calvados",6F,desDig1);

String desDig2="4cl. Boisson alcoolisée douce, avec un léger parfum d'amandes amères, originaire d'Italie.";
Article dig2 = new Article (sCat11,tva3,"Amaretto",6F,desDig2);

String desDig3="4cl. Liqueur à la menthe, à base d'huiles essentielles de menthe, d'alcool, d'eau et de sucre";
Article dig3 = new Article (sCat11,tva3,"Get 27",6F,desDig3);

String desDig4="4cl. Eau-de-vie de marc de raisin produite en Italie, dans le canton suisse du Tessin et à Saint-Marin.";
Article dig4 = new Article (sCat11,tva3,"Grappa",6F,desDig4);

// boissons chaudes


String desBoiCh1 = "Pur Arabica, issu des caféier de l'île de Java";
Article boiCh1 = new Article(sCat12, tva1,"Café",1.5F,desBoiCh1);

String desBoiCh2 = "A base de Forastero, il se caractérise par son très fort goût de cacao.";
Article boiCh2 = new Article(sCat12, tva1,"Chocolat",3F,desBoiCh2);

String desBoiCh3 = "Earl Grey. Mélange de thé noir aromatisé à la bergamote";
Article boiCh3 = new Article(sCat12, tva1,"Thé",1.5F,desBoiCh3);

String desBoiCh4 = "Expresso coiffé de lait préalablement chauffé à la vapeur jusqu'à le faire mousser.";
Article boiCh4 = new Article(sCat12, tva1,"Cappuccino",2F,desBoiCh4);

// vins rouges

String desVinR1 = "Célèbre vin Toscan, le Chianti classico de Dievole est parmi les meilleurs!";
Article vinR1 = new Article (sCat13, tva3, "Chianti",21F,desVinR1);

String desVinR2 = "Le Bardolino est un vin italien sec de la région de Vénétie doté d'une appellation DOC.";
Article vinR2 = new Article (sCat13, tva3, "Bardolino",21F,desVinR2);

String desVinR3 = "Château Tenein. Vin riche aux notes complexes caractérisées par des arômes épicés.";
Article vinR3 = new Article (sCat13, tva3, "Bordeaux Supérieur",19F,desVinR3);

String desVinR4 = "Château l'Evesque. Expressif, arômes de cerise kirchée, arômes de pruneau, arômes de poivre noir, arômes de réglisse.";
Article vinR4 = new Article (sCat13, tva3, "Merlot",16F,desVinR4);

// vins blancs

String desVinB1 = "Le Frascati est un vin blanc sec originaire du Lazio (province de Rome), disposant d'une AOC.";
Article vinB1 = new Article (sCat14, tva3,"Frascati",14F,desVinB1);

String desVinB2 = "Le Lacryma Christi A.Caputo est un vin blanc sec originaire des pentes du Vésuve en Campanie, près de Naples. ";
Article vinB2 = new Article (sCat14, tva3,"Lacryma Christi",16F,desVinB2);

String desVinB3 = "En bouche, il dévoile une grande fraîcheur et une grande complexité.";
Article vinB3 = new Article (sCat14, tva3,"Chateau Ste Marie",15F,desVinB3);

String desVinB4 = "Vin long en bouche et riche aromatiquement.";
Article vinB4 = new Article (sCat14, tva3,"Cambades",15F,desVinB4);

// vins rosés

String desVinRs1 = "Idéal pour l'apéritif ou le repas.";
Article vinRs1 = new Article (sCat15, tva3, "Juliana Prosecco Rosé",14F,desVinRs1);

String desVinRs2 = "Un superbe rosé, frais et très équilibré.";
Article vinRs2 = new Article (sCat15, tva3, "Rosato Toscana",14F,desVinRs2);

String desVinRs3 = "Tavel. Il sait faire honneur à la gastronomie et il se consomme toute l’année.";
Article vinRs3 = new Article (sCat15, tva3, "Château d'Aquéria",16F,desVinRs3);

String desVinRs4 = "Bordeaux. Compagnon idéal de tous les plaisirs de l’été.";
Article vinRs4 = new Article (sCat15, tva3, "Henry de Larose",17F,desVinRs4);

// persist
em.persist(dig1);
em.persist(dig2);
em.persist(dig3);
em.persist(dig4);
em.persist(boiCh1);
em.persist(boiCh2);
em.persist(boiCh3);
em.persist(boiCh4);
em.persist(vinR1);
em.persist(vinR2);
em.persist(vinR3);
em.persist(vinR4);
em.persist(vinB1);
em.persist(vinB2);
em.persist(vinB3);
em.persist(vinB4);
em.persist(vinRs1);
em.persist(vinRs2);
em.persist(vinRs3);
em.persist(vinRs4);


        
        
        
        
//*******
//Formules
//*******
        ArrayList<Article> arts = new ArrayList();
        arts.add(ar01);
        arts.add(ar02);
        arts.add(ar03);
        arts.add(ar09);
        arts.add(ar10);
        arts.add(ar11);
        arts.add(boiSa1);
        arts.add(boiSa2);
        arts.add(boiSa3);
        arts.add(boiSa4);
        Formule form01 = new Formule(arts, "Entrée-Plat", 16.5F, "ent",tva2);
        em.persist(form01);
        
        ArrayList<Article> arts2 = new ArrayList();
        arts2.add(ar08);
        arts2.add(ar06);
        arts2.add(ar07);
        arts2.add(ar09);
        arts2.add(ar10);
        arts2.add(ar11);
        arts2.add(ar12);
        arts2.add(ar13);
        arts2.add(ar14);
        arts2.add(de1);
        arts2.add(de2);
        arts2.add(de6);
        arts2.add(de7);
        Formule form02 = new Formule(arts2, "Pizza", 19.5F, "piz",tva2);
        em.persist(form02);
        
        ArrayList<Article> arts3 = new ArrayList();
        arts3.add(ar02);
        arts3.add(ar03);
        arts3.add(ar08);
        arts3.add(ar04);
        arts3.add(pa02);
        arts3.add(pa03);
        arts3.add(pa04);
        arts3.add(pa05);
        arts3.add(de1);
        arts3.add(de2);
        arts3.add(de6);
        arts3.add(de7);
        Formule form03 = new Formule(arts3, "Pâtes", 21.5F, "pat",tva2);
        em.persist(form03);
        
        
    
        em.persist(u01);
        em.persist(u02);
        em.persist(u03);
        em.persist(u04);
        em.persist(u05);
        em.persist(u06);
        em.persist(u07);
        
        
// 
        
        Date d01 = new GregorianCalendar(2016, 04, 05).getTime();
        Date d02 = new GregorianCalendar(2016, 04, 06).getTime();
        Date d03 = new GregorianCalendar(2016, 04, 01).getTime();
        
        
        Emplacement e01 = new Emplacement(1, "libre", 4);
        Emplacement e02 = new Emplacement(2, "libre", 2);
        Emplacement e03 = new Emplacement(3, "libre", 6);
        Emplacement e04 = new Emplacement(4, "libre", 2);
        Emplacement e05 = new Emplacement(5, "libre", 2);
        Emplacement e06 = new Emplacement(6, "libre", 2);
        Emplacement e07 = new Emplacement(7, "libre", 4);
        Emplacement e08 = new Emplacement(8, "libre", 4);
        Emplacement e09 = new Emplacement(9, "libre", 4);
        Emplacement e10 = new Emplacement(10, "libre", 2);
        Emplacement e11 = new Emplacement(11, "libre", 2);
        Emplacement e12 = new Emplacement(12, "libre", 2);
        Emplacement e13 = new Emplacement(13, "libre", 2);
        Emplacement e14 = new Emplacement(14, "libre", 2);
        Emplacement e15 = new Emplacement(15, "libre", 4);
        Emplacement e16 = new Emplacement(16, "libre", 4);
        Emplacement e17 = new Emplacement(17, "libre", 4);
        Emplacement e18 = new Emplacement(18, "libre", 4);
        Emplacement e19 = new Emplacement(19, "libre", 2);
        Emplacement e20 = new Emplacement(20, "libre", 2);
        Emplacement e21 = new Emplacement(21, "libre", 2);
        Emplacement e22 = new Emplacement(22, "libre", 2);
        Emplacement e23 = new Emplacement(23, "libre", 2);
        Emplacement e24 = new Emplacement(24, "libre", 2);
        Emplacement e25 = new Emplacement(25, "libre", 2);
        
        Commande c01 = new Commande(d01,"CO2016000004","terminee");
        Commande c02 = new Commande(d01, "CO2016000005","en cours");
        Commande c03 = new Commande(d01, "CO2016000006","en cours");
        Commande c04 = new Commande(d02,"CO2016000007","en cours");
        Commande c05 = new Commande(d02,"CO2016000008","en cours");
        Commande c06 = new Commande(d02,"CO2016000009","terminee");
        Commande c07 = new Commande(d02,"CO20160000010","terminee");
        Commande c08 = new Commande(d02,"CO20160000011","payee");
        Commande c09 = new Commande(d03,"CO2016000001","payee");
        Commande c10 = new Commande(d03,"CO2016000002","payee");
        Commande c11 = new Commande(d03,"CO2016000003","payee");



        
        c01.getEmplacements().add(e01);
        c01.getEmplacements().add(e05);
        c02.getEmplacements().add(e25);
        c03.getEmplacements().add(e14);
        c04.getEmplacements().add(e12);
        c04.getEmplacements().add(e13);
        c04.getEmplacements().add(e15);
        c05.getEmplacements().add(e18);
        c06.getEmplacements().add(e13);
        c07.getEmplacements().add(e13);
        c08.getEmplacements().add(e13);
        c09.getEmplacements().add(e13);
        c10.getEmplacements().add(e13);
        c11.getEmplacements().add(e13);
        
        
        
        em.persist(e01);
        em.persist(e02);
        em.persist(e03);
        em.persist(e04);
        em.persist(e05);
        em.persist(e06);
        em.persist(e07);
        em.persist(e08);
        em.persist(e09);
        em.persist(e10);
        em.persist(e11);
        em.persist(e12);
        em.persist(e13);
        em.persist(e14);
        em.persist(e15);
        em.persist(e16);
        em.persist(e17);
        em.persist(e18);
        em.persist(e19);
        em.persist(e20);
        em.persist(e21);
        em.persist(e22);
        em.persist(e23);
        em.persist(e24);
        em.persist(e25);
        
        em.persist(c01);
        em.persist(c02);
        em.persist(c03);
        em.persist(c04);
        em.persist(c05);
        em.persist(c06);
        em.persist(c07);
        em.persist(c08);
        em.persist(c09);
        em.persist(c10);
        em.persist(c11);
        
        EtatLigneCommande elc01 = new EtatLigneCommande (1,"Attente");
        em.persist(elc01);
        EtatLigneCommande elc02 = new EtatLigneCommande (2,"En préparation");
        em.persist(elc02);
        EtatLigneCommande elc03 = new EtatLigneCommande (3,"Prêt");
        em.persist(elc03);
        EtatLigneCommande elc04 = new EtatLigneCommande (4,"Servi");
        em.persist(elc04);


        LigneCommande lc01 = new LigneCommande(21.5F,null,null, elc01);
        lc01.setCommande(c01);
        em.persist(lc01);

        LigneCommande lc02 = new LigneCommande(0F,"sans sel","pat01", elc01);
        lc02.setArticle(pa02);
        lc02.setCommande(c01);
        em.persist(lc02);

        LigneCommande lc03 = new LigneCommande(0F,null,"pat01",elc01);
        lc03.setCommande(c01);
        lc03.setArticle(ar03);
        em.persist(lc03);

        LigneCommande lc04 = new LigneCommande(0F,null,"pat01",elc01);
        lc04.setArticle(de7);
        lc04.setCommande(c01);
        em.persist(lc04);

        LigneCommande lc05 = new LigneCommande(15F,null,null,elc01);
        lc05.setArticle(vinB4);
        lc05.setCommande(c01);
        em.persist(lc05);

        LigneCommande lc06 = new LigneCommande(3F,null,null,elc01);
        lc06.setArticle(boiCh2);
        lc06.setCommande(c02);
        em.persist(lc06);

        LigneCommande lc07 = new LigneCommande(1.5F,null,null,elc01);
        lc07.setArticle(boiCh3);
        lc07.setCommande(c02);
        em.persist(lc07);
        
        
        
    }

}
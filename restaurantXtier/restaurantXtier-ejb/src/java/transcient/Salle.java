package transcient;

import beanEntite.Article;
import beanEntite.Commande;
import beanEntite.Emplacement;
import beanEntite.Formule;
import beanEntite.LigneCommande;
import beanEntite.Utilisateur;
import beansSession.BeanCommandeLocal;
import beansSession.BeanFormuleLocal;
import beansSession.BeanLigneCommandeLocal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;

@Singleton
public class Salle implements SalleLocal {

    @EJB
    private BeanFormuleLocal beanFormule;
    @EJB
    private BeanLigneCommandeLocal beanLigneCommande;
    @EJB
    private GroupeEmplacementLocal groupesEmplacement;
    @EJB
    private BeanCommandeLocal beanCommande;

    private HashMap<Integer, Commande> commandes;

    @PostConstruct
    public void init() {
        commandes = new HashMap<>();
    }

    @Override
    public GroupeEmplacementLocal getGroupesEmplacement() {
        return groupesEmplacement;
    }

    @Override
    public void setGroupesEmplacement(GroupeEmplacementLocal groupesEmplacement) {
        this.groupesEmplacement = groupesEmplacement;
    }

    @Override
    public BeanCommandeLocal getBeanCommande() {
        return beanCommande;
    }

    @Override
    public void setBeanCommande(BeanCommandeLocal beanCommande) {
        this.beanCommande = beanCommande;
    }

    @Override
    public HashMap<Integer, Commande> getCommandes() {
        return commandes;
    }

    @Override
    public void setCommandes(HashMap<Integer, Commande> commandes) {
        this.commandes = commandes;
    }

    //crée une commande, la rajoute dans la salle, crée le groupe d'emplacement à partir de la collection de table,
    //le rajoute dans le bean Groupe emplacement et retourne l'integer correspondant à la clef
    //de la commande.
    @Override
    public Integer creerCommande(Collection<Emplacement> emp, Utilisateur util) {
        Commande c01 = beanCommande.createCommande(emp, util);
        Integer keyCommande = groupesEmplacement.creerGroupe(emp);
        commandes.put(keyCommande, c01);
        return keyCommande;
    }

    @Override
    public List<Commande> selectCommandeEnCours() {
        List<Commande> commandesList = new ArrayList<>();
        for (Entry<Integer, Commande> entry : commandes.entrySet()) {
            commandesList.add(entry.getValue());
        }
        for (Commande c : commandesList) {
            List<Emplacement> emplacements = beanCommande.selectEmplacementByIdCommande(c.getId());
            c.setEmplacements(emplacements);
        }
        return commandesList;
    }

    //Récupération de la commande par la cle de commande
    @Override
    public Commande selectCommandeByCleCommande(Integer cleCommande) {
        return this.commandes.get(cleCommande);
    }

    @Override
    public void ajouterArticle(Integer cleCommande, Long idArticle) {
        LigneCommande lc = beanLigneCommande.creerLigneDeCommandeArticle(idArticle);
        Commande co = selectCommandeByCleCommande(cleCommande);
        Collection<LigneCommande> listLc = co.getLignesCommandes();
        listLc.add(lc);
    }

    @Override
    public void ajouterFormule(Integer cleCommande, Long idFromule, Article entree, Article plat, Article dessert, Article boisson) {

        Formule f = beanFormule.selectFormuleById(idFromule);
        String refFormule = beanFormule.createRefFormuleUnique(f);
        f.setRefFormuleUnique(refFormule);
        Commande co = selectCommandeByCleCommande(cleCommande);
        LigneCommande lc00 = new LigneCommande(f.getPrix(), null, f.getRefFormuleUnique(), null, co, null);

        co.getLignesCommandes().add(lc00);
        if (entree != null) {
            LigneCommande lc01 = new LigneCommande(0F, null, f.getRefFormuleUnique(), entree, co, null);
            co.getLignesCommandes().add(lc01);
        }
        if (plat != null) {
            LigneCommande lc02 = new LigneCommande(0F, null, f.getRefFormuleUnique(), plat, co, null);
            co.getLignesCommandes().add(lc02);
        }
        if (dessert != null) {
            LigneCommande lc03 = new LigneCommande(0F, null, f.getRefFormuleUnique(), dessert, co, null);
            co.getLignesCommandes().add(lc03);
        }
        if (boisson != null) {
            LigneCommande lc04 = new LigneCommande(0F, null, f.getRefFormuleUnique(), boisson, co, null);
            co.getLignesCommandes().add(lc04);
        }

    }

    @Override
    public Collection<LigneCommande> getAllLigneCommandeFromCommande(Integer cleCommande) {
        Commande co = selectCommandeByCleCommande(cleCommande);
        return co.getLignesCommandes();
    }

    @Override
    public Collection<LigneCommande> getEntreesCommandees(Integer cleCommande) {
        Commande co = selectCommandeByCleCommande(cleCommande);
        Collection<LigneCommande> lcs = co.getLignesCommandes();
        Collection<LigneCommande> lcentree = new ArrayList<>();
        for (LigneCommande l : lcs) {

            if (l.getArticle() != null) {

                if (l.getArticle().getSousCategorie().getCategorie().getNom().equalsIgnoreCase("Les Entrées")
                        && l.getRefFormule() == null) {
                    lcentree.add(l);
                }
            }
        }

        return lcentree;
    }

    @Override
    public Collection<LigneCommande> getPlatsCommandees(Integer cleCommande) {
        Commande co = selectCommandeByCleCommande(cleCommande);
        Collection<LigneCommande> lcs = co.getLignesCommandes();
        Collection<LigneCommande> lcplat = new ArrayList<>();
        for (LigneCommande l : lcs) {

            if (l.getArticle() != null) {
                if (l.getArticle().getSousCategorie().getCategorie().getNom().equalsIgnoreCase("Les Plats")
                        && l.getRefFormule() == null) {
                    lcplat.add(l);
                }
            }
        }

        return lcplat;
    }

    @Override
    public Collection<LigneCommande> getDessertsCommandees(Integer cleCommande) {
        Commande co = selectCommandeByCleCommande(cleCommande);
        Collection<LigneCommande> lcs = co.getLignesCommandes();
        Collection<LigneCommande> lcdessert = new ArrayList<>();
        for (LigneCommande l : lcs) {

            if (l.getArticle() != null) {
                if (l.getArticle().getSousCategorie().getCategorie().getNom().equalsIgnoreCase("Les Desserts")
                        && l.getRefFormule() == null) {
                    lcdessert.add(l);
                }
            }

        }
        return lcdessert;
    }

    @Override
    public Collection<LigneCommande> getBoissonsCommandees(Integer cleCommande) {
        Commande co = selectCommandeByCleCommande(cleCommande);
        Collection<LigneCommande> lcs = co.getLignesCommandes();
        Collection<LigneCommande> lcboisson = new ArrayList<>();
        for (LigneCommande l : lcs) {
            if (l.getArticle() != null) {
                if (l.getArticle().getSousCategorie().getCategorie().getNom().equalsIgnoreCase("Les Boissons")
                        && l.getRefFormule() == null) {
                    lcboisson.add(l);
                }
            }
        }

        return lcboisson;
    }

    @Override
    public Collection<LigneCommande> getFormulesCommandees(Integer cleCommande) {
        Commande co = selectCommandeByCleCommande(cleCommande);
        Collection<LigneCommande> lcs = co.getLignesCommandes();
        Collection<LigneCommande> lcformule = new ArrayList<>();
        for (LigneCommande l : lcs) {
            if (l.getRefFormule() != null) {
                lcformule.add(l);
            }
        }
        return lcformule;
    }

    @Override
    public void enleverArticle(Integer cleCommande, Long idArticle) {
        Commande co = selectCommandeByCleCommande(cleCommande);
        Collection<LigneCommande> lcs = co.getLignesCommandes();
        Iterator it = lcs.iterator();
        while (it.hasNext()) {
            LigneCommande l = (LigneCommande) it.next();
            if (l.getRefFormule() == null && l.getArticle() != null) {
                if (Objects.equals(l.getArticle().getId(), idArticle)) {
                    it.remove();
                }
            }
        }
    }

    @Override
    public Float getPrixTtcCommande(Integer cleCommande) {
        Commande co = selectCommandeByCleCommande(cleCommande);
        Collection<LigneCommande> lcs = getAllLigneCommandeFromCommande(cleCommande);
        float prixTotal = 0;

        for (LigneCommande l : lcs) {
            prixTotal += beanLigneCommande.getPrixLcTTC(l);
        }
        return prixTotal;
    }

    @Override
    public  HashMap<String, HashMap<Formule, Collection<LigneCommande>>>  getFormuleMapper(Collection<LigneCommande> lcs) {

         HashMap<String, HashMap<Formule, Collection<LigneCommande>>>  hmf = new HashMap<>();
         
         Collection<String> refForms = new ArrayList();

        for (LigneCommande l : lcs) {
            if (!refForms.contains((l.getRefFormule()))) {

                String ref = l.getRefFormule();
                System.out.println("REFFORMULE DANS FORMULE MAPPER =" + ref);
                refForms.add(ref);
            }
        }

        for (String s : refForms) {
            Collection<LigneCommande> col = new ArrayList<>();
            for (LigneCommande l : lcs) {
                if (l.getRefFormule().equalsIgnoreCase(s)) {
                    col.add(l);
                    System.out.println("COL *SIZE FORMULE MAPPER======" + col.size());
                }
            }
            Formule f = beanFormule.selectFormuleByRef(s.substring(0, 3));
            System.out.println("FORMULE DANS MAPPER ==="+f);
            HashMap<Formule, Collection<LigneCommande>> sousHmf=new HashMap<>();
            sousHmf.put(f, col);
            hmf.put(s, sousHmf);
        }

        return hmf;
    }

    @Override
    public void enleverFormule(Integer cleCommande, String refFormule) {
        Commande co = selectCommandeByCleCommande(cleCommande);
        Collection<LigneCommande> lcs = co.getLignesCommandes();
        Iterator it = lcs.iterator();
        while (it.hasNext()) {
            LigneCommande l = (LigneCommande) it.next();
            if (l.getRefFormule() != null) {
                if (l.getRefFormule().equalsIgnoreCase(refFormule)) {
                    it.remove();
                }
            }
        }
    }

}

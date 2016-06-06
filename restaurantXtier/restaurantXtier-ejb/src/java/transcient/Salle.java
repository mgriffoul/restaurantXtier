package transcient;

import beanEntite.Commande;
import beanEntite.Emplacement;
import beanEntite.Utilisateur;
import beansSession.BeanCommandeLocal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;

@Singleton
public class Salle implements SalleLocal {

    @EJB
    private GroupeEmplacementLocal groupesEmplacement;
    @EJB
    private BeanCommandeLocal beanCommande;

    private HashMap<Integer, Commande> commandes;

    @PostConstruct
    public void init() {
        commandes = new HashMap<>();
    }

    public GroupeEmplacementLocal getGroupesEmplacement() {
        return groupesEmplacement;
    }

    public void setGroupesEmplacement(GroupeEmplacementLocal groupesEmplacement) {
        this.groupesEmplacement = groupesEmplacement;
    }

    public BeanCommandeLocal getBeanCommande() {
        return beanCommande;
    }

    public void setBeanCommande(BeanCommandeLocal beanCommande) {
        this.beanCommande = beanCommande;
    }

    public HashMap<Integer, Commande> getCommandes() {
        return commandes;
    }

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
        List<Commande> commandesList = null;
        for (Entry<Integer, Commande> entry : commandes.entrySet()) {
            commandesList.add(entry.getValue());
        }
          for (Commande c : commandesList) {
            List<Emplacement> emplacements = beanCommande.selectEmplacementByIdCommande(c.getId());
            c.setEmplacements(emplacements);
        }
        return commandesList;
    }
}

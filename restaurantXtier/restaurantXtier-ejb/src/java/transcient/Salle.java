

package transcient;

import beanEntite.Commande;
import beanEntite.Emplacement;
import beanEntite.LigneCommande;
import beanEntite.Utilisateur;
import beansSession.BeanCommandeLocal;
import beansSession.BeanLigneCommandeLocal;
import java.util.Collection;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;


@Singleton
public class Salle implements SalleLocal {
    @EJB
    private BeanLigneCommandeLocal beanLigneCommande;
    @EJB
    private GroupeEmplacementLocal groupesEmplacement;
    @EJB
    private BeanCommandeLocal beanCommande;

    private HashMap<Integer,Commande> commandes;

    @PostConstruct
    public void init(){
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
        //appeler createnumerocommande quelquepart
        Integer keyCommande = groupesEmplacement.creerGroupe(emp);
        commandes.put(keyCommande, c01);
        
        return keyCommande;
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
        Collection<LigneCommande> listLc =  co.getLignesCommandes();
        
        
        listLc.add(lc);
    }
    
    
    
    
}

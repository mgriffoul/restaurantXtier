package utilitaire;

import beanEntite.LigneCommande;
import beansSession.BeanLigneCommandeLocal;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LigneCommandeWar implements Serializable{
    BeanLigneCommandeLocal beanLigneCommande = lookupBeanLigneCommandeLocal();
    
    private BeanLigneCommandeLocal ligneCommande;

    public LigneCommandeWar() {
        ligneCommande = lookupBeanLigneCommandeLocal();
    }

    public Float getPrixTotalTTC(LigneCommande lc){
        return ligneCommande.getPrixLcTTC(lc);
    }
    
//    public BeanLigneCommandeLocal getLigneCommande() {
//        return ligneCommande;
//    }
//
//    public void setLigneCommande(LigneCommande ligneCommande) {
//        this.ligneCommande.setLc(ligneCommande);
//    }

    private BeanLigneCommandeLocal lookupBeanLigneCommandeLocal() {
        try {
            Context c = new InitialContext();
            return (BeanLigneCommandeLocal) c.lookup("java:global/restaurantXtier/restaurantXtier-ejb/BeanLigneCommande!beansSession.BeanLigneCommandeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    
    
    
}

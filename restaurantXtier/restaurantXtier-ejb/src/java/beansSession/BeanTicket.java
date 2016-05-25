/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beansSession;

import beanEntite.Commande;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author cdi211
 */
@Stateless
public class BeanTicket implements BeanTicketLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "restaurantXtier-ejbPU")
    private EntityManager em;

public Commande selectionnerCommandeFinieParEmplacement(Integer emplacement){
    String req = "select c from commande c where c.emplacements = :paramemplacement and c.statut = :paramstatut";
    String statut = "terminee";
    Query qr = em.createQuery(req);
        qr.setParameter("paramemplacement", emplacement);
        qr.setParameter("paramstatut", statut);
        Commande commande = (Commande)qr.getSingleResult();
    
    return commande;
}

    

}

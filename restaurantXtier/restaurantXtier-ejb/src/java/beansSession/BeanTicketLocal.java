/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beansSession;

import beanEntite.Commande;
import javax.ejb.Local;

/**
 *
 * @author cdi211
 */
@Local
public interface BeanTicketLocal {

    public Commande selectionnerCommandeFinieParEmplacement(Integer emplacement);

    public void afficherTicket(Commande commande);

    public float getTotal(Commande commande);




    
}

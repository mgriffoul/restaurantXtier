/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beansSession;

import beanEntite.LigneCommande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ludo_home
 */
@Local
public interface BeanLigneCommandeLocal {
    public List<LigneCommande> selectLigneCommandeByIdCategorie(Long idCat);
    public List<LigneCommande> selectAllLigneCommandeTriByEtat ();
    public List<LigneCommande> selectAllLigneCommandeTriByPlat ();
    public LigneCommande changerEtatLigneCommande (Long id);
    public List<LigneCommande> selectLigneCommandeServies ();
    public List<LigneCommande> selectLigneCommandeByChrono ();
    public List<LigneCommande> selectLigneCommandeByEmplacement ();
}

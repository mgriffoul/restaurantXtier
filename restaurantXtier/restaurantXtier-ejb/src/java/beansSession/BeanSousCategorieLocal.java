/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beansSession;

import beanEntite.SousCategorie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cdi207
 */
@Local
public interface BeanSousCategorieLocal {
    
    public SousCategorie selectSousCategorieById(Long id);
    public SousCategorie selectSousCategorieByNom(String nom);
    public List<SousCategorie> selectAllSousCategorie();
    public List<SousCategorie> selectAllSousCategorieByCategorieId(Long id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEntite;

import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author gantn
 */
@Entity
public class EtatLigneCommande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer ordre;
    private String etat; // 1-Attente 2-En préparattion 3- Prêt 4- Servi
    
    // association
    @OneToMany (mappedBy = "etatLc")
    private Collection<LigneCommande> ligneComs;
    
    //constructeurs

    public EtatLigneCommande() {
    }

    public EtatLigneCommande(Integer ordre) {
        this();
        this.ordre = ordre;
    }
    
    

    public EtatLigneCommande(Integer ordre, String etat) {
        this();
        
        this.ordre = ordre;
        this.etat = etat;
        
    }
//getters et setters
    

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Collection<LigneCommande> getLigneComs() {
        return ligneComs;
    }

    public void setLigneComs(Collection<LigneCommande> ligneComs) {
        this.ligneComs = ligneComs;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtatLigneCommande)) {
            return false;
        }
        EtatLigneCommande other = (EtatLigneCommande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanEntite.EtatLigneCommande[ id=" + id + " ]";
    }
    
}

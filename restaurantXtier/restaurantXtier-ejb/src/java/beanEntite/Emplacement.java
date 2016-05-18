/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEntite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 *
 * @author cdi211
 */
@Entity
public class Emplacement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Integer numero;
    private String statut;
    private Integer nbCouvert;

    
    @ManyToMany
    private Collection<Commande>commandes;
    
    
    public Emplacement() {
    }

    public Emplacement(Integer numero, String statut, Integer nbCouvert) {
        this.numero = numero;
        this.statut = statut;
        this.nbCouvert = nbCouvert;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Integer getNbCouvert() {
        return nbCouvert;
    }

    public void setNbCouvert(Integer nbCouvert) {
        this.nbCouvert = nbCouvert;
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
        if (!(object instanceof Emplacement)) {
            return false;
        }
        Emplacement other = (Emplacement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanEntite.Emplacement[ id=" + id + " ]";
    }
    
}

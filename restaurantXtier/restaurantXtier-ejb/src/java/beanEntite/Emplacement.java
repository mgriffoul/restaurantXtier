package beanEntite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

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
    @Column(unique = true)
    private Integer numero;
    private String statut;
    private Integer nbCouvert;
    
    @Transient
    private Integer keyCommande;
    


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getKeyCommande() {
        return keyCommande;
    }



    public void setKeyCommande(Integer KeyCommande) {
        this.keyCommande = KeyCommande;
    }


    
    @ManyToMany(mappedBy = "emplacements")
    private Collection<Commande>commandes;
    
    public Emplacement() {
        commandes = new ArrayList<>();
    }

    public Emplacement(Integer numero, String statut, Integer nbCouvert) {
        this();
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

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
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

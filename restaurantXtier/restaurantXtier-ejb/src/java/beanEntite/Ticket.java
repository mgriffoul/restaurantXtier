package beanEntite;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;
    

    public Date getDate() {
        return date;
    }

    

    public Commande getCommande() {
        return commande;
    }

    public void setDate(Date date) {
        this.date = date;
    }

  

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    
      // associations

    public Ticket(Date date) {
        this.date = date;
        
    }

    public Ticket() {
    }
 
    @OneToMany
    private Collection<Paiement> paiements;
    @OneToOne()
    private Commande commande;
    //fin associations
    
    public Long getId() {
        return id;
    }
    

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(Collection<Paiement> paiements) {
        this.paiements = paiements;
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
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanEntite.Ticket[ id=" + id + " ]";
    }
    
}

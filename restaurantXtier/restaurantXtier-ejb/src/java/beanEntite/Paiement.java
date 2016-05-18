package beanEntite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;


@Entity
public class Paiement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;
    private boolean encaisser;
    private float montant;
    
    // associations
    @ManyToOne
    private Ticket ticket;
    
    @ManyToOne
    private TypePaiement typePaiement; 
    //fin associations

    public Paiement() {
    }

    public Paiement(Date date, boolean encaisser, float montant) {
        this.date = date;
        this.encaisser = encaisser;
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public boolean isEncaisser() {
        return encaisser;
    }

    public float getMontant() {
        return montant;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEncaisser(boolean encaisser) {
        this.encaisser = encaisser;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Paiement)) {
            return false;
        }
        Paiement other = (Paiement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanEntite.Paiement[ id=" + id + " ]";
    }
    
}

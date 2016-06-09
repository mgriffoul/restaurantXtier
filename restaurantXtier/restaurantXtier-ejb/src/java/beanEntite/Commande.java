
package beanEntite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;
    private String numero;
    private String statut; //"en cours" // payée // terminée 

    
    
     // associations
    @ManyToMany
    private Collection<Emplacement> emplacements;

    @ManyToOne
    private Utilisateur utilisateur;

    @OneToOne
    private Ticket ticket;

    @OneToMany(mappedBy = "commande")
    private Collection<LigneCommande> lignesCommandes;
    //fin associations
    

    public Commande() {
        emplacements = new ArrayList<>();
        lignesCommandes = new ArrayList<>();
    }

    public Commande(Collection<Emplacement> emplacements) {
        this.emplacements = emplacements;
    }

    public Commande(Date date, String numero, String statut) {
        this();
        this.date = date;
        this.numero = numero;
        this.statut = statut;
    }

    public Date getDate() {
        return date;
    }

    public String getNumero() {
        return numero;
    }

    public Collection<Emplacement> getEmplacements() {
        return emplacements;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setEmplacements(Collection<Emplacement> emplacements) {
        this.emplacements = emplacements;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Collection<LigneCommande> getLignesCommandes() {
        return lignesCommandes;
    }

    public void setLignesCommandes(Collection<LigneCommande> lignesCommandes) {
        this.lignesCommandes = lignesCommandes;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
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
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanEntite.Commande[ id=" + id + " ]";
    }

}

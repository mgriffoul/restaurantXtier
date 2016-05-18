package beanEntite;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

    public Commande() {
    }

    public Commande(Collection<Emplacement> emplacements) {
        this.emplacements = emplacements;
    }

    public Commande(Date date, String numero) {
        this.date = date;
        this.numero = numero;
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
    
     // associations
    @ManyToMany
    private Collection<Emplacement> emplacements;
    
    @ManyToOne
    private Utilisateur utilisateur;
    
    @OneToOne
    private Ticket ticket;
    //fin associations
    
    
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


/*
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    private String race;
    private Integer age;
    
       
    // associations
    @ManyToMany(mappedBy = "animaux")
    private Collection<Soigneur> soigneurs;
    
    @ManyToOne
    private CentreSPA centre;
    
    //fin associations

    public Animal() {
        soigneurs = new ArrayList<>();
    }

    public Animal(String nom, String race, Integer age) {
        this();
        this.nom = nom;
        this.race = race;
        this.age = age;
    }

    public Collection<Soigneur> getSoigneurs() {
        return soigneurs;
    }

    public void setSoigneurs(Collection<Soigneur> soigneurs) {
        this.soigneurs = soigneurs;
    }

    public CentreSPA getCentre() {
        return centre;
    }

    public void setCentre(CentreSPA centre) {
        this.centre = centre;
    }
    
    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nom animal = " + nom + "("+id+")";
    }
    
    
}

*/
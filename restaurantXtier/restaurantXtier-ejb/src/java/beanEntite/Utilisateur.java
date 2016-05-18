/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEntite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author cdi206
 */
@Entity
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String code;
    
    private int role; // 1-IHM Cuisine 2-IHM Caisse 3-IHM Garçon de Salle 4-IHM Client
    private String nom;
    private String prenom;
    
    // association
    @OneToMany(mappedBy = "utilisateur")
    private Collection<Commande>commandes;
    // fin association
    
    // constructeurs

    public Utilisateur() {
        commandes = new ArrayList<>();
    }

    public Utilisateur(String code, int role, String nom, String prenom) {
        this();
        this.code = code;
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
    }
   
    // getters et setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }
    
    
    
    // méthodes
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Code : "+code+", numéro IHM : "+role+", nom : "+nom+", prenom : "+prenom;
    }
    
}

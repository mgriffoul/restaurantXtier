
package beanEntite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Formule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private Collection<Article> articles;
    
    private String nom;
    private Float prix;
    private String refFormule;
    
    @ManyToOne
    private Tva tva;

    public Formule() {
        articles = new ArrayList<>();
    }

    public Formule(Collection<Article> articles, String nom, Float prix, String refFormule, Tva tva) {
        this.articles = articles;
        this.nom = nom;
        this.prix = prix;
        this.refFormule = refFormule;
        this.tva = tva;
    }

    public Formule(List<Article> articles, String nom, Float prix, String refFormule) {
        this.articles = articles;
        this.nom = nom;
        this.prix = prix;
        this.refFormule = refFormule;
    }

    public Formule(Collection<Article> articles, String nom, Float prix, Tva tva) {
        this.articles = articles;
        this.nom = nom;
        this.prix = prix;
        this.tva = tva;
    }

    public Collection<Article> getArticles() {
        return articles;
    }

    public void setArticles(Collection<Article> articles) {
        this.articles = articles;
    }

    public String getNom() {
        return nom;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getRefFormule() {
        return refFormule;
    }

    public void setRefFormule(String refFormule) {
        this.refFormule = refFormule;
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
        if (!(object instanceof Formule)) {
            return false;
        }
        Formule other = (Formule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanEntite.Formule[ id=" + id + " ]";
    }
    
}

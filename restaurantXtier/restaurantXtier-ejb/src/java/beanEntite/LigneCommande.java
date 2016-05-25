package beanEntite;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private float prixHT;
    private String etat;
    private String remarque;
    private String refFormule;
    
    // associations

    @ManyToOne
    private Sauce Sauce;
    
    @ManyToOne
    private TypeCuisson typeCuisson;
    
    @ManyToOne
    private Article article;
    
    @ManyToOne
    private Commande commande;

    //fin associations

    public LigneCommande() {
    }

    public LigneCommande(float prixHT, String etat, String remarque, String refFormule) {
        this.prixHT = prixHT;
        this.etat = etat;
        this.remarque = remarque;
        this.refFormule = refFormule;
    }

    public float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(float prixHT) {
        this.prixHT = prixHT;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public String getRefFormule() {
        return refFormule;
    }

    public void setRefFormule(String refFormule) {
        this.refFormule = refFormule;
    }

    public Sauce getSauce() {
        return Sauce;
    }

    public void setSauce(Sauce Sauce) {
        this.Sauce = Sauce;
    }

    public TypeCuisson getTypeCuisson() {
        return typeCuisson;
    }

    public void setTypeCuisson(TypeCuisson typeCuisson) {
        this.typeCuisson = typeCuisson;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
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
        if (!(object instanceof LigneCommande)) {
            return false;
        }
        LigneCommande other = (LigneCommande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return article+" - "+etat+" - "+remarque;
    }
    
}

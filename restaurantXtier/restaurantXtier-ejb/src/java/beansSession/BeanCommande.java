package beansSession;

import beanEntite.Commande;
import beanEntite.Emplacement;
import beanEntite.LigneCommande;
import beanEntite.Utilisateur;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BeanCommande implements BeanCommandeLocal {
    
    @PersistenceContext(unitName = "restaurantXtier-ejbPU")
    private EntityManager em;
    
    @Override
    public Commande selectCommandeById(Long id) {
        Commande commande = em.find(Commande.class, id);
        String req = "Select c.lignesCommandes from Commande c where c.id = :paramid";
        Query qr = em.createQuery(req);
        qr.setParameter("paramid", id);
        List<LigneCommande> lgnCommandes = qr.getResultList();
        commande.setLignesCommandes(lgnCommandes);
        return commande;
        
    }
    
    @Override
    public Commande newCommande() {
        Commande c = new Commande();
        return c;
    }
    
    @Override
    public Commande createCommande(ArrayList<Emplacement> emps, Utilisateur ut01) {
        Commande com = new Commande();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        com.setDate(date);
        com.setEmplacements(emps);
        com.setStatut("en cours");
        com.setNumero(createNumeroCommande());
        com.setUtilisateur(ut01);
        return com;
    }
    
    @Override
    public String createNumeroCommande() {
        String req = "Select c from Commande c order by c.id desc";
        Query qr = em.createQuery(req);
        Commande last = (Commande) qr.setMaxResults(1).getResultList();
        int numero = Integer.parseInt(last.getNumero().substring(1, last.getNumero().length())) + 1;
        return Integer.toString(numero);
        
    }
    
    @Override
    public void sauvegarderCommande(Commande commande) {
        em.persist(commande);
    }
    
    @Override
    public List<Commande> selectCommandeByDate(String date) {
        String req = "Select c from Commande c where c.date = :paramdate";
        Query qr = em.createQuery(req);
        qr.setParameter("paramnom", date);
        List<Commande> com = qr.getResultList();
        return com;
    }
    
    @Override
    public Commande selectCommandeByNumero(String numero) {
        String req = "Select c from Commande c where c.numero = :paramnumero";
        Query qr = em.createQuery(req);
        qr.setParameter("paramnumero", numero);
        Commande com = (Commande) qr.getSingleResult();
        return com;
    }
    
    @Override
    public List<Commande> selectCommandeTerminee() {
        String req = "Select c from Commande c where c.statut=:paramstatut";
        String statut = "terminée";
        Query qr = em.createQuery(req);
        qr.setParameter("paramstatut", statut);
        List<Commande> liste = qr.getResultList();
        for (Commande c : liste) {
            List<Emplacement> emplacements = selectEmplacementByIdCommande(c.getId());
            c.setEmplacements(emplacements);
            String numero = selectNumCommandeByIdCommande(c.getId());
            c.setNumero(numero);
        }
        return liste;
    }
    
    @Override
    public List<Emplacement> selectEmplacementByIdCommande(Long id) {
        String req = "Select c.emplacements from Commande c where c.id=:paramid";
        Query qr = em.createQuery(req);
        qr.setParameter("paramid", id);
        List<Emplacement> emplacements = qr.getResultList();
        return emplacements;
    }
    
    @Override
    public String selectNumCommandeByIdCommande(Long id) {
        String req = "Select c.numero from Commande c where c.id=:paramid";
        Query qr = em.createQuery(req);
        qr.setParameter("paramid", id);
        String numero = (String) qr.getSingleResult();
        return numero;
    }
    
    @Override
    public List<Integer> selectNumEmplacementById(Long id) {
        String req = "Select e.numero from Emplacement e where e.id=:paramid";
        Query qr = em.createQuery(req);
        qr.setParameter("paramid", id);
        List<Integer> numero = qr.getResultList();
        return numero;
    }

    @Override
    public List<Commande> selectCommandeEnCours() {
        String req = "Select c from Commande c where c.statut=:paramstatut";
        Query qr = em.createQuery(req);
        qr.setParameter("paramstatut", "en cours");
        List<Commande> commandes = qr.getResultList();
        for (Commande c : commandes) {
            List<Emplacement> emplacements = selectEmplacementByIdCommande(c.getId());
            c.setEmplacements(emplacements);
        }
        return commandes;
    }
    
}

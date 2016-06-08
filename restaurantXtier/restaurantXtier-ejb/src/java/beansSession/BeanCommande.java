package beansSession;

import beanEntite.Commande;
import beanEntite.Emplacement;
import beanEntite.LigneCommande;
import beanEntite.Utilisateur;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BeanCommande implements BeanCommandeLocal {

    @EJB
    private BeanLigneCommandeLocal beanLigneCommande;
    
    @EJB
    private BeanFormuleLocal beanFormuleLocal;

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
    public Commande selectCommandeByNumeroEmplacement(String numero) {
        String req = "Select e.commandes from Emplacement e where e.numero = :paramnumero";
        Query qr = em.createQuery(req);
        qr.setParameter("paramnumero", numero);
        Commande commande = (Commande) qr.getSingleResult();
        return commande;
    }

    @Override
    public Commande newCommande() {
        Commande c = new Commande();
        return c;
    }

    @Override
    public Commande createCommande(Collection<Emplacement> emps, Utilisateur ut01) {
        Commande com = new Commande();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        com.setDate(date);
        com.setEmplacements(emps);
        com.setStatut("en cours");
        com.setUtilisateur(ut01);
        return com;
    }

    @Override
    public String createNumeroCommande(long id) {
        String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
        return "C" + year + "00000" + Long.toString(id);
    }

    @Override
    public void sauvegarderCommande(Commande commande) {
        em.persist(commande);
        em.flush();
        String numeroCommande = createNumeroCommande(commande.getId());
        commande.setNumero(numeroCommande);
        em.merge(commande);
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
        List<LigneCommande> lc = beanLigneCommande.selectLigneCommandeByIdCommande(com.getId());
        return com;
    }

    @Override
    public List<Commande> selectCommandeTerminee() {
        String req = "Select c from Commande c where c.statut=:paramstatut";
        String statut = "terminee";
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

    
    @Override
    public void ajouterLigneDeCommande(Commande co, Long idArticle) {
        LigneCommande lc = beanLigneCommande.creerLigneDeCommandeArticle(idArticle);
        Collection<LigneCommande> listLc =  co.getLignesCommandes();
        listLc.add(lc);
    }
    
    @Override
    public Float getTotalCommandeTtc(String numero){
    Float total = 0F;
    Commande c = this.selectCommandeByNumero(numero);
    List<LigneCommande> liste = beanLigneCommande.selectLigneCommandeByIdCommande(c.getId());
    for (LigneCommande lc : liste) {
        Float f = beanLigneCommande.getPrixLcTTC();
        System.out.println("F = "+f);
        total += f;
        return total;
    }
    return total;
}    
    
}

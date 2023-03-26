/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Client;
import Entity.Contact;
import Entity.Enregistrement;
import Entity.Niveau;
import Entity.Offre;
import Entity.PisteOpp;
import Entity.Piste_opportunite;
import Entity.Profil;
import Entity.Statut;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mel
 */
@Stateless
public class Piste_opportuniteFacade extends AbstractFacade<Piste_opportunite> implements Piste_opportuniteFacadeLocal {
    
    @EJB
    private EnregistrementFacadeLocal enregistrementFacade;

    @PersistenceContext(unitName = "ProjetDassaultSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Piste_opportuniteFacade() {
        super(Piste_opportunite.class);
    }
    
    //Créer piste
    @Override
    public Piste_opportunite creerPisteOpportunite(Niveau niveau_interet, int tx_reussite, Niveau niveau_risque, double budget_estime, Client leClient) 
    {
        Piste_opportunite po = new Piste_opportunite();

        po.setDate_creation_popp(new Date());
        po.setDate_modif_popp(null);
        po.setNiveau_risque(niveau_risque);
        po.setTx_reussite(tx_reussite);
        po.setNiveau_interet(niveau_interet);
        po.setBudget_estime(budget_estime);
        po.setType(PisteOpp.PISTE);
        po.setStatut(Statut.OUVERTE);
        po.setVendeur(null);
        po.setExpert_technique(null);
        po.setLeClient(leClient);
        getEntityManager().persist(po);
        return po;
    }
    
       @Override
    public void CreerEnregistrementapresCreationPiste(Piste_opportunite p) {
        Enregistrement e = enregistrementFacade.CreerEnregistrement(p);
        p.setEnregistrement(e);
    } 
    
    //Modifier piste
    @Override
    public Piste_opportunite ModifierPisteOpportunite(Piste_opportunite p, Niveau niveau_interet, int tx_reussite, Niveau niveau_risque, double budget_estime, Client leClient) {
    p.setDate_modif_popp(new Date());
    p.setNiveau_interet(niveau_interet);
    p.setTx_reussite(tx_reussite);
    p.setNiveau_risque(niveau_risque);
    p.setBudget_estime(budget_estime);
    
    p.setLeClient(leClient);
    getEntityManager().merge(p);
    return p;
    }

     @Override
    public void AjouterEnregistrementApresModifPiste(Piste_opportunite p) {
        long id = p.getEnregistrement().getId();
        enregistrementFacade.ModifierEnregistrement(id, p);
    }
    
    //Affecter un vendeur à une piste
    @Override
    public void AffecterVendeur(Piste_opportunite p, Profil vendeur) {
        p.setStatut(Statut.QUALIFIE);
        p.setVendeur(vendeur);
        p.setDate_modif_popp(new Date());
        getEntityManager().merge(p);
    }
    
    //Accepter la piste par le vendeur
    @Override
    public void AccepterParVendeur(Piste_opportunite p, Profil vendeur) {
        p.setType(PisteOpp.OPPORTUNITE);
        p.setStatut(Statut.ACCEPTEE);
        p.setVendeur(vendeur);
        getEntityManager().merge(p);
    }
    
    //Refuser la piste par le vendeur
    @Override
    public void RefuserParVendeur(Piste_opportunite p) {
        p.setStatut(Statut.REJETEE);
        p.setVendeur(null);
        getEntityManager().merge(p);
    }
    
    //MAJ de la piste pour ajouter ou modifier des infos sur le client et/ou les contacts
    @Override
    public void MajPoParVendeur(Piste_opportunite p, Date date_modif_popp, Client c, String nom_client, String siret, Date date_modif_client, Contact co, String nom_contact, String prenom_contact, String mail_contact, String tel_contact, Date date_modif_contact) {
    date_modif_popp=new Date();
    p.setLeClient(c);
    
    c.setNom_client(nom_client);
    c.setSiret(siret);
    
    co.setNom_contact(nom_contact);
    co.setPrenom_contact(prenom_contact);
    co.setMail_contact(tel_contact);
    co.setTel_contact(tel_contact);
    date_modif_contact=new Date();
    getEntityManager().merge(p);
    getEntityManager().merge(c);
    getEntityManager().merge(co);
    }
    
    //Modifier le statut de l'opportunité pour la mettre sous le statut gagné
    @Override
    public void PisteGagne(Piste_opportunite p) {
        p.setDate_modif_popp(new Date());
        p.setStatut(Statut.GAGNE);
        getEntityManager().merge(p);
    }
    
    //Modifier le statut de l'opportunité pour la mettre sous le statut perdu
    @Override
    public void PistePerdu(Piste_opportunite p) {
        p.setDate_modif_popp(new Date());
        p.setStatut(Statut.PERDU);
        getEntityManager().merge(p);
    }
    
    //Rouvrir la piste par le marketeur
    @Override
    public void RouvrirPiste(Piste_opportunite p) {
        p.setStatut(Statut.OUVERTE);
        p.setDate_modif_popp(new Date());
        getEntityManager().merge(p);
    }
    
    //Affecter un expert technique à une piste
    @Override
    public void AffecterExpert(Piste_opportunite p, Profil expert_technique) {
        p.setExpert_technique(expert_technique);
        p.setDate_modif_popp(new Date());
        getEntityManager().merge(p);
    }
    
    //MAJ d'une offre pour une PO; fait pas l'expert technique
    @Override
    public void MajOffreParExpert(Piste_opportunite p, Date date_modif_popp, Offre offre) {
        date_modif_popp=new Date();
        p.setUneOffre(offre);
        getEntityManager().merge(p);
    }
    
    //Recherche piste_opportunite par Id
    @Override
    public Piste_opportunite RechercherPisteOpportuniteParId(long id_piste_opportunite) {
    Piste_opportunite p=null;
    List<Piste_opportunite> result;
    String txt="SELECT p FROM Piste_opportunite AS p WHERE p.id=:id";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("id", id_piste_opportunite);
    result=req.getResultList();
    if(result.size()==1){
        p=(Piste_opportunite)result.get(0);
    }
    return p;        
    }

    //Recherche piste_opportunite par Type
    @Override
    public List<Piste_opportunite> RechercherPisteOpportuniteParType(PisteOpp type) {
    Piste_opportunite p=null;
    List<Piste_opportunite> result;
    String txt="SELECT p FROM Piste_opportunite AS p WHERE p.type=:type";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("type", type);
    result=req.getResultList();

        return result;
    }
    
    //Recherche piste_opportunite par Statut
    @Override
    public List<Piste_opportunite> RechercherPisteOpportuniteParStatut(Statut statut) {
    Piste_opportunite p=null;
    List<Piste_opportunite> result;
    String txt="SELECT p FROM Piste_opportunite AS p WHERE p.statut=:statut";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("statut", statut);
    result=req.getResultList();
    
    return result;        
    }
    
    //Recherche piste_opportunite par Marketeur
    @Override
    public List<Piste_opportunite> RechercherPisteOpportuniteParMarketeur(Profil marketeur) {
    Piste_opportunite p=null;
    List<Piste_opportunite> result;
    String txt="SELECT p FROM Piste_opportunite AS p WHERE p.marketeur=:marketeur";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("marketeur", marketeur);
    result=req.getResultList();
    
    return result;        
    }
    
    //Recherche piste_opportunite par Vendeur
    @Override
    public List<Piste_opportunite> RechercherPisteOpportuniteParVendeur(Profil vendeur) {
    Piste_opportunite p=null;
    List<Piste_opportunite> result;
    String txt="SELECT p FROM Piste_opportunite AS p WHERE p.vendeur=:vendeur";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("vendeur", vendeur);
    result=req.getResultList();
   
    return result;        
    }
    
    //Recherche piste_opportunite par Expert technique
    @Override
    public List<Piste_opportunite> RechercherPisteOpportuniteParExpert(Profil expert_technique) {
    Piste_opportunite p=null;
    List<Piste_opportunite> result;
    String txt="SELECT p FROM Piste_opportunite AS p WHERE p.expert_technique=:expert_technique";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("expert_technique", expert_technique);
    result=req.getResultList();
   
    return result;        
    }
    
    //Recherche piste_opportunite par Client
    @Override
    public List<Piste_opportunite> RechercherPisteOpportuniteParClient(Client leClient) {
    Piste_opportunite p=null;
    List<Piste_opportunite> result;
    String txt="SELECT p FROM Piste_opportunite AS p WHERE p.leClient=:leClient";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("leClient", leClient);
    result=req.getResultList();
    
    return result;        
    }

    @Override
    public List<Piste_opportunite> AfficherPistes() {
        List <Piste_opportunite> lesPistes_opportunites;
        String tx = "SELECT p FROM Piste_opportunite AS p";
        Query req = getEntityManager().createQuery(tx);
        lesPistes_opportunites=req.getResultList();
        return lesPistes_opportunites;
    }

   




    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Client;
import Entity.Enregistrement;
import Entity.Niveau;
import Entity.PisteOpp;
import Entity.Piste_opportunite;
import Entity.Profil;
import Entity.Statut;
import java.util.Date;
import java.util.List;
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
    public void creerPisteOpportunite(int id_piste_opp, Date date_creation_popp, Date date_modif_popp, Niveau niveau_interet, int tx_reussite, Niveau niveau_risque, double budget_estime, PisteOpp type, Statut statut, Profil marketeur, Profil vendeur, Profil expert_technique) 
    {
        Piste_opportunite po = new Piste_opportunite();
        po.setId_piste_opp(id_piste_opp);
        po.setDate_creation_popp(date_creation_popp);
        po.setDate_modif_popp(date_modif_popp);
        po.setNiveau_risque(niveau_risque);
        po.setTx_reussite(tx_reussite);
        po.setNiveau_interet(niveau_interet);
        po.setBudget_estime(budget_estime);
        po.setType(type);
        po.setStatut(statut);
        po.setMarketeur(marketeur);
        po.setVendeur(vendeur);
        po.setExpert_technique(expert_technique);
        getEntityManager().persist(po);
    }
    
    //Modifier piste
    public void ModifierPisteOpportunite(Piste_opportunite p, Date date_modif_popp, Niveau niveau_interet, int tx_reussite, Niveau niveau_risque, double budget_estime, PisteOpp type, Statut statut, Profil marketeur, Profil vendeur, Profil expert_technique, Enregistrement enregistrement, Client leClient) {
    p.setDate_modif_popp(date_modif_popp);
    p.setNiveau_interet(niveau_interet);
    p.setTx_reussite(tx_reussite);
    p.setNiveau_risque(niveau_risque);
    p.setBudget_estime(budget_estime);
    p.setType(type);
    p.setStatut(statut);
    p.setMarketeur(marketeur);
    p.setVendeur(vendeur);
    p.setExpert_technique(expert_technique);
    p.setEnregistrement(enregistrement);
    p.setLeClient(leClient);
    getEntityManager().merge(p);
    }

    //Recherche piste_opportunite par Id
    public Piste_opportunite RechercherPisteOpportuniteParId(int id_piste_opportunite) {
    Piste_opportunite p=null;
    List<Piste_opportunite> result;
    String txt="SELECT p FROM Couturier AS p WHERE p.id_piste_opportunite=:id_piste_opportunite";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("id_piste_opportunite", id_piste_opportunite);
    result=req.getResultList();
    if(result.size()==1){
        p=(Piste_opportunite)result.get(0);
    }
    return p;        
    }

    //Recherche piste_opportunite par Type
    public Piste_opportunite RechercherPisteOpportuniteParType(PisteOpp type) {
    Piste_opportunite p=null;
    List<Piste_opportunite> result;
    String txt="SELECT p FROM Couturier AS p WHERE p.type=:type";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("type", type);
    result=req.getResultList();
    if(result.size()==1){
        p=(Piste_opportunite)result.get(0);
    }
        return p;
    }
    
    //Recherche piste_opportunite par Statut
    public Piste_opportunite RechercherPisteOpportuniteParStatut(Statut statut) {
    Piste_opportunite p=null;
    List<Piste_opportunite> result;
    String txt="SELECT p FROM Couturier AS p WHERE p.statut=:statut";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("statut", statut);
    result=req.getResultList();
    if(result.size()==1){
        p=(Piste_opportunite)result.get(0);
    }
    return p;        
    }
    
    //Recherche piste_opportunite par Marketeur
    public Piste_opportunite RechercherPisteOpportuniteParMarketeur(Profil marketeur) {
    Piste_opportunite p=null;
    List<Piste_opportunite> result;
    String txt="SELECT p FROM Couturier AS p WHERE p.marketeur=:marketeur";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("marketeur", marketeur);
    result=req.getResultList();
    if(result.size()==1){
        p=(Piste_opportunite)result.get(0);
    }
    return p;        
    }
    
    //Recherche piste_opportunite par Vendeur
    public Piste_opportunite RechercherPisteOpportuniteParVendeur(Profil vendeur) {
    Piste_opportunite p=null;
    List<Piste_opportunite> result;
    String txt="SELECT p FROM Couturier AS p WHERE p.vendeur=:vendeur";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("vendeur", vendeur);
    result=req.getResultList();
    if(result.size()==1){
        p=(Piste_opportunite)result.get(0);
    }
    return p;        
    }
    
    //Recherche piste_opportunite par Expert technique
    public Piste_opportunite RechercherPisteOpportuniteParExpert(Profil expert_technique) {
    Piste_opportunite p=null;
    List<Piste_opportunite> result;
    String txt="SELECT p FROM Couturier AS p WHERE p.expert_technique=:expert_technique";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("expert_technique", expert_technique);
    result=req.getResultList();
    if(result.size()==1){
        p=(Piste_opportunite)result.get(0);
    }
    return p;        
    }
    
    //Recherche piste_opportunite par Client
    public Piste_opportunite RechercherPisteOpportuniteParClient(Client leClient) {
    Piste_opportunite p=null;
    List<Piste_opportunite> result;
    String txt="SELECT p FROM Couturier AS p WHERE p.leClient=:leClient";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("leClient", leClient);
    result=req.getResultList();
    if(result.size()==1){
        p=(Piste_opportunite)result.get(0);
    }
    return p;        
    }
    
}

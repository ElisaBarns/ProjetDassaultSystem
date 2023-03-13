/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Niveau;
import Entity.PisteOpp;
import Entity.Piste_opportunite;
import Entity.Profil;
import Entity.Statut;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
    
    //Modifier piste

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
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Enregistrement;
import Entity.Piste_opportunite;
import java.util.ArrayList;
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
public class EnregistrementFacade extends AbstractFacade<Enregistrement> implements EnregistrementFacadeLocal {

    @PersistenceContext(unitName = "ProjetDassaultSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnregistrementFacade() {
        super(Enregistrement.class);
    }
    
    
    //Créer enregistrement

    public Enregistrement CreerEnregistrement(Piste_opportunite p) 
    {
        Enregistrement e = new Enregistrement();
    ArrayList<Piste_opportunite> liste_modifications = new ArrayList();
    liste_modifications.add(p);
    getEntityManager().persist(p);
    return e;
    //Pensez à l'intégrer dans la méthode Creer Piste_opportunite !!!
    }

    
    //Modifier enregistrement
    public void ModifierEnregistrement(long id, Piste_opportunite p) {
    Enregistrement e = RechercherEnregistrement(id);
        ArrayList<Piste_opportunite> liste_modifications = e.getListe_modifications();
    liste_modifications.add(p);
    //Pensez à l'intégrer dans la méthode Creer Piste_opportunite !!!
    }
    
    public Enregistrement RechercherEnregistrement(long id) {
        Enregistrement e = null;
        String txt="SELECT e FROM Enregistrement as e WHERE e.id=:id";
        Query req=getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        e=(Enregistrement)req.getSingleResult();
        return e;
    }
}

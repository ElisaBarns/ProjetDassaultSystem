/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Piste_opportunite;
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
    
}

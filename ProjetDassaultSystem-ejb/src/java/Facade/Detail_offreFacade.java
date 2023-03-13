/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Detail_offre;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mel
 */
@Stateless
public class Detail_offreFacade extends AbstractFacade<Detail_offre> implements Detail_offreFacadeLocal {

    @PersistenceContext(unitName = "ProjetDassaultSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Detail_offreFacade() {
        super(Detail_offre.class);
    }
 
    
    //Créer détail offre
    
    //Modifier détail offre
    
    //Supprimer détail offre
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Produit;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mel
 */
@Stateless
public class ProduitFacade extends AbstractFacade<Produit> implements ProduitFacadeLocal {

    @PersistenceContext(unitName = "ProjetDassaultSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitFacade() {
        super(Produit.class);
    }
    
    
    //Créer produit
    
    //Modifier produit
    
    //Inactiver produit
    
    
}

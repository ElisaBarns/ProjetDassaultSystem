/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Detail_offre;
import Entity.Offre;
import Entity.Produit;
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
    public void CreerDetailOffre(int quantite, Produit leProduit, Offre uneOffre, float p_detail) {
    Detail_offre d = new Detail_offre();
    d.setQuantite(quantite);
    d.setLeProduit(leProduit);
    d.setUneOffre(uneOffre);
    d.setP_detail(p_detail);
    getEntityManager().persist(d);
    }
    
    //Modifier détail offre
    public void ModifierDetailOffre(Detail_offre d, int quantite, Produit leProduit, Offre uneOffre, float p_detail) {
    d.setQuantite(quantite);
    d.setLeProduit(leProduit);
    d.setUneOffre(uneOffre);
    d.setP_detail(p_detail);
    getEntityManager().merge(d);
    }
    
    //Supprimer détail offre

    @Override
    public void SupprimerDetailOffre(Detail_offre d) {
    getEntityManager().remove(d);
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Offre;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mel
 */
@Stateless
public class OffreFacade extends AbstractFacade<Offre> implements OffreFacadeLocal {

    @PersistenceContext(unitName = "ProjetDassaultSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OffreFacade() {
        super(Offre.class);
    }
    
    
    //Créer offre
    public void CreerOffre(int remise, Date date_creation_offre, float p_somme, float p_total) {
    Offre o=new Offre();
    o.setRemise(remise);
    o.setDate_creation_offre(date_creation_offre);
    o.setP_somme(p_somme);
    o.setP_total(p_total);
    getEntityManager().persist(o);
    }
    
    //Modifier offre

    public void ModifierOffre(Offre o, int remise, Date date_modif_offre, float p_somme, float p_total) {
    o.setRemise(remise);
    o.setDate_modif_offre(date_modif_offre);
    o.setP_somme(p_somme);
    o.setP_total(p_total);
    getEntityManager().merge(o);
    }
    

}

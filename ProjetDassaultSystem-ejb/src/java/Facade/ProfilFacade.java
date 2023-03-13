/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Fonction;
import Entity.Profil;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mel
 */
@Stateless
public class ProfilFacade extends AbstractFacade<Profil> implements ProfilFacadeLocal {

    @PersistenceContext(unitName = "ProjetDassaultSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfilFacade() {
        super(Profil.class);
    }
    
    
    //Créer profil
    public void CreerProfil(Fonction f, boolean inactif, Date date_creation_profil, Date date_inactif_profil) {
    Profil p=new Profil();
    p.setFonction(f);
    p.setInactif(inactif);
    p.setDate_creation_profil(date_creation_profil);
    p.setDate_inactif_profil(date_inactif_profil);
    getEntityManager().persist(p);
    }
    
    //Modifier profil
    public void ModifierProfil(Profil p, Fonction f) {
    p.setFonction(f);
    getEntityManager().merge(p);
    }
    
    //Inactiver profil
    public void InactiverProfil(Profil p, boolean inactif, Date date_inactif_profil) {
    p.setInactif(inactif);
    p.setDate_inactif_profil(date_inactif_profil);
    getEntityManager().merge(p);
    }

}

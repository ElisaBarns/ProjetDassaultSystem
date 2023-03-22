/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Contact;
import Entity.Fonction;
import Entity.Profil;
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
    @Override
    public void CreerProfil(Fonction f) {
    Profil p=new Profil();
    p.setFonction(f);
    p.setInactif(false);
    p.setDate_creation_profil(new Date());
    getEntityManager().persist(p);
    }
    
    //Modifier profil
    @Override
    public void ModifierProfil(Profil p, Fonction f) {
    p.setFonction(f);
    getEntityManager().merge(p);
    }
    
    //Inactiver profil
    @Override
    public void InactiverProfil(Profil p) {
    p.setInactif(true);
    p.setDate_inactif_profil(new Date());
    getEntityManager().merge(p);
    }

    @Override
    public Profil RechercherProfilparID(long id) {
        Profil p=null;
        String txt=" SELECT p FROM Profil AS p WHERE p.id=:id";
        Query req=getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        p=(Profil)req.getSingleResult();
        return p;
    }

    
    
}

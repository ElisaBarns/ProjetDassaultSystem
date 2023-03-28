/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Contact;
import Entity.Fonction;
import Entity.Profil;
import Entity.Utilisateur;
import java.util.ArrayList;
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
    public void CreerProfil(Fonction f, Utilisateur u) {
    Profil p=new Profil();
    p.setFonction(f);
    p.setUnUtilisateur(u);
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
    public Profil RechercherProfilparId(long id) {
        Profil p=null;
        String txt="SELECT p FROM Profil AS p WHERE p.id=:id";
        Query req=getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        p=(Profil)req.getSingleResult();
        return p;
    }
    

    @Override
    public List<Profil> AfficherTousLesProfils() {
        List <Profil> p;
        String tx = "SELECT p FROM Profil AS p";
        Query req = getEntityManager().createQuery(tx);
        p=req.getResultList();
        return p;
    }
    
    @Override
    public List<Profil> ListeVendeursActifs() {
        List<Profil> lp = findAll();
        ArrayList<Profil> lpva = new ArrayList();
        Profil p;
        int i = 1;
        while(i<lp.size()){
            p = lp.get(i);
            if(p.getFonction().equals(Fonction.VENDEUR) && p.isInactif() == false) {
                lpva.add(p);
                i++;
               
            }
            
            else { i++; 
            
            }     
        }
       
        return lpva;
    }

    @Override
    public List<Profil> ListeExpertActif() {
        List<Profil> lp = findAll();
        ArrayList<Profil> lpea = new ArrayList();
        Profil p;
        int i = 1;
        while(i<lp.size()){
            p = lp.get(i);
            if(p.getFonction().equals(Fonction.EXPERT_TECHNIQUE) && p.isInactif() == false) {
                
                lpea.add(p);
               System.out.println(p.getId());
                i++;
            }
            else { i++;}
        }
        
        return lpea;
    }
    @Override
     public Profil RechercherUnMarketeurParId(Utilisateur unUtilisateur)
    {
        Profil p=null;
          List <Profil> listeProfil;
        String txt="SELECT p FROM Profil AS p WHERE p.unUtilisateur=:unUtilisateur";
        Query req=getEntityManager().createQuery(txt);
        req=req.setParameter("unUtilisateur", unUtilisateur);
       listeProfil=req.getResultList();
       
       for (int i=0;i<listeProfil.size();i++){
            System.out.println(listeProfil.get(i).getFonction().name());
            if (listeProfil.get(i).getFonction().name().equals("MARKETEUR")){
                p=listeProfil.get(i);
            }
            
            }
            
        return p;
          }
     
      @Override
     public Profil RechercherUnVendeurParId(Utilisateur unUtilisateur)
    {
        Profil p=null;
          List <Profil> listeProfil;
        String txt="SELECT p FROM Profil AS p WHERE p.unUtilisateur=:unUtilisateur";
        Query req=getEntityManager().createQuery(txt);
        req=req.setParameter("unUtilisateur", unUtilisateur);
       listeProfil=req.getResultList();
       
       for (int i=0;i<listeProfil.size();i++){
            System.out.println(listeProfil.get(i).getFonction().name());
            if (listeProfil.get(i).getFonction().name().equals("VENDEUR")){
                p=listeProfil.get(i);
            }
            
            }
            
        return p;
          }
     
     @Override
     public Profil RechercherUnExpertParId(Utilisateur unUtilisateur)
    {
        Profil p=null;
          List <Profil> listeProfil;
        String txt="SELECT p FROM Profil AS p WHERE p.unUtilisateur=:unUtilisateur";
        Query req=getEntityManager().createQuery(txt);
        req=req.setParameter("unUtilisateur", unUtilisateur);
       listeProfil=req.getResultList();
       
       for (int i=0;i<listeProfil.size();i++){
            System.out.println(listeProfil.get(i).getFonction().name());
            if (listeProfil.get(i).getFonction().name().equals("EXPERT_TECHNIQUE")){
                p=listeProfil.get(i);
            }
            
            }
            
        return p;
          }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Piste_opportunite;
import Entity.Produit;
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
    @Override
    public void CreerProduit(String nom_produit, String description_commerciale, float pu_produit, Date date_creation_produit, boolean inactif) {
    Produit p=new Produit();
    p.setNom_produit(nom_produit);
    p.setDescription_commerciale(description_commerciale);
    p.setPu_produit(pu_produit);
    date_creation_produit=new Date();  
    p.setInactif(false);
    getEntityManager().persist(p);
    }
    
    //Modifier produit
    @Override
    public void ModifierProduit(Produit p, String nom_produit, String description_commerciale, float pu_produit, Date date_modif_produit) {
    p.setNom_produit(nom_produit);
    p.setDescription_commerciale(description_commerciale);
    p.setPu_produit(pu_produit);
    date_modif_produit=new Date();
    getEntityManager().merge(p);
    }
    
    //Inactiver produit
    @Override
    public void InactiverProduit(Produit p, Date date_inactivation_produit, boolean inactif) {
    date_inactivation_produit=new Date();
    p.setInactif(true);
    getEntityManager().merge(p);
    }
    
    @Override
    public Produit RechercherProduitParNom(String nom_produit) {
    Produit p=null;
    List<Produit> result;
    String txt="SELECT p FROM Produit AS p WHERE p.nom_produit=:nom_produit";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("nom_produit", nom_produit);
    result=req.getResultList();
    if(result.size()==1){
        p=(Produit)result.get(0);
    }
    return p;        
    }
    
    @Override
    public Produit RechercherProduitParId(long id) {
    Produit p=null;
    List<Produit> result;
    System.out.println("I1");
    String txt="SELECT p FROM Produit AS p WHERE p.id=:id";
    Query req=getEntityManager().createQuery(txt);
    System.out.println("I2");
    req=req.setParameter("id", id);
    result=req.getResultList();
    if(result.size()==1){
        p=(Produit)result.get(0);
    }
    return p;        
    }
    
    @Override
    public List<Produit> AfficherLesProduits() {
    List <Produit> p;
    String tx = "SELECT p FROM Produit AS p";
    Query req = getEntityManager().createQuery(tx);
    p=req.getResultList();
    return p;
    }
}

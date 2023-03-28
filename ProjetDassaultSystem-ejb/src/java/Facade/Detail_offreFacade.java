/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Detail_offre;
import Entity.Offre;
import Entity.Produit;
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
    @Override
    public void CreerDetailOffre(int quantite, Produit leProduit, Offre uneOffre) {
    Detail_offre d = new Detail_offre();
    d.setQuantite(quantite);
    d.setLeProduit(leProduit);
    d.setUneOffre(uneOffre);
        float prix = d.CalculerP_detail(leProduit);
    d.setP_detail(prix);
    getEntityManager().persist(d);
    }
    
    //Modifier détail offre
    @Override
    public void ModifierDetailOffre(Detail_offre d, int quantite, Produit leProduit, Offre uneOffre) {
    d.setQuantite(quantite);
    d.setLeProduit(leProduit);
    d.setUneOffre(uneOffre);
        float prix = d.CalculerP_detail(leProduit);
    d.setP_detail(prix);
    getEntityManager().merge(d);
    }
    
    //Supprimer détail offre

    @Override
    public void SupprimerDetailOffre(Detail_offre d) {
    getEntityManager().remove(d);
    }
    
    @Override
    public Detail_offre RechercherDetail_offreParId(long id) {
    Detail_offre d=null;
    List<Detail_offre> result;
    String txt="SELECT d FROM Deatil_offre AS d WHERE d.id=:id";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("id", id);
    result=req.getResultList();
    if(result.size()==1){
        d=(Detail_offre)result.get(0);
    }
    return d;        
    }
    
    public List<Detail_offre> AfficherTousLesDetails_offres() {
        List <Detail_offre> d;
        String tx = "SELECT d FROM Detail_offre AS d";
        Query req = getEntityManager().createQuery(tx);
        d=req.getResultList();
        return d;
    }
}

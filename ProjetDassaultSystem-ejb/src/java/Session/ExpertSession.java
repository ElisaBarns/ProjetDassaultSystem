/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package Session;


import Entity.Detail_offre;
import Entity.Offre;
import Entity.Piste_opportunite;
import Entity.Produit;
import Entity.Profil;
import Entity.Utilisateur;
import Facade.Detail_offreFacadeLocal;
import Facade.OffreFacadeLocal;
import Facade.Piste_opportuniteFacadeLocal;
import Facade.ProduitFacadeLocal;
import Facade.UtilisateurFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Mel
 */
@Stateful
public class ExpertSession implements ExpertSessionLocal {

    @EJB
    private Piste_opportuniteFacadeLocal piste_opportuniteFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;
    
    @EJB 
    private OffreFacadeLocal offreFacade;    
    
    @EJB
    private Detail_offreFacadeLocal detail_offreFacade;
    
    @EJB
    private ProduitFacadeLocal produitFacade;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    
    //Consulter l'historique des actions effectuées sur un prospect ou une opportunité spécifique

    
    //Afficher tous les leads et opportunités qui me sont attribués
    @Override
    public List<Piste_opportunite> AfficherPistesExpert() {
        return piste_opportuniteFacade.AfficherPistes();
    }
    
    
    //MAJ une piste sur laquelle je suis assignée pour ajouter ou modifier l'offre
    @Override
    public void MajOffreParExpert(String l, String mdp, Piste_opportunite p, Date date_modif_popp, Offre offre) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            // A REVOIR !!! p=piste_opportuniteFacade.RechercherPisteOpportuniteParId(p.getId_piste_opp());
            
            piste_opportuniteFacade.MajOffreParExpert(p, date_modif_popp, offre);
        }
        else
        {
            System.out.println("Vous avez saisi un mauvais login et/ou mot de passe. Veuillez réessayer.");
        }
    }
    
    @Override
    public void CreerOffre(int remise, String conditions, Piste_opportunite piste)
    {
        offreFacade.CreerOffre(remise, conditions, piste);
    }
    
    @Override
    public void ModifierOffre(int id_offre, int remise, String conditions)
    {
        Offre offre = offreFacade.RechercherOffreParId(id_offre);
        offreFacade.ModifierOffre(offre, remise, conditions);
    }
    
    
    //Rechercher ou parcourir le catalogue et choisir des éléments afin de remplir l'offre
    
    
    //Joindre un document de proposition à une piste et à une opportunité qui m'ont été attribuées

    
    
    @Override
    public void CreerDetail_offre(Offre o, Produit p, int quantite) {
        detail_offreFacade.CreerDetailOffre(o, p, quantite);
    }

    @Override
    public void ModifierDetail_offre(long id_detail, String nom_produit, long id_offre, int quantite) {
        Detail_offre detail = detail_offreFacade.RechercherDetail_offreParId(id_detail);
        Produit leProduit = produitFacade.RechercherProduitParNom(nom_produit);
        Offre uneOffre = offreFacade.RechercherOffreParId(id_offre);
        detail_offreFacade.ModifierDetailOffre(detail, quantite, leProduit, uneOffre);
    }

    @Override
    public void SupprimerDetailOffre(long id_detail) {
        Detail_offre detail = detail_offreFacade.RechercherDetail_offreParId(id_detail);
        detail_offreFacade.SupprimerDetailOffre(detail);
    }

    @Override
    public Produit RechercherProduitParNom(String nom_produit) {
        return produitFacade.RechercherProduitParNom(nom_produit);
    }
    
    @Override
    public List<Detail_offre> AfficherTousLesDetails_offres() {
        return detail_offreFacade.AfficherTousLesDetails_offres();
    }
    
    @Override
    public Detail_offre RechercherDetail_offreParId(long id_detail_offre){
        return detail_offreFacade.RechercherDetail_offreParId(id_detail_offre);
    }
    
    @Override
    public Piste_opportunite RechercherPisteParId(long id) {
        
        return piste_opportuniteFacade.RechercherPisteOpportuniteParId(id);
    }
    
    @Override
    public List<Piste_opportunite> AfficherPistes() {
        return piste_opportuniteFacade.AfficherPistes();
    }
    
    @Override
    public Offre RechercherOffreParId(long id) {
        return offreFacade.RechercherOffreParId(id);
    }
    
    @Override
    public Produit RechercherProduitParId(long id) {
        return produitFacade.RechercherProduitParId(id);
    }
    
    @Override
    public List<Offre> AfficherLesOffres(){
        return offreFacade.AfficherLesOffres();
    }
    
    @Override
    public List<Produit> AfficherLesProduits(){
        return produitFacade.AfficherLesProduits();
    }
}

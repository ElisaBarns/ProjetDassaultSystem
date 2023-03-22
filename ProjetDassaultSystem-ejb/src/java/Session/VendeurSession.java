/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package Session;

import Entity.Client;
import Entity.Contact;
import Entity.Niveau;
import Entity.Piste_opportunite;
import Entity.Profil;
import Entity.Statut;
import Entity.Utilisateur;
import Facade.ClientFacadeLocal;
import Facade.ContactFacadeLocal;
import Facade.Piste_opportuniteFacadeLocal;
import Facade.ProfilFacadeLocal;
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
public class VendeurSession implements VendeurSessionLocal {

    @EJB
    private ProfilFacadeLocal profilFacade;

    @EJB
    private Piste_opportuniteFacadeLocal piste_opportuniteFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;
    
    @EJB
    private ClientFacadeLocal clientFacade;

    @EJB
    private ContactFacadeLocal contactFacade;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //Accepter une piste qui m'a été attribuée
    @Override
    public void AccepterPiste(Piste_opportunite p, long idvendeur) {
        
            //IL NE FAUT PAS RECHERCHER LA PISTE PUISQU'IL EST CENSE EN AVOIR CHOISI UNE
            //LA SOLUTION SERAIT D'AFFICHER UNE LISTE DES PISTES SOUS LE STATUT QUALIFIE, autrement dit des pistes auxquelles des vendeurs ont été affectés mais que ce dernier n'a pas encore repondu
            
            /*Piste_opportunite po=piste_opportuniteFacade.RechercherPisteOpportuniteParId(id_piste_opportunite);
            v=po.getVendeur();
            if(listeProfils.contains(v))
            {*/
            Profil vendeur = profilFacade.RechercherProfilparID(idvendeur);
                piste_opportuniteFacade.AccepterParVendeur(p, vendeur);
            /*}
            else
            {
                System.out.println("Vous n'avez pas les droits d'accès nécessaires pour modifier le vendeur affecté à cette piste. Veuillez vous rapprocher de votre administrateur.");
            }*/
        
    }
    
    
    //Refuser une piste qui m'a été affectée
    @Override
    public void RefuserPiste(Piste_opportunite p) {
        
            piste_opportuniteFacade.RefuserParVendeur(p); 
        
    }
    
    
    //Assigner un expert technique
    @Override
    public void AffecterExpert(long id, long idexpert) {
        
            
            Piste_opportunite po=piste_opportuniteFacade.RechercherPisteOpportuniteParId(id);
            Profil expert_technique = profilFacade.RechercherProfilparID(idexpert);
         
            
            
                piste_opportuniteFacade.AffecterExpert(po,expert_technique);
            
        
        
    }
    
    //Afficher toutes les pistes et opportunités qui me sont attribuées
    //PAS BESOIN CAR A GERER DANS JSP ?????
    /*@Override
    public void AfficherListePO(String l, String mdp, Profil v) {
        Utilisateur u=null;
        u=utilisateurFacade.Authentification(l, mdp);
        if(u!=null)
        {
            List<Profil> listeProfils=u.getLesProfils();
            
            Piste_opportunite po=piste_opportuniteFacade.RechercherPisteOpportuniteParVendeur(v);
            v=po.getVendeur();
            if(listeProfils.contains(v))
            {
                piste_opportuniteFacade.RechercherPisteOpportuniteParVendeur(v);
            }
            else
            {
                System.out.println("Vous n'avez pas de pistes auxquelles vous êtes affectés.");
            }
        }
        else
        {
            System.out.println("Vous avez saisi un mauvais login et/ou mot de passe. Veuillez réessayer.");
        }
    }*/
    
    //MAJ de la piste/opportunité qui m'a été attribué pour ajouter ou modifier des informations sur le client, le contact
   
    
    //Soumettre une proposition pour une piste qui m'a été assignée, le document doit être envoyé au contact par mail (Soumis)
    //TROUVER UN MOYEN D'EXTRAIRE UN DOC !!! cf Gestion des API sur le Drive
    
    
    //Suivre la réponse du client sur un prospect ou une opportunité qui m'a été attribué (Gagné ou Perdu)
    @Override
    public void PisteGagne(long id) {
        Piste_opportunite p = piste_opportuniteFacade.RechercherPisteOpportuniteParId(id);
       piste_opportuniteFacade.PisteGagne(p); 
        
    }
    
    @Override
    public void PistePerdu(long id) {
        Piste_opportunite p = piste_opportuniteFacade.RechercherPisteOpportuniteParId(id);
            piste_opportuniteFacade.PistePerdu(p); 
        
    }
    
    @Override
    public void ModifierPiste(long id_piste, Niveau niveau_interet, int tx_reussite, Niveau niveau_risque, double budget_estime, long idclient){
        Piste_opportunite p = piste_opportuniteFacade.RechercherPisteOpportuniteParId(id_piste);
        Client client = clientFacade.rechercherClientparId(idclient);
        p = piste_opportuniteFacade.ModifierPisteOpportunite(p, niveau_risque, tx_reussite, niveau_risque, budget_estime, client);
        piste_opportuniteFacade.AjouterEnregistrementApresModifPiste(p);
    }
    
    @Override
    public void ModifierClient(long id_client, String nom, String siret) {
        Client c = clientFacade.rechercherClientparId(id_client);
        clientFacade.modifierClient(c, nom, siret);
        
    }
    
    @Override
    public void ModifierContact(long id_contact, String nom, String prenom, String mail, String tel) {
        Contact c = contactFacade.rechercherContact(id_contact);
        contactFacade.modifierContact(c, nom, prenom, mail, tel);
    }
    
}

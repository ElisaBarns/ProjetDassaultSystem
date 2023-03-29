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
    public void AccepterPiste(Piste_opportunite p) {
        piste_opportuniteFacade.AccepterParVendeur(p);
    }
    
    
    //Refuser une piste qui m'a été affectée
    @Override
    public void RefuserPiste(Piste_opportunite p) {
        piste_opportuniteFacade.RefuserParVendeur(p); 
    }
    
    
    //Assigner un expert technique
    @Override
    public void AffecterExpert(Piste_opportunite piste, Profil expert) 
    {
        piste_opportuniteFacade.AffecterExpert(piste, expert);
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
    public void PisteGagne(Piste_opportunite p) {
       piste_opportuniteFacade.PisteGagne(p); 
    }
    
    @Override
    public void PistePerdu(Piste_opportunite p) {
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
    public void ModifierClient(long id, String nom, String siret) {
        Client c = clientFacade.rechercherClientparId(id);
        if (c!=null)
        {
         clientFacade.modifierClient(c, id, nom, siret);
        }
    
            
    }
    
    @Override
    public void ModifierContact(long id_contact, String nom, String prenom, String mail, String tel) {
        Contact c = contactFacade.rechercherContact(id_contact);
        contactFacade.modifierContact(c, nom, prenom, mail, tel);
    }

    @Override
    public List<Piste_opportunite> AfficherPistes() {
        return piste_opportuniteFacade.AfficherPistes();
    }
    
    @Override
    public Piste_opportunite RechercherPisteParId(long id_piste){
        return piste_opportuniteFacade.RechercherPisteOpportuniteParId(id_piste);
    }
    
    @Override
    public Profil RechercherUnProfilExpertParId(Utilisateur utilisateur) {
        
        return profilFacade.RechercherUnExpertParId(utilisateur);
    }
    
    @Override
    public List<Profil> ListeExpertActif() {
        return profilFacade.ListeExpertActif();
    }
    
    @Override
    public List<Piste_opportunite> ListePistes() {
        return piste_opportuniteFacade.AfficherPistes();
    }
    
    @Override
    public void SoumettrePiste(Piste_opportunite p) {
            piste_opportuniteFacade.SoumettrePiste(p); 
    }
}

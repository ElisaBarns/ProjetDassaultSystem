/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package Session;

import Entity.Client;
import Entity.Contact;
import Entity.Piste_opportunite;
import Entity.Profil;
import Entity.Statut;
import Entity.Utilisateur;
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

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //Accepter une piste qui m'a été attribuée
    @Override
    public void AccepterPiste(String l, String mdp, Piste_opportunite p, Profil vendeur) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            List <Profil> listeProfils =u.getLesProfils();
            
            //IL NE FAUT PAS RECHERCHER LA PISTE PUISQU'IL EST CENSE EN AVOIR CHOISI UNE
            //LA SOLUTION SERAIT D'AFFICHER UNE LISTE DES PISTES SOUS LE STATUT QUALIFIE, autrement dit des pistes auxquelles des vendeurs ont été affectés mais que ce dernier n'a pas encore repondu
            
            /*Piste_opportunite po=piste_opportuniteFacade.RechercherPisteOpportuniteParId(id_piste_opportunite);
            v=po.getVendeur();
            if(listeProfils.contains(v))
            {*/
                piste_opportuniteFacade.AccepterParVendeur(p, vendeur);
            /*}
            else
            {
                System.out.println("Vous n'avez pas les droits d'accès nécessaires pour modifier le vendeur affecté à cette piste. Veuillez vous rapprocher de votre administrateur.");
            }*/
        }
        else
        {
            System.out.println("Vous avez saisi un mauvais login et/ou mot de passe. Veuillez réessayer.");
        }
    }
    
    
    //Refuser une piste qui m'a été affectée
    @Override
    public void RefuserPiste(String l, String mdp, Piste_opportunite p, Profil vendeur) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            
            piste_opportuniteFacade.RefuserParVendeur(p, vendeur);
        }
        else
        {
            System.out.println("Vous avez saisi un mauvais login et/ou mot de passe. Veuillez réessayer.");
        }
    }
    
    
    //Assigner un expert technique
    @Override
    public void AffecterExpert(String l, String mdp, int id_piste_opportunite, Profil v, Piste_opportunite p, Profil expert_technique) {
        Utilisateur u=null;
        u=utilisateurFacade.Authentification(l, mdp);
        if(u!=null)
        {
            List<Profil> listeProfils=u.getLesProfils();
            Piste_opportunite po=piste_opportuniteFacade.RechercherPisteOpportuniteParId(id_piste_opportunite);
            v=po.getVendeur();
            if(listeProfils.contains(v))
            {
                piste_opportuniteFacade.AffecterExpert(p,expert_technique);
            }
            else
            {
                System.out.println("Vous n'avez pas les droits d'accès nécessaires pour affecter un expert technique à cette piste. Veuillez vous rapprocher de votre administrateur.");
            }
        }
        
    }
    
    //Afficher toutes les pistes et opportunités qui me sont attribuées
    //PAS BESOIN CAR A GERER DANS JSP ?????
    @Override
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
    }
    
    //MAJ de la piste/opportunité qui m'a été attribué pour ajouter ou modifier des informations sur le client, le contact
    @Override
    public void MajPoParVendeur(String l, String mdp, Piste_opportunite p, Date date_modif_popp, Client c, String nom_client, String siret, boolean inactif, Date date_inactiv_client, Date date_modif_client, Contact co, String nom_contact, String prenom_contact, String mail_contact, String tel_contact, Date date_modif_contact, Date date_inactiv_contact) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            
            piste_opportuniteFacade.MajPoParVendeur(p, date_modif_popp, c, nom_client, siret, inactif, date_inactiv_client, date_modif_client, co, nom_contact, prenom_contact, mail_contact, tel_contact, date_modif_contact, date_inactiv_contact);
        }
        else
        {
            System.out.println("Vous avez saisi un mauvais login et/ou mot de passe. Veuillez réessayer.");
        }
    }
    
    //Soumettre une proposition pour une piste qui m'a été assignée, le document doit être envoyé au contact par mail (Soumis)
    //TROUVER UN MOYEN D'EXTRAIRE UN DOC !!! cf Gestion des API sur le Drive
    
    
    //Suivre la réponse du client sur un prospect ou une opportunité qui m'a été attribué (Gagné ou Perdu)
    @Override
    public void PisteGagne(String l, String mdp, Piste_opportunite p, Date date_modif_popp, Statut statut) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            
            piste_opportuniteFacade.PisteGagne(p, date_modif_popp, statut);
        }
        else
        {
            System.out.println("Vous avez saisi un mauvais login et/ou mot de passe. Veuillez réessayer.");
        }
    }
    
    @Override
    public void PistePerdu(String l, String mdp, Piste_opportunite p, Date date_modif_popp, Statut statut) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            
            piste_opportuniteFacade.PistePerdu(p, date_modif_popp, statut);
        }
        else
        {
            System.out.println("Vous avez saisi un mauvais login et/ou mot de passe. Veuillez réessayer.");
        }
    }
    
}

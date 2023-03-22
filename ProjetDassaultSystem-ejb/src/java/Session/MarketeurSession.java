/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package Session;

import Entity.Client;
import Entity.Contact;
import Entity.Niveau;
import Entity.PisteOpp;
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
public class MarketeurSession implements MarketeurSessionLocal {

    @EJB
    private Piste_opportuniteFacadeLocal piste_opportuniteFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;
    
    @EJB
    private ClientFacadeLocal clientFacade;
    
    @EJB
    private ContactFacadeLocal contactFacade;
    
    @EJB
    private ProfilFacadeLocal profilFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    //Créer une piste ou opportunité
    @Override
    public void CreerPiste(String l, String mdp, Date date_creation_popp, Date date_modif_popp, Niveau niveau_interet, int tx_reussite, Niveau niveau_risque, double budget_estime, PisteOpp type, Statut statut, Profil marketeur, Profil vendeur, Profil expert_technique) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            piste_opportuniteFacade.creerPisteOpportunite(0, date_creation_popp, date_modif_popp, Niveau.HAUT, 0, Niveau.MEDIUM, 0, PisteOpp.PISTE, Statut.GAGNE, marketeur, vendeur, expert_technique);
        }
        else
        {
            System.out.println("Vous n'avez pas les droits d'accès nécessaires pour pouvoir créer une piste. Veuillez vous rapprocher de votre administrateur.");
        }
    }
    
    @Override
    public void CreerClient(String nom, String siret, String nom_contact, String prenom, String mail, String tel) {
            clientFacade.creerClient(nom, siret);
            contactFacade.creerContact(nom_contact, prenom, mail, tel);
    }
    
    
    
    @Override
    public void CreerContact(String nom, String prenom, String mail, String tel)
    {
        contactFacade.creerContact(nom, prenom, mail, tel);
    }
    
    //Affecter un vendeur (+ vérifier si je suis assigné à cette piste, sinon jpp affecter un vendeur)
    @Override
    public void AffecterVendeur(long id, long id_profil) {
        //Utilisateur u = null;
        //u = utilisateurFacade.Authentification(l,mdp);
        //if(u!=null)
        //{
            //List <Profil> listeProfils =u.getLesProfils();
            Piste_opportunite po=piste_opportuniteFacade.RechercherPisteOpportuniteParId(id);
            //m=po.getMarketeur();
            //if(listeProfils.contains(m))
            //{
            Profil vendeur = profilFacade.RechercherProfilparID(id);
            if(vendeur.getFonction().equals("Vendeur"))
            {
                piste_opportuniteFacade.AffecterVendeur(po, vendeur);
            }
            else
            {
                System.out.println("Le profil indiqué ne correspond pas à un vendeur");
            }
            //    System.out.println("Vous n'avez pas les droits d'accès nécessaires pour affecter un vendeur à une piste. Veuillez vous rapprocher de votre administrateur.");
            //}
       // }
    }
    
    //Consulter l'historique des actions effectuées sur un prospect ou une opportunité spécifique

    //Rouvrir la piste (car le vendeur a refusé son affectation à la piste)

    @Override
    public void RouvrirPiste(long id) {
        Piste_opportunite p = piste_opportuniteFacade.RechercherPisteOpportuniteParId(id);
            piste_opportuniteFacade.RouvrirPiste(p);
        
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

    @Override
    public void InactiverContact(long id) {
        Contact c = contactFacade.rechercherContact(id);
        contactFacade.inactiverContact(c, true);
    }

    @Override
    public void InactiverClient(long id) {
        Client c = clientFacade.rechercherClientparId(id);
        clientFacade.inactiverClient(c, true);
        List<Contact> listecontacts = contactFacade.RechercherContactsClient(c);
        int i =1;
        while (i<listecontacts.size())
        {
            listecontacts.get(i).setInactif(true);
            i++;
        }
    }

    @Override
    public List<Contact> RechercherContactsClient(long id) {
        Client c = clientFacade.rechercherClientparId(id);
        List<Contact> listecontacts = contactFacade.RechercherContactsClient(c);
        return listecontacts;
    }
    
    
    
    
    
    
}

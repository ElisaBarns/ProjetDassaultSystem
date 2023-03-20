/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package Session;

import Entity.Fonction;
import Entity.Profil;
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
public class AdministrateurSession implements AdministrateurSessionLocal {

    @EJB
    private ProfilFacadeLocal profilFacade;

    @EJB
    private Piste_opportuniteFacadeLocal piste_opportuniteFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    
    //Consulter l'historique des actions effectuées sur un prospect ou une opportunité spécifique
    //Charger un catalogue dans le système à partir d'un fichier   
    
    //Creer un utilisateur
    @Override
    public void CreerUtilisateur(String l, String mdp, String nom, String prenom, String mail, String tel, boolean inactif, Date date_creation, Date date_inactivation, Date date_modification) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            List <Profil> listeProfils =u.getLesProfils();
            int i=0;
            while(i<=listeProfils.size())
            {
                if(listeProfils.get(i).getFonction().equals("administrateur")&&!listeProfils.get(i).isInactif())
                {
                    utilisateurFacade.CreerUtilisateur(nom, prenom, l, mdp, mail, tel, inactif, date_creation, date_inactivation, date_modification);
                }
                else
                {
                System.out.println ("Vous n'êtes pas administrateur");
                }
                i++;
            }
        }
    }

    //Modifier un utilisateur
    @Override
    public void ModifierUtilisateur(String l, String mdp, String nom, String prenom, String mail, String tel, Date date_modification) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            List <Profil> listeProfils =u.getLesProfils();
            int i=0;
            while(i<=listeProfils.size())
            {
                if(listeProfils.get(i).getFonction().equals("administrateur")&&!listeProfils.get(i).isInactif())
                {
                    utilisateurFacade.ModifierUtilisateur(u, nom, prenom, mail, tel, date_modification);
                }
                else
                {
                System.out.println ("Vous n'êtes pas administrateur");
                }
                i++;
            }
        }
    }

    //Supprimer/Inactiver un utilisateur
    @Override
    public void InactiverUtilisateur(String l, String mdp, boolean inactif, Date date_inactivation) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            List <Profil> listeProfils =u.getLesProfils();
            int i=0;
            while(i<=listeProfils.size())
            {
                if(listeProfils.get(i).getFonction().equals("administrateur")&&!listeProfils.get(i).isInactif())
                {
                    utilisateurFacade.InactiverUtilisateur(u, inactif, date_inactivation);
                }
                else
                {
                System.out.println ("Vous n'êtes pas administrateur");
                }
                i++;
            }
        }
    }
    
    //Attribuer des rôles aux utilisateurs
    @Override
    public void AttribuerRolesUtilisateur(String l, String mdp, Profil p, Fonction f) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            List <Profil> listeProfils =u.getLesProfils();
            int i=0;
            while(i<=listeProfils.size())
            {
                if(listeProfils.get(i).getFonction().equals("administrateur")&&!listeProfils.get(i).isInactif())
                {
                    utilisateurFacade.RechercherUtilisateur(l);
                    profilFacade.ModifierProfil(p,f);
                }
                else
                {
                System.out.println ("Vous n'êtes pas administrateur");
                }
                i++;
            }
        }
    }
    
    //Gérer les mots de passe des utilisateurs (définir ou réinitialiser)
    @Override
    public void ModifierMdpUtilisateur(String l, String mdp, Date date_modification_utilisateur) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            List <Profil> listeProfils =u.getLesProfils();
            int i=0;
            while(i<=listeProfils.size())
            {
                if(listeProfils.get(i).getFonction().equals("administrateur")&&!listeProfils.get(i).isInactif())
                {
                    utilisateurFacade.ModifierMdpUtilisateur(u, mdp, date_modification_utilisateur);
                }
                else
                {
                System.out.println ("Vous n'êtes pas administrateur");
                }
                i++;
            }
        }
    }
    
    //MAJ la configuration du système à partir des fichiers de propriétés
    //Accéder aux journaux du système pour enquêter sur les rpoblèmes
    //Consulter les journaux d'accès pour savoir qui accèse au système


    
    
}

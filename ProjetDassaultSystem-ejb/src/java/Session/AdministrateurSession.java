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
    public void CreerUtilisateur(String nom_utilisateur, String prenom_utilisateur, String login_utilisateur, String mdp_utilisateur, String mail_utilisateur, String tel_utilisateur) {
        /*Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            List <Profil> listeProfils =u.getLesProfils();
            int i=0;
            while(i<=listeProfils.size())
            {
                if(listeProfils.get(i).getFonction().equals("administrateur")&&!listeProfils.get(i).isInactif())
                {*/
                    utilisateurFacade.CreerUtilisateur(nom_utilisateur, prenom_utilisateur, login_utilisateur, mdp_utilisateur, mail_utilisateur, tel_utilisateur);
       
                /*}
                else
                {
                System.out.println ("Vous n'êtes pas administrateur");
                }
                i++;
            }
        }*/
    }

    //Modifier un utilisateur
    @Override
    public void ModifierUtilisateur(String nom, String prenom, String login, String mail, String tel) {
        Utilisateur u = utilisateurFacade.RechercherUtilisateur(login);
        if(u!=null)
        {
            utilisateurFacade.ModifierUtilisateur(u, nom, prenom, login, mail, tel);
        }
        /*u = utilisateurFacade.Authentification(login,mdp);
        if(u!=null)
        {
            List <Profil> listeProfils =u.getLesProfils();
            int i=0;
            while(i<=listeProfils.size())
            {
                if(listeProfils.get(i).getFonction().equals("administrateur")&&!listeProfils.get(i).isInactif())
                {*/
                    
                /*}
                
                i++;
            }
        }*/
    }

    //Supprimer/Inactiver un utilisateur
    @Override
    public void InactiverUtilisateur(String login_utilisateur, boolean inactif) {
        Utilisateur u = utilisateurFacade.RechercherUtilisateur(login_utilisateur);
        if(u!=null)
        {
            utilisateurFacade.InactiverUtilisateur(u, inactif);
        }
    }
    
    //Créer un nouveau profil
    @Override
    public void CreerProfil(String login_utilisateur, Fonction fonction) {
        Utilisateur u=utilisateurFacade.RechercherUtilisateur(login_utilisateur);

        if(u!=null)
        {
            profilFacade.CreerProfil(fonction, u);

        }
    }
    
    //Attribuer des rôles aux utilisateurs
    @Override
    public void AttribuerRolesUtilisateur(String login_utilisateur, Profil p, Fonction f) {
        /*Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            List <Profil> listeProfils =u.getLesProfils();
            int i=0;
            while(i<=listeProfils.size())
            {
                if(listeProfils.get(i).getFonction().equals("administrateur")&&!listeProfils.get(i).isInactif())
                {*/
        Utilisateur u = utilisateurFacade.RechercherUtilisateur(login_utilisateur);
        if(u!=null)
        {
          profilFacade.ModifierProfil(p,f);  
        }
                /*}
                else
                {
                System.out.println ("Vous n'êtes pas administrateur");
                }
                i++;
            }
        }*/
    }
    
    @Override
    public List<Profil> AfficherLesProfils() {
        return profilFacade.AfficherTousLesProfils();
    }
    
    //Gérer les mots de passe des utilisateurs (définir ou réinitialiser)
    @Override
    public void ModifierMdpUtilisateur(String login_utilisateur, String mdp_utilisateur) {
        Utilisateur u = utilisateurFacade.RechercherUtilisateur(login_utilisateur);
        if(u!=null)
        {
            utilisateurFacade.ModifierMdpUtilisateur(u, mdp_utilisateur);
        }
    }
    
    @Override
    public Utilisateur RechercherUtilisateur(String login) {
        Utilisateur u = utilisateurFacade.RechercherUtilisateur(login);
        return u;
    }
    
    
    //MAJ la configuration du système à partir des fichiers de propriétés
    //Accéder aux journaux du système pour enquêter sur les rpoblèmes
    //Consulter les journaux d'accès pour savoir qui accède au système








    
    
    
    
    
    
}

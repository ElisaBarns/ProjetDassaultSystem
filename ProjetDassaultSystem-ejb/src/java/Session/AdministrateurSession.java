/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package Session;

import Entity.Profil;
import Entity.Utilisateur;
import Facade.Piste_opportuniteFacadeLocal;
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
    private Piste_opportuniteFacadeLocal piste_opportuniteFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    //Creer un utilisateur
    @Override
    public void CreerUtilisateur(String l, String mdp, String nom_utilisateur, String prenom_utilisateur, String login_utilisateur, String mdp_utilisateur, String mail_utilisateur, String tel_utilisateur, boolean inactif, Date date_creation_utilisateur, Date date_inactivation_utilisateur, Date date_modification_utilisateur) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            List <Profil> listeProfils =u.getLesProfils();
            int i=0;
            while(i<=listeProfils.size())
            {
                if(listeProfils.get(i).getFonction().equals(administrateur))
                {
                    utilisateurFacade.CreerUtilisateur(String nom_utilisateur, String prenom_utilisateur, String login_utilisateur, String mdp_utilisateur, String mail_utilisateur, String tel_utilisateur, boolean inactif, Date date_creation_utilisateur, Date date_inactivation_utilisateur, Date date_modification_utilisateur);
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
    public void ModifierUtilisateur() {
    }

    //Supprimer/Inactiver un utilisateur
    @Override
    public void InactiverUtilisateur() {
    }
    
    
}

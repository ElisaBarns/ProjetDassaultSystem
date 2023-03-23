/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Session;

import Entity.Fonction;
import Entity.Profil;
import Entity.Utilisateur;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface AdministrateurSessionLocal {

    void CreerUtilisateur(String l, String mdp, String nom, String prenom, String mail, String tel);

    void ModifierUtilisateur(String nom, String prenom, String login, String mail, String tel);

    void InactiverUtilisateur(String login_utilisateur, boolean inactif);

    void ModifierMdpUtilisateur(String login_utilisateur, String mdp_utilisateur);
    
    void CreerProfil(String login_utilisateur, Fonction fonction);

    void AttribuerRolesUtilisateur(String login_utilisateur, Profil p, Fonction f);

    Utilisateur RechercherUtilisateur(String login);
    
}

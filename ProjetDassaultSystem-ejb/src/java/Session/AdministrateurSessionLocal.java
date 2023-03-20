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

    void CreerUtilisateur(String l, String mdp, String nom, String prenom, String mail, String tel, boolean inactif, Date date_creation, Date date_inactivation, Date date_modification);

    void ModifierUtilisateur(String l, String mdp, String nom, String prenom, String mail, String tel, Date date_modification);

    void InactiverUtilisateur(String l, String mdp, boolean inactif, Date date_inactivation);

    void ModifierMdpUtilisateur(String l, String mdp, Date date_modification_utilisateur);

    void AttribuerRolesUtilisateur(String l, String mdp, Profil p, Fonction f);
    
}

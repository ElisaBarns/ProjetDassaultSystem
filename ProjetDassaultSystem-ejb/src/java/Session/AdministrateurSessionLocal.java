/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Session;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface AdministrateurSessionLocal {

    void CreerUtilisateur(String l, String mdp, String nom_utilisateur, String prenom_utilisateur, String login_utilisateur, String mdp_utilisateur, String mail_utilisateur, String tel_utilisateur, boolean inactif, Date date_creation_utilisateur, Date date_inactivation_utilisateur, Date date_modification_utilisateur);

    void ModifierUtilisateur();

    void InactiverUtilisateur();
    
}

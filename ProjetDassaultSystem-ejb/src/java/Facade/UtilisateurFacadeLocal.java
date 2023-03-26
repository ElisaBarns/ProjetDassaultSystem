/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Facade;

import Entity.Utilisateur;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface UtilisateurFacadeLocal {

    void create(Utilisateur utilisateur);

    void edit(Utilisateur utilisateur);

    void remove(Utilisateur utilisateur);

    Utilisateur find(Object id);

    List<Utilisateur> findAll();

    List<Utilisateur> findRange(int[] range);

    int count();

    Utilisateur Authentification(String login_utilisateur, String mdp_utilisateur);

    void CreerUtilisateur(String nom_utilisateur, String prenom_utilisateur, String login_utilisateur, String mdp_utilisateur, String mail_utilisateur, String tel_utilisateur);

    void ModifierUtilisateur(Utilisateur u, String nom_utilisateur, String prenom_utilisateur, String login_utilisateur, String mail_utilisateur, String tel_utilisateur);
    
    void ModifierMdpUtilisateur(Utilisateur u, String mdp_utilisateur);

    void InactiverUtilisateur(Utilisateur u, boolean inactif);

    Utilisateur RechercherUtilisateur(String login_utilisateur);

    public Utilisateur RechercherUtilisateurParId(long id);
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Session;

import Entity.Client;
import Entity.Contact;
import Entity.Piste_opportunite;
import Entity.Profil;
import Entity.Statut;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface VendeurSessionLocal {

    void AffecterExpert(String l, String mdp, int id_piste_opportunite, Profil m, Piste_opportunite p, Profil expert_technique, Date date_modif_popp);

    void AccepterPiste(String l, String mdp, Piste_opportunite p, Profil vendeur);
    
    void RefuserPiste(String l, String mdp, Piste_opportunite p, Profil vendeur);

    void AfficherListePO(String l, String mdp, Profil v);

    void MajPoParVendeur(String l, String mdp, Piste_opportunite p, Date date_modif_popp, Client c, String nom_client, String siret, boolean inactif, Date date_inactiv_client, Date date_modif_client, Contact co, String nom_contact, String prenom_contact, String mail_contact, String tel_contact, Date date_modif_contact);

    void PisteGagne(String l, String mdp, Piste_opportunite p, Date date_modif_popp, Statut statut);
    
    void PistePerdu(String l, String mdp, Piste_opportunite p, Date date_modif_popp, Statut statut);
    
}

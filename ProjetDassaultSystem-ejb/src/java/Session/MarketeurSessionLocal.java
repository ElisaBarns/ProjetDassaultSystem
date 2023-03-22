/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Session;

import Entity.Contact;
import Entity.Niveau;
import Entity.PisteOpp;
import Entity.Piste_opportunite;
import Entity.Profil;
import Entity.Statut;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface MarketeurSessionLocal {

    void CreerPiste(String l, String mdp, Niveau niveau_interet, int tx_reussite, Niveau niveau_risque, double budget_estime, PisteOpp type, Statut statut);

    void AffecterVendeur(long id, long id_profil);

    void RouvrirPiste(long id);

    void CreerClient(String nom, String siret, String nom_contact, String prenom, String mail, String tel);
    
    void CreerContact(String nom, String prenom, String mail, String tel);

    void ModifierClient(long id_client, String nom, String siret);

    void ModifierContact(long id_contact, String nom, String prenom, String mail, String tel);

    void InactiverContact(long id);

    void InactiverClient(long id);

    List<Contact> RechercherContactsClient(long id);
    
}

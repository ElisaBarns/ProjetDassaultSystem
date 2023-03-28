/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Session;

import Entity.Client;
import Entity.Contact;
import Entity.Niveau;
import Entity.Piste_opportunite;
import Entity.Profil;
import Entity.Statut;
import Entity.Utilisateur;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface VendeurSessionLocal {

    void AffecterExpert(Piste_opportunite piste, Profil expert);

    void AccepterPiste(Piste_opportunite p);
    
    void RefuserPiste(Piste_opportunite p);

    //void AfficherListePO(String l, String mdp, Profil v);

    

    void PisteGagne(long id);
    
    void PistePerdu(long id);
    
    void ModifierPiste(long id_piste, Niveau niveau_interet, int tx_reussite, Niveau niveau_risque, double budget_estime, long idclient);
    
    void ModifierClient(long id, String nom, String siret);
    
    void ModifierContact(long id_contact, String nom, String prenom, String mail, String tel);
    
    List<Piste_opportunite> AfficherPistes();
    
    Piste_opportunite RechercherPisteParId(long id_piste);
    
    Profil RechercherUnProfilExpertParId(Utilisateur utilisateur);
    
    List<Profil> ListeExpertActif();
    
    public List<Piste_opportunite> ListePistes();
}

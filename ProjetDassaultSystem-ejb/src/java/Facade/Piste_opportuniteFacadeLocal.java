/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Facade;

import Entity.Client;
import Entity.Contact;
import Entity.Enregistrement;
import Entity.Niveau;
import Entity.Offre;
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
public interface Piste_opportuniteFacadeLocal {

    void create(Piste_opportunite piste_opportunite);

    void edit(Piste_opportunite piste_opportunite);

    void remove(Piste_opportunite piste_opportunite);

    Piste_opportunite find(Object id);

    List<Piste_opportunite> findAll();

    List<Piste_opportunite> findRange(int[] range);

    int count();

    void creerPisteOpportunite(int id_piste_opp, Date date_creation_popp, Date date_modif_popp, Niveau niveau_interet, int tx_reussite, Niveau niveau_risque, double budget_estime, PisteOpp type, Statut statut, Profil marketeur, Profil vendeur, Profil expert_technique);

    void ModifierPisteOpportunite(Piste_opportunite p, Date date_modif_popp, Niveau niveau_interet, int tx_reussite, Niveau niveau_risque, double budget_estime, PisteOpp type, Statut statut, Profil marketeur, Profil vendeur, Profil expert_technique, Enregistrement enregistrement, Client leClient);

    void AffecterVendeur(Piste_opportunite p, Profil vendeur, Date date_modif_popp);
    
    void AccepterParVendeur(Piste_opportunite p, Profil vendeur);
    
    void RefuserParVendeur(Piste_opportunite p, Profil vendeur);
    
    void MajPoParVendeur(Piste_opportunite p, Date date_modif_popp, Client c, String nom_client, String siret, Date date_modif_client, Contact co, String nom_contact, String prenom_contact, String mail_contact, String tel_contact, Date date_modif_contact);
    
    void PisteGagne(Piste_opportunite p, Date date_modif_popp, Statut statut);
    
    void PistePerdu(Piste_opportunite p, Date date_modif_popp, Statut statut);
    
    void RouvrirPiste(Piste_opportunite p, Date date_modif_popp);
    
    void AffecterExpert(Piste_opportunite p, Profil expert_technique, Date date_modif_popp);
    
    void MajOffreParExpert(Piste_opportunite p, Date date_modif_popp, Offre offre);
    
    Piste_opportunite RechercherPisteOpportuniteParId(long id_piste_opportunite);

    Piste_opportunite RechercherPisteOpportuniteParType(PisteOpp type);
    
    Piste_opportunite RechercherPisteOpportuniteParStatut(Statut statut);
    
    Piste_opportunite RechercherPisteOpportuniteParMarketeur(Profil marketeur);
    
    Piste_opportunite RechercherPisteOpportuniteParVendeur(Profil vendeur);
    
    Piste_opportunite RechercherPisteOpportuniteParExpert(Profil expert_technique);
    
    Piste_opportunite RechercherPisteOpportuniteParClient(Client leClient);

    

    
}

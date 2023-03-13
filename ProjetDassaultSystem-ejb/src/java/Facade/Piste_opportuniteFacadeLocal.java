/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Facade;

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
public interface Piste_opportuniteFacadeLocal {

    void create(Piste_opportunite piste_opportunite);

    void edit(Piste_opportunite piste_opportunite);

    void remove(Piste_opportunite piste_opportunite);

    Piste_opportunite find(Object id);

    List<Piste_opportunite> findAll();

    List<Piste_opportunite> findRange(int[] range);

    int count();

    void creerPisteOpportunite(int id_piste_opp, Date date_creation_popp, Date date_modif_popp, Niveau niveau_interet, int tx_reussite, Niveau niveau_risque, double budget_estime, PisteOpp type, Statut statut, Profil marketeur, Profil vendeur, Profil expert_technique);
    
}

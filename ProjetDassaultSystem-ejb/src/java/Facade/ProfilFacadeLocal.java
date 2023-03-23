/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Facade;

import Entity.Fonction;
import Entity.Profil;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface ProfilFacadeLocal {

    void create(Profil profil);

    void edit(Profil profil);

    void remove(Profil profil);

    Profil find(Object id);

    List<Profil> findAll();

    List<Profil> findRange(int[] range);

    int count();

    void CreerProfil(Fonction f);

    void ModifierProfil(Profil p, Fonction f);

    void InactiverProfil(Profil p);

    Profil RechercherProfilparID(long id);

    List<Profil> ListeVendeursActifs();

    List<Profil> ListeExpertActif();
    
}

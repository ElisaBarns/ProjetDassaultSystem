/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Facade;

import Entity.Enregistrement;
import Entity.Piste_opportunite;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface EnregistrementFacadeLocal {

    void create(Enregistrement enregistrement);

    void edit(Enregistrement enregistrement);

    void remove(Enregistrement enregistrement);

    Enregistrement find(Object id);

    List<Enregistrement> findAll();

    List<Enregistrement> findRange(int[] range);

    int count();

    Enregistrement CreerEnregistrement(Piste_opportunite p);
    
    void ModifierEnregistrement(long id, Piste_opportunite p);
    
    Enregistrement RechercherEnregistrement(long id);
}

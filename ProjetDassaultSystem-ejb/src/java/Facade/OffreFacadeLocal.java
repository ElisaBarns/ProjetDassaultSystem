/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Facade;

import Entity.Offre;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface OffreFacadeLocal {

    void create(Offre offre);

    void edit(Offre offre);

    void remove(Offre offre);

    Offre find(Object id);

    List<Offre> findAll();

    List<Offre> findRange(int[] range);

    int count();

    void CreerOffre(int remise, Date date_creation_offre, float p_somme, float p_total);

    void ModifierOffre(Offre o, int remise, Date date_modif_offre, float p_somme, float p_total);
    
}

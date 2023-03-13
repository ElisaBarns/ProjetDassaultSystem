/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Facade;

import Entity.Detail_offre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface Detail_offreFacadeLocal {

    void create(Detail_offre detail_offre);

    void edit(Detail_offre detail_offre);

    void remove(Detail_offre detail_offre);

    Detail_offre find(Object id);

    List<Detail_offre> findAll();

    List<Detail_offre> findRange(int[] range);

    int count();
    
}

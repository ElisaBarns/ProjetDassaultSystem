/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Facade;

import Entity.Detail_offre;
import Entity.Offre;
import Entity.Produit;
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

    void CreerDetailOffre(int quantite, Produit leProduit, Offre uneOffre);

    void ModifierDetailOffre(Detail_offre d, int quantite, Produit leProduit, Offre uneOffre);

    void SupprimerDetailOffre(Detail_offre d);
    
    Detail_offre RechercherDetail_offreParId(long id);
    
    List<Detail_offre> AfficherTousLesDetails_offres();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Facade;

import Entity.Produit;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface ProduitFacadeLocal {

    void create(Produit produit);

    void edit(Produit produit);

    void remove(Produit produit);

    Produit find(Object id);

    List<Produit> findAll();

    List<Produit> findRange(int[] range);

    int count();

    void CreerProduit(String nom_produit, String description_commerciale, float pu_produit, Date date_creation_produit, boolean inactif);

    void ModifierProduit(Produit p, String nom_produit, String description_commerciale, float pu_produit, Date date_modif_produit);

    void InactiverProduit(Produit p, Date date_inactivation_produit, boolean inactif);
    
    Produit RechercherProduitParNom(String nom_produit);
    
}

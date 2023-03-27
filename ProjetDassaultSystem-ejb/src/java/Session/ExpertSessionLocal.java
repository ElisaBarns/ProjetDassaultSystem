/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Session;

import Entity.Offre;
import Entity.Piste_opportunite;
import Entity.Produit;
import Entity.Profil;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface ExpertSessionLocal {

    void MajOffreParExpert(String l, String mdp, Piste_opportunite p, Date date_modif_popp, Offre offre);
    
    void CréerOffre(int remise, String conditions);
    
    void ModifierOffre(int id_offre, int remise, String conditions);

    void CreerDetail_offre(String nom_produit, long id_offre, int quantite);

    void ModifierDetail_offre(long id_detail, String nom_produit, long id_offre, int quantite);

    void SupprimerDetailOffre(long id_detail);

    List<Piste_opportunite> AfficherPistesExpert();

    Produit RechercherProduitParNom(String nom_produit);
}

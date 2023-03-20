/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package Session;

import Entity.Offre;
import Entity.Piste_opportunite;
import Entity.Profil;
import Entity.Utilisateur;
import Facade.Piste_opportuniteFacadeLocal;
import Facade.UtilisateurFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Mel
 */
@Stateful
public class ExpertSession implements ExpertSessionLocal {

    @EJB
    private Piste_opportuniteFacadeLocal piste_opportuniteFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    
    //Consulter l'historique des actions effectuées sur un prospect ou une opportunité spécifique
    
    
    //Afficher tous les leads et opportunités qui me sont attribués
    
    
    //MAJ une piste sur laquelle je suis assignée pour ajouter ou modifier l'offre
    @Override
    public void MajOffreParExpert(String l, String mdp, Piste_opportunite p, Date date_modif_popp, Offre offre) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            // A REVOIR !!! p=piste_opportuniteFacade.RechercherPisteOpportuniteParId(p.getId_piste_opp());
            
            piste_opportuniteFacade.MajOffreParExpert(p, date_modif_popp, offre);
        }
        else
        {
            System.out.println("Vous avez saisi un mauvais login et/ou mot de passe. Veuillez réessayer.");
        }
    }
    
    //Rechercher ou parcourir le catalogue et choisir des éléments afin de remplir l'offre
    
    
    //Joindre un document de proposition à une piste et à une opportunité qui m'ont été attribuées
    
    
    
}

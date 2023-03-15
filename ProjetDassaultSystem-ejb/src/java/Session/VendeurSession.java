/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package Session;

import Entity.Piste_opportunite;
import Entity.Profil;
import Entity.Utilisateur;
import Facade.Piste_opportuniteFacadeLocal;
import Facade.UtilisateurFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Mel
 */
@Stateful
public class VendeurSession implements VendeurSessionLocal {

    @EJB
    private Piste_opportuniteFacadeLocal piste_opportuniteFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //Accepter une piste qui m'a été attribuée
    //Refuser une piste qui m'a été affectée
    
    
    
    //Assigner un expert technique
    @Override
    public void AffecterExpert(String l, String mdp, int id_piste_opportunite, Profil m, Piste_opportunite p, Profil expert_technique) {
        Utilisateur u=null;
        u=utilisateurFacade.Authentification(l, mdp);
        if(u!=null)
        {
            List<Profil> listeProfils=u.getLesProfils();
            Piste_opportunite po=piste_opportuniteFacade.RechercherPisteOpportuniteParId(id_piste_opportunite);
            m=po.getMarketeur();
            if(listeProfils.contains(m))
            {
                piste_opportuniteFacade.AffecterExpert(p,expert_technique);
            }
            else
            {
                System.out.println("Vous n'avez pas les droits d'accès nécessaires pour affecter un expert technique à cette piste. Veuillez vous rapprocher de votre administrateur.");
            }
        }
        
    }
    
    //Afficher toutes les pistes et opportunités qui me sont attribuées
    //MAJ de la piste/opportunité qui m'a été attribué pour ajouter ou modifier des informations sur le client, le contact, le prospect, l'opportunité et l'offre
    //Soumettre une prposition pour une piste qui m'a été assignée, le document doit être envoyé au contact par mail (Soumis)
    //Suivre la réponse du client sur un prospect ou une opportunité qui m'a été attribué (Gagné ou Perdu)
    
    
}

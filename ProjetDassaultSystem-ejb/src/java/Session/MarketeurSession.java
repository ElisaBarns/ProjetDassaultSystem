/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package Session;

import Entity.Niveau;
import Entity.PisteOpp;
import Entity.Piste_opportunite;
import Entity.Profil;
import Entity.Statut;
import Entity.Utilisateur;
import Facade.Piste_opportuniteFacadeLocal;
import Facade.UtilisateurFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Mel
 */
@Stateful
public class MarketeurSession implements MarketeurSessionLocal {

    @EJB
    private Piste_opportuniteFacadeLocal piste_opportuniteFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    //Créer une piste ou opportunité
    @Override
    public void CreerPiste(String l, String mdp, int id_piste_opp, Date date_creation_popp, Date date_modif_popp, Niveau niveau_interet, int tx_reussite, Niveau niveau_risque, double budget_estime, PisteOpp type, Statut statut, Profil marketeur, Profil vendeur, Profil expert_technique) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            piste_opportuniteFacade.creerPisteOpportunite(0, date_creation_popp, date_modif_popp, Niveau.HAUT, 0, Niveau.MEDIUM, 0, PisteOpp.PISTE, Statut.GAGNE, marketeur, vendeur, expert_technique);
        }
        else
        {
            System.out.println("Vous n'avez pas les droits d'accès nécessaires pour pouvoir créer une piste. Veuillez vous rapprocher de votre administrateur.");
        }
    }
    
    //Affecter un vendeur (+ vérifier si je suis assigné à cette piste, sinon jpp affecter un vendeur)
    @Override
    public void AffecterVendeur(String l, String mdp, int id_piste_opportunite, Profil m, Piste_opportunite p, Profil vendeur, Date date_modif_popp) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            List <Profil> listeProfils =u.getLesProfils();
            Piste_opportunite po=piste_opportuniteFacade.RechercherPisteOpportuniteParId(id_piste_opportunite);
            m=po.getMarketeur();
            if(listeProfils.contains(m))
            {
                piste_opportuniteFacade.AffecterVendeur(p, vendeur, date_modif_popp);
            }
            else
            {
                System.out.println("Vous n'avez pas les droits d'accès nécessaires pour affecter un vendeur à une piste. Veuillez vous rapprocher de votre administrateur.");
            }
        }
    }
    
    //Consulter l'historique des actions effectuées sur un prospect ou une opportunité spécifique

    //Rouvrir la piste (car le vendeur a refusé son affectation à la piste)

    @Override
    public void RouvrirPiste(String l, String mdp, Piste_opportunite p, Date date_modif_popp) {
        Utilisateur u = null;
        u = utilisateurFacade.Authentification(l,mdp);
        if(u!=null)
        {
            piste_opportuniteFacade.RouvrirPiste(p, date_modif_popp);
        }
        else
        {
            System.out.println("Vous avez saisi un mauvais login et/ou mot de passe. Veuillez réessayer.");
        }
    }
    
}

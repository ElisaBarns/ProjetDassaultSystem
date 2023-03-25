/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package Session;

import Entity.Utilisateur;
import Facade.UtilisateurFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author marie
 */
@Stateful
public class UtilisateurSession implements UtilisateurSessionLocal {
    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;
    private Utilisateur connectedUser;

    @Override
    public Utilisateur authentification(String login, String mdp) {
        connectedUser = utilisateurFacade.Authentification(login, mdp);
        return connectedUser;
    }

    public Utilisateur getConnectedUser() {
        return connectedUser;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    
}

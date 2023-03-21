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

    @Override
    public Utilisateur authentification(String login, String mdp) {
        //long id;
        Utilisateur u;
        u=utilisateurFacade.Authentification(login, mdp);
        //id=u.getId();
        return u;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Session;

import javax.ejb.Local;

/**
 *
 * @author marie
 */
@Local
public interface UtilisateurSessionLocal {

    int authentification(String login, String mdp);
    
}

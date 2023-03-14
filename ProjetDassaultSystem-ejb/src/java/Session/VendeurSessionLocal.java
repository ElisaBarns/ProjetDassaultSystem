/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Session;

import Entity.Piste_opportunite;
import Entity.Profil;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface VendeurSessionLocal {

    void AffecterExpert(String l, String mdp, int id_piste_opportunite, Profil m, Piste_opportunite p, Profil expert_technique);
    
}

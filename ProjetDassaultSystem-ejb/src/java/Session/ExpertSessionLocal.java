/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Session;

import Entity.Offre;
import Entity.Piste_opportunite;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface ExpertSessionLocal {

    void MajOffreParExpert(String l, String mdp, Piste_opportunite p, Date date_modif_popp, Offre offre);
    
}

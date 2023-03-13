/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Enregistrement;
import Entity.Piste_opportunite;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mel
 */
@Stateless
public class EnregistrementFacade extends AbstractFacade<Enregistrement> implements EnregistrementFacadeLocal {

    @PersistenceContext(unitName = "ProjetDassaultSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnregistrementFacade() {
        super(Enregistrement.class);
    }
    
    
    //Créer enregistrement
/*
    public void CreerEnregistrement(Piste_opportunite p) {
    List<Piste_opportunite> liste_modifications = new List();
    liste_modifications=liste_modifications.add(p);
    //Pensez à l'intégrer dans la méthode Creer Piste_opportunite !!!
    }
*/
    
    //Modifier enregistrement
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Client;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mel
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    @PersistenceContext(unitName = "ProjetDassaultSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
    
    //Créer client
    @Override
    public void creerClient(String nom_client, String siret) 
    {
        Client c = new Client();
        c.setNom_client(nom_client);
        c.setSiret(siret);
        c.setInactif(false);
        c.setDate_creation_client(new Date());
        c.setDate_modif_client(null);
        c.setDate_inactiv_client(null);
        getEntityManager().persist(c);
    }
    
       
    //Modifier client
    @Override
    public void modifierClient(Client c, String nom_client, String siret, Date date_modif_client) {
        c.setNom_client(nom_client);
        c.setSiret(siret);
        date_modif_client=new Date();
        getEntityManager().merge(c);
    }
    
    //Inactiver  client

    @Override
    public void inactiverClient(Client c, boolean inactif, Date date_inactiv_client) {
        c.setInactif(true);
        date_inactiv_client=new Date();
        getEntityManager().merge(c);
    }

    //Rechercher client 

    @Override
    public Client rechercherClient(String nom_client) {
    Client c=null;
    List<Client>result;
    String txt="SELECT c FROM Client AS c WHERE c.nom_client=:nom_client";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("nom_client", nom_client);
    result=req.getResultList();
    if(result.size()==1){
        c=(Client)result.get(0);
    }
    return c; 
               
    }
    
    
}

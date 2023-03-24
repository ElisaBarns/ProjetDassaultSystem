/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Client;
import Entity.Contact;
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
public class ContactFacade extends AbstractFacade<Contact> implements ContactFacadeLocal {

    @PersistenceContext(unitName = "ProjetDassaultSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactFacade() {
        super(Contact.class);
    }
 
    //Créer contact
    
    @Override
    public void creerContact(String nom_contact, String prenom_contact, String mail_contact, String tel_contact, Client leClient) {
    Contact co= new Contact();
  
    co.setNom_contact(nom_contact);
    co.setPrenom_contact(prenom_contact);
    co.setMail_contact(mail_contact);
    co.setTel_contact(tel_contact);
    co.setLeClient(leClient);
    co.setInactif(false);
    co.setDate_creation_contact(new Date());
    co.setDate_modif_contact(null);
    co.setDate_inactiv_contact(null);
    getEntityManager().persist(co);    
    }
    
    
    //Modifier contact
    @Override
    public void modifierContact(Contact co, String nom_contact, String prenom_contact, String mail_contact, String tel_contact) 
    {
        co.setNom_contact(nom_contact);
        co.setPrenom_contact(prenom_contact);
        co.setMail_contact(mail_contact);
        co.setTel_contact(tel_contact);
        co.setDate_modif_contact(new Date());
        getEntityManager().merge(co);
    }
    
    
    //Inactiver contact

    @Override
    public void inactiverContact(Contact co, boolean inactif) {
        co.setInactif(true);
        co.setDate_inactiv_contact(new Date());
        getEntityManager().merge(co);
    }

    @Override
    public Contact rechercherContact(long id) {
        Contact co=null;
        List<Contact> result;
        String txt=" SELECT co FROM Contact AS co WHERE co.id=:id";
        Query req=getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=req.getResultList();
        if(result.size()==1){
            co=(Contact)result.get(0);
        }
        return co;
    }

    @Override
    public List<Contact> RechercherContactsClient(Client leClient) {
        List<Contact> result;
        String txt=" SELECT co FROM Contact AS co WHERE co.leClient=:leClient";
        Query req=getEntityManager().createQuery(txt);
        req=req.setParameter("leClient", leClient);
        result=req.getResultList();
        return result;
    }

    

    
}

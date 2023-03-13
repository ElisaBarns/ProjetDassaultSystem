/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

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
    public void creerContact(int id_contact, String nom_contact, String prenom_contact, String mail_contact, String tel_contact, boolean inactif, Date date_creation_contact, Date date_modif_contact, Date date_inactiv_contact) {
    Contact co= new Contact();
    co.setId_contact(id_contact);
    co.setNom_contact(nom_contact);
    co.setPrenom_contact(prenom_contact);
    co.setMail_contact(mail_contact);
    co.setTel_contact(tel_contact);
    co.setInactif(inactif);
    co.setDate_creation_contact(date_creation_contact);
    co.setDate_modif_contact(date_modif_contact);
    co.setDate_inactiv_contact(date_inactiv_contact);
    getEntityManager().persist(co);    
    }
    
    
    //Modifier contact
    @Override
    public void modifierContact(Contact co, String nom_contact, String prenom_contact, String mail_contact, String tel_contact, Date date_modif_contact) 
    {
        co.setNom_contact(nom_contact);
        co.setPrenom_contact(prenom_contact);
        co.setMail_contact(mail_contact);
        co.setTel_contact(tel_contact);
        co.setDate_modif_contact(date_modif_contact);
        getEntityManager().merge(co);
    }
    
    
    //Inactiver contact

    @Override
    public void inactiverContact(Contact co, boolean inactif, Date date_inactiv_contact) {
        co.setInactif(inactif);
        co.setDate_inactiv_contact(date_inactiv_contact);
        getEntityManager().merge(co);
    }

    @Override
    public Contact rechercherContact(int id_contact) {
        Contact co=null;
        List<Contact> result;
        String txt=" SELECT co FROM Contact AS co WHERE co.id_contact=:id_contact";
        Query req=getEntityManager().createQuery(txt);
        req=req.setParameter("id_contact", id_contact);
        result=req.getResultList();
        if(result.size()==1){
            co=(Contact)result.get(0);
        }
        return co;
    }

    

    
}

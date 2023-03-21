/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Facade;

import Entity.Contact;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface ContactFacadeLocal {

    void create(Contact contact);

    void edit(Contact contact);

    void remove(Contact contact);

    Contact find(Object id);

    List<Contact> findAll();

    List<Contact> findRange(int[] range);

    int count();

    void creerContact(String nom_contact, String prenom_contact, String mail_contact, String tel_contact);

    void modifierContact(Contact co, String nom_contact, String prenom_contact, String mail_contact, String tel_contact, Date date_modif_contact);

    void inactiverContact(Contact co, boolean inactif, Date date_inactiv_contact);

    Contact rechercherContact(int id_contact);
    
}

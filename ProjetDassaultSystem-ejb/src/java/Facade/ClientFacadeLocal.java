/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Facade;

import Entity.Client;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mel
 */
@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);

    List<Client> findAll();

    List<Client> findRange(int[] range);

    int count();

    void creerClient(int id_client, String nom_client, String siret, boolean inactif, Date date_creation_client, Date date_modification_client, Date date_inactiv_client);

    void modifierClient(Client c, String nom_client, String siret, Date date_modif_client);

    void inactiverClient(Client c, boolean inactif, Date date_inactiv_client);

    Client rechercherClient(String nom_client);

    
}

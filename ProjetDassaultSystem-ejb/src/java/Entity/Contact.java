/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Elisa
 */
@Entity
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Contact[ id=" + id + " ]";
    }
    
   
     @Column (nullable=false, unique = false)
    private String nom_contact;

    /**
     * Get the value of nom_contact
     *
     * @return the value of nom_contact
     */
    public String getNom_contact() {
        return nom_contact;
    }

    /**
     * Set the value of nom_contact
     *
     * @param nom_contact new value of nom_contact
     */
    public void setNom_contact(String nom_contact) {
        this.nom_contact = nom_contact;
    }

     @Column (nullable=false, unique = false)
    private String prenom_contact;

    /**
     * Get the value of prenom_contact
     *
     * @return the value of prenom_contact
     */
    public String getPrenom_contact() {
        return prenom_contact;
    }

    /**
     * Set the value of prenom_contact
     *
     * @param prenom_contact new value of prenom_contact
     */
    public void setPrenom_contact(String prenom_contact) {
        this.prenom_contact = prenom_contact;
    }

     @Column (nullable=false, unique = false)
    private String mail_contact;

    /**
     * Get the value of mail_contact
     *
     * @return the value of mail_contact
     */
    public String getMail_contact() {
        return mail_contact;
    }

    /**
     * Set the value of mail_contact
     *
     * @param mail_contact new value of mail_contact
     */
    public void setMail_contact(String mail_contact) {
        this.mail_contact = mail_contact;
    }

     @Column (nullable=false, unique = false)
    private String tel_contact;

    /**
     * Get the value of tel_contact
     *
     * @return the value of tel_contact
     */
    public String getTel_contact() {
        return tel_contact;
    }

    /**
     * Set the value of tel_contact
     *
     * @param tel_contact new value of tel_contact
     */
    public void setTel_contact(String tel_contact) {
        this.tel_contact = tel_contact;
    }

     @Column (nullable=true)
    private boolean inactif;

    /**
     * Get the value of inactif
     *
     * @return the value of inactif
     */
    public boolean isInactif() {
        return inactif;
    }

    /**
     * Set the value of inactif
     *
     * @param inactif new value of inactif
     */
    public void setInactif(boolean inactif) {
        this.inactif = inactif;
    }

     @Column (nullable=false, unique = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_creation_contact;

    /**
     * Get the value of date_creation_contact
     *
     * @return the value of date_creation_contact
     */
    public Date getDate_creation_contact() {
        return date_creation_contact;
    }

    /**
     * Set the value of date_creation_contact
     *
     * @param date_creation_contact new value of date_creation_contact
     */
    public void setDate_creation_contact(Date date_creation_contact) {
        this.date_creation_contact = date_creation_contact;
    }

     @Column (nullable=true, unique = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_modif_contact;

    /**
     * Get the value of date_modif_contact
     *
     * @return the value of date_modif_contact
     */
    public Date getDate_modif_contact() {
        return date_modif_contact;
    }

    /**
     * Set the value of date_modif_contact
     *
     * @param date_modif_contact new value of date_modif_contact
     */
    public void setDate_modif_contact(Date date_modif_contact) {
        this.date_modif_contact = date_modif_contact;
    }

     @Column (nullable=true, unique = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_inactiv_contact;

    /**
     * Get the value of date_inactiv_contact
     *
     * @return the value of date_inactiv_contact
     */
    public Date getDate_inactiv_contact() {
        return date_inactiv_contact;
    }

    /**
     * Set the value of date_inactiv_contact
     *
     * @param date_inactiv_contact new value of date_inactiv_contact
     */
    public void setDate_inactiv_contact(Date date_inactiv_contact) {
        this.date_inactiv_contact = date_inactiv_contact;
    }

    @ManyToOne
    private Client leClient;

    /**
     * Get the value of leClient
     *
     * @return the value of leClient
     */
    public Client getLeClient() {
        return leClient;
    }

    /**
     * Set the value of leClient
     *
     * @param leClient new value of leClient
     */
    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }

}

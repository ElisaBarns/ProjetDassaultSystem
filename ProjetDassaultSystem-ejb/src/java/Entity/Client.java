/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author Elisa
 */
@Entity
public class Client implements Serializable {

    @OneToMany(mappedBy = "leClient")
    private List<Contact> lesContacts;

    @OneToMany(mappedBy = "leClient")
    private List<Piste_opportunite> lesPiste_opportunites;

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence_generator")
    @SequenceGenerator(name = "my_sequence_generator", sequenceName = "my_sequence", initialValue = 1000, allocationSize = 1)
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Client[ id=" + id + " ]";
    }
    

    
 @Column (nullable=false, unique = false)
    private String nom_client;

    /**
     * Get the value of nom_client
     *
     * @return the value of nom_client
     */
    public String getNom_client() {
        return nom_client;
    }

    /**
     * Set the value of nom_client
     *
     * @param nom_client new value of nom_client
     */
    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

     @Column (nullable=false, unique = true)
    private String siret;

    /**
     * Get the value of siret
     *
     * @return the value of siret
     */
    public String getSiret() {
        return siret;
    }

    /**
     * Set the value of siret
     *
     * @param siret new value of siret
     */
    public void setSiret(String siret) {
        this.siret = siret;
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
    private Date date_creation_client;

    /**
     * Get the value of date_creation_client
     *
     * @return the value of date_creation_client
     */
    public Date getDate_creation_client() {
        return date_creation_client;
    }

    /**
     * Set the value of date_creation_client
     *
     * @param date_creation_client new value of date_creation_client
     */
    public void setDate_creation_client(Date date_creation_client) {
        this.date_creation_client = date_creation_client;
    }

     @Column (nullable=true, unique = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_modif_client;

    /**
     * Get the value of date_modif_client
     *
     * @return the value of date_modif_client
     */
    public Date getDate_modif_client() {
        return date_modif_client;
    }

    /**
     * Set the value of date_modif_client
     *
     * @param date_modif_client new value of date_modif_client
     */
    public void setDate_modif_client(Date date_modif_client) {
        this.date_modif_client = date_modif_client;
    }

     @Column (nullable=true, unique = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_inactiv_client;

    /**
     * Get the value of date_inactiv_client
     *
     * @return the value of date_inactiv_client
     */
    public Date getDate_inactiv_client() {
        return date_inactiv_client;
    }

    /**
     * Set the value of date_inactiv_client
     *
     * @param date_inactiv_client new value of date_inactiv_client
     */
    public void setDate_inactiv_client(Date date_inactiv_client) {
        this.date_inactiv_client = date_inactiv_client;
    }

    public List<Contact> getLesContacts() {
        return lesContacts;
    }

    public void setLesContacts(List<Contact> lesContacts) {
        this.lesContacts = lesContacts;
    }

    public List<Piste_opportunite> getLesPiste_opportunites() {
        return lesPiste_opportunites;
    }

    public void setLesPiste_opportunites(List<Piste_opportunite> lesPiste_opportunites) {
        this.lesPiste_opportunites = lesPiste_opportunites;
    }

    
}

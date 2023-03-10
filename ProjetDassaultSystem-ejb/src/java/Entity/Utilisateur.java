/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Elisa
 */
@Entity
public class Utilisateur implements Serializable {

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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Utilisateur[ id=" + id + " ]";
    }
   
    private int id_utilisateur;

    /**
     * Get the value of id_utilisateur
     *
     * @return the value of id_utilisateur
     */
    public int getId_utilisateur() {
        return id_utilisateur;
    }

    /**
     * Set the value of id_utilisateur
     *
     * @param id_utilisateur new value of id_utilisateur
     */
    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    private String nom_utilisateur;

    /**
     * Get the value of nom_utilisateur
     *
     * @return the value of nom_utilisateur
     */
    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    /**
     * Set the value of nom_utilisateur
     *
     * @param nom_utilisateur new value of nom_utilisateur
     */
    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    private String prenom_utilisateur;

    /**
     * Get the value of prenom_utilisateur
     *
     * @return the value of prenom_utilisateur
     */
    public String getPrenom_utilisateur() {
        return prenom_utilisateur;
    }

    /**
     * Set the value of prenom_utilisateur
     *
     * @param prenom_utilisateur new value of prenom_utilisateur
     */
    public void setPrenom_utilisateur(String prenom_utilisateur) {
        this.prenom_utilisateur = prenom_utilisateur;
    }

    private String login_utilisateur;

    /**
     * Get the value of login_utilisateur
     *
     * @return the value of login_utilisateur
     */
    public String getLogin_utilisateur() {
        return login_utilisateur;
    }

    /**
     * Set the value of login_utilisateur
     *
     * @param login_utilisateur new value of login_utilisateur
     */
    public void setLogin_utilisateur(String login_utilisateur) {
        this.login_utilisateur = login_utilisateur;
    }

    private String mdp_utilisateur;

    /**
     * Get the value of mdp_utilisateur
     *
     * @return the value of mdp_utilisateur
     */
    public String getMdp_utilisateur() {
        return mdp_utilisateur;
    }

    /**
     * Set the value of mdp_utilisateur
     *
     * @param mdp_utilisateur new value of mdp_utilisateur
     */
    public void setMdp_utilisateur(String mdp_utilisateur) {
        this.mdp_utilisateur = mdp_utilisateur;
    }

    private String mail_utilisateur;

    /**
     * Get the value of mail_utilisateur
     *
     * @return the value of mail_utilisateur
     */
    public String getMail_utilisateur() {
        return mail_utilisateur;
    }

    /**
     * Set the value of mail_utilisateur
     *
     * @param mail_utilisateur new value of mail_utilisateur
     */
    public void setMail_utilisateur(String mail_utilisateur) {
        this.mail_utilisateur = mail_utilisateur;
    }

    private String tel_utilisateur;

    /**
     * Get the value of tel_utilisateur
     *
     * @return the value of tel_utilisateur
     */
    public String getTel_utilisateur() {
        return tel_utilisateur;
    }

    /**
     * Set the value of tel_utilisateur
     *
     * @param tel_utilisateur new value of tel_utilisateur
     */
    public void setTel_utilisateur(String tel_utilisateur) {
        this.tel_utilisateur = tel_utilisateur;
    }

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

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_creation_utilisateur;

    /**
     * Get the value of date_creation_utilisateur
     *
     * @return the value of date_creation_utilisateur
     */
    public Date getDate_creation_utilisateur() {
        return date_creation_utilisateur;
    }

    /**
     * Set the value of date_creation_utilisateur
     *
     * @param date_creation_utilisateur new value of date_creation_utilisateur
     */
    public void setDate_creation_utilisateur(java.util.Date date_creation_utilisateur) {
        this.date_creation_utilisateur = date_creation_utilisateur;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_inactivation_utilisateur;

    /**
     * Get the value of date_inactivation_utilisateur
     *
     * @return the value of date_inactivation_utilisateur
     */
    public Date getDate_inactivation_utilisateur() {
        return date_inactivation_utilisateur;
    }

    /**
     * Set the value of date_inactivation_utilisateur
     *
     * @param date_inactivation_utilisateur new value of
     * date_inactivation_utilisateur
     */
    public void setDate_inactivation_utilisateur(Date date_inactivation_utilisateur) {
        this.date_inactivation_utilisateur = date_inactivation_utilisateur;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_modification_utilisateur;

    /**
     * Get the value of date_modification_utilisateur
     *
     * @return the value of date_modification_utilisateur
     */
    public Date getDate_modification_utilisateur() {
        return date_modification_utilisateur;
    }

    /**
     * Set the value of date_modification_utilisateur
     *
     * @param date_modification_utilisateur new value of
     * date_modification_utilisateur
     */
    public void setDate_modification_utilisateur(Date date_modification_utilisateur) {
        this.date_modification_utilisateur = date_modification_utilisateur;
    }
 
}

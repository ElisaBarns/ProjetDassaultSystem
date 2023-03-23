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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Elisa
 */
@Entity
public class Profil implements Serializable {


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
        if (!(object instanceof Profil)) {
            return false;
        }
        Profil other = (Profil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Profil[ id=" + id + " ]";
    }
    
    @Column(nullable=false, unique=true)
    private int id_profil;

    /**
     * Get the value of id_profil
     *
     * @return the value of id_profil
     */
    public int getId_profil() {
        return id_profil;
    }

    /**
     * Set the value of id_profil
     *
     * @param id_profil new value of id_profil
     */
    public void setId_profil(int id_profil) {
        this.id_profil = id_profil;
    }

    private Fonction fonction;

    /**
     * Get the value of fonction
     *
     * @return the value of fonction
     */
    public Fonction getFonction() {
        return fonction;
    }

    /**
     * Set the value of fonction
     *
     * @param fonction new value of fonction
     */
    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
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

    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_creation_profil;

    /**
     * Get the value of date_creation_profil
     *
     * @return the value of date_creation_profil
     */
    public Date getDate_creation_profil() {
        return date_creation_profil;
    }

    /**
     * Set the value of date_creation_profil
     *
     * @param date_creation_profil new value of date_creation_profil
     */
    public void setDate_creation_profil(Date date_creation_profil) {
        this.date_creation_profil = date_creation_profil;
    }

    @Column(nullable=true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_inactif_profil;

    /**
     * Get the value of date_inactif_profil
     *
     * @return the value of date_inactif_profil
     */
    public Date getDate_inactif_profil() {
        return date_inactif_profil;
    }

    /**
     * Set the value of date_inactif_profil
     *
     * @param date_inactif_profil new value of date_inactif_profil
     */
    public void setDate_inactif_profil(Date date_inactif_profil) {
        this.date_inactif_profil = date_inactif_profil;
    }

    @ManyToMany
    private List<Piste_opportunite> lesPistes_opportunites;

    /**
     * Get the value of lesPistes_opportunites
     *
     * @return the value of lesPistes_opportunites
     */
    public List<Piste_opportunite> getLesPistes_opportunites() {
        return lesPistes_opportunites;
    }

    /**
     * Set the value of lesPistes_opportunites
     *
     * @param lesPistes_opportunites new value of lesPistes_opportunites
     */
    public void setLesPistes_opportunites(List<Piste_opportunite> lesPistes_opportunites) {
        this.lesPistes_opportunites = lesPistes_opportunites;
    }

    
    @ManyToOne
        private Utilisateur unUtilisateur;

    /**
     * Get the value of unUtilisateur
     *
     * @return the value of unUtilisateur
     */
    public Utilisateur getUnUtilisateur() {
        return unUtilisateur;
    }

    /**
     * Set the value of unUtilisateur
     *
     * @param unUtilisateur new value of unUtilisateur
     */
    public void setUnUtilisateur(Utilisateur unUtilisateur) {
        this.unUtilisateur = unUtilisateur;
    }

}

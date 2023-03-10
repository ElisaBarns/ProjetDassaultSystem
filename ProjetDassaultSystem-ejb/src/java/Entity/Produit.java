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
import javax.persistence.Temporal;

/**
 *
 * @author rober
 */
@Entity
public class Produit implements Serializable {

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
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Produit[ id=" + id + " ]";
    }
    
    @Column(nullable=false, unique=true)
    private int id_produit;

    /**
     * Get the value of id_produit
     *
     * @return the value of id_produit
     */
    public int getId_produit() {
        return id_produit;
    }

    /**
     * Set the value of id_produit
     *
     * @param id_produit new value of id_produit
     */
    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    @Column(nullable=false, unique=true)
    private String nom_produit;

    /**
     * Get the value of nom_produit
     *
     * @return the value of nom_produit
     */
    public String getNom_produit() {
        return nom_produit;
    }

    /**
     * Set the value of nom_produit
     *
     * @param nom_produit new value of nom_produit
     */
    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    @Column(nullable = false)
      private String description_commerciale;

    /**
     * Get the value of description_commerciale
     *
     * @return the value of description_commerciale
     */
    public String getDescription_commerciale() {
        return description_commerciale;
    }

    /**
     * Set the value of description_commerciale
     *
     * @param description_commerciale new value of description_commerciale
     */
    public void setDescription_commerciale(String description_commerciale) {
        this.description_commerciale = description_commerciale;
    }
    
    @Column(nullable = false)

      private float pu_produit;

    /**
     * Get the value of pu_produit
     *
     * @return the value of pu_produit
     */
    public float getPu_produit() {
        return pu_produit;
    }

    /**
     * Set the value of pu_produit
     *
     * @param pu_produit new value of pu_produit
     */
    public void setPu_produit(float pu_produit) {
        this.pu_produit = pu_produit;
    }

   @Column(nullable=false, unique= false)
    @Temporal(javax.persistence.TemporalType.DATE)
     private Date date_creation_produit;

    /**
     * Get the value of date_creation_produit
     *
     * @return the value of date_creation_produit
     */
    public Date getDate_creation_produit() {
        return date_creation_produit;
    }

    /**
     * Set the value of date_creation_produit
     *
     * @param date_creation_produit new value of date_creation_produit
     */
    public void setDate_creation_produit(Date date_creation_produit) {
        this.date_creation_produit = date_creation_produit;
    }
 
    @Column (nullable=true, unique = false)
    @Temporal(javax.persistence.TemporalType.DATE)
     private Date date_modif_produit;

    /**
     * Get the value of date_modif_produit
     *
     * @return the value of date_modif_produit
     */
    public Date getDate_modif_produit() {
        return date_modif_produit;
    }

    /**
     * Set the value of date_modif_produit
     *
     * @param date_modif_produit new value of date_modif_produit
     */
    public void setDate_modif_produit(Date date_modif_produit) {
        this.date_modif_produit = date_modif_produit;
    }

    @Column (nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_inactivation_produit;

    /**
     * Get the value of date_inactivation_produit
     *
     * @return the value of date_inactivation_produit
     */
    public Date getDate_inactivation_produit() {
        return date_inactivation_produit;
    }

    /**
     * Set the value of date_inactivation_produit
     *
     * @param date_inactivation_produit new value of date_inactivation_produit
     */
    public void setDate_inactivation_produit(Date date_inactivation_produit) {
        this.date_inactivation_produit = date_inactivation_produit;
    }
    
    
}

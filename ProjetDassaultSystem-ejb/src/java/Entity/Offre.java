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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author rober
 */
@Entity
public class Offre implements Serializable {

    @OneToMany(mappedBy = "uneOffre")
    private List<Detail_offre> lesDetail_offres;

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
        if (!(object instanceof Offre)) {
            return false;
        }
        Offre other = (Offre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Offre[ id=" + id + " ]";
    }
    
    @Column(nullable= false, unique=true)
        private int id_offre;

    /**
     * Get the value of id_offre
     *
     * @return the value of id_offre
     */
    public int getId_offre() {
        return id_offre;
    }

    /**
     * Set the value of id_offre
     *
     * @param id_offre new value of id_offre
     */
    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    @Column(nullable = false)
        private int remise;

    /**
     * Get the value of remise
     *
     * @return the value of remise
     */
    public int getRemise() {
        return remise;
    }

    /**
     * Set the value of remise
     *
     * @param remise new value of remise
     */
    public void setRemise(int remise) {
        this.remise = remise;
    }

    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
        private Date date_creation_offre;

    /**
     * Get the value of date_creation_offre
     *
     * @return the value of date_creation_offre
     */
    public Date getDate_creation_offre() {
        return date_creation_offre;
    }

    /**
     * Set the value of date_creation_offre
     *
     * @param date_creation_offre new value of date_creation_offre
     */
    public void setDate_creation_offre(Date date_creation_offre) {
        this.date_creation_offre = date_creation_offre;
    }

    @Column (nullable=true)
    @Temporal(javax.persistence.TemporalType.DATE)
        private Date date_modif_offre;

    /**
     * Get the value of date_modif_offre
     *
     * @return the value of date_modif_offre
     */
    public Date getDate_modif_offre() {
        return date_modif_offre;
    }

    /**
     * Set the value of date_modif_offre
     *
     * @param date_modif_offre new value of date_modif_offre
     */
    public void setDate_modif_offre(Date date_modif_offre) {
        this.date_modif_offre = date_modif_offre;
    }

         private List<Detail_offre> contenu;

    /**
     * Get the value of contenu
     *
     * @return the value of contenu
     */
    public List<Detail_offre> getContenu() {
        return contenu;
    }

    /**
     * Set the value of contenu
     *
     * @param contenu new value of contenu
     */
    public void setContenu(List<Detail_offre> contenu) {
        this.contenu = contenu;
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


    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Elisa
 */
@Entity
public class Enregistrement implements Serializable {

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
        if (!(object instanceof Enregistrement)) {
            return false;
        }
        Enregistrement other = (Enregistrement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Enregistrement[ id=" + id + " ]";
    }
    
     @Column (nullable=false, unique = true)
    private int id_enregistrement;

    /**
     * Get the value of id_enregistrement
     *
     * @return the value of id_enregistrement
     */
    public int getId_enregistrement() {
        return id_enregistrement;
    }

    /**
     * Set the value of id_enregistrement
     *
     * @param id_enregistrement new value of id_enregistrement
     */
    public void setId_enregistrement(int id_enregistrement) {
        this.id_enregistrement = id_enregistrement;
    }
    
    private List<Piste_opportunite> liste_modifications;

    /**
     * Get the value of liste_modifications
     *
     * @return the value of liste_modifications
     */
    public List<Piste_opportunite> getListe_modifications() {
        return liste_modifications;
    }

    /**
     * Set the value of liste_modifications
     *
     * @param liste_modifications new value of liste_modifications
     */
    public void setListe_modifications(List<Piste_opportunite> liste_modifications) {
        this.liste_modifications = liste_modifications;
    }

}

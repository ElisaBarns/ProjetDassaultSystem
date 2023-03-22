/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Elisa
 */
@Entity
public class Enregistrement implements Serializable {

    @OneToOne(mappedBy = "enregistrement")
    private Piste_opportunite piste_opportunite;

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
    
    
    private ArrayList<Piste_opportunite> liste_modifications;

    /**
     * Get the value of liste_modifications
     *
     * @return the value of liste_modifications
     */
    public ArrayList<Piste_opportunite> getListe_modifications() {
        return liste_modifications;
    }

    /**
     * Set the value of liste_modifications
     *
     * @param liste_modifications new value of liste_modifications
     */
    public void setListe_modifications(ArrayList<Piste_opportunite> liste_modifications) {
        this.liste_modifications = liste_modifications;
    }

}

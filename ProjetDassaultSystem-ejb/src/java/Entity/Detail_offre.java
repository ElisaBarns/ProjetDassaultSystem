/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author rober
 */
@Entity
public class Detail_offre implements Serializable {

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
        if (!(object instanceof Detail_offre)) {
            return false;
        }
        Detail_offre other = (Detail_offre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Detail_offre[ id=" + id + " ]";
    }
    
    @Column (nullable=false)   
    private int id_detail;

    /**
     * Get the value of id_detail
     *
     * @return the value of id_detail
     */
    public int getId_detail() {
        return id_detail;
    }

    /**
     * Set the value of id_detail
     *
     * @param id_detail new value of id_detail
     */
    public void setId_detail(int id_detail) {
        this.id_detail = id_detail;
    }

    @Column (nullable= false)
        private int quantite;

    /**
     * Get the value of quantite
     *
     * @return the value of quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Set the value of quantite
     *
     * @param quantite new value of quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
  
    private Produit produit;

    /**
     * Get the value of produit
     *
     * @return the value of produit
     */
    public Produit getProduit() {
        return produit;
    }

    /**
     * Set the value of produit
     *
     * @param produit new value of produit
     */
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

}

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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Elisa
 */
@Entity
public class Piste_opportunite implements Serializable {

    @OneToOne(mappedBy = "laPisteOpportunite")
    private Offre uneOffre;

    public Offre getUneOffre() {
        return uneOffre;
    }

    public void setUneOffre(Offre uneOffre) {
        this.uneOffre = uneOffre;
    }

    public List<Profil> getLesProfils() {
        return lesProfils;
    }

    public void setLesProfils(List<Profil> lesProfils) {
        this.lesProfils = lesProfils;
    }


    @ManyToMany(mappedBy = "lesPistes_opportunites")
    private List<Profil> lesProfils;

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
        if (!(object instanceof Piste_opportunite)) {
            return false;
        }
        Piste_opportunite other = (Piste_opportunite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Piste_opportunite[ id=" + id + " ]";
    }
   
     @Column (nullable=false, unique = true)
    private int id_piste_opp;

    /**
     * Get the value of id_piste_opp
     *
     * @return the value of id_piste_opp
     */
    public int getId_piste_opp() {
        return id_piste_opp;
    }

    /**
     * Set the value of id_piste_opp
     *
     * @param id_piste_opp new value of id_piste_opp
     */
    public void setId_piste_opp(int id_piste_opp) {
        this.id_piste_opp = id_piste_opp;
    }

     @Column (nullable=false, unique = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_creation_popp;

    /**
     * Get the value of date_creation_popp
     *
     * @return the value of date_creation_popp
     */
    public Date getDate_creation_popp() {
        return date_creation_popp;
    }

    /**
     * Set the value of date_creation_popp
     *
     * @param date_creation_popp new value of date_creation_popp
     */
    public void setDate_creation_popp(Date date_creation_popp) {
        this.date_creation_popp = date_creation_popp;
    }

     @Column (nullable=true, unique = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_modif_popp;

    /**
     * Get the value of date_modif_popp
     *
     * @return the value of date_modif_popp
     */
    public Date getDate_modif_popp() {
        return date_modif_popp;
    }

    /**
     * Set the value of date_modif_popp
     *
     * @param date_modif_popp new value of date_modif_popp
     */
    public void setDate_modif_popp(Date date_modif_popp) {
        this.date_modif_popp = date_modif_popp;
    }
 
     @Column (nullable=true, unique = false)
    private Niveau niveau_interet;

    /**
     * Get the value of niveau_interet
     *
     * @return the value of niveau_interet
     */
    public Niveau getNiveau_interet() {
        return niveau_interet;
    }

    /**
     * Set the value of niveau_interet
     *
     * @param niveau_interet new value of niveau_interet
     */
    public void setNiveau_interet(Niveau niveau_interet) {
        this.niveau_interet = niveau_interet;
    }

     @Column (nullable=true, unique = false)
    private int tx_reussite;

    /**
     * Get the value of tx_reussite
     *
     * @return the value of tx_reussite
     */
    public int getTx_reussite() {
        return tx_reussite;
    }

    /**
     * Set the value of tx_reussite
     *
     * @param tx_reussite new value of tx_reussite
     */
    public void setTx_reussite(int tx_reussite) {
        this.tx_reussite = tx_reussite;
    }

     @Column (nullable=true, unique = false)
    private Niveau niveau_risque;

    /**
     * Get the value of niveau_risque
     *
     * @return the value of niveau_risque
     */
    public Niveau getNiveau_risque() {
        return niveau_risque;
    }

    /**
     * Set the value of niveau_risque
     *
     * @param niveau_risque new value of niveau_risque
     */
    public void setNiveau_risque(Niveau niveau_risque) {
        this.niveau_risque = niveau_risque;
    }

     @Column (nullable=true, unique = false)
    private double budget_estime;

    /**
     * Get the value of budget_estime
     *
     * @return the value of budget_estime
     */
    public double getBudget_estime() {
        return budget_estime;
    }

    /**
     * Set the value of budget_estime
     *
     * @param budget_estime new value of budget_estime
     */
    public void setBudget_estime(double budget_estime) {
        this.budget_estime = budget_estime;
    }

     @Column (nullable=false, unique = false)
    private PisteOpp type;

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public PisteOpp getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(PisteOpp type) {
        this.type = type;
    }

     @Column (nullable=false, unique = false)
    private Statut statut;

    /**
     * Get the value of statut
     *
     * @return the value of statut
     */
    public Statut getStatut() {
        return statut;
    }

    /**
     * Set the value of statut
     *
     * @param statut new value of statut
     */
    public void setStatut(Statut statut) {
        this.statut = statut;
    }

     @Column (nullable=false, unique = false)
    private Profil marketeur;

    /**
     * Get the value of marketeur
     *
     * @return the value of marketeur
     */
    public Profil getMarketeur() {
        return marketeur;
    }

    /**
     * Set the value of marketeur
     *
     * @param marketeur new value of marketeur
     */
    public void setMarketeur(Profil marketeur) {
        this.marketeur = marketeur;
    }

     @Column (nullable=true, unique = false)
    private Profil vendeur;

    /**
     * Get the value of vendeur
     *
     * @return the value of vendeur
     */
    public Profil getVendeur() {
        return vendeur;
    }

    /**
     * Set the value of vendeur
     *
     * @param vendeur new value of vendeur
     */
    public void setVendeur(Profil vendeur) {
        this.vendeur = vendeur;
    }

     @Column (nullable=true, unique = false)
    private Profil expert_technique;

    /**
     * Get the value of expert_technique
     *
     * @return the value of expert_technique
     */
    public Profil getExpert_technique() {
        return expert_technique;
    }

    /**
     * Set the value of expert_technique
     *
     * @param expert_technique new value of expert_technique
     */
    public void setExpert_technique(Profil expert_technique) {
        this.expert_technique = expert_technique;
    }

    @OneToOne
    private Enregistrement enregistrement;

    /**
     * Get the value of enregistrement
     *
     * @return the value of enregistrement
     */
    public Enregistrement getEnregistrement() {
        return enregistrement;
    }

    /**
     * Set the value of enregistrement
     *
     * @param enregistrement new value of enregistrement
     */
    public void setEnregistrement(Enregistrement enregistrement) {
        this.enregistrement = enregistrement;
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

    //TEST POUR SUPPRIMER LE VENDEUR AFFECTE A LA PISTE (LORSQU'IL REFUSE)
    /*public void ViderVendeur(Piste_opportunite p){
        p.delete();
    }*/
}

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author Elisa
 */
@Entity
public class Utilisateur implements Serializable {

    @OneToMany(mappedBy = "unUtilisateur")
    private List<Profil> lesProfils;

    public List<Profil> getLesProfils() {
        return lesProfils;
    }

    public void setLesProfils(List<Profil> lesProfils) {
        this.lesProfils = lesProfils;
    }

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
    
   
    @Column(nullable=false, unique=false)
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

    @Column(nullable=false, unique=false)
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

    @Column(nullable=false, unique=true)
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

    @Column(nullable=false, unique=true)
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
    
    @Column(nullable=false, unique=true)

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

    @Column(nullable=false, unique=false)
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

    @Column(nullable=true)
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

    @Column(nullable=false, unique=false)
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

    @Column(nullable=true)
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

    @Column(nullable=true)
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
 
    public boolean verify_Marketeur(){
        for (int i=0;i<lesProfils.size();i++){
            System.out.println(lesProfils.get(i).getFonction().name());
            if (lesProfils.get(i).getFonction().name().equals("MARKETEUR")){
                return true;
            }
        }
        return false;
    }
    
 public boolean verify_Vendeur(){
        for (int i=0;i<lesProfils.size();i++){
            System.out.println(lesProfils.get(i).getFonction().name());
            if (lesProfils.get(i).getFonction().name().equals("VENDEUR")){
                return true;
            }
        }
        return false;
    }
 
  public boolean verify_Admin(){
        for (int i=0;i<lesProfils.size();i++){
            System.out.println(lesProfils.get(i).getFonction().name());
            if (lesProfils.get(i).getFonction().name().equals("ADMINISTRATEUR")){
                return true;
            }
        }
        return false;
    }
  
   public boolean verify_Expert(){
        for (int i=0;i<lesProfils.size();i++){
            System.out.println(lesProfils.get(i).getFonction().name());
            if (lesProfils.get(i).getFonction().name().equals("EXPERT_TECHNIQUE")){
                return true;
            }
        }
        return false;
    }
   
    public boolean verify_OperateurVentes(){
        for (int i=0;i<lesProfils.size();i++){
            System.out.println(lesProfils.get(i).getFonction().name());
            if (lesProfils.get(i).getFonction().name().equals("OPERATEUR_VENTES")){
                return true;
            }
        }
        return false;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Utilisateur;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mel
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal {

    @PersistenceContext(unitName = "ProjetDassaultSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }
 
    //Authentification
    public Utilisateur Authentification(String login_utilisateur, String mdp_utilisateur) {
    Utilisateur u=null;
    String txt="SELECT u FROM Utilisateur AS u WHERE u.login_utilisateur=:login and u.mdp_utilisateur=:mdp";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("login",login_utilisateur);
    req=req.setParameter("mdp",mdp_utilisateur);
    List<Utilisateur>result=req.getResultList();
    if (result.size()==1){
        u=(Utilisateur)result.get(0);
    }
    return u;
    }
    
    //Créer utilisateur
    public void CreerUtilisateur(String nom_utilisateur, String prenom_utilisateur, String login_utilisateur, String mdp_utilisateur, String mail_utilisateur, String tel_utilisateur, boolean inactif, Date date_creation_utilisateur, Date date_inactivation_utilisateur, Date date_modification_utilisateur) {
    Utilisateur u=new Utilisateur();
    u.setNom_utilisateur(nom_utilisateur);
    u.setPrenom_utilisateur(prenom_utilisateur);
    u.setLogin_utilisateur(login_utilisateur);
    u.setMdp_utilisateur(mdp_utilisateur);
    u.setMail_utilisateur(mail_utilisateur);
    u.setTel_utilisateur(tel_utilisateur);
    u.setInactif(inactif);
    u.setDate_creation_utilisateur(date_creation_utilisateur);
    u.setDate_inactivation_utilisateur(date_inactivation_utilisateur);
    u.setDate_modification_utilisateur(date_modification_utilisateur);
    getEntityManager().persist(u);
}
    
    //Modifier utilisateur
    public void ModifierUtilisateur(Utilisateur u, String nom_utilisateur, String prenom_utilisateur, String mail_utilisateur, String tel_utilisateur, Date date_modification_utilisateur) {
    u.setNom_utilisateur(nom_utilisateur);
    u.setPrenom_utilisateur(prenom_utilisateur);
    /*
    Pas besoin car le login ne peut être modifier par qui que ce soit
    Et concernant le mdp, il existe une méthode spécifique pour modifier le mdp
    u.setLogin_utilisateur(login_utilisateur);
    u.setMdp_utilisateur(mdp_utilisateur);
    */
    u.setMail_utilisateur(mail_utilisateur);
    u.setTel_utilisateur(tel_utilisateur);
    /*
    Pas besoin car nous avons une méthode spécifique pour inactiver un utilisateur
    u.setInactif(inactif);
    */
    /*
    Pas besoin pour la modification puisque ces dates ne sont pas censés changer dans le cas d'une modification
    u.setDate_creation_utilisateur(date_creation_utilisateur);
    u.setDate_inactivation_utilisateur(date_inactivation_utilisateur);
    */
    u.setDate_modification_utilisateur(date_modification_utilisateur);
    getEntityManager().merge(u);
    }
    
    //Modifier mot de passe
    public void ModifierMdpUtilisateur(Utilisateur u, String mdp_utilisateur) {
    u.setMdp_utilisateur(mdp_utilisateur);
    getEntityManager().merge(u);
    }
    
    //Inactiver l'utilisateur
    public void InactiverUtilisateur(Utilisateur u, boolean inactif, Date date_inactivation_utilisateur) {
    u.setInactif(inactif);
    u.setDate_inactivation_utilisateur(date_inactivation_utilisateur);
    getEntityManager().merge(u);
    }
    
    //Rechercher Utilisateur
    public Utilisateur RechercherUtilisateur(String login_utilisateur) {
    Utilisateur u=null;
    List<Utilisateur> result;
    String txt="SELECT u FROM Couturier AS u WHERE u.login_utilisateur=:login_utilisateur";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("login_utilisateur", login_utilisateur);
    result=req.getResultList();
    if(result.size()==1){
        u=(Utilisateur)result.get(0);
    }
    return u;        
    }
    

}

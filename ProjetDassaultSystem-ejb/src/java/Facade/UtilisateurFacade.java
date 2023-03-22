/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Fonction;
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
    @Override
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
    @Override
    public void CreerUtilisateur(String nom_utilisateur, String prenom_utilisateur, String login_utilisateur, String mdp_utilisateur, String mail_utilisateur, String tel_utilisateur) {
    Utilisateur u=new Utilisateur();
    
    u.setNom_utilisateur(nom_utilisateur);
    u.setPrenom_utilisateur(prenom_utilisateur);
    u.setLogin_utilisateur(login_utilisateur);
    u.setMdp_utilisateur(mdp_utilisateur);
    u.setMail_utilisateur(mail_utilisateur);
    u.setTel_utilisateur(tel_utilisateur);
    u.setInactif(false);
    u.setDate_creation_utilisateur(new Date()); //A CONFIRMER !!!
    u.setDate_inactivation_utilisateur(null);
    u.setDate_modification_utilisateur(null);
    
    getEntityManager().persist(u);
}
    
    //Modifier utilisateur
    @Override
    public void ModifierUtilisateur(Utilisateur u, String nom_utilisateur, String prenom_utilisateur, String login_utilisateur, String mail_utilisateur, String tel_utilisateur) {
    u.setNom_utilisateur(nom_utilisateur);
    u.setPrenom_utilisateur(prenom_utilisateur);
    u.setLogin_utilisateur(login_utilisateur);
    /*
    Pas besoin car il existe une méthode spécifique pour modifier le mdp
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
    u.setDate_modification_utilisateur(new Date());
    getEntityManager().merge(u);
    }
    
    //Modifier mot de passe
    @Override
    public void ModifierMdpUtilisateur(Utilisateur u, String mdp_utilisateur, Date date_modification_utilisateur) {
    u.setMdp_utilisateur(mdp_utilisateur);
    date_modification_utilisateur=new Date();
    getEntityManager().merge(u);
    }
    
    //Inactiver l'utilisateur
    @Override
    public void InactiverUtilisateur(Utilisateur u, boolean inactif, Date date_inactivation_utilisateur) {
    u.setInactif(true);
    date_inactivation_utilisateur=new Date();
    getEntityManager().merge(u);
    }
    
    //Rechercher Utilisateur
    @Override
    public Utilisateur RechercherUtilisateur(String login_utilisateur) {
    Utilisateur u=null;
    List<Utilisateur> result;
    String txt="SELECT u FROM Utilisateur AS u WHERE u.login_utilisateur=:login_utilisateur";
    Query req=getEntityManager().createQuery(txt);
    req=req.setParameter("login_utilisateur", login_utilisateur);
    result=req.getResultList();
    if(result.size()==1){
        u=(Utilisateur)result.get(0);
    }
    return u;        
    }
    
    
    
}

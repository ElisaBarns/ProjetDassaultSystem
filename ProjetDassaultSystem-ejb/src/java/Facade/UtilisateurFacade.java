/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Entity.Utilisateur;
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
    @Override
    public void CreerUtilisateur(String , ) {
    Utilisateur u=new Utilisateur();
    u.setNomMannequin(nomMannequin);
    u.setPrenomMannequin(prenomMannequin);
    u.setSalaireMannequin(salaireMannequin);
    //u.setLesVetements(lesVetements); //pas certaine pour cette ligne
    u.setLogin(login);
    u.setMotdepasse(mdp);
    getEntityManager().persist(u);
}
    
    //Modifier utilisateur
    
    //Modifier mot de passe
    
    //Inactiver l'utilisateur
}

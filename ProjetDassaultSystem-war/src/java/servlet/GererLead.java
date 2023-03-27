/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;


import Entity.Client;
import Entity.Fonction;
import Entity.Niveau;
import Entity.Piste_opportunite;
import Entity.Produit;
import Entity.Profil;
import Entity.Utilisateur;
import Facade.ClientFacadeLocal;
import Facade.ContactFacadeLocal;
import Facade.Detail_offreFacadeLocal;
import Facade.EnregistrementFacadeLocal;
import Facade.OffreFacadeLocal;
import Facade.Piste_opportuniteFacadeLocal;
import Facade.ProduitFacadeLocal;
import Facade.ProfilFacadeLocal;
import Facade.UtilisateurFacadeLocal;
import Session.AdministrateurSession;
import Session.AdministrateurSessionLocal;
import Session.ExpertSessionLocal;
import Session.MarketeurSessionLocal;
import Session.OperateurVentesSessionLocal;
import Session.UtilisateurSessionLocal;
import Session.VendeurSessionLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rober
 */
@WebServlet(name = "GererLead", urlPatterns = {"/GererLead"})
public class GererLead extends HttpServlet {

    AdministrateurSessionLocal administrateurSession = lookupAdministrateurSessionLocal();
    UtilisateurSessionLocal utilisateurSession = lookupUtilisateurSessionLocal();
    ExpertSessionLocal expertSession = lookupExpertSessionLocal();
    MarketeurSessionLocal marketeurSession = lookupMarketeurSessionLocal();
    OperateurVentesSessionLocal operateurVentesSession = lookupOperateurVentesSessionLocal();
    VendeurSessionLocal VendeurSession = lookupVendeurSessionLocal();

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;
    
    @EJB
    private ClientFacadeLocal clientFacade;

    @EJB
    private ContactFacadeLocal contactFacade;
    
    @EJB
    private Detail_offreFacadeLocal detail_offreFacade;
    
    @EJB
    private EnregistrementFacadeLocal enregistrementFacade;
    
    @EJB
    private OffreFacadeLocal offreFacade;
    
    @EJB
    private Piste_opportuniteFacadeLocal piste_opportuniteFacade;
    
    @EJB
    private ProduitFacadeLocal produitFacade;
    
    @EJB
    private ProfilFacadeLocal profilFacade;
    


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String jspDassault=null;
        String act=request.getParameter("action");
        if((act==null)||(act.equals("vide")))
        {
            //jspDassault="/MenuGeneral.jsp";            
            jspDassault="/Authentification.jsp";
            request.setAttribute("message", "pas d'information");
        }
        else if(act.equals("authentification"))
        {
            HttpSession sess=request.getSession(true);
            String login_utilisateur = request.getParameter( "login_utilisateur" ); 
            String mdp_utilisateur = request.getParameter( "mdp_utilisateur" );
            //Integer id; 
            Utilisateur u; 
            if (!(login_utilisateur.trim().isEmpty()) && !(mdp_utilisateur.trim().isEmpty()) ) 
            { 
            //login = Integer.valueOf(login); 
            //mdp=Integer.valueOf(mdp);
            u = utilisateurSession.authentification(login_utilisateur, mdp_utilisateur); 
                if (u!=null){
                jspDassault="/MenuGeneral.jsp"; 
                sess.setAttribute("session", u); 
                Utilisateur u1 = (Utilisateur)sess.getAttribute("session");
                System.out.println("testuserget");
                System.out.println(u1);
                System.out.println("testMarketeur");
                System.out.println(u1.verify_Marketeur());
                } 
                else
                {
                    jspDassault="/MauvaisLoginMdp.jsp";
                }
            }
            else 
            { 
            jspDassault="/RenseignerTousChamps.jsp"; 
            } 
        }    

        
        else if(act.equals("CreerUtilisateur"))
        {
            /*String nom_utilisateur = request.getParameter( "nom_utilisateur" ); 
            String prenom_utilisateur = request.getParameter( "prenom_utilisateur" );
            String login_utilisateur = request.getParameter( "login_utilisateur" ); 
            String mdp_utilisateur = request.getParameter( "mdp_utilisateur" );
            String mail_utilisateur = request.getParameter( "mail_utilisateur" ); 
            String tel_utilisateur = request.getParameter( "tel_utilisateur" );
            //Integer id; 
            Utilisateur u; 
            if (!(nom_utilisateur.trim().isEmpty()) && !(prenom_utilisateur.trim().isEmpty()) && !(login_utilisateur.trim().isEmpty()) && !(mdp_utilisateur.trim().isEmpty()) && !(mail_utilisateur.trim().isEmpty()) && !(tel_utilisateur.trim().isEmpty())) 
            { 
            administrateurSession.CreerUtilisateur(login_utilisateur, mdp_utilisateur, nom_utilisateur, prenom_utilisateur, mail_utilisateur, tel_utilisateur); 
            jspDassault="/SuccesCreation.jsp";     
            } 
            else
            {
                jspDassault="/RenseignerTousChamps.jsp";
            }
            
            /* CE QUI Y AVAIT DE BASE*/
            jspDassault="/CreerUtilisateur.jsp";
            doActionCreerUtilisateur(request, response); 
        }
        
        else if(act.equals("ModifierUtilisateur"))
        {
            /* String nom_utilisateur = request.getParameter( "nom_utilisateur" ); 
            String prenom_utilisateur = request.getParameter( "prenom_utilisateur" );
            String login_utilisateur = request.getParameter( "login_utilisateur" ); 
            String mail_utilisateur = request.getParameter( "mail_utilisateur" ); 
            String tel_utilisateur = request.getParameter( "tel_utilisateur" );
            Utilisateur u; 
            if (!(nom_utilisateur.trim().isEmpty()) && !(prenom_utilisateur.trim().isEmpty()) && !(login_utilisateur.trim().isEmpty()) && !(mail_utilisateur.trim().isEmpty()) && !(tel_utilisateur.trim().isEmpty())) 
            { 
            administrateurSession.ModifierUtilisateur(login_utilisateur, nom_utilisateur, prenom_utilisateur, mail_utilisateur, tel_utilisateur); 
            jspDassault="/SuccesCreation.jsp";     
            } 
            else
            {
                jspDassault="/RenseignerTousChamps.jsp";
            }
            
            CE QU'IL Y AVAIT DE BASE*/
            jspDassault="/ModifierUtilisateur.jsp";
            doActionModifierUtilisateur(request, response);
        }
        
        else if(act.equals("ModifierMdpUtilisateur"))
        {
            jspDassault="/ModifierMdpUtilisateur.jsp";
            doActionModifierMdpUtilisateur(request, response);
        }
        
        else if(act.equals("InactiverUtilisateur"))
        {
            jspDassault="/InactiverUtilisateur.jsp";
            doActionInactiverUtilisateur(request, response);
        }
        
        else if (act.equals("RechercherUtilisateur"))
         {
            HttpSession sess = request.getSession(true);
             String login_utilisateur = request.getParameter("login_utilisateur");
             Utilisateur u;
             if(!(login_utilisateur.trim().isEmpty())) 
             {
                 u= administrateurSession.RechercherUtilisateur(login_utilisateur);
                 jspDassault="/AfficherUtilisateur.jsp";
                 sess.setAttribute("Utilisateur", u);
             }
            else 
            {
                jspDassault="/MenuGeneral.jsp";    
            }
         }
        
        else if(act.equals("CreerProfil"))
        {
            jspDassault="/CreerProfil.jsp";
            doActionCreerProfil(request,response);
        }
        
        else if(act.equals("AfficherProfils"))
        {
            jspDassault="/AfficherProfils.jsp";
            List<Profil>lesProf=administrateurSession.AfficherLesProfils();
            request.setAttribute("lesProfils",lesProf);
            request.setAttribute("message", "");
        }
        
        else if(act.equals("AfficherListeMarketeur"))
        {
            //TROUVER UN MOYEN DE GERER LE NIVEAU_RISQUE QUI EST UNE CLASSE DE TYPE ENUM
            jspDassault="/AfficherListeMarketeur.jsp";
            List<Piste_opportunite>lesPO=marketeurSession.AfficherPistes();
            request.setAttribute("lesPistes_opportunites",lesPO);
            request.setAttribute("message", "");
        }
        
        else if(act.equals("AfficherPistesExpert"))//A TERMINER !!!
        {
            jspDassault="/AfficherPistesExpert.jsp";
            List<Piste_opportunite> lesPistes_opportunites= expertSession.AfficherPistesExpert();
            request.setAttribute("lesPistes",lesPistes_opportunites);
            request.setAttribute("message", "Liste des Profils existants");
        }
        
        else if(act.equals("CreerClient"))
        {
            jspDassault="/CreerClient.jsp";
            doActionCreerClient(request, response);
        }
        
        else if(act.equals("CreerContact"))
        {
            jspDassault="/CreerContact.jsp";
            doActionCreerContact(request, response);
        }
        
        else if(act.equals("CreerPiste"))
        {
           
            jspDassault="/CreerPiste.jsp";
           List<Profil> vendeursActifs=administrateurSession.ListeVendeursActifs();
            
           request.setAttribute("lesVendeursActifs",vendeursActifs);
            
            doActionCreerPiste(request, response);
            
        }
        
         else if(act.equals("AfficherCreerPiste"))
        {
        
            jspDassault="/CreerPiste.jsp";
           
            List<Profil> vendeursActifs=administrateurSession.ListeVendeursActifs();
      
           request.setAttribute("lesVendeursActifs",vendeursActifs);
        
        }
        
        else if(act.equals("ModifierPiste"))
        {
            jspDassault="/ModifierPiste.jsp";
            doActionModifierPiste(request, response);
        }
       
         else if (act.equals("ModifierClient"))
         {
             jspDassault="/ModifierClient.jsp";
             doActionModifierClient(request, response);
         }
        
        else if (act.equals("RechercherProduit"))
         {
            HttpSession sess = request.getSession(true);
             String nom_produit = request.getParameter("nom_produit");
             Produit p;
             if(!(nom_produit.trim().isEmpty())) 
             {
                 p= expertSession.RechercherProduitParNom(nom_produit);
                 jspDassault="/AfficherProduit.jsp";
                 sess.setAttribute("Produit", p);
             }
            else 
            {
                jspDassault="/MenuGeneral.jsp";    
            }
         }
        
        else if(act.equals("CreerDetailOffre"))
        {
            jspDassault="/CreerDetailOffre.jsp";
            doActionCreerDetailOffre(request, response);
        }
        
        else if(act.equals("CreerOffre"))
        {
            jspDassault="/CreerOffre.jsp";
            doActionCreerOffre(request, response);
        }
        
    /*mettre les else if ici*/

    
      RequestDispatcher Rd;
      Rd= getServletContext().getRequestDispatcher(jspDassault);
      Rd.forward(request,response);
      
      
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GererLead</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GererLead at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    /* mettre les doaction ici*/
    protected void doActionCreerUtilisateur (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String nom_utilisateur = request.getParameter("nom_utilisateur");
        String prenom_utilisateur = request.getParameter("prenom_utilisateur");
        String login_utilisateur = request.getParameter("login_utilisateur");
        String mdp_utilisateur = request.getParameter("mdp_utilisateur");
        String mail_utilisateur = request.getParameter("mail_utilisateur");
        String tel_utilisateur = request.getParameter("tel_utilisateur");
        String message;
        
        if (nom_utilisateur.trim().isEmpty()|| prenom_utilisateur.trim().isEmpty()|| login_utilisateur.trim().isEmpty()|| mdp_utilisateur.trim().isEmpty()|| mail_utilisateur.trim().isEmpty()|| tel_utilisateur.trim().isEmpty())
        {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
                    + "<br /> <a href =\"CreerUtilisateur.jsp\" > Cliquez ici </a> pour accéder au formulaire de création d'un utilisateur.";
        }
        else 
        {
           administrateurSession.CreerUtilisateur( nom_utilisateur, prenom_utilisateur,login_utilisateur, mdp_utilisateur, mail_utilisateur, tel_utilisateur);
           message = "Utilisateur créé avec succès!";
        }
        
        request.setAttribute("message", message);
    }

    protected void doActionModifierUtilisateur (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
       
        String nom_utilisateur = request.getParameter("nom_utilisateur");
        String prenom_utilisateur = request.getParameter("prenom_utilisateur");
        String login_utilisateur = request.getParameter("login_utilisateur");
        String mail_utilisateur = request.getParameter("mail_utilisateur");
        String tel_utilisateur = request.getParameter("tel_utilisateur");
        String message;
        
        if (login_utilisateur.trim().isEmpty())
        {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
                    + "<br /> <a href =\"ModifierUtilisateur.jsp\" > Cliquez ici </a> pour accéder au formulaire de modification d'un utilisateur.";
        }
        else 
        {
           
           administrateurSession.ModifierUtilisateur(nom_utilisateur, prenom_utilisateur,login_utilisateur, mail_utilisateur, tel_utilisateur);
           message = "Utilisateur modifié avec succès!";
        }
        
        request.setAttribute("message", message);
    }
    
    protected void doActionModifierMdpUtilisateur (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String login_utilisateur = request.getParameter("login_utilisateur");
        String mdp_utilisateur = request.getParameter("mdp_utilisateur");
        String message;
        
        if (login_utilisateur.trim().isEmpty() || mdp_utilisateur.trim().isEmpty())
        {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
                    + "<br /> <a href =\"ModifierUtilisateur.jsp\" > Cliquez ici </a> pour accéder au formulaire de modification d'un utilisateur.";
        }
        else 
        {
           
           administrateurSession.ModifierMdpUtilisateur(login_utilisateur, mdp_utilisateur);
           message = "Le mot de passe de l'utilisateur a été modifié avec succès!";
        }
        
        request.setAttribute("message", message);
    }
    
    protected void doActionInactiverUtilisateur (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String login_utilisateur = request.getParameter("login_utilisateur");
        String inactifS=request.getParameter("inactif");
        boolean inactif;
        
        String message;
        
        if (login_utilisateur.trim().isEmpty())
        {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
                    + "<br /> <a href =\"ModifierUtilisateur.jsp\" > Cliquez ici </a> pour accéder au formulaire de modification d'un utilisateur.";
        }
        else 
        {
           inactif= Boolean.valueOf(inactifS);
           administrateurSession.InactiverUtilisateur(login_utilisateur, inactif);
           message = "Le mot de passe de l'utilisateur a été modifié avec succès!";
        }
        
        request.setAttribute("message", message);
    }
    
    
        protected void doActionAuthentification (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String login = request.getParameter("login_utilisateur");
        String mdp = request.getParameter("mdp_utilisateur");
        String message;
        
        if (login.trim().isEmpty()|| mdp.trim().isEmpty())
        {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
                    + "<br /> <a href =\"Authentification.jsp\" > Cliquez ici </a> pour vous connecter.";
        }
        else 
        {
           
           utilisateurSession.authentification(login, mdp); //renvoie l'id en long pour récupérer la liste des profils associés
           message = "Connexion réussie";
        }
        
        request.setAttribute("message", message);
    }
        
        protected void doActionCreerProfil (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String login_utilisateur = request.getParameter("login_utilisateur");
        String fonction = request.getParameter("fonction");
        System.out.println("fonction = "+fonction);
        String message;
        
        if (login_utilisateur.trim().isEmpty())
        {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
                    + "<br /> <a href =\"ModifierUtilisateur.jsp\" > Cliquez ici </a> pour accéder au formulaire de création d'un profil.";
        }
        else
        {
            message = "Le profil a été créé avec succès!";
            if (fonction.equals("vendeur")) 
            { 
                administrateurSession.CreerProfil(login_utilisateur, Fonction.VENDEUR); 
            } 
            else if(fonction.equals("marketeur"))
            {
                administrateurSession.CreerProfil(login_utilisateur, Fonction.MARKETEUR);
            }
            else if(fonction.equals("operateur_ventes"))
            {
                administrateurSession.CreerProfil(login_utilisateur, Fonction.OPERATEUR_VENTES);
            }
            else if(fonction.equals("expert_technique"))
            {
                administrateurSession.CreerProfil(login_utilisateur, Fonction.EXPERT_TECHNIQUE);
            }
            else if(fonction.equals("administrateur"))
            {
                administrateurSession.CreerProfil(login_utilisateur, Fonction.ADMINISTRATEUR);
            }
        } 
        //request.setAttribute( "fournisseur", client ); 
        request.setAttribute( "message", message ); 
    }
        
        protected void doActionCreerClient (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
                String nom = request.getParameter("nom_client");
                String siret = request.getParameter("siret");
                String message;

                if (nom.trim().isEmpty()|| siret.trim().isEmpty())
                {
                    message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
                            + "<br /> <a href =\"CreerClient.jsp\" > Cliquez ici </a> pour accéder au formulaire de création d'un organisateur.";
                }
                else 
                {
                   marketeurSession.CreerClient(nom, siret);
                   message = "Client créé avec succès!";
                }

                request.setAttribute("message", message);
    }
        
        protected void doActionCreerContact (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String nom_contact = request.getParameter("nom_contact");
        String prenom_contact = request.getParameter("prenom_contact");
        String mail_contact = request.getParameter("mail_contact");
        String tel_contact = request.getParameter("tel_contact");
        String nom_client=request.getParameter("nom_client");
        String message;
        
        if (nom_contact.trim().isEmpty()|| prenom_contact.trim().isEmpty()|| mail_contact.trim().isEmpty()|| tel_contact.trim().isEmpty()||nom_client.trim().isEmpty())
        {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
                    + "<br /> <a href =\"CreerUtilisateur.jsp\" > Cliquez ici </a> pour accéder au formulaire de création d'un utilisateur.";
        }
        else 
        {
           marketeurSession.CreerContact(nom_contact, prenom_contact, mail_contact, tel_contact, nom_client);
           message = "Contact créé avec succès!";
        }
        
        request.setAttribute("message", message);
    }
        
        protected void doActionCreerPiste (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        HttpSession sess=request.getSession(true);
        Utilisateur u = (Utilisateur)sess.getAttribute("session");
       
        String nom_client = request.getParameter("nom_client");
       
        Long id_marketeur = u.getId();
                String niveau_interet = request.getParameter("niveau_interet");
         
        String tx_reussite = request.getParameter("tx_reussite");
        
        String niveau_risque = request.getParameter("niveau_risque");
         
        String budget_estime = request.getParameter("budget_estime");
         
        String id_vendeur = request.getParameter("id_vendeur");
        long id_vendeurL;
                
        String message;
        
        if (id_vendeur !=null && id_vendeur.trim().isEmpty())
           
        {
         message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
               + "<br /> <a href =\"CreerPiste.jsp\" > Cliquez ici </a> pour accéder au formulaire de création d'une piste.";
        }
        else {
        System.out.println("AAAAAAA");
        System.out.println(id_vendeur);
        int tx_reussiteI=Integer.parseInt(tx_reussite);
         System.out.println(budget_estime);
        double budget_estimeD=Double.parseDouble(budget_estime);
        id_vendeurL=Long.parseLong(id_vendeur);
         System.out.println("C1");
       Utilisateur marketeur = marketeurSession.RechercherUnMarketeurParId(id_marketeur);
       System.out.println(id_vendeurL);
        Utilisateur vendeur = marketeurSession.RechercherUnVendeurParId(id_vendeurL);
        System.out.println("C3");

        if (nom_client !=null && nom_client.trim().isEmpty())
        {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
                    + "<br /> <a href =\"CreerPiste.jsp\" > Cliquez ici </a> pour accéder au formulaire de création d'une piste.";
        }
        else 
            {
            //Pour avoir l'ordre des différents niveaux dans la méthode-->1er niveau=interet; 2e niveau=risque
            //marketeurSession.CreerPiste(niveau_interet, tx_reussite, niveau_risque, budget_estime, id_marketeur, id_client);
            System.out.println("TestErreur1");
            Niveau N1=Niveau.HAUT;
            if(niveau_interet.equals("bas")) N1=Niveau.BAS;
            else if (niveau_interet.equals("medium")) N1=Niveau.MEDIUM;
            else if (niveau_interet.equals("haut")) N1=Niveau.HAUT;
            
            Niveau N2=Niveau.HAUT;
            if(niveau_risque.equals("bas")) N2=Niveau.BAS;
            else if (niveau_risque.equals("medium")) N2=Niveau.MEDIUM;
            else if (niveau_risque.equals("haut")) N2=Niveau.HAUT;
           
            marketeurSession.CreerPiste(N1, tx_reussiteI, N2, budget_estimeD, marketeur, nom_client, vendeur);
            
            
           
           message = "Piste créé avec succès!";
        }
        }
    System.out.println("after else");
        request.setAttribute("message", message);
    }
     
        protected void doActionModifierPiste (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String id = request.getParameter("id");
        long idL=Long.parseLong(id);
        String niveau_interet = request.getParameter("niveau_interet");
        String tx_reussite = request.getParameter("tx_reussite");
        String niveau_risque = request.getParameter("niveau_risque");
        String budget_estime = request.getParameter("budget_estime");
        int tx_reussiteI=Integer.parseInt(tx_reussite);
        double budget_estimeD=Double.parseDouble(budget_estime);
        String nom_client = request.getParameter("nom_client");
        String message;
        
        if (id.trim().isEmpty())
        {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
                    + "<br /> <a href =\"ModifierPiste.jsp\" > Cliquez ici </a> pour accéder au formulaire de modification d'une piste.";
        }
        else 
        {
           if(niveau_interet.equals("bas"))
            {
                if(niveau_risque.equals("bas"))
                {
                    marketeurSession.ModifierPiste(idL, Niveau.BAS, tx_reussiteI, Niveau.BAS, budget_estimeD, nom_client);
                }
                else if(niveau_risque.equals("medium"))
                {
                    marketeurSession.ModifierPiste(idL, Niveau.BAS, tx_reussiteI, Niveau.MEDIUM, budget_estimeD, nom_client);
                }
                else if(niveau_risque.equals("haut"))
                {
                    marketeurSession.ModifierPiste(idL, Niveau.BAS, tx_reussiteI, Niveau.HAUT, budget_estimeD, nom_client);
                }
            }
            else if (niveau_interet.equals("medium"))
            {
                if(niveau_risque.equals("bas"))
                {
                    marketeurSession.ModifierPiste(idL, Niveau.MEDIUM, tx_reussiteI, Niveau.BAS, budget_estimeD, nom_client);
                }
                else if(niveau_risque.equals("medium"))
                {
                    marketeurSession.ModifierPiste(idL, Niveau.MEDIUM, tx_reussiteI, Niveau.MEDIUM, budget_estimeD, nom_client);
                }
                else if(niveau_risque.equals("haut"))
                {
                    marketeurSession.ModifierPiste(idL, Niveau.MEDIUM, tx_reussiteI, Niveau.HAUT, budget_estimeD, nom_client);
                }
            }
            else if(niveau_interet.equals("haut"))
            {
                if(niveau_risque.equals("bas"))
                {
                    marketeurSession.ModifierPiste(idL, Niveau.HAUT, tx_reussiteI, Niveau.BAS, budget_estimeD, nom_client);
                }
                else if(niveau_risque.equals("medium"))
                {
                    marketeurSession.ModifierPiste(idL, Niveau.HAUT, tx_reussiteI, Niveau.MEDIUM, budget_estimeD, nom_client);
                }
                else if(niveau_risque.equals("haut"))
                {
                    marketeurSession.ModifierPiste(idL, Niveau.HAUT, tx_reussiteI, Niveau.HAUT, budget_estimeD, nom_client);
                }
            }
           message = "Piste modifiée avec succès!";
        }
        
        request.setAttribute("message", message);
    }
            
    protected void doActionModifierClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String nom = request.getParameter("nom_client");
    String siret = request.getParameter("siret");
    String idC = request.getParameter("clientId");
    String message;

     if ( nom.trim().isEmpty() )
     {
     message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires.";
     } else 
     { 
         Long id = Long.parseLong(idC);
         VendeurSession.ModifierClient(id, nom, siret);
          
       message = "Le client a été modifié avec succès !";
    
     }
     request.setAttribute( "message", message );
     }

    protected void doActionCreerDetailOffre (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String id_offre = request.getParameter("id_offre");
        String nom_produit = request.getParameter("nom_produit");
        long nom_produitL = Long.parseLong(nom_produit);
        String quantite = request.getParameter("quantite");
        int quantiteI = Integer.parseInt(quantite);
        String message;

        if (id_offre.trim().isEmpty()|| nom_produit.trim().isEmpty()|| quantite.trim().isEmpty())
        {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
                    + "<br /> <a href =\"CreerDetailOffre.jsp\" > Cliquez ici </a> pour accéder au formulaire de création d'un détail offre.";
        }
        else 
        {
           expertSession.CreerDetail_offre(id_offre, nom_produitL, quantiteI);
           message = "Détail offre créé avec succès!";
        }

        request.setAttribute("message", message);
    }
    
        protected void doActionCreerOffre (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String remise = request.getParameter("remise");
        int remiseI = Integer.parseInt(remise);
        String conditions = request.getParameter("conditions");
        String message;

        if (remise.trim().isEmpty())
        {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
                    + "<br /> <a href =\"CreerOffre.jsp\" > Cliquez ici </a> pour accéder au formulaire de création d'une offre.";
        }
        else 
        {
           expertSession.CréerOffre(remiseI, conditions);
           message = "Offre créé avec succès!";
        }

        request.setAttribute("message", message);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private AdministrateurSessionLocal lookupAdministrateurSessionLocal() {
        try {
            Context c = new InitialContext();
            return (AdministrateurSessionLocal) c.lookup("java:global/ProjetDassaultSystem/ProjetDassaultSystem-ejb/AdministrateurSession!Session.AdministrateurSessionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private UtilisateurSessionLocal lookupUtilisateurSessionLocal() {
        try {
            Context c = new InitialContext();
            return (UtilisateurSessionLocal) c.lookup("java:global/ProjetDassaultSystem/ProjetDassaultSystem-ejb/UtilisateurSession!Session.UtilisateurSessionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
        private ExpertSessionLocal lookupExpertSessionLocal() {
        try {
            Context c = new InitialContext();
            return (ExpertSessionLocal) c.lookup("java:global/ProjetDassaultSystem/ProjetDassaultSystem-ejb/ExpertSession!Session.ExpertSessionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
        
        private MarketeurSessionLocal lookupMarketeurSessionLocal() {
        try {
            Context c = new InitialContext();
            return (MarketeurSessionLocal) c.lookup("java:global/ProjetDassaultSystem/ProjetDassaultSystem-ejb/MarketeurSession!Session.MarketeurSessionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
        
        private OperateurVentesSessionLocal lookupOperateurVentesSessionLocal() {
        try {
            Context c = new InitialContext();
            return (OperateurVentesSessionLocal) c.lookup("java:global/ProjetDassaultSystem/ProjetDassaultSystem-ejb/OperateurVentesSession!Session.OperateurVentesSessionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
        private VendeurSessionLocal lookupVendeurSessionLocal() {
        try {
            Context c = new InitialContext();
            return (VendeurSessionLocal) c.lookup("java:global/ProjetDassaultSystem/ProjetDassaultSystem-ejb/VendeurSession!Session.VendeurSessionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}

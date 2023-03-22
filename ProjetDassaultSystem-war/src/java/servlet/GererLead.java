/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;


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
        
        else if(act.equals("CréerClient"))
        {
            jspDassault="/CreerClient.jsp";
            doActionCreerClient(request, response);
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
        
            protected void doActionCreerClient (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String nom = request.getParameter("login_utilisateur");
        String siret = request.getParameter("mdp_utilisateur");
        String message;
        
        if (nom.trim().isEmpty()|| siret.trim().isEmpty())
        {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
                    + "<br /> <a href =\"CreerClient.jsp\" > Cliquez ici </a> pour accéder au formulaire de création d'un organisateur.";
        }
        else 
        {
           
           //marketeurSession.CreerClient(nom, siret); !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
           message = "Client créé avec succès!";
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

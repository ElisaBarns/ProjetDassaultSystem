/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;


import Facade.ClientFacadeLocal;
import Facade.ContactFacadeLocal;
import Facade.Detail_offreFacadeLocal;
import Facade.EnregistrementFacadeLocal;
import Facade.OffreFacadeLocal;
import Facade.Piste_opportuniteFacadeLocal;
import Facade.ProduitFacadeLocal;
import Facade.ProfilFacadeLocal;
import Facade.UtilisateurFacadeLocal;
import Session.AdministrateurSessionLocal;
import Session.ExpertSessionLocal;
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

/**
 *
 * @author rober
 */
@WebServlet(name = "GererLead", urlPatterns = {"/GererLead"})
public class GererLead extends HttpServlet {

    AdministrateurSessionLocal administrateurSession = lookupAdministrateurSessionLocal();
    ExpertSessionLocal expertSession = lookupExpertSessionLocal();

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
        else if(act.equals("CreerUtilisateur"))
        {
            jspDassault="/CreerUtilisateur.jsp";
            doActionCreerUtilisateur(request, response);
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
        String nom = request.getParameter("nom_utilisateur");
        String prenom = request.getParameter("prenom_utilisateur");
        String login = request.getParameter("login_utilisateur");
        String mdp = request.getParameter("mdp_utilisateur");
        String mail = request.getParameter("mail_utilisateur");
        String tel = request.getParameter("tel_utilisateur");
        String inactif =request.getParameter("inactif");
        String creation=request.getParameter("date_creation");
        String inactivation=request.getParameter("date_inactivation");
        String modification=request.getParameter("date_modification");
        Date dateCreation;
        Date date_inactivation;
        Date date_modification;
        String message;
        
        if (nom.trim().isEmpty()|| prenom.trim().isEmpty()|| login.trim().isEmpty()|| mdp.trim().isEmpty()|| mail.trim().isEmpty())
        {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
                    + "<br /> <a href =\"CreerUtilisateur.jsp\" > Cliquez ici </a> pour accéder au formulaire de création d'un organisateur.";
        }
        else 
        {
           dateCreation = Date.valueOf(creation);
           date_inactivation = Date.valueOf(inactivation);
           date_modification = Date.valueOf(modification);
           administrateurSession.CreerUtilisateur(tel, mdp, nom, prenom, mail, tel, false, dateCreation, date_inactivation, date_modification);
           message = "Utilisateur créé avec succès!";
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

}

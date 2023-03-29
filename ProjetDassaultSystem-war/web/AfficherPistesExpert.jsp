<%-- 
    Document   : AfficherPistesExpert
    Created on : 20 mars 2023, 17:31:14
    Author     : Mel
--%>

<%@page import="Entity.Utilisateur"%>
<%@page import="Entity.Piste_opportunite"%>
<%@page import="java.util.List"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        
        <jsp:useBean id="lesPistes_opportunites" scope="request" class="java.util.List"></jsp:useBean> 
        

       <title>Les pistes et opportunités</title> 
        <link rel="stylesheet" href="CSS_Afficher.css">

    </head> 
    <body> 
 <img src="logo-Dassault.png" alt="Logo Dassault" class="logo-Dassault">      
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
  <div class="main-content">      
        <h1>Mes pistes et opportunités</h1> 
        <p> <% 
      String attribut = (String) request.getAttribute("message"); 
           HttpSession sess=request.getSession(true);
           Utilisateur u = (Utilisateur)sess.getAttribute("session");
        System.out.println("I6");
      out.println( attribut ); 
      %> </p>
    <TABLE border width=5%>
     <tr><TD>Identifiant</TD>
         <TD>Statut</TD>
         <TD>Type</TD>
         <TD>Niveau d'intéret</TD>
         <TD>Taux de réussite</TD>
         <TD>Niveau de risque</TD>
         <TD>Budget estimé</TD>
         <TD>Client</TD>
         <TD>Vendeur</TD>
         <TD>Date de création</TD>
         <TD>Date de modification</TD>
                 <%System.out.println("I7");%>

    <% List<Piste_opportunite> lesPO=lesPistes_opportunites; 
    for(Piste_opportunite po : lesPO){
    
    if(po.getExpert_technique()!=null && po.getExpert_technique().getUnUtilisateur()!=null && po.getExpert_technique().getUnUtilisateur().getId()==u.getId()){
    %>
  <tr>  <td><%=po.getId()%></td> 
        <td><%=po.getStatut()%></td>
        <td><%=po.getType()%></td>  
        <td><%=po.getNiveau_interet()%></td>
        <td><%=po.getTx_reussite()%> %</td>
        <td><%=po.getNiveau_risque()%></td> 
        <td><%=po.getBudget_estime()%> €</td>  
        <td><%=po.getLeClient().getNom_client() %></td>
        <td><%=po.getVendeur().getUnUtilisateur().getNom_utilisateur()%> <%=po.getVendeur().getUnUtilisateur().getPrenom_utilisateur() %></td>
        <td><%=po.getDate_creation_popp()%></td> 
        <td><%=po.getDate_modif_popp()%></td> 
   </tr><%}

    }%> 
    </TABLE>
      </div>             
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuExpert.jsp'">
        </span>
    </body> 
</html> 
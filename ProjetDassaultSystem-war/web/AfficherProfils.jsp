<%-- 
    Document   : AfficherProfils
    Created on : 24 mars 2023, 15:21:48
    Author     : Mel
--%>

<%@page import="java.util.List"%>
<%@page import="Entity.Profil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="lesProfils" scope="request" class="java.util.List"></jsp:useBean>
        <title>Les profils</title>
    </head>
    <body>
        <h1>Les profils</h1>
        <p> <%
      String attribut = (String) request.getAttribute("message");
      out.println( attribut );
      %> </p>
    <TABLE border width=50%>
     <tr> <TD>Identifiant</TD>
          <TD>Utilisateur</TD>
          <TD>Fonction</TD>
          <TD>Inactif</TD>
          <TD>Date de création</TD>
          <TD>Date d'inactivation</TD> </tr>
   <% List<Profil> lesProf=lesProfils;
   for(Profil p : lesProf){%>
   <tr> <td Width=15%><%=p.getId()%></td>
        <td Width=15%><%=p.getUnUtilisateur()%></td>
        <td Width=15%><%=p.getFonction()%></td>
        <td Width=15%><%=p.isInactif()%></td>
        <td Width=15%><%=p.getDate_creation_profil()%></td>
        <td Width=15%><%=p.getDate_inactif_profil()%></td>
   </tr><%}%>
     </TABLE> 
              
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuAdmin.jsp'"><br />
        </span>
        
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
</body></html>
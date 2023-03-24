<%-- 
    Document   : AfficherUtilisateur
    Created on : 22 mars 2023, 14:44:39
    Author     : Mel
--%>

<%@page import="Entity.Utilisateur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="Utilisateur" scope="session" class="Utilisateur"></jsp:useBean>
        
        <title>Afficher l'utilisateur recherché</title>
    </head>
    <body>
        <h1>Afficher l'utilisateur recherché</h1>
    <tr>
        <td Width=15%>Login : <%=Utilisateur.getLogin_utilisateur()%></td><br>
        <td Width=15%>Identifiant : <%=Utilisateur.getId()%></td><br>
        <td Width=15%>Nom : <%=Utilisateur.getNom_utilisateur()%></td><br>
        <td Width=15%>Prénom : <%=Utilisateur.getPrenom_utilisateur()%></td><br>
        <!--<td Width=15%>Mot de passe<%=Utilisateur.getMdp_utilisateur()%></td>-->
        <td Width=15%>Mail : <%=Utilisateur.getMail_utilisateur()%></td><br>
        <td Width=15%>Téléphone : <%=Utilisateur.getTel_utilisateur()%></td><br>
    
    </tr>
    <hr>
            <table><tr>
        
    </table>
    
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuAdmin.jsp'"><br />
        </span>
    
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
    
    </body>
</html>

<%-- 
    Document   : Menu
    Created on : 16 mars 2023, 17:01:57
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Administrateur</title>
    </head>
    <body>
        <p>
            <%
        String attribut = (String)request.getAttribute("message");
        out.println(attribut);
    %>

        </p>
        <h1>Que voulez-vous faire?</h1>
       
        <table>
            <!--<tr>
           <td Width =15%><A HREF ="Authentification.jsp">Authentification</A></td>
            </tr>-->
             
               
           <tr>
           <td Width =15%><A HREF ="RechercherUtilisateur.jsp">Rechercher un utilisateur</A></td>
               
           <td Width =15%><A HREF ="CreerUtilisateur.jsp">Créer un utilisateur</A></td>
           </tr>

          <tr> 
              <td Width =15%><A HREF ="ModifierUtilisateur.jsp">Modifier un utilisateur</A></td> </br>
              <td Width =15%><A HREF ="InactiverUtilisateur.jsp">Désactiver un utilisateur</A></td> </br>
              <td Width =15%><A HREF ="ModifierMdpUtilisateur.jsp">Modifier le mot de passe d'un utilisateur</A></td> </br>
           
              <td Width =15%><A HREF ="CreerProfil.jsp">Créer un profil</A></td> </br>
           </tr>

           <!--
            <tr> 
             <%--<td Width =15%><A HREF ="AfficherUnVetement.jsp">Afficher un vetement</A></td>--%>
            <td Width =15%><A HREF ="RechercherVetement.jsp">Rechercher vetement</A></td>
            <%-- <td Width =15%><A HREF ="AfficherUnAccessoire.jsp">Afficher un accessoire</A></td>--%>
            <td Width =15%><A HREF ="RechercherAccessoire.jsp">Rechercher accessoire</A></td>
            <%--<td Width =15%><A HREF ="AfficherMannequin.jsp">Afficher un mannequin</A></td>--%>
            <td Width =15%><A HREF ="RechercherMannequin.jsp">Rechercher mannequin</A></td>
            <td Width =15%><A HREF ="RechercherOrganisateur.jsp">Rechercher organisateur</A></td>
            <td Width =15%><A HREF ="RechercherDefileDunOrganisateur.jsp">Rechercher les défilés d'un organisateur</A></td>
            </tr>
           -->
       </tr>
        
      
        </table>
            
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuGeneral.jsp'"><br />
        </span>
            
        <span class="SeDeconnecter">
            <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
    </body>
</html>

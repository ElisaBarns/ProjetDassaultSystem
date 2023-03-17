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
        <title>JSP Page</title>
    </head>
    <body>
        <p>
            <%
        String attribut = (String)request.getAttribute("message");
        out.println(attribut);
    %>

        </p>
        <h1>Que voulez-vous faire?</h1>
       
        <table><tr>
           <td Width =15%><A HREF ="Authentification.jsp">Authentification</A></td></tr>
             
               
           <tr>
           <td Width =15%><A HREF ="CreerUtilisateur.jsp">Créer un utilisateur</A></td>
           <!--
           <td Width =15%><A HREF ="creerOrganisateur.jsp">Creer organisateur</A></td>
           <td Width =15%><A HREF ="CreerLieu.jsp">Creer lieu</A></td>  
           <td Width =15%><A HREF ="CreerCouturier.jsp">Creer couturier</A></td> 
           <td Width =15%><A HREF ="AccesDefiles?action=CreerVetement">Creer vetement</A></td> 
           <td Width =15%><A HREF ="CreerAccessoire.jsp">Creer accessoire</A></td> 
           <td Width =15%><A HREF ="CreerMannequin.jsp">Creer mannequin</A></td>
           </tr>
           -->
        
          
           
          <tr> 
           <td Width =15%><A HREF ="ModifierUtilisateur.jsp">Modifier un utilisateur</A></td> 
           <td Width =15%><A HREF ="InactiverUtilisateur.jsp">Désactiver un utilisateur</A></td> 
           <td Width =15%><A HREF ="AttribuerRolesUtilisateur.jsp">Attribuer un ou plusieurs rôles à un utilisateur</A></td>
           <td Width =15%><A HREF ="ModifierMdpUtilisateur.jsp">Modifier le mot de passe d'un utilisateur</A></td>
           </tr>
           
           
           <!--
           <tr>
           <td Width =15%><A HREF ="SupprimerAccessoire.jsp">Supprimer Accessoire</A></td>
           <td Width =15%><A HREF ="SupprimerVetement.jsp">Supprimer Vetement</A></td>
           <td Width =15%><A HREF ="SupprimerMannequin.jsp">Supprimer Mannequin</A></td>
           </tr>
           -->
           
            
           <!--
           <tr>
           <td Width =15%><A HREF ="AccesDefiles?action=AfficherDefile">Afficher tous les defiles</A></td>
           <td Width =15%><A HREF ="AccesDefiles?action=AfficherOrganisateur">Afficher tous les organisateurs</A></td>
           <td Width =15%><A HREF ="AccesDefiles?action=AfficherVetement">Afficher tous les vêtements</A></td>
           <td Width =15%><A HREF ="AccesDefiles?action=AfficherAccessoire">Afficher tous les accessoires</A></td>
           </tr>
           -->
           
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
    </body>
</html>

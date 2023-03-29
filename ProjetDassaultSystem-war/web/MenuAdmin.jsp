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
        <link rel="stylesheet" href="CSS_Menu.css">
        
    </head>
    <body>
        <img src="logo-Dassault.png" alt="Logo Dassault" class="logo-Dassault">
                <span class="SeDeconnecter">
            <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
                </span>
        
        <p>
            <%
        String attribut = (String)request.getAttribute("message");
        //out.println(attribut);
    %>


        </p>
        <h1>Que voulez-vous faire?</h1>
       
        <table>
            <!--<tr>
           <td Width =15%><A HREF ="Authentification.jsp">Authentification</A></td>
            </tr>-->
             
               
           <tr>
        <td>
            <div class="menu-items">
                <A HREF ="RechercherUtilisateur.jsp">Rechercher un utilisateur</A><br/>  
                <A HREF ="CreerUtilisateur.jsp">Créer un utilisateur</A><br/>
                <A HREF ="ModifierUtilisateur.jsp">Modifier un utilisateur</A><br/>
                <A HREF ="InactiverUtilisateur.jsp">Désactiver un utilisateur</A><br/>
                <A HREF ="ModifierMdpUtilisateur.jsp">Modifier le mot de passe d'un utilisateur</A><br/>
                <A HREF ="CreerProfil.jsp">Créer un profil</A><br/>
                <A HREF ="GererLead?action=AfficherProfils">Afficher la liste des profils</A><br/>
            </div>
        </td>
    </tr>
      
        </table>
            
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuGeneral.jsp'"><br />
        </span>
            
    </body>
</html>

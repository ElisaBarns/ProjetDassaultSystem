<%-- 
    Document   : InactiverUtilisateur
    Created on : 20 mars 2023, 17:07:38
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Désactiver un utilisateur</title>
    </head>
    <body>
                
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <fieldset>
    <h1>Informations de l'utilisateur à modifier</h1>
    <form action="GererLead" method="post">
                    
        <label for="login_utilisateur">Login</label>
        <input type="text" id="login_utilisateur" name="login_utilisateur">
        <br/>
        <!--
        <label for="inactif">Inactiver <span class=""></span></label>
        <input type="checkbox" id="inactif" name="inactif" value="<%=request.getParameter("inactif")%>" readonly>
        -->
        <br/>
        

        <input type="hidden" name="action" value="InactiverUtilisateur">
       
        <input type="submit" value="Désactiver">
        <input type="button" value="Annuler">

    </form>
        
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuAdmin.jsp'"><br />
        </span>

        
    </body>
</html>

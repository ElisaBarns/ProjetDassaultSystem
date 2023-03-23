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
        <input type="button" value="Annuler" onclick="location.href='MenuGeneral.jsp'">
        
            <hr>
            <td Width=25%><A HREF="GererLead?action=vide"> Retour Menu</A></td>
            <hr>
    </form>
    </body>
</html>

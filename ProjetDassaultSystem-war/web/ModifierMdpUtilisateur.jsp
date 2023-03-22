<%-- 
    Document   : ModifierMdpUtilisateur
    Created on : 20 mars 2023, 17:18:00
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modification du mot de passe d'un utilisateur</title>
    </head>
    <body>
        <fieldset>
    <h1>Informations de l'utilisateur</h1>
    <form action="GererLead" method="post">
                    
                    <label for="login_utilisateur">Login de l'utilisateur à modifier</label>
                    <input type="text" id="login_utilisateur" name="login_utilisateur">
                    <br/>
        
                    <label for="mdp_utilisateur">Nouveau mot de passe <span class="requis"></span></label>
                    <input type="text" id="mdp_utilisateur" name="mdp_utilisateur">
                    <br/>
                    
                    <input type="hidden" name="action" value="ModifierMdpUtilisateur">
       
        <input type="submit" value="Modifier">
        <input type="button" value="Annuler" onclick="location.href='MenuGeneral.jsp'">

    </form>
    </body>
</html>

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
        <img src="logo-Dassault.png" alt="Logo Dassault" class="logo-Dassault">        
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
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
        <input type="reset" value="Annuler">

    </form>
        
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuAdmin.jsp'"><br />
        </span> 

    
    </body>
</html>

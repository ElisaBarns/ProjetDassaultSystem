<%-- 
    Document   : ModifierProfil
    Created on : 23 mars 2023, 10:23:04
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modification du profil d'un utilisateur</title>
    </head>
    <body>
           
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <fieldset>
    <h1>Informations de l'utilisateur</h1>
    <form action="GererLead" method="post">
                    
                    <label for="login_utilisateur">Login de l'utilisateur à modifier</label>
                    <input type="text" id="login_utilisateur" name="login_utilisateur">
                    <br/>
        
                    <label for="p">Nouveau profil <span class="requis"></span></label>
                    <input type="text" id="p" name="p">
                    <br/>
                    
                    <input type="hidden" name="action" value="ModifierProfil">
       
        <input type="submit" value="Modifier">
        <input type="reset" value="Annuler">

    </form>
                        
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuAdmin.jsp'"><br />
        </span> 

   
    </body>
</html>
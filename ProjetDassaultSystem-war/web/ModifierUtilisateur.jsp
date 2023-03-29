<%-- 
    Document   : ModifierUtilisateur
    Created on : 16 mars 2023, 16:24:21
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modification d'un utilisateur</title>
    </head>
    <body>
        <img src="logo-Dassault.png" alt="Logo Dassault" class="logo-Dassault">    
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <fieldset>
    <h1>Informations de l'utilisateur à désactiver</h1>
    <form action="GererLead" method="post">
                    
                    <label for="login_utilisateur">Login</label>
                    <input type="text" id="login_utilisateur" name="login_utilisateur">
                    <br/>
        
                    <label for="nom_utilisateur">Nom <span class="requis"></span></label>
                    <input type="text" id="nom_utilisateur" name="nom_utilisateur">
                    <br/>
                    <label for="prenom_utilisateur">Prénom <span class="requis"></span></label>
                    <input type="text" id="prenom_utilisateur" name="prenom_utilisateur">
                    <br/>
                    
                    <label for="mail_utilisateur">Mail <span class="requis"></span></label>
                    <input type="text" id="mail_utilisateur" name="mail_utilisateur">
                    <br/>
                    <label for="tel_utilisateur">Téléphone <span class=""></span></label>
                    <input type="text" id="tel_utilisateur" name="tel_utilisateur">
                    <br/>

                    <input type="hidden" name="action" value="ModifierUtilisateur">
       
        <input type="submit" value="Modifier">
        <input type="reset" value="Annuler">

    </form>
         
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuAdmin.jsp'"><br />
        </span> 

    
    </body>
</html>
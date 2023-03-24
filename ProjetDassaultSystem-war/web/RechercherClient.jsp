<%-- 
    Document   : RechercherClient
    Created on : 22 mars 2023, 21:52:49
    Author     : marie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rechercher un Client</title>
        <link rel="stylesheet" href="CSS.css">
    </head>
    <body>
        
         <form method="get" action="GererLead">
            <fieldset>
                <legend>Rechercher un Client</legend>
                <label for ="login_utilisateur">Login <span class="requis">*</span></label>
                <input type="text"id="login_utilisateur" name="login_utilisateur"value=""size="20"maxlength="20"/>
                <br/>                
                 <input type="hidden"name="action"value="RechercherClient">
            </fieldset>
            <input type="submit"value="Valider"/>
            <input type="reset"value="Annuler"/><br/>
            </form>
                       
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuMarketeur.jsp'"><br />
        </span> 
        
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
    </body>
</html>

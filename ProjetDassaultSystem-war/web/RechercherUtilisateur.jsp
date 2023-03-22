<%-- 
    Document   : RechercherUtilisateur
    Created on : 22 mars 2023, 14:41:59
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rechercher un utilisateur</title>
    </head>
    <body>
        
         <form method="get" action="GererLead">
            <fieldset>
                <legend>Rechercher un utilisateur</legend>
                <label for ="login_utilisateur">Login<span class="requis">*</span></label>
                <input type="text"id="login_utilisateur" name="login_utilisateur"value=""size="20"maxlength="20"/>
                <br/>                
                 <input type="hidden"name="action"value="RechercherUtilisateur">
            </fieldset>
            <input type="submit"value="Valider"/>
            <input type="reset"value="Remettre à zéro"/><br/>
            </form>
    </body>
</html>

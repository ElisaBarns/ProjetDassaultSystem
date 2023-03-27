<%-- 
    Document   : RechercherProduit
    Created on : 27 mars 2023, 14:25:41
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rechercher un produit</title>
    </head>
    <body>
            
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
         <form method="get" action="GererLead">
            <fieldset>
                <legend>Rechercher un produit</legend>
                <label for ="nom_produit">Nom du produit <span class="requis"></span></label>
                <input type="text"id="nom_produit" name="nom_produit"value=""size="20"maxlength="20"/>
                <br/>                
                 <input type="hidden"name="action"value="RechercherProduit">
            </fieldset>
            <input type="submit"value="Valider"/>
            <input type="reset"value="Annuler"/><br/>
            </form>
                 
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuExpert.jsp'"><br />
        </span> 

        
    </body>
</html>


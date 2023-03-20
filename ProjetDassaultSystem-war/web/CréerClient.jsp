<%-- 
    Document   : CréerClient
    Created on : 19 mars 2023, 18:29:01
    Author     : marie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Création d'un client</title>
    </head>
    <body>
        <h1>Nouveau Client</h1>
        
        <div>
            <form method="post" action="GererLead">
                <fieldset>
                    <legend>Informations du client</legend>
                    <br/><!-- comment -->          
                    <label for="nom_client">Nom <span class="requis"></span></label>
                    <input type="text" id="nom_client" name="nom_client" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="siret">SIRET <span class="requis"></span></label>
                    <input type="text" id="siret" name="siret" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="inactif">Inactiver <span class=""></span></label>
                    <input type="checkbox" id="inactif" name="inactif" value="non">
                    <br/>
                    
                    <input type="hidden" name="action" value="CreerClient">
                    
                </fieldset>
                <input type="submit" value="Valider" /> 
                <input type="reset" value="Vider les champs" /> <br />
                        
                <hr>
                <td Width=25%><A HREF="GererLead?action=vide">Retour Menu</A></td>
                <hr>
            </form>
        </div>
        
    </body>
</html>

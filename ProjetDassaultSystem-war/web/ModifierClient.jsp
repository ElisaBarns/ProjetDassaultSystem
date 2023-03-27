<%-- 
    Document   : ModifierClient
    Created on : 23 mars 2023, 00:14:26
    Author     : marie
--%>

<%@page import="Entity.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modification d'un Client</title>
        <link rel="stylesheet" href="CSS.css">
    </head>
    <body>
                
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <h1>Modifier un Client</h1>
        
        <div>
        <form method="get" action="GererLead">
        <fieldset>
        <legend>Informations du Client </legend>
 
        <label for="clientId">Identifiant client <span class="requis"></span></label>
        <input type="text" id="clientId" name="clientId" value="" size"20" maxlength="20"/>
                    <br/>        
        <label for="nom_client">Nom <span class=""></span></label>
        <input type="text" id="nom_client" name="nom_client" value="" size"20" maxlength="20"/>
                    <br/>
        <label for="siret">SIRET <span class=" "></span></label>
        <input type="text" id="siret" name="siret" value="" size"20" maxlength="20"/>
                    <br/>
        
        
        <input type="hidden" name="action" value="ModifierClient">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Annuler" /> <br />
        </form>
        </div>
              
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuVendeur.jsp'"><br />
        </span> 

        
    </body>
</html>

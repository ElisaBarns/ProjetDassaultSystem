<%-- 
    Document   : ModifierPiste
    Created on : 27 mars 2023, 01:44:07
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modification d'une piste/opportunité</title>
    </head>
    <body>
        <fieldset>
    <h1>Informations de la piste/opportunité</h1>
    <form action="GererLead" method="post">
                    
                    <label for="id">Identifiant de la piste</label>
                    <input type="text" id="id" name="id">
                    <br/>
                    <tr><td>Niveau d'intérêt </td><td><SELECT size="1" name="niveau_interet"> 
                    <OPTION value ="bas">Bas</OPTION> 
                    <OPTION value ="medium">Medium</OPTION> 
                    <OPTION value ="haut">Haut</OPTION> 
                    </SELECT></td></tr>
                    <br/>
                    <br/>
                    <label for="tx_reussite">Taux de réussite <span class="requis"></span></label>
                    <input type="text" id="tx_reussite" name="tx_reussite">
                    <br/>
                    <tr><td>Niveau de risque </td><td><SELECT size="1" name="niveau_risque"> 
                    <OPTION value ="bas">Bas</OPTION> 
                    <OPTION value ="medium">Medium</OPTION> 
                    <OPTION value ="haut">Haut</OPTION> 
                    </SELECT></td></tr>
                    <br/>
                    <br/>
                    <label for="budget_estime">Budget estimé <span class=""></span></label>
                    <input type="text" id="budget_estime" name="budget_estime">
                    <br/>
                    <label for="nom_client">Nom du client <span class="requis"></span></label>
                    <input type="text" id="nom_client" name="nom_client" value="" size"50" maxlength="50"/>
                    <br/>

                    <input type="hidden" name="action" value="ModifierPiste">
       
        <input type="submit" value="Modifier">
        <input type="reset" value="Annuler">

    </form>
         
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuMarketeur.jsp'"><br />
        </span> 
    
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
    
    </body>
</html>
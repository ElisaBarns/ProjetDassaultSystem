<%-- 
    Document   : CreerClient
    Created on : 19 mars 2023, 18:29:01
    Author     : marie
--%>
<%@page import="Entity.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Création d'un Client</title>
    </head>
    <body>
        <h1>Nouveau Client</h1>
        
        <div>
            <form method="post" action="GererLead">
                <fieldset>
                    <legend>Informations du client</legend>
                    <br/><!-- comment -->          
                    <label for="nom_client">Nom <span class="requis"></span></label>
                    <input type="text" id="nom_client" name="nom_client" value="" size"20" maxlength="50"/>
                    <br/>
                    <label for="siret">SIRET <span class="requis"></span></label>
                    <input type="text" id="siret" name="siret" value="" size"20" maxlength="20"/>
                    <br/>
                    <br/>
                    <legend>Informations du contact attaché</legend>
                    <br/><!-- comment -->          
                    <label for="nom_contact">Nom <span class="requis"></span></label>
                    <input type="text" id="nom_contact" name="nom_contact" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="prenom_contact">Prénom <span class="requis"></span></label>
                    <input type="text" id="prenom_contact" name="prenom_contact" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="mail">E-mail <span class="requis"></span></label>
                    <input type="text" id="mail" name="mail" value="" size"50" maxlength="50"/>
                    <br/>
                    <label for="tel">Téléphone <span class="requis"></span></label>
                    <input type="text" id="tel" name="tel" value="" size"20" maxlength="20"/>
                    <br/>
                    
                    
                    <input type="hidden" name="action" value="CreerClient">
                    
                </fieldset>
                <input type="submit" value="Valider" /> 
                <input type="reset" value="Annuler" /> <br />
                
            </form>
        </div>
        
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuMarketeur.jsp'"><br />
        </span> 
        
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
    </body>
</html>

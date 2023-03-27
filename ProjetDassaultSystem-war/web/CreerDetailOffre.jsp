<%-- 
    Document   : CreerDetailOffre
    Created on : 27 mars 2023, 15:26:47
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Création d'un détail offre</title>
    </head>
    <body>
        <h1>Nouveau Détail offre</h1>
        
        <div>
            <form method="post" action="GererLead">
                <fieldset>
                    <legend>Informations du détail de l'offre</legend>
                    <br/>         
                    <label for="id_offre">Identifiant de l'offre <span class="requis"></span></label>
                    <input type="text" id="id_offre" name="id_offre" value="" size"50" maxlength="50"/>
                    <br/>
                    <label for="nom_produit">Nom du produit <span class="requis"></span></label>
                    <input type="text" id="nom_produit" name="nom_produit" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="quantite">Quantité <span class="requis"></span></label>
                    <input type="text" id="quantite" name="quantite" value="" size"20" maxlength="20"/>
                    <br/>
                    
                    <input type="hidden" name="action" value="CreerDetailOffre">
                    
                </fieldset>
                <input type="submit" value="Valider" /> 
                <input type="reset" value="Annuler" /> <br />
                
            </form>
        </div>
        
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuExpert.jsp'"><br />
        </span> 
        
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
    </body>
</html>


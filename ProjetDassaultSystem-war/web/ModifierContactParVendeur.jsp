<%-- 
    Document   : ModifierContactParVendeur
    Created on : 29 mars 2023, 01:16:05
    Author     : Mel
--%>

<%@page import="java.util.List"%>
<%@page import="Entity.Contact"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modification d'un Contact</title>
        <link rel="stylesheet" href="CSS.css">
    </head>
    <body>
        <img src="logo-Dassault.png" alt="Logo Dassault" class="logo-Dassault">        
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <h1>Modifier un Contact</h1>
        
        <div>
        <form method="get" action="GererLead">
        <fieldset>
        <legend>Informations du contact </legend>
        <label for="id_contact">Identifiant contact <span class="requis"></span></label>
        <input type="text" id="id_contact" name="id_contact" value="" size"20" maxlength="20"/>
                    <br/> 
        <label for="nom_contact">Nom <span class="requis"></span></label>
        <input type="text" id="nom_contact" name="nom_contact" value="" size"20" maxlength="20"/>
                    <br/>
        <label for="prenom_contact">Prénom <span class="requis"></span></label>
        <input type="text" id="prenom_contact" name="prenom_contact" value="" size"20" maxlength="20"/>
                    <br/>
        <label for="mail_contact">e-mail <span class="requis"></span></label>
        <input type="text" id="mail_contact" name="mail_contact" value="" size"50" maxlength="50"/>
                    <br/>
        <label for="tel_contact">Téléphone <span class="requis"></span></label>
        <input type="text" id="tel_contact" name="tel_contact" value="" size"20" maxlength="20"/>
                    <br/>
        
        <input type="hidden" name="action" value="ModifierContactParVendeur">
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
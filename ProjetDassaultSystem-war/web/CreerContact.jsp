<%-- 
    Document   : CreerClient
    Created on : 22 mars 2023, 20:59:46
    Author     : marie
--%>

<%@page import="java.util.List"%>
<%@page import="Entity.Client"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Création d'un Contact</title>
        <link rel="stylesheet" href="CSS.css">
    </head>
    <body>
        <h1>Nouveau Contact</h1>
        
        <div>
            <form method="post" action="GererLead">
                <fieldset>
                    <legend>Sélection du client concerné </legend>
        <label for="id_client">Identifiant client <span class="requis">*</span></label>
        <select name="id_client">
        <% for (Client cl :lesClients) {%>
        <option value ="<%=cl.getId()%>"><%=cl.getNom_client()%></option>
        <% }%>
        </select>
        <br />
                    <legend>Informations du contact</legend>
                    <br/><!-- comment -->          
                    <label for="nom_contact">Nom <span class="requis"></span></label>
                    <input type="text" id="nom_contact" name="nom_contact" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="prenom_contact">Prénom <span class="requis"></span></label>
                    <input type="text" id="prenom_contact" name="prenom_contact" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="mail">e-mail <span class="requis"></span></label>
                    <input type="text" id="mail" name="mail" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="tel">Téléphone <span class="requis"></span></label>
                    <input type="text" id="tel" name="tel" value="" size"20" maxlength="20"/>
                    <br/>
                    
                    <input type="hidden" name="action" value="CreerContact">
                    
                </fieldset>
                <input type="submit" value="Valider" /> 
                <input type="reset" value="Vider les champs" /> <br />
                        
                <hr>
                <td Width=25%><A HREF="GererLead?action=vide">Retour</A></td>
                <hr>
            </form>
        </div>
        
    </body>
</html>
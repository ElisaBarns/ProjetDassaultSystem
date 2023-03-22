<%-- 
    Document   : CreerPiste
    Created on : 22 mars 2023, 21:19:58
    Author     : marie
--%>

<%@page import="Entity.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Création d'une Piste</title>
        <link rel="stylesheet" href="CSS.css">
        <jsp:useBean id="listeclients" scope="request" class="java.util.List"></jsp:useBean>
        
    </head>
    <body>
        <h1>Nouvelle Piste</h1>
        
        
        
        <div>
            <form method="post" action="GererLead">
                <fieldset>
                    <legend>Informations de la piste</legend>
                    <br/><!-- comment -->          
                    <label for="niveau_interet">Niveau d'intérêt de la piste <span class="requis"></span></label>
                    <input type="text" id="niveau_interet" name="niveau_interet" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="tx_reussite">Taux de réussite estimé <span class="requis"></span></label>
                    <input type="text" id="tx_reussite" name="tx_reussite" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="budget_estime">Budget estimé du client <span class="requis"></span></label>
                    <input type="text" id="budget_estime" name="budget_estime" value="" size"20" maxlength="20"/>
                    <br/>
                    <legend>Choisir le client concerné </legend>
                        <label for="id_client">Identifiant du client <span class="requis">*</span></label>
                        <select name="id_client">
                        <% for (Client c :lesClients) {%>
                        <option value ="<%=c.getId()%>"><%=c.getId()%></option>
                        <% }%>
                        </select>
                    //si client à créer ??
                    
                    <input type="hidden" name="action" value="CreerPiste">
                    
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

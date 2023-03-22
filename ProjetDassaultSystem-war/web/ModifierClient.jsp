<%-- 
    Document   : ModifierClient
    Created on : 23 mars 2023, 00:14:26
    Author     : marie
--%>

<%@page import="java.util.List"%>
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
        
        <h1>Modifier un Client</h1>
        <% List<Client> listeClients = lesClients;%>
        <div>
        <form method="get" action="GererLead">
        <fieldset>
        <legend>Informations du Client </legend>
        <label for="id_client">Identifiant <span class="requis">*</span></label>
        <select name="id_client">
        <% for (Client c :listeClients) {%>
        <option value ="<%=c.getId()%>"><%=c.getNom_client()%></option>
        <% }%>
        </select>
        <br />
        
        <label for="nom_client">Nom <span class="requis"></span></label>
        <input type="text" id="nom_client" name="nom_client" value="" size"20" maxlength="20"/>
                    <br/>
        <label for="siret">SIRET <span class="requis"></span></label>
        <input type="text" id="siret" name="siret" value="" size"20" maxlength="20"/>
                    <br/>
        
        
        <input type="hidden" name="action" value="ModifierClient">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
        </div>
        
        
    </body>
</html>

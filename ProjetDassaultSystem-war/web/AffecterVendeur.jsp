<%-- 
    Document   : AffecterVendeur
    Created on : 23 mars 2023, 10:20:23
    Author     : marie
--%>

<%@page import="java.util.List"%>
<%@page import="Entity.Profil"%>
<%@page import="Entity.Piste_opportunite"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Affecter un Vendeur</title>
        <link rel="stylesheet" href="CSS.css">
        <jsp:useBean id="listevendeur" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="piste" scope="request" class="Entity.Piste_opportunite"></jsp:useBean>
    </head>
    <body>
        <h1>Affectation d'un Vendeur</h1>
    <% List<Profil> lesvendeurs=listevendeur;%>
        <div>
        <form method="get" action="GererLead">
        <fieldset>
        <legend>Information de la piste</legend>
        <label for="id_piste">Identifiant <span class="requis">*</span></label>
        <select name="id_piste">
      
        <option value ="<%=piste.getId()%>">  %></option>
        <% }%>
        </select>
        <br />
        
        <label for="prixDej">Prix petit déjeuner <span class="requis">*</span></label>
       <input type="text" name="prixDej" value="" size=“80" maxlength="20" />
        
        <input type="hidden" name="action" value="changerprixdej">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
        </div>
        
        
    </body>
</html>

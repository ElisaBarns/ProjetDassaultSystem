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
                
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <h1>Affectation d'un Vendeur</h1>
    <% List<Profil> lesvendeurs=listevendeur;%>
        <div>
        <form method="get" action="GererLead">
        <fieldset>
        <legend>Information de la piste</legend>
        <label for="id_piste">Identifiant de la piste <span class="requis">*</span></label>
        <select name="id_piste">
      
        <option value ="<%=piste.getId()%>">  %></option>
        <% }%>
        </select>
        <br />
        
        <input type="hidden" name="action" value="AffecterVendeur">
        </fieldset>
        
        <input type="submit" value="Valider" />
        <input type="reset" value="Annuler" /> <br />
        </form>
        </div>

                
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuMarketeur.jsp'"><br />
        </span>
        
    </body>
</html>

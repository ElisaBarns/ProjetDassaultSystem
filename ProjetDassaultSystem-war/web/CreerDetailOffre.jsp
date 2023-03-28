<%-- 
    Document   : CreerDetailOffre
    Created on : 27 mars 2023, 15:26:47
    Author     : Mel
--%>

<%@ page import="Entity.Offre" %>
<%@ page import="Entity.Produit" %>
<%@ page import="Entity.Detail_offre" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<% System.out.println("Test Mel 1");
%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="LesOffres" scope="request" class="java.util.List"></jsp:useBean>
<% System.out.println("Test Mel 2");
%>
        <jsp:useBean id="LesProduits" scope="request" class="java.util.List"></jsp:useBean>
<% System.out.println("Test Mel 3");
%>
        <link rel="stylesheet" href="CSS.css">
        <title>Création d'un détail offre</title>
    </head>
    <body>
                
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <h1>Nouveau Détail offre</h1>
        
        <div>
            <form method="post" action="GererLead">
                <fieldset>
                    <legend>Informations du détail de l'offre</legend>
                    <br/>         
<tr><td>Identifiant de l'offre </td><td><SELECT size="1" name="id_offre"> 
<% System.out.println("O1");
for(int i = 0; i<LesOffres.size(); i++) {
    Offre o = (Offre)LesOffres.get(i);
%>
    <OPTION value ="<%=o.getId()%>"><%=o.getId() %> </OPTION>
<%
}
%>
</SELECT></td></tr>
                    <br/>
                    <br/>
<tr><td>Nom du produit </td><td><SELECT size="1" name="nom_produit"> 
<% System.out.println("O2");
for(int i = 0; i<LesProduits.size(); i++) {
    Produit p = (Produit)LesProduits.get(i);
%>
    <OPTION value ="<%=p.getId()%>"><%=p.getNom_produit() %> </OPTION>
<%
}
%>
</SELECT></td></tr>
                    <br/>
                    <br/>
                    <label for="quantite">Quantité <span class="requis"></span></label>
                    <input type="text" id="quantite" name="quantite" value="" size="20" maxlength="20"/>
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

        
    </body>
</html>


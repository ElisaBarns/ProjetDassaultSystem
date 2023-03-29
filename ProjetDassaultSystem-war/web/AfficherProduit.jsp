<%-- 
    Document   : AfficherProduit
    Created on : 27 mars 2023, 14:27:10
    Author     : Mel
--%>

<%@page import="Entity.Produit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS_Afficher.css">

        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="Produit" scope="session" class="Produit"></jsp:useBean>
        
        <title>Afficher le produit recherché</title>
    </head>
    <body>
            
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <h1>Afficher le produit recherché</h1>
    <tr>
        <td Width=15%>Identifiant : <%=Produit.getId()%></td><br>
        <td Width=15%>Nom : <%=Produit.getNom_produit()%></td><br>
        <td Width=15%>Description commerciale : <%=Produit.getDescription_commerciale()%></td><br>
        <td Width=15%>Prix unitaire : <%=Produit.getPu_produit()%></td><br>
        <td Width=15%>Inactif : <%=Produit.isInactif()%></td><br>
        <td Width=15%>Date de création : <%=Produit.getDate_creation_produit()%></td><br>
        <td Width=15%>Date de la dernière modification : <%=Produit.getDate_modif_produit()%></td><br>
        <td Width=15%>Date d'inactivation : <%=Produit.getDate_inactivation_produit()%></td><br>
    
    </tr>
    <hr>
            <table><tr>
        
    </table>
    
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuExpert.jsp'"><br />
        </span>

    
    </body>
</html>


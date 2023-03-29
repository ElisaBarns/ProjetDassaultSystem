<%-- 
    Document   : AfficherListeMarketeur
    Created on : 23 mars 2023, 09:33:06
    Author     : marie
--%>

<%@page import="Entity.Utilisateur"%>
<%@page import="Entity.Piste_opportunite"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="lesPistes_opportunites" scope="request" class="java.util.List"></jsp:useBean>
        <title>Les pistes et opportunités</title>
        <link rel="stylesheet" href="CSS_Afficher.css">
    </head>
    <body>
        <img src="logo-Dassault.png" alt="Logo Dassault" class="logo-Dassault">
        
        <span class="SeDeconnecter">
            <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>

        <div class="main-content">
            <h1>Mes pistes et opportunités</h1>
            <p>
                <% 
                String attribut = (String) request.getAttribute("message"); 
                HttpSession sess=request.getSession(true);
                Utilisateur u = (Utilisateur)sess.getAttribute("session");
                //out.println(attribut);
                %>
            </p>
            <table>
                <tr>
                    <th>Identifiant</th>
                    <th>Statut</th>
                    <th>Type</th>
                    <th>Niveau d'intéret</th>
                    <th>Taux de réussite</th>
                    <th>Niveau de risque</th>
                    <th>Budget estimé</th>
                    <th>Client</th>
                    <th>Vendeur</th>
                    <th>Date de création</th>
                    <th>Date de modification</th>
                </tr>
                <% List<Piste_opportunite> lesPO=lesPistes_opportunites;
                for(Piste_opportunite po : lesPO){
                if(po.getMarketeur()!=null && po.getMarketeur().getUnUtilisateur()!=null && po.getMarketeur().getUnUtilisateur().getId()==u.getId()){
                %>
                <tr>
                    <td><%=po.getId()%></td>
                    <td><%=po.getStatut()%></td>
                    <td><%=po.getType()%></td>
                    <td><%=po.getNiveau_interet()%></td>
                    <td><%=po.getTx_reussite()%> %</td>
                    <td><%=po.getNiveau_risque()%></td>
                    <td><%=po.getBudget_estime()%> €</td>
                    <td><%=po.getLeClient().getNom_client() %></td>
                    <%if(po.getVendeur()!=null){%>
                        <td><%=po.getVendeur().getUnUtilisateur().getNom_utilisateur()%> <%=po.getVendeur().getUnUtilisateur().getPrenom_utilisateur() %></td>
                    <%}else{%>
                        <td></td>
                    <%}%>
                    <td><%=po.getDate_creation_popp()%></td>
                    <td><%=po.getDate_modif_popp()%></td>
                </tr>
                <%}
                }%>
            </table>
        </div>
                   
        <span class="RetourMenu">
            <input type="button" value="Retour" onclick="location.href='MenuMarketeur.jsp'">
        </span>
    </body> 
</html> 

<%-- 
    Document   : AfficherPistesExpert
    Created on : 20 mars 2023, 17:31:14
    Author     : Mel
--%>

<%@page import="Entity.Piste_opportunite"%>
<%@page import="java.util.List"%> 

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:useBean id="listePistes" scope="request" class="java.util.List"></jsp:useBean> 
<!DOCTYPE html> 
    <html> 
        <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Mes pistes et opportunités</title> 
        </head> 
    <body> 
    <h1>Mes pistes et opportunités</h1> 
    <p> 
    <% 
    String attribut = (String) request.getAttribute("message"); 
    out.println( attribut ); 
    %> 
    </p> 
 
    <p class="info">${ message }</p> 
    <p class="info">${ message }</p> 
    <% List<Piste_opportunite> listePistes=listePistes; 
    for(Piste_opportunite po : listePistes){%> 
    <tr> 
    <td Width=15%><%=po.getId()%></td> 
    <td Width=30%><%=po.getDate_creation_popp()%></td> 
    <td Width=15%><%=po.getDate_modif_popp()%></td> 
    <td Width=15%><%=po.getNiveau_interet()%></td> 
    <td Width=15%><%=po.getNiveau_risque()%></td> 
    <td Width=15%><%=po.getBudget_estime()%></td> 
    <td Width=15%><%=po.getType()%></td> 
    <td Width=15%><%=po.getStatut()%></td> 
    <td Width=15%><%=po.getMarketeur()%></td>
    <td Width=15%><%=po.getVendeur()%></td> 
    <!--Pas besoin de l'expert technique puisque c'est l'utilisateur qui est censé consulter cette liste-->
    <!--Pas besoin de l'enregistrement-->
    <td Width=15%><%=po.getLeClient()%></td> 
    <td Width=55%><%out.println(); %></td> 
    </tr><%}%> 
 <hr> 
 <br> 
    <td Width=25%><A HREF="GererLead?action=vide"> Retour Menu</A></td> 
 <hr> 
    </body> 
</html> 
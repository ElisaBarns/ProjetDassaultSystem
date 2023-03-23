<%-- 
    Document   : AfficherListeMarketeur
    Created on : 23 mars 2023, 09:33:06
    Author     : marie
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
        <link rel="stylesheet" href="CSS.css">
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
    <td Width=15%><%=po.getVendeur()%></td> 
    <!--Pas besoin de l'enregistrement-->
    <td Width=15%><%=po.getLeClient()%></td>
    <td Width=15%><input type="submit"value="Modifier"/>
    <td Width=15%><input type="submit"value="Affecter un vendeur"/>
    <td Width=15%><input type="submit"value="Rouvrir"/>
    <td Width=55%><%out.println(); %></td> 
    </tr><%}%> 
 <hr> 
 <br> 
    <td Width=25%><A HREF="GererLead?action=vide">Retour</A></td> 
 <hr> 
    </body> 
</html> 
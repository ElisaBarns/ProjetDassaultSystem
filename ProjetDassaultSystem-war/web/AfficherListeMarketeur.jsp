<%-- 
    Document   : AfficherListeMarketeur
    Created on : 23 mars 2023, 09:33:06
    Author     : marie
--%>

<%@page import="Entity.Piste_opportunite"%>
<%@page import="java.util.List"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
       <jsp:useBean id="lesPistes_opportunites" scope="request" class="java.util.List"></jsp:useBean> 
        <title>Les pistes et opportunités</title> 
    </head> 
    <body> 
        <h1>Mes pistes et opportunités</h1> 
        <p> <% 
      String attribut = (String) request.getAttribute("message"); 
      out.println( attribut ); 
      %> </p>
    <TABLE border width=30%>
     <tr><TD>Identifiant</TD>
         <TD>Statut</TD>
         <TD>Type</TD>
         <TD>Niveau d'intéret</TD>
         <TD>Niveau de risque</TD>
         <TD>Budget estimé</TD>
         <TD>Client</TD>
         <TD>Vendeur</TD>
         <TD>Date de création</TD>
         <TD>Date de modification</TD>
    <% List<Piste_opportunite> lesPO=lesPistes_opportunites; 
    for(Piste_opportunite po : lesPO){%> 
    <tr> 
    <td Width=15%><%=po.getId()%></td> 
    <td Width=15%><%=po.getStatut()%></td>
    <td Width=15%><%=po.getType()%></td>  
    <td Width=15%><%=po.getNiveau_interet()%></td>
    <td Width="15%><%=po.getTx_reussite()%></td>
    <td Width=15%><%=po.getNiveau_risque()%></td> 
    <td Width=15%><%=po.getBudget_estime()%></td>  
    
    <td Width=15%><%=po.getLeClient()%></td>%></td>
    <td Width=15%><%=po.getVendeur()%></td>
    <td Width=30%><%=po.getDate_creation_popp()%></td> 
    <td Width=15%><%=po.getDate_modif_popp()%></td> 
    <td Width=55%><%out.println(); %></td> 
   </tr><%}%> 
    </TABLE>
    
    
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuMarketeur.jsp'"><br />
        </span>
    
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
    
        
    </body> 
</html> 
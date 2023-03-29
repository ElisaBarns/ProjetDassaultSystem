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
        <link rel="stylesheet" href="CSS.css">
    </head> 
    <body> 

        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <h1>Mes pistes et opportunités</h1> 
        <p> <% 
            String attribut = (String) request.getAttribute("message"); 
            HttpSession sess=request.getSession(true);
            Utilisateur u = (Utilisateur)sess.getAttribute("session");
            System.out.println("TEST30");
            out.println( attribut ); 
        %> </p>
    <TABLE border width=5%>
     <tr><TD>Identifiant</TD>
         <TD>Statut</TD>
         <TD>Type</TD>
         <TD>Niveau d'intéret</TD>
         <TD>Taux de réussite</TD>
         <TD>Niveau de risque</TD>
         <TD>Budget estimé</TD>
         <TD>Client</TD>
         <TD>Vendeur</TD>
         <TD>Date de création</TD>
         <TD>Date de modification</TD>
    <% List<Piste_opportunite> lesPO=lesPistes_opportunites; 
    System.out.println("TEST46");
    for(Piste_opportunite po : lesPO){
    if(po.getMarketeur()!=null && po.getMarketeur().getUnUtilisateur()!=null && po.getMarketeur().getUnUtilisateur().getId()==u.getId()){
    %>
  <tr>  <td Width=15%><%=po.getId()%></td> 
        <td Width=15%><%=po.getStatut()%></td>
        <td Width=15%><%=po.getType()%></td>  
        <td Width=15%><%=po.getNiveau_interet()%></td>
        <td Width=15%><%=po.getTx_reussite()%> %</td>
        <td Width=15%><%=po.getNiveau_risque()%></td> 
        <td Width=15%><%=po.getBudget_estime()%> €</td>  
        <td Width=15%><%=po.getLeClient().getNom_client() %></td>
        <%if(po.getVendeur()!=null){%><td Width=15%><%=po.getVendeur().getUnUtilisateur().getNom_utilisateur()%> <%=po.getVendeur().getUnUtilisateur().getPrenom_utilisateur() %></td>
        <%}else{%><td Width=15%></td><%}%>
        <td Width=15%><%=po.getDate_creation_popp()%></td> 
        <td Width=15%><%=po.getDate_modif_popp()%></td> 
   </tr><%}

    }%> 
    </TABLE>
                   
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuMarketeur.jsp'">
        </span>
    </body> 
</html> 
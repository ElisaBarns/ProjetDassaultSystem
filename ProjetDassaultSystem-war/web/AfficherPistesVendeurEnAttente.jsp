<%-- 
    Document   : AfficherPistesExpert
    Created on : 20 mars 2023, 17:31:14
    Author     : Mel
--%>

<%@page import="Entity.Utilisateur"%>
<%@page import="Entity.Piste_opportunite"%>
<%@page import="Entity.Statut"%>
<%@page import="java.util.List"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <%System.out.println("J0");%>
        <jsp:useBean id="lesPistes_opportunites" scope="request" class="java.util.List"></jsp:useBean> 

       <title>Les pistes et opportunités</title> 
        <link rel="stylesheet" href="CSS.css">
    </head> 
    <body> 

        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <h1>Mes pistes et opportunités en attente d'acceptation</h1> 
        <p> <% 
      String attribut = (String) request.getAttribute("message"); 
           HttpSession sess=request.getSession(true);
           Utilisateur u = (Utilisateur)sess.getAttribute("session");
        System.out.println("I6");
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
         <!--<TD>Vendeur</TD>-->
         <TD>Date de création</TD>
         <TD>Date de modification</TD>
                 <%System.out.println("I7");%>

    <% List<Piste_opportunite> lesPO=lesPistes_opportunites; 
    for(Piste_opportunite po : lesPO){
    if(po.getStatut()==Statut.QUALIFIE && po.getVendeur()!=null && po.getVendeur().getUnUtilisateur()!=null && po.getVendeur().getUnUtilisateur().getId()==u.getId()){
    %>
  <tr>  <td Width=15%><%=po.getId()%></td> 
        <td Width=15%><%=po.getStatut()%></td>
        <td Width=15%><%=po.getType()%></td>  
        <td Width=15%><%=po.getNiveau_interet()%></td>
        <td Width=15%><%=po.getTx_reussite()%> %</td>
        <td Width=15%><%=po.getNiveau_risque()%></td> 
        <td Width=15%><%=po.getBudget_estime()%> €</td>  
        <td Width=15%><%=po.getLeClient().getNom_client() %></td>
        <!--
        <td Width=15%><%=po.getVendeur().getUnUtilisateur().getNom_utilisateur()%> <%=po.getVendeur().getUnUtilisateur().getPrenom_utilisateur() %></td>
        -->
        <td Width=15%><%=po.getDate_creation_popp()%></td> 
        <td Width=15%><%=po.getDate_modif_popp()%></td> 
   </tr><%}

    }%> 
    </TABLE>
      
        <form method="get" action="GererLead">
<tr><td>Identifiant de la piste </td><td><SELECT size="1" name="piste"> 
<% System.out.println("E1");
for(int i = 0; i<lesPO.size(); i++) {
Piste_opportunite po = (Piste_opportunite)lesPO.get(i);
if(po.getStatut()==Statut.QUALIFIE && po.getVendeur()!=null && po.getVendeur().getUnUtilisateur()!=null && po.getVendeur().getUnUtilisateur().getId()==u.getId()){
%>
    <OPTION value ="<%=po.getId()%>"><%=po.getId() %> </OPTION>
<%
}}
%>
</SELECT></td></tr>
                    <br/>
                    <br/>
                    
                    <tr><td>Décision </td><td><SELECT size="1" name="decision"> 
                    <OPTION value ="acceptee">Acceptée</OPTION> 
                    <OPTION value ="refusee">Refusée</OPTION> 
                    </SELECT></td></tr>
                    <br/>
                    <br/>
              
                    <input type="hidden" name="action" value="AffecterPistesVendeurEnAttente">
                    <input type="submit" value="Confirmer" /> 
        </form>
                    
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuVendeur.jsp'">
        </span>
    </body> 
</html> 
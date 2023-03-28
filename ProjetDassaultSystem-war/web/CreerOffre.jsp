<%-- 
    Document   : CreerOffre
    Created on : 26 mars 2023, 16:50:01
    Author     : rober
--%>
<%@ page import="Entity.Offre" %>
<%@ page import="Entity.Detail_offre" %>
<%@ page import="Entity.Piste_opportunite" %>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <% System.out.println("E");
%>
        <link rel="stylesheet" href="CSS.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="LesPistes" scope="request" class="java.util.List"></jsp:useBean>
<% System.out.println("E0");
%>
        <title>Création d'une offre</title>
    </head>
    <body>
        <span class="SeDeconnecter">
            <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <h1>Création d'une offre</h1>
        
        <div>
            <form method="get" action="GererLead">
                <fieldset>
                    <legend>Informations de l'offre</legend>
                    <br/>       
                    <label for="remise">Taux de remise <span class="requis"></span></label>
                    <input type="text" id="remise" name="remise" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="conditions">Conditions <span class="requis"></span></label>
                    <input type="text" id="conditions" name="conditions" value="" size"20" maxlength="20"/>
                    <br/>
<tr><td>Identifiant de la piste </td><td><SELECT size="1" name="piste"> 
<% System.out.println("E1");
for(int i = 0; i<LesPistes.size(); i++) {
    Piste_opportunite po = (Piste_opportunite)LesPistes.get(i);
%>
    <OPTION value ="<%=po.getId()%>"><%=po.getId() %> </OPTION>
<%
}
%>
</SELECT></td></tr>
                    <br/>
                    <br/>
                    <!--On laisse tombé la liste déroulante pour l'instant
                    <label for="detailOffre">Détail de l'offre</label>
                    <select name="detailOffre">
                        <c:forEach var="do" items="${detail_offre}">
                            <option value="${do.id}">${do.id}</option>
                        </c:forEach>
                    </select>
                    -->
                    
                    <br />

                    <input type="hidden" name="action" value="CreerOffre">
                    
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


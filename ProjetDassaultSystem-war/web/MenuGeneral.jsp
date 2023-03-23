<%-- 
    Document   : MenuGeneral
    Created on : 20 mars 2023, 11:08:20
    Author     : Mel
--%>

<%@page import="Entity.Profil"%>
<%@page import="java.util.List"%>
<%@page import="Entity.Utilisateur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste de mes profils</title>
        <link rel="stylesheet" href="CSS.css">
        <jsp:useBean id="listeprofils" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="utilisateur" scope="request" class="Entity.Utilisateur"></jsp:useBean>
    </head>
    <body>
        <p>
            <%
        String attribut = (String)request.getAttribute("message");
        out.println(attribut);
    %>

        </p>
        <h1>Liste de mes profils disponibles</h1>
       
        <table>
            <% List<Profil> mesProfils=listeProfils; 
    for(Profil p : mesProfils){%> 
    <tr> 
    <td Width=15%><%=p.getFonction()%></td> 
    <td Width=15%><input type="submit"value="Connexion"/>
    <td Width=55%><%out.println(); %></td> 
    </tr><%}%> 
        </table>
    </body>
</html>

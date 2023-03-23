<%-- 
    Document   : MenuGeneral
    Created on : 20 mars 2023, 11:08:20
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu général</title>
    </head>
    <body>
        <p>
            <%
        String attribut = (String)request.getAttribute("message");
        out.println(attribut);
    %>

        </p>
        <h1>Choisissez le profil sur lequel vous voulez travailler</h1>
       
        <table>
            <tr>
           <td Width =15%><A HREF ="MenuAdmin.jsp">Administrateur</A></td>
           <td Width =15%><A HREF ="MenuMarketeur.jsp">Marketeur</A></td>
           <td Width =15%><A HREF ="MenuVendeur.jsp">Vendeur</A></td>
           <td Width =15%><A HREF ="MenuExpert.jsp">Expert technique</A></td> 
           <td Width =15%><A HREF ="MenuOperateurVentes.jsp">Responsable des opérations de ventes</A></td>
            </tr>
        </table>
    </body>
</html>

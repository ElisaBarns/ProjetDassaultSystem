<%-- 
    Document   : MenuGeneral
    Created on : 20 mars 2023, 11:08:20
    Author     : Mel
--%>

<%@page import="Entity.Utilisateur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu général</title>
        <link rel="stylesheet" href="CSS_Menu.css">
        
    </head>
    <body>
                <span class="SeDeconnecter">
            <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
                </span>
        
        <p>
            <%
        String attribut = (String)request.getAttribute("message");
        //out.println(attribut);
    %>

        </p>
         <h1>Choisissez le profil sur lequel vous voulez travailler</h1>
       
        <table>
            <tr>
                <%HttpSession sess=request.getSession(true);%>
                <%Utilisateur u = (Utilisateur)sess.getAttribute("session");%>
                <%if (u.verify_Admin()){%><td><A HREF ="MenuAdmin.jsp">Administrateur</A></td><%}%> 
                <%if (u.verify_Marketeur()){%><td><A HREF ="MenuMarketeur.jsp">Marketeur</A></td><%}%> 
                <%if (u.verify_Vendeur()){%><td><A HREF ="MenuVendeur.jsp">Vendeur</A></td><%}%>
                <%if (u.verify_Expert()){%><td><A HREF ="MenuExpert.jsp">Expert technique</A></td><%}%>
                <%if (u.verify_OperateurVentes()){%><td><A HREF ="MenuOperateurVentes.jsp">Responsable des opérations de ventes</A></td><%}%>
            </tr>
        </table>
        

    </body>
</html>

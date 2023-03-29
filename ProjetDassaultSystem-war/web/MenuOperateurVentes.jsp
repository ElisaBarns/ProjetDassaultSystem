<%-- 
    Document   : MenuOperateurVentes
    Created on : 17 mars 2023, 15:09:26
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Responsable des opérations ventes</title>
        <link rel="stylesheet" href="CSS_Menu.css">
        
    </head>
    <body>
        <img src="logo-Dassault.png" alt="Logo Dassault" class="logo-Dassault">            
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <p>
            <%
        String attribut = (String)request.getAttribute("message");
        //out.println(attribut);
    %>

        </p>
        <h1>Que voulez-vous faire?</h1>
       
        <table>
    <tr>
        <td>
            <div class="menu-items">
                <A HREF ="CreerPiste.jsp">Afficher les rapports prévisionnels</A>
            </div>
        </td>
    </tr>
</table>

        
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuGeneral.jsp'"><br />
        </span>

    </body>
</html>

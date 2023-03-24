<%-- 
    Document   : MauvaisLoginMdp
    Created on : 21 mars 2023, 15:31:31
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erreur</title>
        <link rel="stylesheet" href="CSS.css">
    </head>
    <body>
        <h1>Erreur</h1><br>
        Vous avez saisi un mauvais login et/ou mot de passe. Veuillez réessayer. <br>
                      
        <span class="SeDeconnecter">
        <input type="button" value="S'authentifier" onclick="location.href='Authentification.jsp'"><br />
        </span>
            <br>
    </body>
</html>

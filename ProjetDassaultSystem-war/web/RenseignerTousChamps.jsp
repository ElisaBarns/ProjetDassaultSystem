<%-- 
    Document   : RenseignerTousChamps
    Created on : 21 mars 2023, 15:09:09
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
       <img src="logo-Dassault.png" alt="Logo Dassault" class="logo-Dassault">     
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <center>
        <h1>Erreur</h1><br>
        Veuillez renseigner tous les champs obligatoires <br>
        </center>
    
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuAdmin.jsp'"><br />
        </span>

    </body>
</html>
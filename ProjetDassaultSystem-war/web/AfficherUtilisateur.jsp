<%-- 
    Document   : AfficherUtilisateur
    Created on : 22 mars 2023, 14:44:39
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Afficher l'utilisateur recherché</title>
    </head>
    <body>
        <h1>Afficher l'utilisateur recherché</h1>
    <tr>
        <td Width=15%><%=Mann.getIdentifiantMannequin()%></td>
        <td Width=15%><%=Mann.getNomMannequin()%></td>
        <td Width=15%><%=Mann.getPrenomMannequin()%></td>
    
    </tr>
    <hr>
            <table><tr>
                    <td Width=25%><A HREF ="AccesDefiles?action=vide">Retour Menu</A></td>        </tr>
        
    </table>
    </body>
</html>

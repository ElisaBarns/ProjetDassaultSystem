<%-- 
    Document   : MenuMarketeur
    Created on : 17 mars 2023, 14:46:32
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Marketeur</title>
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
                <A HREF ="GererLead?action=AfficherCreerPiste">Créer une piste</A><br/>
                <A HREF ="ModifierPiste.jsp">Modifier une piste</A><br/>
                <A HREF ="CreerClient.jsp">Créer un client</A><br/>
                <A HREF ="GererLead?action=AfficherCreerContact">Créer un contact</A><br/>
                <A HREF ="GererLead?action=AfficherAffecterVendeur">Affecter un vendeur à une piste</A><br/>
                <A HREF ="ModifierClient.jsp">Modifier un client</A><br/>
                <A HREF ="ModifierContact.jsp">Modifier un contact</A><br/>
                <A HREF ="GererLead?action=AfficherListeMarketeur">Afficher la liste des pistes</A><br/>
            </div>
        </td>
    </tr>
</table>

        
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuGeneral.jsp'"><br />
        </span>
            

    </body>
</html>

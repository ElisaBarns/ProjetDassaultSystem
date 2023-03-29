<%-- 
    Document   : MenuVendeur
    Created on : 17 mars 2023, 15:11:06
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS_Menu.css">
        <title>Menu Vendeur</title>
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
                <A HREF ="GererLead?action=AfficherPistesVendeur">Afficher mes pistes et opportunités</A><br/>
                <A HREF ="GererLead?action=AfficherAffecterPistesVendeurEnAttente">Mes pistes et opportunités en attente d'acceptation</A><br/>
                <A HREF ="GererLead?action=AfficherAffecterExpert">Affecter un expert</A><br/>
                <A HREF ="MajPoParVendeur.jsp">Mettre à jour la piste/opportunité</A><br/>
                <A HREF ="PisteGagne.jsp">Décision finale d'une piste</A><br/>
                <A HREF ="ModifierClient.jsp">Modifier un client</A><br/>
                <A HREF ="ModifierContactParVendeur.jsp">Modifier un contact</A><br/>
                <A HREF ="GererLead?action=AfficherPistesAvecStatutSoumis">Mes pistes et opportunités au statut soumis</A><br/>
                <A HREF ="GererLead?action=AfficherPistesASoumettre">Mes pistes et opportunités à soumettre</A><br/>
            </div>
        </td>
    </tr>
</table>

        
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuGeneral.jsp'"><br />
        </span>

    </body>
</html>

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
        <link rel="stylesheet" href="CSS.css">
    </head>
    <body>
                <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        <p>
            <%
        String attribut = (String)request.getAttribute("message");
        out.println(attribut);
    %>

        </p>
        <h1>Que voulez-vous faire?</h1>
       
        <table><tr>
                
           <tr>
           <A HREF ="GererLead?action=AfficherCreerPiste">Créer une piste</A></td><br/>
           <A HREF ="ModifierPiste.jsp">Modifier une piste</A></td><br/>
           <A HREF ="CreerClient.jsp">Créer un client</A></td></br>
           <A HREF ="CreerContact.jsp">Créer un contact</A></td><br/>
           <A HREF ="AffecterVendeur.jsp">Affecter un vendeur à une piste</A></td><br/>
           <A HREF ="ModifierClientParMarketeur.jsp">Modifier un client</A></td><br/>
           <A HREF ="ModifierContact.jsp">Modifier un contact</A></td><br/>
           
          <tr> 
           <A HREF ="GererLead?action=AfficherListeMarketeur">Afficher la liste des pistes</A></td><br/> 

           <!--
            <tr> 
             <%--<td Width =15%><A HREF ="AfficherUnVetement.jsp">Afficher un vetement</A></td>--%>
            <td Width =15%><A HREF ="RechercherVetement.jsp">Rechercher vetement</A></td>
            <%-- <td Width =15%><A HREF ="AfficherUnAccessoire.jsp">Afficher un accessoire</A></td>--%>
            <td Width =15%><A HREF ="RechercherAccessoire.jsp">Rechercher accessoire</A></td>
            <%--<td Width =15%><A HREF ="AfficherMannequin.jsp">Afficher un mannequin</A></td>--%>
            <td Width =15%><A HREF ="RechercherMannequin.jsp">Rechercher mannequin</A></td>
            <td Width =15%><A HREF ="RechercherOrganisateur.jsp">Rechercher organisateur</A></td>
            <td Width =15%><A HREF ="RechercherDefileDunOrganisateur.jsp">Rechercher les défilés d'un organisateur</A></td>
            </tr>
           -->
       </tr>
        
      
        </table>
        
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuGeneral.jsp'"><br />
        </span>
            

    </body>
</html>

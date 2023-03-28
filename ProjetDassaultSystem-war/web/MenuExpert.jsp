<%-- 
    Document   : MenuExpert
    Created on : 17 mars 2023, 15:04:29
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Expert technique</title>
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
          <A HREF ="MajOffreParExpert.jsp">Mettre à jour l'offre</A></td><br/>
          <A HREF ="GererLead?action=AfficherPistesExpert">Afficher mes pistes et opportunités</A></td><br/>
          <A HREF ="GererLead?action=AfficherCreerOffre">Créer l'offre</A></td><br/>
          <A HREF ="RechercherProduit.jsp">Rechercher un produit</A></td><br/>
          <A HREF ="GererLead?action=AfficherCreerDetailOffre">Créer le détail d'une offre</A></td><br/>
          <A HREF ="GererLead?action=AfficherPistesSansOffre">Afficher les pistes sans offre</A></td><br/>
           
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

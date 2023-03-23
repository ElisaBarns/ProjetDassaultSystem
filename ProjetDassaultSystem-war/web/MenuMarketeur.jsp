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
        <p>
            <%
        String attribut = (String)request.getAttribute("message");
        out.println(attribut);
    %>

        </p>
        <h1>Que voulez-vous faire?</h1>
       
        <table><tr>
                
           <tr>
           <td Width =15%><A HREF ="CreerPiste.jsp">Créer une piste</A></td>
           <td Width =15%><A HREF ="CreerClient.jsp">Créer un client</A></td>
           <td Width =15%><A HREF ="CreerContact.jsp">Créer un contact</A></td>
           <!--
           <td Width =15%><A HREF ="creerOrganisateur.jsp">Creer organisateur</A></td>
           <td Width =15%><A HREF ="CreerLieu.jsp">Creer lieu</A></td>  
           <td Width =15%><A HREF ="CreerCouturier.jsp">Creer couturier</A></td> 
           <td Width =15%><A HREF ="AccesDefiles?action=CreerVetement">Creer vetement</A></td> 
           <td Width =15%><A HREF ="CreerAccessoire.jsp">Creer accessoire</A></td> 
           <td Width =15%><A HREF ="CreerMannequin.jsp">Creer mannequin</A></td>
           </tr>
           -->
        
          
           
          <tr> 
           <td Width =15%><A HREF ="AfficherListeMarketeur.jsp">Afficher ma liste de pistes</A></td> 
           <!--
           <td Width =15%><A HREF ="AffecterVendeur.jsp">Affecter un vendeur</A></td> 
           <td Width =15%><A HREF ="RouvrirPiste.jsp">Réouvrir une piste</A></td> 
           -->
           <!--
           <td Width =15%><A HREF ="ModifierVetement.jsp">Modifier Vetement</A></td>
           <td Width =15%><A HREF ="ModifierAccessoire.jsp">Modifier Accessoire</A></td>
           </tr>
           -->
           
           <!--
           <tr>
           <td Width =15%><A HREF ="SupprimerAccessoire.jsp">Supprimer Accessoire</A></td>
           <td Width =15%><A HREF ="SupprimerVetement.jsp">Supprimer Vetement</A></td>
           <td Width =15%><A HREF ="SupprimerMannequin.jsp">Supprimer Mannequin</A></td>
           </tr>
           -->
           
            
           <!--
           <tr>
           <td Width =15%><A HREF ="AccesDefiles?action=AfficherDefile">Afficher tous les defiles</A></td>
           <td Width =15%><A HREF ="AccesDefiles?action=AfficherOrganisateur">Afficher tous les organisateurs</A></td>
           <td Width =15%><A HREF ="AccesDefiles?action=AfficherVetement">Afficher tous les vêtements</A></td>
           <td Width =15%><A HREF ="AccesDefiles?action=AfficherAccessoire">Afficher tous les accessoires</A></td>
           </tr>
           -->
           
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
    </body>
</html>

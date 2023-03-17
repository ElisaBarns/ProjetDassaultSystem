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
        <title>JSP Page</title>
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
   
           <!--
           <tr>
           <td Width =15%><A HREF ="CreerPiste.jsp">Créer une piste</A></td>
           <td Width =15%><A HREF ="creerOrganisateur.jsp">Creer organisateur</A></td>
           <td Width =15%><A HREF ="CreerLieu.jsp">Creer lieu</A></td>  
           <td Width =15%><A HREF ="CreerCouturier.jsp">Creer couturier</A></td> 
           <td Width =15%><A HREF ="AccesDefiles?action=CreerVetement">Creer vetement</A></td> 
           <td Width =15%><A HREF ="CreerAccessoire.jsp">Creer accessoire</A></td> 
           <td Width =15%><A HREF ="CreerMannequin.jsp">Creer mannequin</A></td>
           </tr>
           -->
        
          
          <tr> 
           <td Width =15%><A HREF ="AccepterPiste.jsp">Accepter la piste</A></td> 
           <td Width =15%><A HREF ="RefuserPiste.jsp">Refuser la piste</A></td> 
           <td Width =15%><A HREF ="AffecterExpert.jsp">Affecter un expert</A></td>
           <td Width =15%><A HREF ="MajPoParVendeur.jsp">Mettre à jour la piste/opportunité</A></td>
           <td Width =15%><A HREF ="PisteGagne.jsp">Déclarer cette opportunité comme gagné</A></td> 
           <td Width =15%><A HREF ="PistePerdu.jsp">Déclarer cette opportunité comme perdu</A></td>
           <td Width =15%><A HREF ="AfficherListePO.jsp">Afficher la liste de mes pistes/opportunités</A></td>
           </tr>
           
           
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

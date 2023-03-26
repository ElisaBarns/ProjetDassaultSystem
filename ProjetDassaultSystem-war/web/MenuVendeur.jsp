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

          <tr> 
           <td Width =15%><A HREF ="AccepterPiste.jsp">Accepter la piste</A></td> 
           <td Width =15%><A HREF ="RefuserPiste.jsp">Refuser la piste</A></td> 
           <td Width =15%><A HREF ="AffecterExpert.jsp">Affecter un expert</A></td>
           <td Width =15%><A HREF ="MajPoParVendeur.jsp">Mettre à jour la piste/opportunité</A></td>
           <td Width =15%><A HREF ="PisteGagne.jsp">Déclarer cette opportunité comme gagné</A></td> 
           <td Width =15%><A HREF ="PistePerdu.jsp">Déclarer cette opportunité comme perdu</A></td>
           <td Width =15%><A HREF ="AfficherListePO.jsp">Afficher la liste de mes pistes/opportunités</A></td>
           <td Width =15%><A HREF ="ModifierClient.jsp">Modifier un client</A></td>
           </tr>

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
            
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
    </body>
</html>

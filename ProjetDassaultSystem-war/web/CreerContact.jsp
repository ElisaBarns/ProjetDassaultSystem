<%-- 
    Document   : CreerContact
    Created on : 23 mars 2023, 21:12:41
    Author     : rober
--%>

<%@page import="java.util.List"%>
<%@page import="Entity.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="LesClients" scope="request" class="java.util.List"></jsp:useBean>

       <% System.out.println("liste");
%>
        <link rel="stylesheet" href="CSS.css">
        <title>Création d'un contact</title>
    </head>
    <body>
        <img src="logo-Dassault.png" alt="Logo Dassault" class="logo-Dassault">         
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <h1>Nouveau Contact</h1>
        
        <div>
            <form method="post" action="GererLead">
                <fieldset>
                    <legend>Informations du contact</legend>
                    <br/>         
                    <label for="nom_contact">Nom <span class="requis"></span></label>
                    <input type="text" id="nom_contact" name="nom_contact" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="prenom_contact">Prénom <span class="requis"></span></label>
                    <input type="text" id="prenom_contact" name="prenom_contact" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="mail_contact">Email <span class="requis"></span></label>
                    <input type="text" id="mail_contact" name="mail_contact" value="" size"50" maxlength="50"/>
                    <br/>
                    <label for="tel_contact">Téléphone <span class="requis"></span></label>
                    <input type="text" id="tel_contact" name="tel_contact" value="" size"20" maxlength="20"/>
                    <br/>
<tr><td>Nom du client </td><td><SELECT size="1" name="id_Client"> 
<% 
for(int i = 0; i<LesClients.size(); i++) {
    Client c = (Client)LesClients.get(i);
%>
    <OPTION value ="<%=c.getId()%>"><%=c.getNom_client() %> </OPTION>
<%
}
%>
</SELECT></td></tr>
                    
                    
                    <input type="hidden" name="action" value="CreerContact">
                    
                </fieldset>
                <input type="submit" value="Valider" /> 
                <input type="reset" value="Annuler" /> <br />
                
            </form>
        </div>
                        
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuMarketeur.jsp'"><br />
        </span>

    </body>
</html>
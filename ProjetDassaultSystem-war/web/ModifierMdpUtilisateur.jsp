<%-- 
    Document   : ModifierMdpUtilisateur
    Created on : 20 mars 2023, 17:18:00
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modification du mot de passe d'un utilisateur</title>
    </head>
    <body>
        <fieldset>
    <h1>Informations de l'utilisateur</h1>
    <form action="Acces" method="post">
                    
        <!-- TROUVER UN MOYEN D'AFFICHER LES INFORMATIONS DE L'UTILISATEUR A INACTIVER !!! -->
        
                    <!--
                    <label for="nom_utilisateur">Nom <span class="requis"></span></label>
                    <input type="text" id="nom_utilisateur" name="nom_utilisateur" value="<%=request.getParameter("nom_utilisateur")%>" readonly>
                    <br/>
                    <label for="prenom_utilisateur">Prénom <span class="requis"></span></label>
                    <input type="text" id="prenom_utilisateur" name="prenom_utilisateur" value="<%=request.getParameter("prenom_utilisateur")%>" readonly>
                    <br/>
                    <label for="login_utilisateur">Login <span class=""requis"></span></label>
                    <input type="text" id="login_utilisateur" name="login_utilisateur" value="<%=request.getParameter("login_utilisateur")%>" readonly>
                    <br/>
                    -->
                    
                    <label for="mdp_utilisateur">Mot de passe <span class="requis"></span></label>
                    <input type="text" id="mdp_utilisateur" name="mdp_utilisateur" value="<%=request.getParameter("mdp_utilisateur")%>" readonly>
                    <br/>
                    
                    <!--
                    <label for="mail_utilisateur">Mail <span class="requis"></span></label>
                    <input type="text" id="mail_utilisateur" name="mail_utilisateur" value="<%=request.getParameter("mail_utilisateur")%>" readonly>
                    <br/>
                    <label for="tel_utilisateur">Téléphone <span class=""></span></label>
                    <input type="text" id="tel_utilisateur" name="tel_utilisateur" value="<%=request.getParameter("tel_utilisateur")%>" readonly>
                    <br/>
                    <label for="inactif">Inactiver <span class=""></span></label>
                    <input type="checkbox" id="inactif" name="inactif" value="<%=request.getParameter("inactif")%>" readonly>
                    <br/>
                    -->
                    
                    <input type="hidden" name="action" value="ModifierMdpUtilisateur">
       
        <input type="submit" value="Modifier">
        <input type="button" value="Annuler">
        
            <hr>
            <td Width=25%><A HREF="GererLead?action=vide"> Retour Menu</A></td>
            <hr>
    </form>
    </body>
</html>

<%-- 
    Document   : CreerProfil
    Created on : 23 mars 2023, 10:36:40
    Author     : Mel
--%>

<%@page import="java.util.List"%>
<%@page import="Entity.Utilisateur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Création d'un profil</title>
    </head>
    <body>
        <h1>Création d'un profil</h1>
        
        
        <div>
            <form method="post" action="GererLead">
                <fieldset>
                    <legend>Informations du nouveau profil</legend>
                    <br/>     
                    
                    <label for="login_utilisateur">Login de l'utilisateur</label>
                    <input type="text" id="login_utilisateur" name="login_utilisateur">
                    <br/>
                    <!--AUTRE METHODE POUR TEST
                    <label for="login_utilisateur">Login de l'utilisateur<span class="requis">*</span></label>
                    <select name="login_utilisateur">

                    </select>
                    -->
                    <!--AUTRE METHODE POUR TEST
                    <form action="list" method="post">
                        Select a profile:&nbsp;
                        <select name="Utilisateur">
                            <u:forEach items="${ListUtilisateur}" var="Utilisateur"> 
                                <option value="${Utilisateur.Id}">${Utilisateur.Nom}</option> 
                            </u:forEach> 
                        </select>
                            <br/><br/>
                    </form>
                    -->
                    
                    <tr><td>Fonction</td><td><SELECT size="1" name="fonction"> 
                    <OPTION value ="vendeur">Vendeur</OPTION> 
                    <OPTION value ="marketeur">Marketeur</OPTION> 
                    <OPTION value ="operateur_ventes">Responsable des opérations de ventes</OPTION> 
                    <OPTION value ="expert_technique">Expert-technique</OPTION>
                    <OPTION value ="administrateur">Administrateur</OPTION>
                    </SELECT></td></tr>
                   
                    <input type="hidden" name="action" value="CreerProfil">
                    
                </fieldset>
                <input type="submit" value="Valider" /> 
                <input type="reset" value="Remettre à zéro" /> <br />
                        
                <hr>
                <td Width=25%><A HREF="GererLead?action=vide"> Retour Menu</A></td>
                <hr>
            </form>
        </div>
    </body>
</html>

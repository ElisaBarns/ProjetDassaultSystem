<%-- 
    Document   : CreerUtilisateur
    Created on : 16 mars 2023, 15:01:22
    Author     : Mel
--%>
<%@page import="Entity.Utilisateur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Création d'un utilisateur</title>
    </head>
    <body>
        <h1>Création utilisateur</h1>
        
        <div>
            <form method="post" action="GererLead">
                <fieldset>
                    <legend>Informations de l'utilisateur</legend>
                    <br/><!-- comment -->          
                    <label for="nom_utilisateur">Nom <span class="requis"></span></label>
                    <input type="text" id="nom_utilisateur" name="nom_utilisateur" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="prenom_utilisateur">Prénom <span class="requis"></span></label>
                    <input type="text" id="prenom_utilisateur" name="prenom_utilisateur" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="login_utilisateur">Login <span class=""requis"></span></label>
                    <input type="text" id="login_utilisateur" name="login_utilisateur" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="msp_utilisateur">Mot de passe <span class="requis"></span></label>
                    <input type="text" id="mdp_utilisateur" name="msp_utilisateur" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="mail_utilisateur">Mail <span class="requis"></span></label>
                    <input type="text" id="mail_utilisateur" name="mail_utilisateur" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="tel_utilisateur">Téléphone <span class=""></span></label>
                    <input type="text" id="tel_utilisateur" name="tel_utilisateur" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="inactif">Inactiver <span class=""></span></label>
                    <input type="checkbox" id="inactif" name="inactif" value="non">
                    <br/>
                    
                    <input type="hidden" name="action" value="CreerUtilisateur">
                    
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

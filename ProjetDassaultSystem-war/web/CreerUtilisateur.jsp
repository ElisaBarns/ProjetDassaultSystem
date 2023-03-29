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
        <img src="logo-Dassault.png" alt="Logo Dassault" class="logo-Dassault">        
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <h1>Création utilisateur</h1>
        
        <div>
            <form method="get" action="GererLead">
                <fieldset>
                    <legend>Informations de l'utilisateur</legend>
                    <br/><!-- comment -->          
                    <label for="nom_utilisateur">Nom <span class="requis"></span></label>
                    <input type="text" id="nom_utilisateur" name="nom_utilisateur" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="prenom_utilisateur">Prénom <span class="requis"></span></label>
                    <input type="text" id="prenom_utilisateur" name="prenom_utilisateur" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="login_utilisateur">Login <span class="requis"></span></label>
                    <input type="text" id="login_utilisateur" name="login_utilisateur" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="mdp_utilisateur">Mot de passe <span class="requis"></span></label>
                    <input type="text" id="mdp_utilisateur" name="mdp_utilisateur" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="mail_utilisateur">Mail <span class="requis"></span></label>
                    <input type="text" id="mail_utilisateur" name="mail_utilisateur" value="" size"50" maxlength="50"/>
                    <br/>
                    <label for="tel_utilisateur">Téléphone <span class="requis"></span></label>
                    <input type="text" id="tel_utilisateur" name="tel_utilisateur" value="" size"20" maxlength="20"/>
                    <br/>
                    
                    <!-- PAS BESOIN CAR FALSE PAR DEFAUT DANS LA METHODE
                    <label for="inactif">Inactiver <span class=""></span></label>
                    <input type="checkbox" id="inactif" name="inactif" value="non">
                    <br/>
                    -->
                    
                    <input type="hidden" name="action" value="CreerUtilisateur">
                    
                </fieldset>
                <input type="submit" value="Valider" /> 
                <input type="reset" value="Annuler" /> <br />
                        
            </form>
        </div>
        
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuAdmin.jsp'"><br />
        </span>

        
    </body>
</html>

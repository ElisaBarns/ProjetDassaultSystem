<%-- 
    Document   : Authentification
    Created on : 16 mars 2023, 16:01:41
    Author     : Mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Authentification</title>
    <link rel="stylesheet" href="CSS.css">
</head>
<body>
<h1>Authentification</h1>

<div>
    <form method="get" action="GererLead">
        <fieldset>
            <legend>Veuillez vous authentifier</legend>
            
            
            <div class="input">
                <input type="text" name="login" placeholder="Login"/>
            </div>
            <div class="input">
                <input type="password" id="pass" name="pass" placeholder="Mot de passe"/>
                <img src="images/red_eye.png" id="eye" onClick="changer()"/>
                </div>
                <input type="submit" value="Se connecter"/>
    </form>
    <script>
        e=true;
        function changer(){
            if(e){
                document.getElementById("pass").setAttribute("type", "text");
                document.getElementById("eye").src="imaes/eye.png";
                e=false;
            }
            else{
                document.getElementById("pass").setAttribute("type", "password");
                document.getElementById("eye").src="images/no_eye.png";
                e=false;
            }
        }
                
                <!--
            <label for="login_utilisateur">Login <span class="requis"></span></label>
            <input type="text" id="login_utilisateur" name="login_utilisateur" value="" size "20" maxlength="20"/>
            <br/>
            <label for="mdp_utilisateur">Mot de passe <span class="requis"></span></label>
            <input type="text" id="mdp_utilisateur" name="mdp_utilisateur" value="" size "20" maxlength="20"/>
            <br/>

            <input type="hidden" name="action" value="authentification">
        </fieldset>

        <input type="submit" value="Se connecter"/>
        <input type="reset" value="Annuler"> <br />
                    </form>
                -->
</div>
</body>
</html>



<%-- 
    Document   : CreerOffre
    Created on : 26 mars 2023, 16:50:01
    Author     : rober
--%>
<%@page import="Entity.Detail_offre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Création d'une offre</title>
        <jsp:useBean id="LesDetail_offres" scope ="request" class ="java.util.List"></jsp:useBean>
    </head>
    <body>
        <h1>Création d'une offre</h1>
        
        <div>
            <form method="get" action="GererLead">
                <fieldset>
                    <legend>Informations de l'offre</legend>
                    <br/>       
                    <label for="remise">Taux de remise <span class="requis"></span></label>
                    <input type="text" id="remise" name="remise" value="" size"20" maxlength="20"/>
                    <br/>
                    <label for="conditions">Conditions <span class="requis"></span></label>
                    <input type="text" id="conditions" name="conditions" value="" size"20" maxlength="20"/>
                    <br/>
                    <!--
                    <select name="contenu">
                        <c:forEach items="${detail_offre}" var="do">
                        <option value="${do.id}">${do.id}</option>
                        </c:forEach>
                    </select>
                    -->
                    <br />

                    <input type="hidden" name="action" value="CreerOffre">
                    
                </fieldset>
                <input type="submit" value="Valider" /> 
                <input type="reset" value="Annuler" /> <br />
                        
            </form>
        </div>
        
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuExpert.jsp'"><br />
        </span>
        
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
    </body>
</html>


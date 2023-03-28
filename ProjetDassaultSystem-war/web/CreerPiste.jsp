<%-- 
    Document   : CreerUtilisateur
    Created on : 16 mars 2023, 15:01:22
    Author     : Mel
--%>
<%@page import="java.util.List"%>
<%@page import="Entity.Profil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <jsp:useBean id="lesVendeursActifs" scope="request" class="java.util.List"></jsp:useBean>
         
        <title>Création d'une piste</title>
    </head>
    <body>
                
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <h1>Création d'une piste</h1>
          <div>
            <form method="get" action="GererLead">
                <fieldset>
                    <legend>Informations de la piste</legend>
                    <br/>       
                    <tr><td>Niveau de risque </td><td><SELECT size="1" name="niveau_risque"> 
                    <OPTION value ="bas">Bas</OPTION> 
                    <OPTION value ="medium">Medium</OPTION> 
                    <OPTION value ="haut">Haut</OPTION> 
                    </SELECT></td></tr>
                    <br/>
                    <br/>
                    <label for="tx_reussite">Taux de réussite <span class="requis"></span></label>
                    <input type="text" id="tx_reussite" name="tx_reussite" value="" size"20" maxlength="20"/>
                    <br/>
                    <br/>
                    <tr><td>Niveau d'intérêt </td><td><SELECT size="1" name="niveau_interet"> 
                    <OPTION value ="bas">Bas</OPTION> 
                    <OPTION value ="medium">Medium</OPTION> 
                    <OPTION value ="haut">Haut</OPTION> 
                    </SELECT></td></tr>
                    <br/>
                    <br/>
                    <tr><td>Nom du vendeur </td><td><SELECT size="1" name="id_vendeur"> 
<%
for(int i = 0; i<lesVendeursActifs.size(); i++) {
    Profil p = (Profil)lesVendeursActifs.get(i);
%>
    <OPTION value ="<%=p.getUnUtilisateur().getId()%>"><%=p.getUnUtilisateur().getNom_utilisateur()%> <%=p.getUnUtilisateur().getPrenom_utilisateur()%></OPTION>
<%
}
%>
</SELECT></td></tr>
                    <br/>
                    <br/>
                    <label for="budget_estime">Budget estimé <span class="requis"></span></label>
                    <input type="text" id="budget_estime" name="budget_estime" value="" size"20" maxlength="20"/>
                    <br/>
                    <br/>
                    <label for="nom_client">Nom du client <span class="requis"></span></label>
                    <input type="text" id="nom_client" name="nom_client" value="" size"50" maxlength="50"/>
                    <br/>
                    <br/>
                    
                    <input type="hidden" name="action" value="CreerPiste">
                    
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

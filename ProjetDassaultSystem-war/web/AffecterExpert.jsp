<%-- 
    Document   : AffecterExpert
    Created on : 29 mars 2023, 00:02:46
    Author     : Mel
--%>

<%@page import="Entity.Piste_opportunite"%>
<%@page import="java.util.List"%>
<%@page import="Entity.Profil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <jsp:useBean id="lesExpertsActifs" scope="request" class="java.util.List"></jsp:useBean>
       <jsp:useBean id="Pistes" scope="request" class="java.util.List"></jsp:useBean>
        <title>Affecter un expert à une piste</title>
        <link rel="stylesheet" href="CSS.css">
    </head>
    <body>
                
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <h1>Affectation d'un Expert</h1>
        <div>
             
        <form method="get" action="GererLead">
        <fieldset>
        <legend>Information de la piste</legend>
        <label for="id_piste">Identifiant de la piste <span class="requis">*</span></label>
        
        
         <label for="id_piste">Identifiant de la piste <span class="requis">*</span></label>
        <select name="id_piste">
      
       <%
for(int i = 0; i<Pistes.size(); i++) {
    Piste_opportunite po = (Piste_opportunite)Pistes.get(i);
%>
    <OPTION value ="<%=po.getId()%>"><%=po.getId()%></OPTION>
<%
}
%>
 </SELECT></td></tr>
        <br />
        
        <select name="login_utilisateur">
      
       <%
for(int i = 0; i<lesExpertsActifs.size(); i++) {
    Profil p = (Profil)lesExpertsActifs.get(i);
%>
    <OPTION value ="<%=p.getUnUtilisateur().getLogin_utilisateur()%>"><%=p.getUnUtilisateur().getNom_utilisateur()%> <%=p.getUnUtilisateur().getPrenom_utilisateur()%></OPTION>
<%
}
%>
 </SELECT></td></tr>
        <br />
        
        <input type="hidden" name="action" value="AffecterExpert">
        </fieldset>
        
        <input type="submit" value="Valider" />
        <input type="reset" value="Annuler" /> <br />
        </form>
        </div>

                
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='MenuVendeur.jsp'"><br />
        </span>
        
    </body>
</html>
<%-- 
    Document   : AfficherCatalogue
    Created on : 26 mars 2023, 16:52:04
    Author     : rober
--%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSS.css">
    </head>
    <body>
                
        <span class="SeDeconnecter">
        <input type="button" value="Se déconnecter" onclick="location.href='Authentification.jsp'"><br />
        </span>
        
        <h1>Catalogues des logiciels</h1>
<table>
<%
    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\rober\\Documents\\NetBeansProject\\ProjetDassaultSystem\\src\\Externe\\Catalogue.csv"));
    String line;
    while ((line = br.readLine()) != null){
        try{
            String[] csv_value = line.split(";");
%>
            <tr>
<%
                for(int i = 0 ; i < csv_value.length ; i++){
%>
                    <td Width=20%><%=csv_value[i]%></td>
<%
                }
%>
            </tr>
<%
        }
        catch(Exception e){}
    }
%>
</table>
        <span class="RetourMenu">
        <input type="button" value="Retour" onclick="location.href='CreerOffre.jsp'"><br />
        </span> 
   
    </body>
</html>

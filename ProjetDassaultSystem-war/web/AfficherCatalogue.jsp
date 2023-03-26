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
    </head>
    <body>
        <h1>Catalogues des logiciels</h1>
        
        <%
                String s = "";
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\rober\\Documents\\NetBeansProject\\ProjetDassaultSystem\\src\\Externe\\Catalogue.csv"));
              String  line = br.readLine();
                                if(line != null){
                    s=line;
                }
        
        %>
        
        <h1> <%=s%></h1>
    </body>
</html>

<%-- 
    Document   : ModifierContact
    Created on : 23 mars 2023, 00:06:12
    Author     : marie
--%>

<%@page import="java.util.List"%>
<%@page import="Entity.Contact"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modification d'un Contact</title>
        <link rel="stylesheet" href="CSS.css">
    </head>
    <body>
        
        <h1>Modifier un Contact</h1>
        <% List<Contact> listeContacts = lesContacts;%>
        <div>
        <form method="get" action="GererLead">
        <fieldset>
        <legend>Informations du contact </legend>
        <label for="id_contact">Identifiant <span class="requis">*</span></label>
        <select name="id_contact">
        <% for (Contact c :listeContacts) {%>
        <option value ="<%=c.getId()%>"><%=c.getNom_contact()%><%=c.getPrenom_contact()%></option>
        <% }%>
        </select>
        <br />
        
        <label for="nom_contact">Nom <span class="requis"></span></label>
        <input type="text" id="nom_contact" name="nom_contact" value="" size"20" maxlength="20"/>
                    <br/>
        <label for="prenom_contact">Prénom <span class="requis"></span></label>
        <input type="text" id="prenom_contact" name="prenom_contact" value="" size"20" maxlength="20"/>
                    <br/>
        <label for="mail">e-mail <span class="requis"></span></label>
        <input type="text" id="mail" name="mail" value="" size"20" maxlength="20"/>
                    <br/>
        <label for="tel">Téléphone <span class="requis"></span></label>
        <input type="text" id="tel" name="tel" value="" size"20" maxlength="20"/>
                    <br/>
        
        <input type="hidden" name="action" value="ModifierContact">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
        </div>
        
        
    </body>
</html>

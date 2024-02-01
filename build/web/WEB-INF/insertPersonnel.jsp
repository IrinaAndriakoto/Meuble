<%-- 
    Document   : insertPersonnel
    Created on : 22 janv. 2024, 19:56:45
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
    <head> 
        <title></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/main.css" rel="stylesheet">
    </head>
    <%
        List<Poste> poste = (List<Poste>) request.getAttribute("poste");
    %>
    <body>
        <!-- <div id="header1"></div> -->
    <center>
        <div id="all">
        <form method="post" action="insertPers">
            <h3>Insertion de nouveaux personnels</h3>
            <p>Nom : <input type="text" name="nompers"class="inp"></p> <br>
            <p>Date de naissance : <input type="date" name="dtn"></p>
            <p>Date d'embauche : <input type="date" name="embauche"></p>
            <p>Poste:
                <select name="post">
                    <% for(int i=0;i<poste.size();i++) { %>
                        <option value="<%= poste.get(i).getIdPoste() %>"><%= poste.get(i).getPoste()  %></option>                            
                     <%   } %>
                </select>
            </p> 
            <input type="submit" value="Inserer">
        </form>
        </div>
    </center>
    
    </body>
    
</html>

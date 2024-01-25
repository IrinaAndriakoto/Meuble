<%-- 
    Document   : insertMetier
    Created on : 22 janv. 2024, 21:26:04
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Metier" %>
<%--<%@ page import="model.Materiel" %>--%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head> 
        <title></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
    </head>
    <% 
        
        List<Metier> met = (List<Metier>) request.getAttribute("list");
    %>
    <body>
        <!-- <div id="header1"></div> -->
    <center>
        <div id="all">
        <form method="post" action="insertMetier">
            <h1>Insertion de Metier</h1>
<p>Metier:
    <select id="metierSelect" name="metier" onchange="afficherMasquerSalaire()">
        <% for(int i=0; i<met.size(); i++) { %>
        <option value="<%= met.get(i).getIdMetier() %>"> <%= met.get(i).getMetier() %> </option>
        <% } %>
    </select>
</p>

<div id="salaireSection">
    <p>Salaire: <input type="text" name="sal"></p>
</div>
            <input type="submit" value="Inserer">
        </form>
        </div>
    </center>
    
    </body>
    
</html>
<script>
    function afficherMasquerSalaire() {
        var metierSelect = document.getElementById("metierSelect");
        var salaireSection = document.getElementById("salaireSection");

        if (metierSelect.value == "1") {
            salaireSection.style.display = "block";
        } else {
            salaireSection.style.display = "none";
        }
    }
</script>

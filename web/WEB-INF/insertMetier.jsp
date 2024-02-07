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
    <!--<link href="assets/css/bootstrap.min.css" rel="stylesheet">-->
    <link href="assets/css/main.css" rel="stylesheet">
    </head>
    <% 
        
        List<Metier> met = (List<Metier>) request.getAttribute("list");
    %>
    <body>
        <!-- <div id="header1"></div> -->
    <center>
        <div id="all">
        <form method="post" action="insertMetier">
            <h3>Insertion de Metier</h3>
<p>Metier:
<p><input type="text" name="metier"></p>
</p>

<div id="salaireSection">
    <!--<p>Salaire: <input type="text" name="sal"></p>-->
    <p>Coefficient : <input type="text" name="coeff"></p>
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

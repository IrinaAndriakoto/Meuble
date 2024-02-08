<%-- 
    Document   : stat
    Created on : 25 janv. 2024, 15:17:39
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/main.css" rel="stylesheet">      
        <script src="assets/js/chart.js"></script>
    </head>
    <%
        List<Client> client = (List<Client>) request.getAttribute("cl");
        List<V_getCommande> cm = (List<V_getCommande>) request.getAttribute("cm");
    %>    
    <body>
        <h3>Afficher les statistiques :</h3>

    <h3>Statistiques sous forme de graphique :</h3>
    <canvas id="myChart" width="300" height="100"></canvas>

    <script>
        // Données du graphique
        var ctx = document.getElementById('myChart').getContext('2d');
        var myChart = new Chart(ctx, {
            type: 'pie',
            data: <%= jsonString %>
        });

    </script>
    </body>
</html>

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
    <link href="assets/css/style.css" rel="stylesheet">        
    </head>
    <%
        List<Client> client = (List<Client>) request.getAttribute("cl");
        List<V_getCommande> cm = (List<V_getCommande>) request.getAttribute("cm");
    %>    
    <body>
        <h2>Afficher les statistiques :</h2>

    <h3>Statistiques sous forme de graphique :</h3>
    <canvas id="myChart" width="400" height="200"></canvas>

    <script>
        var ctx = document.getElementById('myChart').getContext('2d');
        var statistiques = <%= new Gson().toJson(request.getAttribute("statistiques")) %>;
        // Extract data for the chart (modify this according to your data structure)
        var labels = statistiques.map(function(client) { return client.nom; });
        var data = statistiques.map(function(client) { return client.idClient; });

        var myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Nombre de clients par produit',
                    data: data,
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    </script>
    </body>
</html>

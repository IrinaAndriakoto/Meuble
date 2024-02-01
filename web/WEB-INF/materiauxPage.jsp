<%-- 
    Document   : materiauxpage
    Created on : 14 déc. 2023, 09:56:06
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Materiel" %>
<%@ page import="java.util.List" %>
<%@ page import="model.V_getStyleMateriel" %>
<html>
<head>
    <title>Materiel</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/main.css" rel="stylesheet">
    <!-- Ajoutez vos styles ou liens vers des bibliothèques ici -->
</head>
<body>
    <h3>Matériaux :</h3>

    <% 
       List<V_getStyleMateriel> materiauxList = null;
    
     materiauxList = (List<V_getStyleMateriel>) request.getAttribute("materiauxList");
    %>

    <% if (materiauxList != null && !materiauxList.isEmpty()) { %>
        <ul>
        <% for (V_getStyleMateriel materiau : materiauxList) { %>
            <li><%= materiau.getMateriel() %></li>
        <% } %>
        </ul>
    <% } else { %>
        <p> Aucun matériau disponible pour ce style. </p>
    <% } %>

    <a href="index.html">Retourner à la page d'accueil.</a>

    <!-- Ajoutez vos scripts ici si nécessaire -->
</body>
</html>


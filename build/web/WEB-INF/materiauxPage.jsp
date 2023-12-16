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
    <!-- Ajoutez vos styles ou liens vers des bibliothèques ici -->
</head>
<body>
    <h2>Matériaux :</h2>

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


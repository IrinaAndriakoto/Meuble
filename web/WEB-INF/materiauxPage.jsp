<%-- 
    Document   : materiauxPage.jsp
    Created on : 14 déc. 2023, 09:50:54
    Author     : Irina
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Materiel" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Materiaux</title>
    <!-- Ajoutez vos styles ou liens vers des bibliothèques ici -->
</head>
<body>
    <h2>Matériaux :</h2>

    <% 
       List<Materiel> materiauxList = null;
    
     materiauxList = (List<Materiel>) request.getAttribute("materiauxList");
    %>

    <% if (materiauxList != null && !materiauxList.isEmpty()) { %>
        <ul>
        <% for (Materiel materiau : materiauxList) { %>
            <li><%= materiau.getNom() %></li>
        <% } %>
        </ul>
    <% } else { %>
        <p> Aucun matériau disponible pour ce style. </p>
    <% } %>

    <a href="index.html">Retourner à la page d'accueil.</a>

    <!-- Ajoutez vos scripts ici si nécessaire -->
</body>
</html>

    </body>
</html>

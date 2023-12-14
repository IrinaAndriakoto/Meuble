<%-- 
    Document   : affichage
    Created on : 12 nov. 2023, 11:42:58
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Materiel" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Liste des materiels</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
    <h2>Tous les matériaux disponibles</h2>

        <% 
           List<Materiel> mat = null;
        
         mat = (List<Materiel>) request.getAttribute("liste_materiel");
//        out.println(mat.size());
    
        %>

<% if (mat != null && !mat.isEmpty()) { %>
    <% for (int i = 0; i < mat.size(); i++) { %>
    <ul>
        <li><%= mat.get(i).getMateriel() %></li>
    </ul>
    <% } %>
<% } else { %>
    <p> Aucun produit disponible. </p>
<% } %>
        <a href="index.html">Retourner a la page d'accueil.</a>

</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

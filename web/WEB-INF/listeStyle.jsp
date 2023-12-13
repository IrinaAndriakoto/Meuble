<%-- 
    Document   : affichage
    Created on : 12 nov. 2023, 11:42:58
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Style" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Styles</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
    <h2>Styles :</h2>

        <% 
           List<Style> st = null;
        
         st = (List<Style>) request.getAttribute("liste_style");
//        out.println(st.size());
    
        %>

<% if (st != null && !st.isEmpty()) { %>
    <% for (int i = 0; i < st.size(); i++) { %>
    <ul>
        <li><%= st.get(i).getStyle() %></li>
    </ul>
    <% } %>
<% } else { %>
    <p> Aucun produit disponible. </p>
<% } %>

</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

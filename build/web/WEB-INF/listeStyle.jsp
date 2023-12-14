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
    <ul>
    <% for (int i = 0; i < st.size(); i++) { %>
        <li><a href="MateriauxServlet?idStyle=<%= st.get(i).getIdStyle() %>"><%= st.get(i).getStyle() %></a></li>
    <% } %>
    </ul>
<% } else { %>
    <p> Aucun produit disponible. </p>
<% } %>


<div id="materiaux-container"></div>

        <a href="index.html">Retourner a la page d'accueil.</a>

</body>
</html>
<!--<script>
    document.addEventListener('DOMContentLoaded', function() {
        var styleLinks = document.querySelectorAll('.style-link');

        styleLinks.forEach(function(link) {
            link.addEventListener('click', function() {
                var styleId = this.getAttribute('data-style-id');
                loadMateriaux(styleId);
            });
        });

        function loadMateriaux(styleId) {
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    document.getElementById('materiaux-container').innerHTML = xhr.responseText;
                }
            };

            xhr.open('GET', 'MateriauxServlet?idStyle=' + styleId, true);
            xhr.send();
        }
    });
</script>-->

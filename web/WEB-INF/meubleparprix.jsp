<%-- 
    Document   : meubleparprix
    Created on : 11 janv. 2024, 03:00:16
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des meubles</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/main.css" rel="stylesheet">
    </head>
    <%
        String min = (String) request.getAttribute("prixMin");
        String max = (String) request.getAttribute("prixMax");
        List<V_getPrixMateriel> list = (List<V_getPrixMateriel>) request.getAttribute("resultats");
    %>
    <body>
        <% for(int i=0;i<list.size();i++) { %>
        <ul>
            <li>
                <strong>Categorie :<%= list.get(i).getNomCategorie()  %> </strong> <br>
                <strong>Style : <%=list.get(i).getNomStyle() %></strong> <br>
                <strong>Taille : <%= list.get(i).getTaille() %></strong> <br>
              <strong>Prix : <%= list.get(i).getPrix() %> Ariary </strong>
            </li>
        </ul>
        <% } %>
    </body>
</html>

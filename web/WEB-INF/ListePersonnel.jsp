<%-- 
    Document   : ListePersonnel
    Created on : 23 janv. 2024, 15:49:47
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@page import="java.util.List" %>
<html>
<head>
    <title>Styles</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
</head>
<% 
  
    List<V_getListePersonnel> list = (List<V_getListePersonnel) request.getAttribute("liste");
    
%>
<body>
        <h1>La liste du personnel</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Poste</th>
                <th>Salaire</th>
            </tr>
            <% for(int i=0;i<list.size();i++) { %>
            <tr>
                <td><%= list.get(i).getIdPersonnel() %></td>
                <td><%= list.get(i).getNomPersonnel() %></td>
                <td> <%= list.get(i).getMetier() %></td>
                <td><%= list.get(i).getSalaireHeure() %></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>

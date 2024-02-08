<%-- 
    Document   : listeposte
    Created on : 7 févr. 2024, 17:36:35
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Poste" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Postes</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/main.css" rel="stylesheet">
    </head>
    <body>
        <h3>La liste des postes : </h3>
            <% 
                List<Poste> p = (List<Poste>) request.getAttribute("listeposte");
            %>
            
            <table border="1">
                <tr>
                    <th>Poste</th>
                    <th>Salaire par heure</th>
                </tr>
                <% for(int i=0;i<p.size();i++) { %>
                <tr>
                    <td><%= p.get(i).getPoste() %> </td>
                    <td><%= p.get(i).getSalaireparheure() %> </td>
                </tr>
                <% } %>
            </table>
    </body>
</html>

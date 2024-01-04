<%-- 
    Document   : fabrication
    Created on : 29 déc. 2023, 21:41:25
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fabrication</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/style.css" rel="stylesheet">
    </head>
    <% 
        List<V_getquantitemateriel> list = (List<V_getquantitemateriel>) request.getAttribute("liste");
    %>
    <body>

        <% for(int i=0;i<list.size();i++) { %>
            <h5> <%= list.get(i).getCategorie() %> : <%= list.get(i).getStyle() %></h5>
            
            <table border="1">
                <tr>
                    <th>Materiaux</th>
                    <th><%= list.get(i).getTaille()  %></th>
                </tr>
                <tr>
                    <td> <%= list.get(i).getMateriaux() %> </td>
                    <td> <%= list.get(i).getQuantite() %> </td>
                </tr>
            </table>
        <% } %>
    </body>
</html>

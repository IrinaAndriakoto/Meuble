<%-- 
    Document   : benefice
    Created on : 8 févr. 2024, 04:20:13
    Author     : ASUS
--%>
<% 
    List<V_benefice> liste = (List<V_benefice>) request.getAttribute("liste");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/main.css" rel="stylesheet">
    <title>JSP Page</title>
</head>
<body>
    <h3>Nos bénéfices par meuble par commande :</h3>

    <table border="1" width="200px">
        <tr>
            <th>iD</th>
            <th>Categorie</th>
            <th>Style</th>
            <th>Taille</th>
            <th>Mains d'oeuvres</th>
            <th>Valeur de fabrication</th>
            <th>Prix de Vente</th>
            <th>Prix de Revient</th>
            <th>Benefice</th>
        </tr>

            
            <% for(V_benefice cmd : liste) { %>
            <tr>
                <td><%= cmd.getIdcategorie() %></td>
                <td><%= cmd.getCategorie() %></td>
                <td><%= cmd.getStyle() %></td>
                <td><%= cmd.getTaille() %></td>
                <td><%= cmd.getMainsDoeuvres() %></td>
                <td><%= cmd.getValeurFabrication() %></td>
                <td><%= cmd.getPrixDeVente() %></td>
                <td><%= cmd.getPrixDeRevient() %></td>
                <td><%= cmd.getBenefice() %></td>
            </tr>

            <% } %>

    </table>
            </form>

</body>
</html>


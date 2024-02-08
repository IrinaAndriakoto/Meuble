<%-- 
    Document   : validation
    Created on : 11 janv. 2024, 15:22:06
    Author     : Irina
--%>

<% 
    List<V_getCommande> listeCommande = (List<V_getCommande>) request.getAttribute("list");

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
    <h3>Les commandes en attente de validation :</h3>
    
            <form method="post" action="validation">

    <table border="1" width="200px">
        <tr>
            <th>Id Commande</th>
            <th>nbCommande</th>
            <th>Categorie</th>
            <th>Taille</th>
            <th>Style</th>
        </tr>

            
            <% for(V_getCommande cmd : listeCommande) { %>
            <tr>
                <td><%= cmd.getIdCommande() %></td>
                <td><%= cmd.getNbCommande() %></td>
                <td><%= cmd.getCategorie() %></td>
                <td><%= cmd.getTaille() %></td>
                <td><%= cmd.getStyle() %></td>
                <td>
                    <!-- Champ hidden pour stocker la valeur nb -->
                    <input type="hidden" name="nb" value="<%= cmd.getNbCommande() %>">
                    <input type="hidden" name="idcommande" value="<%= cmd.getIdCommande() %>">
                    <!-- Bouton de soumission de formulaire -->
                    <input type="submit" value="Valider la commande">
                </td>
            </tr>

            <% } %>

    </table>
            </form>

</body>
</html>

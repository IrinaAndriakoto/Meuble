<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<% 
    List<Materiel> mat = null;
    mat = (List<Materiel>) request.getAttribute("liste_materiel");
%>

<html>
    <head> 
        <title></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/main.css" rel="stylesheet"> </head>

    <body>
        <center>
            <div id="all">
                <form method="post" action="insertStock">
                <h3>Insertion de stock </h3>
                <p> Materiel: 
                    <select name="materiel">
                        <% for (int i = 0; i < mat.size(); i++) { %>
                            <option value="<%= mat.get(i).getIdMateriel() %>"><%= mat.get(i).getMateriel() %></option>
                        <% } %>
                    </select> 
                </p>
                <p> Quantite: <input type="text" name="qtestock" class="inp"> </p>
                <input type="date" name="dat">
                <input type="submit" value="Inserer">
            </div>
        </form>
        </center>
    </body>
    
</html>
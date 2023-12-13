<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head> 
        <title></title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    </head>
    <% 
       List<Style> styles = (List<Style>) request.getAttribute("liste_style");
    %>
    <body>
        <form method="post" action="insertMateriel">
            
        <label for="style">Style :</label>
        <select name="style" id="style">
            <% for(int i=0;i<styles.size();i++) { %>
                <option value="<%= styles.get(i).getIdStyle() %>"><%= styles.get(i).getStyle()  %></option>
            <% } %>
        </select>
        <br>
            
            <p> Materiel <input type="text" name="materiel"> </p>
            <input type="submit" value="Inserer">
        </form>
    </body>
    
</html>
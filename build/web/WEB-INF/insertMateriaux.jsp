<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="model.Style" %>
<%@ page import="java.util.List" %>
<html>
    <head> 
        <title></title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    </head>

    <body>
        <form method="post" action="insertMateriel">
            

        <br>
            
            <p> Materiel <input type="text" name="materiel"> </p>
            <input type="submit" value="Inserer">
        </form>
    </body>
    
</html>
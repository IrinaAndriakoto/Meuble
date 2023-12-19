<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="model.Style" %>
<%@ page import="java.util.List" %>
<html>
    <head> 
        <title></title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
            <link rel="stylesheet" href="index.css">
            <link href="assets/css/bootstrap.min.css" rel="stylesheet">
            <link href="../assets/css/style.css" rel="stylesheet">
    </head>

    <body>
        <center>
            <h1>Ins&eacute;rez les mati&egrave;res pour votre meuble </h1>
            <div id="all">
        <form method="post" action="insertMateriel">
            
        <label for="style">Style :</label>
        
        <select name="style" id="style" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
            <% for(int i=0;i<styles.size();i++) { %>
                <option value="<%= styles.get(i).getIdStyle() %>"><%= styles.get(i).getStyle()  %></option>
            <% } %>
        </select>
        <br>
            
            <p> Materiel <input type="text" name="materiel"> </p>
            <input type="submit" value="Inserer">
        </form>
        </center>
    </body>
    
</html>
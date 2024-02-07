<%-- 
    Document   : insertPoste
    Created on : 7 févr. 2024, 11:48:59
    Author     : ASUS
--%>

<!DOCTYPE html>
<html>
    <head> 
        <title></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/main.css" rel="stylesheet">
    </head>
    <body>
        <!-- <div id="header1"></div> -->
        <center>
        <div id="all">
        <form method="post" action="insertPoste">
            <h3>Insertion de poste </h3>
            <p><input type="text" name="poste"class="inp" placeholder="Poste"></p>
            <!--<p><input type="date" name="date_naissance "class="inp"></p>-->
            <p><input type="text" name="salaire" placeholder="Salaire Par Heure"><!-- comment --></p>
            <input type="submit" value="Inserer">
        </form>
        </div>
        </center>
    </body>
    
</html>

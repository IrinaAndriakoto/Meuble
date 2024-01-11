<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste Meubles</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/style.css" rel="stylesheet">
    </head>
    <body>
        <center>
            <div id="all">
            <form method="get" action="prixmeuble">
            <h1> Liste des meubles selon les prix </h1>
                <p><h2>Prix minimal: </h2>
                <input type="text" name="prixMin" class="inp"></p>
                <p><h2>Prix maximal: </h2>
                    <input type="text" name="prixMax" class="inp"></p>
                <input type="submit" value="Valider">
            </form>
            </div>
        </center>
    </body>
</html>

<%@ page import="inc.Service"%>
<%@ page import="java.sql.* , java.util.*" %>
<%@ page import="com.google.gson.*" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Homepage</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
                <script src="assets/js/chart.js"></script>
	</head>
    <style>
                .insert {
            display: none;
        }

        .insert.active {
            display: block;
        }

        .insert a {
            display: block;
            padding: 10px;
            text-decoration: none;
            color: #333;
            margin-bottom: 10px;
            border-radius: 5px;
            background-color: #ddd;
        }

        .insert a.active {
            background-color: #007bff;
            color: #ddd;
        }
        .cnv{
            width:300px;
            height: 100px;
        }
    </style>
    
    <% 
        
      Service s = new Service();
      Connection con = s.getConnection();
    
      try{
    String sql = "SELECT genre, COUNT(*) FROM v_getcommande GROUP BY genre";
    PreparedStatement pstmt = con.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();

    // Créer un Map pour stocker les données
    Map<String, Integer> data = new HashMap<>();

    while (rs.next()) {
        String genre = rs.getString(1);
        int count = rs.getInt(2);
        data.put(genre, count);
    }

    // Convertir le Map en JSON
    String json = new Gson().toJson(data);

    // Stocker le JSON dans une variable JavaScript
    out.println("<script>var data = " + json + ";</script>");
} catch (SQLException e) {
    // Gérer les exceptions
    e.printStackTrace();
}
    %>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">
							<!-- Header -->
								<header id="header">
									<a href="index.html" class="logo"><strong>Atelier de fabrication de meuble.</strong></a>
								</header>

							<!-- Section -->
								<section>
									<div class="content">
                                        <div class="insert" id="insertion">
                                            <header class="major">
                                                <h2>Insertions :</h2>
                                            </header>
											<a href="http://localhost:8080/Meuble/insertCategorie" onclick="showContent('insertCategorie')">Insert Categorie</a>
											<a href="http://localhost:8080/Meuble/insertMateriel" onclick="showContent('insertMateriel')">Insertion des mat&eacute;riaux</a>
											<a href="http://localhost:8080/Meuble/insertStyle" onclick="showContent('insertStyle')">Insertion de style</a>
											<a href="http://localhost:8080/Meuble/insertTaille" onclick="showContent('insertTaille')">Insertion de taille</a>
											<a href="http://localhost:8080/Meuble/insertStock" onclick="showContent('insertStock')">Insertion de stock</a>
											<a href="http://localhost:8080/Meuble/insertPers" onclick="showContent('insertPersonnel')">Insertion de personnel</a>
                                                                                        <a href="http://localhost:8080/Meuble/insertPoste" onclick="showContent('insertPoste')">Insertion de poste</a>
											<a href="http://localhost:8080/Meuble/insertMetier" onclick="showContent('insertMetier')">Insertion de metier</a>
											<a href="http://localhost:8080/Meuble/insertClient" onclick="showContent('insertClient')">Insertion Client</a>
											<a href="http://localhost:8080/Meuble/quantitemateriel" onclick="showContent('insertquantite')">Insertion des quantites</a>
										</div>
								
										<div class="insert" id="lists">
                                            <header class="major">
                                                <h2>Listes :</h2>
                                            </header>
											<a href="http://localhost:8080/Meuble/listeMateriel" onclick="showContent('listeMateriel')">Liste des materiaux</a>
											<a href="http://localhost:8080/Meuble/listeStyle" onclick="showContent('listeStyle')">Liste des styles</a>
											<a href="http://localhost:8080/Meuble/listeMeuble" onclick="showContent('listeMeuble')">Liste des meubles</a>
											<a href="http://localhost:8080/Meuble/fabrication" onclick="showContent('quantitemateriel')">Quantit&eacute; des mat&eacute;riaux</a>
											<a href="http://localhost:8080/Meuble/listepersonnel" onclick="showContent('listePers')">Liste Personnel</a>
                                                                                        <a href="http://localhost:8080/Meuble/listeposte" onclick="showContent('listeposte')">Liste poste</a>
										</div>
								
										<div class="insert" id="otherContent">
                                            <header class="major">
                                                <h2>Nos services :</h2>
                                            </header>
											<a href="http://localhost:8080/Meuble/commander" onclick="showContent('commander')">Commander</a>
											<a href="http://localhost:8080/Meuble/validation" onclick="showContent('valider')">Validation des commandes</a>
											<a href="http://localhost:8080/Meuble/benefice" onclick="showContent('benefice')">Visualiser les bénéfices par meuble</a>
											<!-- Add other links as needed -->
										</div>
										<!-- Add other content divs as needed -->
									</div>
								
								</section>
                                                        <h4 style='text-decoration: underline;'>Statistique de vente de meuble par genre</h4>
                                                        <div class="cnv"><canvas id="myChart" width="200" height="100"></canvas></div>
						</div>
					</div>

				<!-- Sidebar -->
					<div id="sidebar">
						<div class="inner">

							<!-- Search -->
								<!-- <section id="search" class="alt">
									<form method="post" action="#">
										<input type="text" name="query" id="query" placeholder="Search" />
									</form>
								</section> -->

							<!-- Menu -->
								<nav id="menu">
									<header class="major">
										<h2>Menu</h2>
									</header>
									<ul>
										<li><a href="#" onclick="showContent('insertion')">Insertion</a></li>
										<li><a href="#" onclick="showContent('lists')">Listes</a></li>
										<li><a href="#"  onclick="showContent('otherContent')">Services</a></li>
										<li><a href="http://localhost:8080/Meuble/stat">Statistiques</a></li>
									</ul>
								</nav>
						</div>
					</div>

			</div>
                            
		<!-- Scripts -->
		<script>
			function showContent(tabId) {
				var contentDivs = document.querySelectorAll('.content .insert');
				contentDivs.forEach(function (div) {
					div.classList.remove('active');
				});
	
				var selectedDiv = document.getElementById(tabId);
				if (selectedDiv) {
					selectedDiv.classList.add('active');
				}
			}
                        
                        var labels = Object.keys(data);
                        var datas = Object.values(data);
                        
                        
// Créer le graphique
var ctx = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: labels,
        datasets: [{
            data: datas,
            backgroundColor: ['rgba(255, 99, 132, 0.2)', 'rgba(54, 162, 235, 0.2)'],
            borderColor: ['rgba(255, 99, 132, 1)', 'rgba(54, 162, 235, 1)'],
            borderWidth: 1
        }]
    },
    options: {
        responsive: true,
        title: {
            display: true,
            text: 'Pourcentage de genre par commande effectuée'
        }
    }
});

		</script>
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
        
        <% 
           s.closeConnection(con);
        %>
</html>
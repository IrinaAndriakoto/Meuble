<%-- 
    Document   : stat
    Created on : 25 janv. 2024, 15:17:39
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.* , inc.Service" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/main.css" rel="stylesheet">      
        <script src="assets/js/chart.js"></script>
    </head>

<%
      Service s = new Service();
      Connection conn = s.getConnection();
    
try {
    String sql = "SELECT categorie, style, taille, genre, COUNT(*), COUNT(*) * 100.0 / SUM(COUNT(*)) OVER (PARTITION BY categorie, style, taille) FROM v_getcommande GROUP BY categorie, style, taille, genre";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();

    // Afficher les résultats sous forme de tableau
    out.println("<h3>Afficher les statistiques :</h3>");
    out.println("<table>");
    out.println("<tr><th>Categorie</th><th>Style</th><th>Taille</th><th>Genre</th><th>Nombre de commandes</th></tr>");

    while (rs.next()) {
        out.println("<tr>");
        out.println("<td>" + rs.getString(1) + "</td>");
        out.println("<td>" + rs.getString(2) + "</td>");
        out.println("<td>" + rs.getString(3) + "</td>");
        out.println("<td>" + rs.getString(4) + "</td>");
        out.println("<td>" + rs.getInt(5) + "</td>");
        out.println("<td>" + rs.getDouble(6) + "%</td>");
        out.println("</tr>");
    }

    out.println("</table>");
} catch (SQLException e) {
    // Gérer les exceptions
    e.printStackTrace();
}
%>

    <body>

    </body>
</html>

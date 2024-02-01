<%-- 
    Document   : error
    Created on : 13 déc. 2023, 17:35:01
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="index.css">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/main.css" rel="stylesheet">
    </head>
    </head>
    <body>
    <%-- Affichage du message d'erreur --%>
    <c:if test="${not empty requestScope.errorMessage}">
        <p style="color: red;">${requestScope.errorMessage}</p>
    </c:if>
        <p style="color: red;">${err}</p>
          
    </body>
</html>

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
    </head>
    <body>
        <% 
            String err = request.getAttribute("errorMessage");
        %>
        <p style="color: red;">${err}</p>
    </body>
</html>

<%-- 
    Document   : commande
    Created on : 11 janv. 2024, 14:08:08
    Author     : Irina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/main.css" rel="stylesheet">
    </head>
    <% 
    List<Style> style= null;
    style= (List<Style>) request.getAttribute("get_styles");
    List<Taille> taille= null;
    taille= (List<Taille>) request.getAttribute("get_tailles");
    List<Categorie> categorie= null;
    categorie= (List<Categorie>) request.getAttribute("get_categories");
    
    List<Materiel> mat = (List<Materiel>) request.getAttribute("mat");
    List<Client> cl = (List<Client>) request.getAttribute("cl");
    %>
    <body>
        <h3>Commander un meuble</h3>
        <form method="post" action="commander">
            <select name="categorie">
                <% for(int i=0;i<categorie.size();i++) { %>
                <option value="<%= categorie.get(i).getIdCategorie() %>" > <%= categorie.get(i).getCategorie() %> </option>
                <% } %>
            </select>
            <select  name="style">
                <% for(int i=0;i<style.size();i++) { %>
                <option value="<%= style.get(i).getIdStyle() %>" > <%= style.get(i).getStyle() %> </option>
                <% } %>
            </select>
            <select name="taille">
                <% for(int i=0;i<taille.size();i++) { %>
                <option value="<%= taille.get(i).getIdTaille() %>" > <%= taille.get(i).getTaille() %> </option>
                <% } %>
            </select>
            <select name="client">
                <% for(int i=0;i<cl.size();i++) { %>
                <option value="<%= cl.get(i).getIdClient() %>" > <%= cl.get(i).getNomClient() %> </option>
                <% } %>
            </select>            
            Nombre de commande :<input type="text" name="qte"> 
            <input type="submit" value="Valider">
        </form>
        </body>
</html>

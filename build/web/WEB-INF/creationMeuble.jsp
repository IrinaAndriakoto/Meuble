<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<%
    List<Style> style= null;
    style= (List<Style>) request.getAttribute("get_styles");
    List<Taille> taille= null;
    taille= (List<Taille>) request.getAttribute("get_tailles");
    List<Categorie> categorie= null;
    categorie= (List<Categorie>) request.getAttribute("get_categories");
 %>
<!DOCTYPE html>
<html>
    <head> 
        <title></title>
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="../assets/css/style.css" rel="stylesheet">
    </head>
    <body>
        <!-- <div id="header1"></div> -->
    <center>
        <div id="all">
        <form method="get" action="creationMeuble">
            <h1>Creation de votre meuble</h1>
           <p> <select name="categorie">
            <% for (int i=0; i<categorie.size(); i++) 
                { %>
                        <option value="<%= categorie.get(i).getIdCategorie() %>"><%= categorie.get(i).getCategorie() %></option>
        <%      } %>        
            </select> </p>
            <p> <select name="style">
                <% for (int j=0; j<style.size(); j++) 
                { %>
                    <option value="<%= style.get(i).getIdStyle() %>"><%= style.get(i).getStyle() %></option>
        <%      } %> 
            </select> </p>
            <p> <select name="taille">
                <% for (int k=0; k<taille.size();k++) 
                { %>
                    <option value="<%= taille.get(i).getIdTaille() %>"><%= taille.get(i).getTaille() %></option>
        <%      } %> 
            </select> </p>
            <input type="submit" value="Inserer">
        </form>
        </div>
    </center>
    
    </body>
    
</html>
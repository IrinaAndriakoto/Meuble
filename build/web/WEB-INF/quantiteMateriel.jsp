<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<%
    List<Style> style= null;
    style= (List<Style>) request.getAttribute("get_styles");
    List<Taille> taille= null;
    taille= (List<Taille>) request.getAttribute("get_tailles");
    List<Categorie> categorie= null;
    categorie= (List<Categorie>) request.getAttribute("get_categories");
    
    List<Materiel> mat = (List<Materiel>) request.getAttribute("mat");
 %>
<!DOCTYPE html>
<html>
    <head> 
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
    </head>
    <body>
        <!-- <div id="header1"></div> -->
    <center>
        <div id="all">
        <form method="post" action="quantitemateriel">
            <h1>Creation de votre meuble</h1>
           <p> <select name="categorie">
            <% for (int i=0; i<categorie.size(); i++) 
                { %>
                        <option value="<%= categorie.get(i).getIdCategorie() %>"><%= categorie.get(i).getCategorie() %></option>
        <%      } %>        
            </select> </p>
            <p> <select name="style">
                <% for (int i=0; i<style.size(); i++) 
                { %>
                    <option value="<%= style.get(i).getIdStyle() %>"><%= style.get(i).getStyle() %></option>
        <%      } %> 
            </select> </p>
            
            
            <p> <select name="materiel">
                <% for (int i=0; i<mat.size();i++) 
                { %>
                    <option value="<%= mat.get(i).getIdMateriel() %>"><%= mat.get(i).getMateriel() %></option>
        <%      } %> 
            </select> </p>
            
            
            <p> <select name="taille">
                <% for (int i=0; i<taille.size();i++) 
                { %>
                    <option value="<%= taille.get(i).getIdTaille() %>"><%= taille.get(i).getTaille() %></option>
        <%      } %> 
            </select> </p>
            
            <input type="text" name="quantite" placeholder="Quantite du materiel" class="qte">
            <br/>
            <input type="submit" value="Inserer">
        </form>
        </div>
    </center>
    
    </body>
    
</html>
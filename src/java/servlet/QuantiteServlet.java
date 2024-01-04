/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

/**
 *
 * @author Irina
 */
import inc.Service;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.sql.*;
import model.*;
import java.util.List;

@WebServlet("/quantitemateriel")
public class QuantiteServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            Connection connection = null;
            try{
                    Service dataService = new Service();
                    connection = dataService.getConnection();
                    request.setAttribute("connection",connection);
                    
                    List<Taille> taille = dataService.getAllTaille();
                    request.setAttribute("get_tailles", taille);
                    
                    List<Categorie> categorie = dataService.getAllCategorie();
                    request.setAttribute("get_categories", categorie);
                    
                    List<Style> style = dataService.getAllStyle();
                    request.setAttribute("get_styles", style);
                    
                    List<Materiel> mat = dataService.getAllMateriel();
                    request.setAttribute("mat",mat);
            
            request.getRequestDispatcher("WEB-INF/quantiteMateriel.jsp").forward(request, response);
            }
            catch(Exception e){
            throw new ServletException(e);
//            e.printStackTrace();
        }
         finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        Connection connection =null;               
        String categ = request.getParameter("categorie");
        String matr = request.getParameter("materiel");
        String style = request.getParameter("style");
        String taille = request.getParameter("taille");
        String quantite = request.getParameter("quantite");
            try{
                Service serv = new Service();
                connection = serv.getConnection();
                request.setAttribute("connection",connection);
                serv.insertQuantiteMateriel(connection, categ, matr, taille, style, quantite);
            
                            // Fermer la connexion
                    connection.close();

                    // Rediriger vers une page de confirmation ou une autre page appropriée
                    response.sendRedirect("confirmation.jsp");
            }
            catch(Exception e){
            e.printStackTrace();
            // Rediriger vers une page d'erreur avec le message d'erreur approprié
            request.setAttribute("errorMessage", "Une erreur s'est produite lors de l'insertion du style : " + e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
  
        }
         finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}

}
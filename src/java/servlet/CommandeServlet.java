/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import exception.InsufficientMaterialsException;
import inc.Service;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.Categorie;
import model.Materiel;
import model.Style;
import model.Taille;

/**
 *
 * @author Irina
 */

@WebServlet("/commander")
public class CommandeServlet extends HttpServlet{
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
            
            request.getRequestDispatcher("WEB-INF/commande.jsp").forward(request, response);
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
//        String matr = request.getParameter("materiel");
        String style = request.getParameter("style");
        String taille = request.getParameter("taille");
        String quantite = request.getParameter("qte");
            try{
                Service serv = new Service();
                connection = serv.getConnection();
                request.setAttribute("connection",connection);
                
                try{
                    serv.insertCommande(connection, quantite, categ, style, taille); 
                                        connection.close();

                    // Rediriger vers une page de confirmation ou une autre page appropriée
                    response.sendRedirect("confirmation.jsp");
                }
                catch(InsufficientMaterialsException e){
                    e.printStackTrace();
                                // Redirigez vers la page d'erreur avec le message d'erreur approprié
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
                }
            
                            // Fermer la connexion

            }
            catch(Exception e){
            e.printStackTrace();
//            // Rediriger vers une page d'erreur avec le message d'erreur approprié
//            request.setAttribute("errorMessage", "Une erreur s'est produite lors de l'insertion du style : " + e.getMessage());
//            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
//            rd.forward(request, response);
  
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


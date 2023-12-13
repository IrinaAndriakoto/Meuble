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
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class InsertStyleServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String styleValue = request.getParameter("style");

        Connection connection = null;
        
        try {
            // Établir la connexion à la base de données (assurez-vous d'avoir correctement configuré votre source de données / pool de connexions)
            // ...
            Service dataService = new Service();
                 connection = dataService.getConnection();
            request.setAttribute("connection",connection);
            dataService.insertStyle(connection, styleValue);

            // Fermer la connexion
            connection.close();

            // Rediriger vers une page de confirmation ou une autre page appropriée
            response.sendRedirect("confirmation.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // Rediriger vers une page d'erreur avec le message d'erreur approprié
            request.setAttribute("errorMessage", "Une erreur s'est produite lors de l'insertion du style : " + e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
            // Gérer les erreurs SQL (par exemple, afficher un message d'erreur)
        } finally {
            // Assurez-vous de bien fermer la connexion dans le bloc finally
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